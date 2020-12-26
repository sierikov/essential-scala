object Utils {
  def divide(numerator: Int, denominator: Int) =
    if (denominator == 0) None
    else Some(numerator / denominator)

  def eval(operator: String, p1: Int, p2: Int): Option[Int] =
    operator match {
      case "+" => Some(p1 + p2)
      case "-" => Some(p1 - p2)
      case "*" => Some(p1 * p2)
      case "/" => divide(p1, p2)
      case _   => None
    }

  def check(result: Option[Int]) =
    result match {
      case None        => println(s"Error calculating...")
      case Some(value) => println(s"The answer is $value")
    }

  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => None
    }
  }

  def calculator(operand1: String, operator: String, operand2: String): Unit =
    for {
      a <- toInt(operand1)
      b <- toInt(operand2)
    } yield check(eval(operator, a, b))
}

object solution extends App {
  Utils.calculator("1", "-", "1")
}
