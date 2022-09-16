package faang

import org.scalatest.funsuite.AnyFunSuite

class Arr2DTest extends AnyFunSuite {
  test("DFS") {
    val m = Array.tabulate(3,3)((r, c) => 3*r+c)
    assert(arr2d.traversalDfs(m) === Array(0, 1, 2, 5, 8, 7, 4, 3, 6))
  }

  test("BFS") {
    val m = Array.tabulate(3,3)((r, c) => 3*r+c)
    assert(arr2d.traversalBfs(m) === Array(0, 1, 3, 2, 4, 6, 5, 7, 8))
  }
}