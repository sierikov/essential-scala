package calculator

trait Expression {
  def eval: Sum[String, Double] =
    this match {
      case Addition(left, right) =>
        left.eval.flatMap { l =>
          right.eval.flatMap { r =>
            Success(l + r)
          }
        }
      case Subtraction(left, right) =>
        left.eval.flatMap { l =>
          right.eval.flatMap { r =>
            Success(l - r)
          }
        }
      case Division(left, right) =>
        left.eval.flatMap { l =>
          right.eval.flatMap { r =>
            if (r == 0) Failure("Division by zero")
            else Success(l / r)
          }
        }
      case SquareRoot(value) =>
        value.eval.flatMap { v =>
          if (v > 0) Success(Math.sqrt(v))
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
