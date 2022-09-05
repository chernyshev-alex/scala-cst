

import org.scalatest.funsuite.AnyFunSuite

class TypesTest extends AnyFunSuite {

    test("t1") {
        val r = Types.testClazz()
        assert(r == (0, "QQQ", 0))
    }

}