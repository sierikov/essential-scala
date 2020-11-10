sealed trait Sum[A, B] {
  def fold[C](failure: A => C, success: B => C): C =
    this match {
      case Failure(a) => failure(a)
      case Success(b) => success(b)
    }

  def map[C](f: B => C): Sum[A, C] =
    this match {
      case Failure(value) => Failure(value)
      case Success(value) => Success(f(value))
    }
}
final case class Failure[A, B](value: A) extends Sum[A, B]
final case class Success[A, B](value: B) extends Sum[A, B]
