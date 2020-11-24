case object Utils {
  def smallest(seq: Seq[Int]): Int =
    seq.foldLeft(Int.MaxValue)((a, b) => if (a < b) a else b)
}

object solution extends App {
  val seq = Seq(52, 85, 1, 8, 3, 2, 7)

  Utils.smallest(seq)
}
