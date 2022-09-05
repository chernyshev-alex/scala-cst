import org.scalatest.funsuite.AnyFunSuite

class ImplObjTest extends AnyFunSuite {

    test("readfile") {
         assert(ImplObj.t1 ==20)
    }

   test("const <:<") {
         assert(ImplObj.constr1 ==0)
    }

}