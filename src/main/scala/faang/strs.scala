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

  def IsPalindrom(s : String) : Boolean =  { 
    // l ---><--- r
      val ac = s.toLowerCase().toCharArray()
      var (l, r) = (0, ac.length -1)
      while (l < r) {
        while (l < r && !(ac(l).isDigit || ac(l).isLetter)) { l +=1 }
        while (l < r && !(ac(r).isDigit || ac(r).isLetter)) { r -=1 }
        if (ac(l) != ac(r)) {
          return false
        }
        l +=1; r -=1
      }
      true
    }

    def lenLongestSubstringNoRepeatedChars(s : String) : Int =  {
        if (s.length <= 1)
            return s.length

        // sliding window
        val seen = Array.fill(255)(Int.MaxValue)
        val chars = s.toCharArray()
        var maxLen = 0;
        var (l, r) = (0, 0)
        for (r <- 0 until chars.length) {
            val c = chars(r)
            val pos = seen(c)
            if (pos >= l && pos != Int.MaxValue) {
                l = pos+1
            }
            seen(c) = r
            maxLen = math.max(maxLen, r-l+1)
            //r +=1
        }
        maxLen
    }

    def longestPalindromicSubstring(s: String) : String = {
        def fcheck(left :  Int, right :  Int) : (String, Int) = {
          var (l , r) = (left, right)
          while (l >=0 && r < s.length && s.charAt(l) == s.charAt(r) ) {
            l -= 1;  r += 1
          }
          (s.substring(l + 1, r) , r -l -1)
        }

        var best  = ("", 0)
        for (i  <- 0 until s.length()) {
          // fcheck odd and even
           best = List(fcheck(i, i), fcheck(i, i+1)).foldLeft(best) {
            case (max_result , ((ss, slen))) => if (slen > max_result._2) (ss, slen)  else max_result
          }
        }
        return best._1
    }


  def reverseString(s : String)  : String = {
        // <--- /2-1 ----> exchange
        val res = s.toCharArray()
        for (i <- res.length /2 -1 to 0 by -1) {
            val  idx = res.length -i-1
            val  tmp = res(i)
            res(i) = res(idx)
            res(idx) = tmp
        }
        new String(res)
    }

  def  backSpaceEdit(s1:  String, s2 : String) : Boolean = {
      def doEdit(s : String) : String = {
          var b = new StringBuilder();
          for (ch <- s) {
              if (ch != '#') b.append(ch);
              else if (b.length() > 0) {
                  b.deleteCharAt(b.length() -1);
              }
          }
          return  b.toString();
      }
      return doEdit(s1) == (doEdit(s2))
  }

}
