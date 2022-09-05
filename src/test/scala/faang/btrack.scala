package faang

import org.scalatest.funsuite.AnyFunSuite

class BtrackTest extends AnyFunSuite {
	// Print all permutations of a given string
	test("Permutation string") {
		assert(btrack.allPermutationString("ABC") === List("ABC", "ACB", "BAC" , "BCA", "CBA", "CAB"))
	}
  }