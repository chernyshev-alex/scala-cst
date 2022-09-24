package faang

import scala.collection._
import scala.annotation.switch
import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex

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

}