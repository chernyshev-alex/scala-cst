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

  }