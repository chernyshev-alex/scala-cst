package faang

import org.scalatest.funsuite.AnyFunSuite

class ArraysTest extends AnyFunSuite {

  test("test 2sum target") {
    assert(arrays.twoSum(Array(2, 7, 11, 15), 26) === Array(2, 3))
  }

  // https://leetcode.com/problems/container-with-most-water/

  test("Test Container With Most Water") {
    assert(arrays.maxArea(Array(1, 8, 6, 2, 5, 4, 8, 3, 7)) == 49)
  }

  // https://leetcode.com/problems/trapping-rain-water/

  test("Trapping Rain Water") {
    assert(arrays.trap(Array(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)) == 6)
  }

}
