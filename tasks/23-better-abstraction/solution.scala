sealed trait IntList {
  def fold(end: Int, f: (Int, Int) => Int): Int =
    this match {
      case End          => end
      case Pair(hd, tl) => f(hd, tl.fold(end, f))
    }

  def length: Int =
    fold(0, (_, tail: Int) => 1 + tail)

  def product: Int =
    fold(1, (head: Int, tail: Int) => head * tail)

  def sum: Int =
    fold(0, (head: Int, tail: Int) => head + tail)

  def double: IntList =
    this match {
      case End          => End
      case Pair(hd, tl) => Pair(hd * 2, tl.double)
    }
}

case object End extends IntList
case class Pair(hd: Int, tl: IntList) extends IntList
