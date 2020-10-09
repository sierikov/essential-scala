package calculator

sealed trait Calculation

final case class Success(result: Double) extends Calculation
final case class Failure(reason: String) extends Calculation
