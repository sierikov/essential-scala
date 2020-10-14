sealed trait Result[A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](reason: String) extends Result[A]

sealed trait LinkedList[A] {
  def apply(index: Int): Result[A] = {
    this match {
      case Pair(head, tail) =>
        if (index == 0) Success(head)
        else tail(index - 1)
      case End() => Failure("Index out of bounds")
    }
  }

  def length: Int =
    this match {
      case Pair(_, tail) => 1 + tail.length
      case End()         => 0
    }

  def contains(target: A): Boolean =
    this match {
      case Pair(head, tail) =>
        if (head == target) true
        else tail contains target
      case End() => false
    }
}

final case class End[A]() extends LinkedList[A]
final case class Pair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]

object solution extends App {
  val example = Pair(1, Pair(2, Pair(3, End())))

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End().length == 0)

  assert(example.contains(3) == true)
  assert(example.contains(4) == false)
  assert(End().contains(0) == false)
  // This should not compile
  // example.contains("not an Int")

  assert(example(0) == Success(1))
  assert(example(1) == Success(2))
  assert(example(2) == Success(3))
  assert(example(3) == Failure("Index out of bounds"))
}
