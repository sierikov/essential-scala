case object Utils {
  def smallest(seq: Seq[Int]): Int =
    seq.foldLeft(Int.MaxValue)((a, b) => if (a < b) a else b)

  def unique(seq: Seq[Int]): Seq[Int] =
    seq.foldLeft(Seq.empty[Int])((seq, a) =>
      if (!seq.contains(a)) seq :+ a
      else seq
    )
}

object solution extends App {
  val seq = Seq(52, 85, 1, 2, 1, 1, 3, 8, 3, 2, 7)

  Utils.smallest(seq)
  Utils.unique(seq)
}
