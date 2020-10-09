import calculator._

object Solution extends App{
  assert(Addition(SquareRoot(Number(-1.0)), Number(2.0)).eval ==
    Failure("Square root of negative number"))
  assert(Addition(SquareRoot(Number(4.0)), Number(2.0)).eval == Success(4.0))
  assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
}
