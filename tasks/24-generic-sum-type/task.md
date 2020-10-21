# Generic Sum Type

**Reference**: 5.4.3

**Description**:  
Implement a trait `Sum[A, B]` with two subtypes `Left` and `Right`.
Create type parameters so that `Left` and `Right` can wrap up values
of two different types.

Example usage:

```scala
Left[Int, String](1).value
// res9: Int = 1

Right[Int, String]("foo").value
// res10: String = foo

val sum: Sum[Int, String] = Right("foo")
// sum: sum.Sum[Int,String] = Right(foo)

sum match {
  case Left(x) => x.toString
  case Right(x) => x
}
// res11: String = foo
```
