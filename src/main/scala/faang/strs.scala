package faang

import scala.collection._

object strs {

  def allPermutation(s: String) : List[String] = {
    var result = List.empty[String]

    @inline def swap(ps: Array[Char], l: Int, i: Int) {
      val tmp = ps(l)
      ps(l) = ps(i)
      ps(i) = tmp
    }

    def do_permutation(ps: Array[Char], l: Int, r: Int) {
      if (l == r) {
        result = result :+ new String(ps)
      } else {
        for (i <- l to r) {
          swap(ps, l, i)
          do_permutation(ps, l + 1, r)
          swap(ps, l, i)
        }
      }
    }
    do_permutation(s.toCharArray(), 0, s.length()-1)
	  result
  }
}
