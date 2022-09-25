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

    //    Given the weights and values of N items, put these items in a knapsack of capacity W
    //    to get the maximum total value in the knapsack.
    //    In Fractional Knapsack, we can break items for maximizing the total value of the knapsack
    //
    //    Input: Items as (value, weight) pairs
    //    arr[] = {{60, 10}, {100, 20}, {120, 30}}
    //    Knapsack Capacity, W = 50
    //    Output: Maximum possible value = 240
    //
    test ("Knapsack Problem Fraction Allowed") {
        var ar = Array(KnapsackItem(500, 30))
        var result = dp.getMaxValueFractionAllowed(ar, 10)
        assert(Math.abs(166.66 - result) < 0.01)

        ar = Array(KnapsackItem(60, 10), KnapsackItem(100, 20), KnapsackItem(120, 30))
        result = dp.getMaxValueFractionAllowed(ar, 50)
        assertResult(240.0)(result)
    }

    // Fraction not allowed !!!
    //
    test ("Knapsack Problem") {
        var ar = Array(KnapsackItem(60, 10), KnapsackItem(100, 20), KnapsackItem(120, 30))
        var result = dp.getMaxValueOfKnapsack(ar, 50)
        assertResult(220.0)(result)

        ar = Array(KnapsackItem(1000, 1), KnapsackItem(2000, 2))
        result = dp.getMaxValueOfKnapsack(ar, 2)
        assertResult(60)(result)
    }
  }