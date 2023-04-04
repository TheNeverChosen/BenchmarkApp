#include <jni.h>

#include <atomic>
#include <numeric>
#include <vector>
#include <algorithm>
#include <functional>
#include <iostream>
#include <memory>
#include <thread>

struct Node
{
    std::shared_ptr<Node> l, r;

    int check() const
    {
        if (l)
            return l->check() + 1 + r->check();
        else
            return 1;
    }
};

std::shared_ptr<Node> make(const int d)
{
    if (d > 0)
    {
        auto root = std::make_shared<Node>();
        root->l = make(d - 1);
        root->r = make(d - 1);
        return root;
    }
    else
    {
        return nullptr;
    }
}

int run_parallel(unsigned depth, int iterations, unsigned int workers = std::thread::hardware_concurrency())
{
    std::vector<std::thread> threads;
    threads.reserve(workers);

    std::atomic_int counter = iterations;
    std::atomic_int output = 0;

    for(unsigned i = 0; i < workers; ++i) {
        threads.push_back(std::thread([&counter, depth, &output] {
            int checksum = 0;

            while(--counter >= 0) {
                auto a = make(depth);
                checksum += a->check();
            }

            output += checksum;
        }));
    }

    for(unsigned i = 0; i < workers; ++i) {
        threads[i].join();
    }

    return output;
}

constexpr auto MIN_DEPTH     = 4;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myappbench_algorithm_cpp_CppAlgorithms_cppBinaryTrees(JNIEnv *env, jclass thiz, jint num) {
    const int max_depth     = num;
    const int stretch_depth = max_depth + 1;

    // Alloc then dealloc stretchdepth tree.
    {
        auto c = make(stretch_depth);
        std::cout << "stretch tree of depth " << stretch_depth << "\t "
                  << "check: " << c->check() << std::endl;
    }

    auto long_lived_tree = make(max_depth);

    for (int d = MIN_DEPTH; d <= max_depth; d += 2)
    {
        const int iterations = 1 << (max_depth - d + MIN_DEPTH);
        auto const c = run_parallel(d, iterations);

        std::cout << iterations << "\t trees of depth " << d << "\t check: " << c << "\n";
    }

    std::cout << "long lived tree of depth " << max_depth << "\t "
              << "check: " << (long_lived_tree->check()) << "\n";
}
