package faang

import org.scalatest.funsuite.AnyFunSuite

class DpTest extends AnyFunSuite {

    // https://leetcode.com/problems/min-cost-climbing-stairs/

    case class TS(cost : Array[Int],  exp : Int)
    var  minCostData : Array[TS] =  Array(
        TS(Array(10, 15, 20), 15), 
        TS(Array(1, 100, 1, 1, 1, 100, 1, 1, 100, 1), 6))

	test("Min cost climbing") {
        for (t <- minCostData) {
            assert(dp.MinCostClimbing(t.cost) == t.exp)
        }
	}

	test("Min cost climbing memo") {
       for (t <- minCostData) {
            assert(dp.MinCostClimbingMemo(t.cost) == t.exp)
       }
	} 

    // Longest Common Subsequence
    // https://leetcode.com/problems/longest-common-subsequence

    test("Longest Common Subsequence") {
        case class LCS(s1 : String, s2 : String, exp : Int)
        val data : Array[LCS] = Array(LCS("abcde", "ace", 3), 
            LCS("abc", "abc", 3), LCS("abc", "def", 0))

       for (t <- data) {
            assert(dp.longestCommonSubsequence(t.s1, t.s2) == t.exp)
       }
	} 
  }