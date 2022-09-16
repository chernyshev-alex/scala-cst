import org.scalatest.funsuite.AnyFunSuite

class StreamsTests extends AnyFunSuite {

    test("is_prime") {
        assert(FSStream.is_prime(3), true)
    }

    test("is_primeErat") {
        assert(FSStream.is_primeErat(3), true)
    }

    test("gen prime") {
        assert(FSStream.gen_prime(10) === List(2,3,5,7))
    }

}