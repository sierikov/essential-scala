object Utils {
  def addOptions(one: Option[Int], two: Option[Int]): Option[Int] =
    for {
      x <- one
      y <- two
    } yield x + y

  def addOptionsMap(one: Option[Int], two: Option[Int]): Option[Int] =
    one.flatMap(x => two.map(y => x + y))

  def divide(numerator: Int, denominator: Int) =
    if(denominator == 0) None
    else Some(numerator / denominator)

  def divideOptions(numerator: Option[Int], denominator: Option[Int]) =
    for {
      n <- numerator
      d <- denominator
      r <- divide(n, d)
    } yield r
}

object solution extends App {
  Utils.addOptions(Some(3), Some(2))
  Utils.addOptionsMap(Some(3), Some(2))

  Utils.divide(10, 5)
  Utils.divideOptions(Some(10), Some(5))
}
