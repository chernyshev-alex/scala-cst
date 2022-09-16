import scala.collection.mutable

object FSStream {

  def fibo() : Stream[BigInt] =  {
    lazy val fibs : Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map( n => n._1 + n._2)
    fibs
  }

  def is_prime(i : Int) : Boolean = {
    if (i <= 1) 
      false
    else if (i==2) 
        true
    else 
      !(2 until i).exists(n => i % n == 0)
  }

  def is_primeErat(n : Int) : Boolean = {
       n >= 2 && (2 to math.sqrt(n).toInt).forall(n%_ != 0)
  }

  def gen_prime(n : Int) : List[Int] = {
    lazy val ps : Stream[Int] = 2 #:: Stream.from(3)
      .filter(x => ps.takeWhile(p => p*p <= x)
      .forall(x %_ !=0))

    ps.takeWhile(_ <=n).toList
  }
}
