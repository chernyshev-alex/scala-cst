package faang

import scala.collection.immutable._
import scala.collection.mutable.ArrayBuffer
import scala.collection.IntStepper

object Nums {
    
    def firstNonRepeatedCharacterWithMap(s: String) : Option[Char] = {
        var map = ListMap.empty[Char, Int]
        for (c <- s.toCharArray()) {  
            map = map.updatedWith(c) { 
                case Some(v) => Some(v+1) 
                case None => Some(1)
            }
        }
        map.collectFirst { case (k, v) if v == 1 => k }
    }
     
    def firstNonRepeatedCharacter(s: String) : Option[Char] = {
        var cnts  = ArrayBuffer.fill(255)(0)
        for ((c, idx) <- s.toCharArray.zipWithIndex) {
            cnts(c) += 1
        }
        s.collectFirst { case c if cnts(c) == 1 => c }  
    }

    def  divide(dividend : Int, divisor : Int) : Int  = {
        if (dividend < divisor) return 0
        var (div, mult) = (divisor, 1)
        while (div + divisor <= dividend) {
            div += divisor
            mult +=1
        }
        return mult
    }

    def findLargestNumber(ls : List[String]) : String =  {
        ls.sortWith { case (s1, s2) => s1.concat(s2).compareTo(s2.concat(s1)) > 0 }.mkString
    }

    def numberOfDigits(n : Int): Int = 1 + Math.log10(n).toInt

    def generateFibo(limit : Int) : Stream[Int]  =  {
        Stream.iterate(Array(0,1))(a => Array(a(1), a(0) + a(1))).take(limit).map( _(0))
    }

    def IsPrime(n : Int) : Boolean = {
        if (n <= 1)
            return  false
        else if (n==2)
            return true

        var result = false;
        for (i <- 2 until n) {
            if (n % i == 0)
                return false
        }
        true;
    }

    def  IsPrimeStream(n : Int) : Boolean = ! ((2 until n-1) exists (n % _ == 0))

    def primeStream(s: Stream[Int]): Stream[Int] = {
        Stream.cons(s.head, primeStream(s.tail filter { _ % s.head != 0 }))
    }

}