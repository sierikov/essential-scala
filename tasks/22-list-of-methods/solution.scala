sealed trait LinkedList[A] {
  def length: Int =
    this match {
      case Pair(_, tail) => 1 + tail.length
      case End()         => 0
    }
}

final case class End[A]() extends LinkedList[A]
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

object solution extends App {
  val example = Pair(1, Pair(2, Pair(3, End())))

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End().length == 0)
}
