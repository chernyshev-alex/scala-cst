
object Rev {

  def reverse_list[T](ls : List[T]) : List[T] = {
    return ls.foldLeft(List.empty[T])((a, b) => a.::(b))
  }

  def reverse_listR[T](ls : List[T]) : List[T] = {
    return ls.foldRight(List.empty[T])((a, b) => b.:+(a))
  }

 def reverse_list2[T](ls : List[T]) : List[T] = {
    var result = List.empty[T]
    ls.foreach {
      case e => result = result.::(e)
    }
    result
  }

 def reverse_list3[T](ls : List[T]) : List[T] = {
  ls match {
    case Nil => List.empty[T]
    case h :: next => reverse_list3(next) :+ h
  }
 }

   def rev4(ls  : List[Int]) : List[Int] = {
    ls match {
      case Nil => List()
      case h :: Nil => List(h)
      case h :: t => rev4(t) :+ h
   
    }
  }

  def rev5(head : Int, tail : List[Int] ) : List[Int] = {
    tail match {
      case Nil  => List(head)
      case h :: t => { 
        rev5(h, t) :+ head
      }
    }
  }

  def revStream(s : Stream[Int]) : Stream[Int] = {
    var xs = Stream.empty[Int]
    val it = s.iterator
    while (it.hasNext) xs = it.next() +: xs
    xs
  } 

  def factorial(n : Int) : Stream[Int] = {
    def factorial(a : Int, b : Int) : Stream[Int] = a #:: factorial(a * (b+1), b+1)
    factorial(1, 1).take(n)
  }
}