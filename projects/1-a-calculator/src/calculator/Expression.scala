package calculator

sealed trait Expression {
  def eval: Calculation =
    this match {
      case Addition(left, right) =>
        left.eval match {
          case Failure(reason) => Failure(reason)
          case Success(l) =>
            right.eval match {
              case Failure(reason) => Failure(reason)
              case Success(r)      => Success(l + r)
            }
        }
      case Subtraction(left, right) =>
        left.eval match {
          case Failure(reason) => Failure(reason)
          case Success(l) =>
            right.eval match {
              case Failure(reason) => Failure(reason)
              case Success(r)      => Success(l - r)
            }
        }
      case Division(left, right) =>
        left.eval match {
          case Failure(reason) => Failure(reason)
          case Success(l) =>
            right.eval match {
              case Failure(reason) => Failure(reason)
              case Success(r) =>
                if (r == 0) Failure("Division by zero")
                else Success(l / r)
            }
        }
      case SquareRoot(value) =>
        value.eval match {
          case Success(value) =>
            if (value > 0) Success(Math.sqrt(value))
            else Failure("Square root of negative number")
        }
      case Number(value) => Success(value)
    }
}

final case class Addition(left: Expression, right: Expression)
    extends Expression
final case class Subtraction(left: Expression, right: Expression)
    extends Expression
final case class Division(left: Expression, right: Expression)
    extends Expression
final case class SquareRoot(value: Expression) extends Expression
final case class Number(value: Double) extends Expression
