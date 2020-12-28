object Utils {
  def divide(numerator: Int, denominator: Int) =
    if (denominator == 0) None
    else Some(numerator / denominator)

  def toInt(s: String): Option[Int] = {
    try {
      Some(s.toInt)
    } catch {
      case e: Exception => None
    }
  }

  def calculator(operand1: String, operator: String, operand2: String): Unit = {
    def calc(a: Int, b: Int): Option[Int] =
      operator match {
        case "+" => Some(a + b)
        case "-" => Some(a - b)
        case "*" => Some(a * b)
        case "/" => divide(a, b)
        case _ => None
      }

    val result = toInt(operand1) flatMap { a =>
      toInt(operand2) flatMap { b =>
        calc(a, b) map {
          result => result
        }
      }
    }

    result match {
      case None => println(s"Error calculating...")
      case Some(value) => println(s"The answer is $value")
    }
  }
}

object solution extends App {
  Utils.calculator("1", "-", "1")
}
