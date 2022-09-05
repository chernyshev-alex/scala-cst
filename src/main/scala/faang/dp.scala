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

    def longestCommonSubsequence(s1 : String, s2 : String) : Int = {
        var dp = Array.ofDim[Int](s1.length() +1, s2.length() +1)
        for {
            (c1, i) <- s1.zipWithIndex 
            (c2, j) <- s2.zipWithIndex
        } yield {
            dp(i+1)(j+1) = if (c1 == c2) dp(i)(j) + 1 else Math.max(dp(i+1)(j), dp(i)(j+1))
        }
        dp(s1.length)(s2.length())
    }

}