sealed trait IntList {
  def length: Int =
    this match {
      case Pair(_, tail) => 1 + tail.length
      case End           => 0
    }

  def product: Int =
    this match {
      case Pair(head, tail) => head * tail.product
      case End              => 1
    }

  def double: IntList =
    this match {
      case Pair(head, tail) => Pair(head * 2, tail.double)
      case End              => End
    }
}

case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList

object solution extends App {
  val example = Pair(1, Pair(2, Pair(3, End)))

  assert(example.length == 3)
  assert(example.tail.length == 2)
  assert(End.length == 0)

  assert(example.product == 6)
  assert(example.tail.product == 6)
  assert(End.product == 1)

  assert(example.double == Pair(2, Pair(4, Pair(6, End))))
  assert(example.tail.double == Pair(4, Pair(6, End)))
  assert(End.double == End)
}
