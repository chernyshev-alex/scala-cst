package faang

import org.scalatest.funsuite.AnyFunSuite

class NumsTest extends AnyFunSuite {

    test("First NonRepeated Character (map)") {
        val result = Nums.firstNonRepeatedCharacterWithMap("geeksforgeeks")
        assertResult(Some('f'))(result)
    }

   test("First NonRepeated Character") {
        val result = Nums.firstNonRepeatedCharacter("geeksforgeeks")
        assertResult(Some('f'))(result)
    }

    // not do any operations using operators: * , / , %.
    // -231 <= dividend, divisor <= 231 - 1; divisor != 0
    // 
     test("Divide number no *,/,%") {
        assertResult(2)(Nums.divide(5, 2))
        assertResult(5)(Nums.divide(10, 2))
    }

    // Form the largest possible number from the array of number.
    
    test("testLargestNumber") {
        val result = Nums.findLargestNumber(List("54", "546", "548", "60"))
        assertResult("6054854654")(result)
    }

    test("testNumOfDigits") {
        assertResult(2)(Nums.numberOfDigits(10))
        assertResult(4)(Nums.numberOfDigits(1000))
    }

    // // https://leetcode.com/problems/numbers-with-repeated-digits/
    // // Given an integer n, return the number of positive integers in the range [1, n]
    // // that have at least one repeated digit.
    // // Input: n = 20  Output: 1
    // // Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
    // // Input: n = 100 Output: 10
    // // Explanation: The positive numbers (<= 100) with at least 1 repeated digit
    // // are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
    // // Input: n = 1000; Output: 262
    
    // test("testNumDupDigitsAtMostN") {
    //     assertResult(Nums.numDupDigitsAtMostN(20), 1);
    //     assertResult(Nums.numDupDigitsAtMostN(100), 10);
    //     assertResult(Nums.numDupDigitsAtMostN(200), 38);
    //     assertResult(Nums.numDupDigitsAtMostN(500), 122);
    //     assertResult(Nums.numDupDigitsAtMostN(900), 234);
    //     assertResult(Nums.numDupDigitsAtMostN(1000), 262);
    // }

    
    test("testGenerateFiboNums") {
        assertResult(List(0,1,1,2,3,5))(Nums.generateFibo(6).toList)
    }
    
    test("testGenPrime") {
        assertResult(List(2, 3, 5, 7, 11, 13))(Nums.primeStream(Stream.from(2)).take(6).toList)
    }
    
    test("testIsPrime") {
        assertResult(true)(Nums.IsPrime(2))
        assertResult(true)(Nums.IsPrime(3))
        assertResult(true)(Nums.IsPrime(5))
        assertResult(false)(Nums.IsPrime(4))
    }

    
    test("testIsPrimeStream") {
        assertResult(true)(Nums.IsPrimeStream(2))
        assertResult(true)(Nums.IsPrimeStream(3))
        assertResult(true)(Nums.IsPrimeStream(5))
        assertResult(false)(Nums.IsPrimeStream(4))
    }

    // test("testIsPrimeErat") {
    //     assertResult(true)(  Nums.IsPrimeErat(2));
    //     assertResult(true)(  Nums.IsPrimeErat(3));
    //     assertResult(true)(  Nums.IsPrimeErat(5));
    //     assertResult(false,  Nums.IsPrimeErat(4));
    // }

    
    // test("testGeneratePrime") {
    //     assertResult(Arrays.<Integer>asList(2,3,5), Nums.generatePrime(6));
    // }

    
    // test("testCountSetBits") {
    //     assertResult(2, Nums.countSetBits(6));
    //     assertResult(3, Nums.countSetBits(13));
    // }
}
