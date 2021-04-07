sealed trait Sum[A, B] {
  def fold[C](failure: A => C, success: B => C): C =
    this match {
      case Failure(value) => failure(value)
      case Success(value) => success(value)
    }

  def map[C](f: B => C): Sum[A, C] =
    this match {
      case Failure(value) => Failure(value)
      case Success(value) => Success(f(value))
    }

  def flatMap[C](f: B => C): Sum[A, C] =
    this match {
      case Failure(value) => Failure(value)
      case Success(value) => f(value)
    }

}
final case class Failure[A, B](value: A) extends Sum[A, B]
final case class Success[A, B](value: B) extends Sum[A, B]
