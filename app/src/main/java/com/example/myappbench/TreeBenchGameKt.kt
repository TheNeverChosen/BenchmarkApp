package com.example.myappbench

class TreeBenchGameKt {
    @Throws(Exception::class)
    fun run(x: Int) {
        val minDepth = 4
        val maxDepth = Math.max(minDepth + 2, x)
        val stretchDepth = maxDepth + 1
        var check = TreeNode.create(stretchDepth).check()
        println("stretch tree of depth " + (maxDepth + 1) + "\t check: " + check)
        val longLivedTree = TreeNode.create(maxDepth)
        var depth = minDepth
        while (depth <= maxDepth) {
            val iterations = 1 shl maxDepth - depth + minDepth
            check = 0
            for (i in 1..iterations) {
                check += TreeNode.create(depth).check()
            }
            println("$iterations\t trees of depth $depth\t check: $check")
            depth += 2
        }
        println("long lived tree of depth " + maxDepth + "\t check: " + longLivedTree.check())
    }

    internal class TreeNode {
        var left: TreeNode? = null
        var right: TreeNode? = null
        fun check(): Int {
            return if (left == null) 1 else left!!.check() + right!!.check() + 1
        }

        companion object {
            fun create(depth: Int): TreeNode {
                return ChildTreeNodes(depth)
            }

            fun ChildTreeNodes(depth: Int): TreeNode {
                val node = TreeNode()
                if (depth > 0) {
                    node.left = ChildTreeNodes(depth - 1)
                    node.right = ChildTreeNodes(depth - 1)
                }
                return node
            }
        }
    }
}