package faang

object searchSort {

    def swap(ar : Array[Int], l : Int,  r : Int) {
        val t = ar(l)
        ar(l) = ar(r)
        ar(r) = t
    }

    def  partition(ar : Array[Int], l : Int,  r : Int) : Int = {
        val pivot = ar(r);
        var pidx = l;
        for (i <- l until r) {
            if (ar(i) <= pivot) {
                swap(ar, i, pidx);
                pidx +=1;
            }
        }
        swap(ar, pidx, r);
        pidx;
    };

    def qsort(nums : Array[Int], l : Int,  r : Int) {
        if (l < r) {
            val p = partition(nums, l, r);
            qsort(nums, l, p-1);
            qsort(nums, p+1, r);
        }
    }

    def findKthLargest(nums : Array[Int], k : Int) = {
        qsort(nums, 0, nums.length -1)
        nums(nums.length-k)
    }

    def findKthSmallest(nums : Array[Int], k : Int) = {
        for {
            _k <- 0 until  k
            i <- _k until nums.length
        } yield {
            if (nums(_k) > nums(i)) {
                val t = nums(_k);
                nums(_k) = nums(i);
                nums(i) = t;
            }
        }
        nums(k-1)
    }

    def  __findKthSmallestQSort(ints : Array[Int], l : Int, r : Int) {
        if (l < r) {
            val p = partition(ints, l, r);
            __findKthSmallestQSort(ints, l, p-1);
            __findKthSmallestQSort(ints, p+1, r);
        }
    }

    def findKthSmallestQSort(ints : Array[Int], k : Int) = {
        __findKthSmallestQSort(ints, 0, ints.length-1);
        ints(k-1);
    }

    def findKthSmallestWithStream(ints : Array[Int], k : Int) = {
        Stream.from(ints).sorted.take(k).toArray.apply(k-1);
    }
}