sealed trait Sum[A, B] {
  def fold[C](left: A => C, right: B => C): C =
    this match {
      case Left(value) => left(value)
      case Right(value) => right(value)
    }
}

case class Left[A, B](value: A) extends Sum[A, B]
case class Right[A, B](value: B) extends Sum[A, B]

object solution extends App {
  Left[Int, String](1).value
  // res9: Int = 1

  Right[Int, String]("foo").value
  // res10: String = foo

  val sum: Sum[Int, String] = Right("foo")
  // sum: sum.Sum[Int,String] = Right(foo)

  sum match {
    case Left(x)  => x.toString
    case Right(x) => x
  }
  // res11: String = foo
}
