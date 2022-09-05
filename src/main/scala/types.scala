
class Parent {}
class ParentExt extends Parent {}
class ParentExtExt extends ParentExt {}

case class Clazz(s : Int)
object Clazz {
    def apply(a : Int, b : Int ) = new Clazz(a)
    def unapply(c : Clazz) : Option[(Int, String, Int)] = Some(c.s, "QQQ", 0)
    def unapplySeq(c : Clazz): Option[List[Int]] = Some(List(c.s))
}

object Types {

  def testClazz() : (Int, String, Int)  = Clazz(0, 1) match { 
    case Clazz(a, b, c) => (a, b, c) 
    case _  => (0, "", -1)
  }

  trait Inv[T]
  trait CoVar[+T]
  trait ContVar[-T]

  trait Function[-A, +B] {
    def apply(a: A): B
  }

  def invariant(p1 : Inv[Parent] , p2 : Inv[Parent])  {}
  def covariant(p1 : CoVar[ParentExt] , p2 : CoVar[ParentExt])  {}
  def contrvariant(p1 : ContVar[ParentExt] , p2 : ContVar[ParentExt])  {}

  def test_variances() {
    invariant(new Inv[Parent]{} , new Inv[Parent] {}) 
    covariant(new CoVar[ParentExt]{} , new CoVar[ParentExtExt] {})
    contrvariant(new ContVar[ParentExt]{} , new ContVar[Parent] {})
  }

  def f1() {

    val f1: Function[Parent, Parent] = a => a
    val f2: Function[ParentExt, Parent] = a => new Parent()
    val f3: Function[ParentExtExt, Parent] = a => new ParentExtExt()

  }

}
