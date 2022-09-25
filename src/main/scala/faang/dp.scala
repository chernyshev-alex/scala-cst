package faang

import scala.collection._
import scala.annotation.switch
import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

case class KnapsackItem(value : Int, weight : Int)
object dp {
 
    def MinCostClimbing(costs :  Array[Int]) : Int = {
        def minCost(n : Int) : Int = {
            if (n < 0) return 0
            if (n == 0 || n == 1) return costs(n)
            return costs(n) + Math.min(minCost(n-1) , minCost(n-2))
        }
        Math.min(minCost(costs.length-1), minCost(costs.length-2))
    }

    def MinCostClimbingMemo(costs :  Array[Int]) : Int = {
        costs.length match {
            case 0 => return 0
            case 1 => return costs(0)
            case _ =>
        }
        val len = costs.length
        val memo = Array.ofDim[Int](len)
        for (i <- 0 until len) {
            if (i < 2) {
                memo(i) = costs(i)
            } else {
                memo(i) = costs(i) + Math.min(memo(i-1) , memo(i-2))
            }
        } 
        Math.min(memo(len -1), memo(len -2))
    }   

    // Knapsack  ============

    import scala.util.control.Breaks._ 

    def getMaxValueFractionAllowed(items : Array[KnapsackItem], __cap : Int) : Double = {
        val itemsSorted = items.sortWith((o1, o2) =>  
            o1.value.asInstanceOf[Double] / o1.weight  < o2.value.asInstanceOf[Double] / o2.weight)
 
        var maxPossibleValue = 0.0
        var capacity = __cap
        breakable { 
            for (item <- itemsSorted) {
                if (capacity >= item.weight) {
                    // this weight can be picked while
                    capacity -= item.weight;
                    maxPossibleValue += item.value;
                } else {
                    // item cant be picked whole
                    val fraction = capacity / item.weight
                    maxPossibleValue += item.value * fraction;
                    break
                }
            }
        }
        return maxPossibleValue;
    }

    // Fraction not allowed !!!

    def  getMaxValueOfKnapsack(items : Array[KnapsackItem], capacity : Int) : Double = {
        val dp = Array.ofDim[Int](capacity + 1)
        for {
            i <- 1 to items.length
            w <- capacity to 0 by -1
        } yield {
            val prev = items(i-1)
            if (prev.weight <= w) {
                dp(w) = Math.max(dp(w), dp(w - prev.weight) + prev.value)
            }
        }
        dp(capacity)
    }
}