sealed trait Expression {
  def eval: Double =
    this match {
      case Addition(left, right)    => left.eval + right.eval
      case Subtraction(left, right) => left.eval + right.eval
      case Number(value)            => value
    }
}
final case class Addition(left: Expression, right: Expression)
    extends Expression
final case class Subtraction(left: Expression, right: Expression)
    extends Expression
final case class Number(value: Double) extends Expression
