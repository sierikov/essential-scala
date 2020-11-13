import calculator._

object Solution extends App {
  assert(Addition(Number(1), Number(2)).eval == Success(3))
  println(Addition(Number(1), Number(4)).eval)
  assert(
    SquareRoot(Number(-1)).eval == Failure("Square root of negative number")
  )
  assert(Division(Number(4), Number(0)).eval == Failure("Division by zero"))
  assert(
    Division(
      Addition(Subtraction(Number(8), Number(6)), Number(2)),
      Number(2)
    ).eval == Success(2.0)
  )
}
