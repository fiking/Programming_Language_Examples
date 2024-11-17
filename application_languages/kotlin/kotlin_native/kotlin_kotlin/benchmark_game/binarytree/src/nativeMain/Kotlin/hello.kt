// gradle nativeBinarie

/**
 * The Computer Language Benchmarks Game
 * https://salsa.debian.org/benchmarksgame-team/benchmarksgame/
 *
 * based on Jarkko Miettinen's Java program
 * contributed by Christophe Beyls
 */
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

private const val MIN_DEPTH = 4

fun main(args: Array<String>) {
    val n = if (args.isNotEmpty()) args[0].toInt() else 0

    val maxDepth = n.coerceAtLeast(MIN_DEPTH + 2)
    val stretchDepth = maxDepth + 1

    println("stretch tree of depth $stretchDepth\t check: ${bottomUpTree(stretchDepth).itemCheck()}")

    val longLivedTree = bottomUpTree(maxDepth)

    runBlocking {
        val results = Array((maxDepth - MIN_DEPTH) / 2 + 1) { resultIndex ->
            async(Dispatchers.Default) {
                var check = 0
                val depth = MIN_DEPTH + resultIndex * 2
                val iterations = 1 shl maxDepth - depth + MIN_DEPTH
                for (i in 1..iterations) {
                    check += bottomUpTree(depth).itemCheck()
                }
                "$iterations\t trees of depth $depth\t check: $check"
            }
        }

        for (str in results) {
            println(str.await())
        }
    }

    println("long lived tree of depth ${maxDepth}\t check: ${longLivedTree.itemCheck()}")
}

private fun bottomUpTree(depth: Int): TreeNode {
    return if (0 < depth) {
        TreeNode(bottomUpTree(depth - 1), bottomUpTree(depth - 1))
    } else TreeNode(null, null)
}

class TreeNode(private val left: TreeNode?, private val right: TreeNode?) {

    fun itemCheck(): Int {
        return if (left != null && right != null) {
            1 + left.itemCheck() + right.itemCheck()
        } else 1
    }
}
