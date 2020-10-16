sealed trait IntList {
  def fold[A](end: A, f: (Int, A) => A): A =
    this match {
      case End              => end
      case Pair(head, tail) => f(head, tail.fold(end, f))
    }

  def length: Int =
    fold[Int](0, (_, tail: Int) => 1 + tail)

  def product: Int =
    fold[Int](1, (head: Int, tail: Int) => head * tail)

  def sum: Int =
    fold[Int](0, (head: Int, tail: Int) => head + tail)

  def double: IntList =
    fold[IntList](End, (head: Int, tail: IntList) => Pair(head * 2, tail))
}

case object End extends IntList
case class Pair(hd: Int, tl: IntList) extends IntList
