
class Fruit
class Apple  extends Fruit
class Banana extends Fruit
class BananaApple extends Apple

abstract class Serializer[-A] {
    def serialize(a: A): String
  }

object ImplObj {

    val animalSerializer: Serializer[Apple] = new Serializer[Fruit] {

      override def serialize(a: Fruit): String = ???
    }

    def t1 = {
        implicit val m1 = "2"
        implicit def asInt(implicit s : String) = s.toInt
      
        def multiply(implicit by: Int) = 10 * by
        multiply 
    }

    class PetContainer[P <: Apple](p: P) {
        def pet: P = p
    }

    def subtype[T, U](t: T, u: U)(implicit ev: T <:< U) = (t, u)
    def subtype2[T, U <: Apple](t: T, u: U) = (t, u)

    def constr1 = {
        new PetContainer[Apple](new BananaApple())

        subtype(new Banana, new Fruit)
        subtype2(new Banana, new Apple)   
    }
}