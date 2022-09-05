import org.scalatest.funsuite.AnyFunSuite

class FuncTest extends AnyFunSuite {
    test("tf1") {
        val r = Func.test1()
        assert(r == List(10, 11, 12, 13))
    }

    test("curried") {
        val r = Func.curried()
        assert(r ==3)
    }
}