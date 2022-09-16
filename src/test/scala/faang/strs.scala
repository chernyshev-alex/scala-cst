package faang

import org.scalatest.funsuite.AnyFunSuite

class StrsTest extends AnyFunSuite {

	test("Permutation string") {
		assert(strs.allPermutation("ABC") === List("ABC", "ACB", "BAC" , "BCA", "CBA", "CAB"))
	}
}