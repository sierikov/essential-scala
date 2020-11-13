package calculator

sealed trait Sum[+A, +B] {
  def fold[C](failure: A => C, success: B => C): C =
    this match {
      case Failure(f) => failure(f)
      case Success(s) => success(s)
    }

  def map[C](f: B => C): Sum[A, C] =
    this match {
      case Failure(f) => Failure(f)
      case Success(s) => Success(f(s))
    }

  def flatMap[AA >: A, C](f: B => Sum[AA, C]): Sum[AA, C] =
    this match {
      case Failure(f) => Failure(f)
      case Success(s) => f(s)
    }
}
final case class Failure[A](value: A) extends Sum[A, Nothing]
final case class Success[B](value: B) extends Sum[Nothing, B]
