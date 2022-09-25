package faang

import org.scalatest.funsuite.AnyFunSuite
import scala.collection.mutable
class StrsTest extends AnyFunSuite {

	test("Permutation string") {
		assert(strs.allPermutation("ABC") === List("ABC", "ACB", "BAC" , "BCA", "CBA", "CAB"))
	}

    // Longest Common Subsequence
    // https://leetcode.com/problems/longest-common-subsequence
	//
    test("Longest Common Subsequence") {
        case class LCS(s1 : String, s2 : String, exp : Int)
        val data : Array[LCS] = Array(LCS("abcde", "ace", 3), 
            LCS("abc", "abc", 3), LCS("abc", "def", 0))

       for (t <- data) {
            assert(strs.longestCommonSubsequence(t.s1, t.s2) == t.exp)
       }
	} 

    test("Is Palindrome") {
        val tests = Map[String, Boolean] (
            "A man, a plan, a canal: Panama" -> true, 
            "race a car" -> false, 
            "atbbga" -> false,
			"aba" -> true,
            "abba" ->  true,
			"abs" ->  false )

        for ((k, v) <-  tests) {
            assertResult(v)(strs.IsPalindrom(k))
        }
    }

    //
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    //
    // Given a string s, find the length of the longest substring without repeating characters.
    // Sliding window
    //
    test("LenLongestSubstringNoRepeatedChars") {
        val tests = Map[String, Int] ("bbbbb" -> 1, "abcdef" -> 6, "abcabcbb" -> 3, "pwwkew" -> 3 )
        for ((k, v) <-  tests) {
            assertResult(v)(strs.lenLongestSubstringNoRepeatedChars(k))
        }
    }

    test("LongestPalindromicSubstring") {
        val tests = Map[String, String] ("Geeks" -> "ee", "forgeeksskeegfor" ->  "geeksskeeg")
      	for ((k, v) <-  tests) {
           assertResult(v)(strs.longestPalindromicSubstring(k))
        }
    }

    test("String Reverse") {
        val tests = Map[String, String] ( //"123456" -> "654321", "123" -> "321"
		   "1234" -> "4321")
      	for ((k, v) <-  tests) {
           assertResult(v)(strs.reverseString(k))
        }
    }

	//
   	// https://leetcode.com/problems/backspace-string-compare/
   	//
    // Given two strings s and t, return true if they are equal when both are typed into empty text editors.
    // '#' means a backspace character.
	// 
    test("BackSpace Edit") {
        val tests = Map[List[String], Boolean] (List("ab#c",  "ad#c") -> true)
      	for ((k, v) <-  tests) {
           assertResult(v)(strs.backSpaceEdit(k(0), k(1)))
        }
    }
}
