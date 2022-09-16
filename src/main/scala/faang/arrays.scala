package faang

import scala.collection._

object arrays {

 def twoSum(nums : Array[Int], target : Int) : Array[Int] = {
    val map = mutable.HashMap.empty[Int, Int]
    for ((v, idx) <- nums.zipWithIndex)  {
      map.get(target - v) match {
        case None => map.put(v, idx)
        case Some(value) => return Array(map.get(target - v).get, idx)
      }
    }
    Array.empty[Int]
  }

  def maxArea(height: Array[Int]): Int = {
    var best_area =0
    var (x1, x2) = (0, height.length -1)
    while (x1 < x2) {
      val area = Math.min(height(x1), height(x2)) * (x2 -x1)
      best_area =  Math.max(best_area, area)
      if (height(x1) <= height(x2)) {
        x1 +=1
      } else {
        x2 -=1
      }
    }
    best_area
  }

  //   |  |
  // __|  |__

  def trap(height: Array[Int]) : Int = {
    var result = 0
    var (lmax, rmax) = (0,0)
    var (li, ri) = (0, height.length -1)
    while (li < ri) {
      if (height(li) <= height(ri)) {

        if (height(li) >= lmax) {
          lmax = height(li)
        } else {
          result += lmax - height(li)
        }
        li +=1
      } else {
        if (height(ri) >= rmax) {
				  rmax = height(ri)
        } else {
				 result += rmax - height(ri)
        }
        ri -=1
			}
    }
    result 
  }
}
