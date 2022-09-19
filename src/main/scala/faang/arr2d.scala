package faang

import scala.collection._
import scala.collection.mutable.ArrayBuffer

object arr2d {

    val DIRS = Array(Array(-1, 0), Array(0, 1), Array(1, 0), Array(0, -1))

    def traversalDfs(n : Array[Array[Int]]) : Array[Int] = {
        val visited = Array.ofDim[Int](n.length, n(0).length)
        var result = Array.empty[Int]
        def dfs(r : Int, c : Int) {
            if (r < 0 || c < 0 || r >= n.length || c >= n(0).length  || visited(r)(c) == 1)
                return 

            visited(r)(c) = 1
            result = result :+ n(r)(c)
            DIRS.foreach(d => dfs(r + d(0), c + d(1)))
        }
        dfs(0, 0)
        result
    }

    def traversalBfs(n : Array[Array[Int]]) : Array[Int] = {
      val visited = Array.ofDim[Int](n.length, n(0).length)
      var result = Array.empty[Int]
      val q = mutable.Queue.empty[(Int, Int)]

      q.enqueue((0,0))
      while (q.length > 0) {
        val (r, c) = q.dequeue()
        if (r < 0 || c < 0 || r >= n.length || c >= n(0).length  || visited(r)(c) == 1) {
          ;
        } else {
          visited(r)(c) = 1
          result = result :+ n(r)(c)
          DIRS.foreach (d => q.enqueue((r + d(0), c + d(1))))
        }
      }
      result
    }

}