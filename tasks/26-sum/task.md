# Sum

**Reference**: 5.5.4

**Description**:  
Recall our `Sum` type.

```scala
sealed trait Sum[A, B] {
  def fold[C](left: A => C, right: B => C): C =
    this match {
      case Left(a) => left(a)
      case Right(b) => right(b)
    }
}
final case class Left[A, B](value: A) extends Sum[A, B]
final case class Right[A, B](value: B) extends Sum[A, B]
```

To prevent a name collision between the built-in `Either`,
rename the `Left` and `Right` cases to `Failure` and `Success` respectively.

Now things are going to get a bit trickier. We are going to
implement `map` and `flatMap`, again using *pattern matching* in the `Sum` trait.

Start with `map`. The general recipe for `map` is to start with a type like `F[A]`
and apply a function `A => B` to get `F[B]`. `Sum` however has two generic type
parameters. To make it fit the `F[A]` pattern we’re going to fix one of these parameters
and allow `map` to alter the other one. The natural choice is to fix the type parameter
associated with `Failure` and allow `map` to alter a `Success`. This corresponds to
“fail-fast” behaviour. If our `Sum` has failed, any sequenced computations don’t get run.

In summary map should have type

```scala
def map[C](f: B => C): Sum[A, C]
```

*Stage 2*: Implement `flatMap` using the same logic as `map`.
