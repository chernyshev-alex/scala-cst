object Func {

  def test1(): List[Int] = {
    val t = List(0,1,2,3)
    val fn : Int => Int = (t) => t + 10
    return t.map(fn)
  }

  def curried() : Int = {
    val f1 : (Int, Int) => Int = (a, b) => a + b
    val r = f1(1,2)
    val f1c = f1(10, 10)
    // f1c(2)
    val f3 = f1.curried
    f3(10)(10)
    r
  }
}
