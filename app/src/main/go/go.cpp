#include <jni.h>
#include <goalgo.h>

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myappbench_algorithm_go_GoAlgorithms_goPiDigitsRun(JNIEnv *env, jclass thiz, jint num){
    GoPiDigitsRun((GoInt) num);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myappbench_algorithm_go_GoAlgorithms_goFannkuchRun(JNIEnv *env, jclass thiz, jint num){
    GoFannkuchRun((GoInt) num);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myappbench_algorithm_go_GoAlgorithms_goBinaryTreesRun(JNIEnv *env, jclass thiz, jint num){
    GoBinaryTreesRun((GoInt) num);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myappbench_algorithm_go_GoAlgorithms_goNBodyRun(JNIEnv *env, jclass thiz, jint num){
    GoNBodyRun((GoInt) num);
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_myappbench_algorithm_go_GoAlgorithms_goFastaRun(JNIEnv *env, jclass thiz, jint num){
    GoFastaRun((GoInt) num);
}