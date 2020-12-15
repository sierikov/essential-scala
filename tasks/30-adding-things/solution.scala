object Utils {
  def addOptions(one: Option[Int], two: Option[Int]): Option[Int] =
    for {
      x <- one
      y <- two
    } yield x + y

  def addOptionsMap(one: Option[Int], two: Option[Int]): Option[Int] =
    one.flatMap(x => two.map(y => x + y))
}

object solution extends App {
  Utils.addOptions(Some(3), Some(2))
  Utils.addOptionsMap(Some(3), Some(2))
}
