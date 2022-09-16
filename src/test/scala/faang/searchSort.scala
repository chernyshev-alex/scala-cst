package faang

import org.scalatest.funsuite.AnyFunSuite

class SearchSortTest extends AnyFunSuite {

    // https://leetcode.com/problems/kth-largest-element-in-an-array/
    //
    
    test ("FindKthLargest") {
        val res = searchSort.findKthLargest(Array(3, 2, 1, 5, 6, 4), 2);
        assert(res == 5);
    }

    test ("FindKthSmallest") {
        val res = searchSort.findKthSmallest(Array(3, 6, 1, 5, 2, 4), 2);
        assert(2 == res);
    }

    test ("FindKthSmallestQSort") {
        val res = searchSort.findKthSmallestQSort(Array(3, 6, 1, 5, 2, 4), 2);
        assert(2 == res);
    }

    test ("FindKthSmallestWithStream") {
        val res = searchSort.findKthSmallestWithStream(Array(3, 6, 1, 5, 2, 4), 2);
        assert(2 == res);
    }

}