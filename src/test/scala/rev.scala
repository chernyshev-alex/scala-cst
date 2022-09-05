
import org.scalatest.funsuite.AnyFunSuite
import scala.annotation.tailrec
import scala.collection.immutable

class ReverseTest extends AnyFunSuite {

  test("t1") {
    val ls = Rev.reverse_list(List(1,2, 3))
    assert(ls == List(3, 2, 1))
  }

  test("tr") {
    val ls = Rev.reverse_listR(List(1,2, 3))
    assert(ls == List(3, 2, 1))
  }

  test("t2") {
    val ls = Rev.reverse_list2(List(1,2, "A"))
    assert(ls == List("A", 2, 1))
  }

  test("t3") {
    val ls = Rev.reverse_list3(List(1,2, "A"))
    assert(ls == List("A", 2, 1))
  }

  test("t4") {
    assert(Rev.rev4(List(1,2)) === List(2,1))
  }

  test("t5") {
    var ls = List(1,2, 3)
    assert(Rev.rev5(ls.head, ls.tail) === List(3,2,1))
  }

  test("t6") {
    val revs = Rev.revStream(Stream(1, 2, 3))
    assert(revs.force === List(3,2,1))
  }

   test("factorial") {
    assert(Rev.factorial(7).force === List(1, 2, 6, 24, 120, 720, 5040))
  }

   test("view") {
    var ls = List(1,2)
    val lsv = ls.view
  }
}
