# Calculator Again

**Reference**: 5.6.6

**Description**:
We’re going to represent calculations as `Sum[String, Double]`,
where the `String` is an error message. Extend `Sum` to have `map`
and `fold` method.

*Stage 2*: Now we’re going to reimplement the calculator from
last time. We have an abstract syntax tree defined via the
following algebraic data type:

```scala
sealed trait Expression
final case class Addition(left: Expression, right: Expression) extends Expression
final case class Subtraction(left: Expression, right: Expression) extends Expression
final case class Division(left: Expression, right: Expression) extends Expression
final case class SquareRoot(value: Expression) extends Expression
final case class Number(value: Double) extends Expression
```

Now implement a method `eval: Sum[String, Double]` on `Expression`.
Use `flatMap` and `map` on `Sum` and introduce any utility methods
you see fit to make the code more compact. Here are some test cases:

```scala
assert(Addition(Number(1), Number(2)).eval == Success(3))
assert(SquareRoot(Number(-1)).eval == Failure("Square root of negative number"))
assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
assert(Division(Addition(Subtraction(Number(8), Number(6)), Number(2)), Number(2)).eval == Success(2.0))
```
