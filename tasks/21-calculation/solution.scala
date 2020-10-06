sealed trait Calculation

final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

object Calculator {
  def +(calculation: Calculation, value: Int): Calculation =
    calculation match {
      case Success(result) => Success(result + value)
      case fail@Failure(_) => fail
    }

  def -(calculation: Calculation, value: Int): Calculation =
    calculation match {
      case Success(result) => Success(result - value)
      case fail@Failure(_) => fail
    }
}
