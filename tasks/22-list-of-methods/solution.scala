sealed trait LinkedList[A] {
  def apply(index: Int): A = {
    this match {
      case Pair(head, tail) =>
        if (index == 0) head
        else tail(index - 1)
      case End() => throw new IndexOutOfBoundsException("Index Out Of Bounds")
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

  assert(example(0) == 1)
  assert(example(1) == 2)
  assert(example(2) == 3)
  assert(try {
    example(3)
    false
  } catch {
    case e: Exception => true
  })
}
