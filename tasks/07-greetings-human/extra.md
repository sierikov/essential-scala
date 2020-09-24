# The Value of Methods

## Question

Are methods values? Are they expressions?
Why might this be the case?

## Anwser

First let’s deal with the equivalence between methods and expressions
As we know, expressions are program fragments that produce values.
A simple test of whether something is an expression is to see if
we can assign it to a field.

```scala
object calculator {
  def square(x: Int) = x * x
}

val someField = calculator.square
// <console>:15: error: missing argument list for method square in object calculator
// Unapplied methods are only converted to functions when a function type is expected.
// You can make this conversion explicit by writing `square _` or `square(_)` instead of `square`.
//        val someField = calculator.square
```

Although we don’t understand this error message fully yet (we shall
learn about “partially applied functions” later), it does show us
that `square` is *not an expression*. However, a *call* to
`square` *does* yield a value:

```scala
val someField = calculator.square(2)
// someField: Int = 4
```

A method with no arguments looks like it behaves differently.
However, this is a trick of the syntax.

```scala
object clock {
  def time = System.currentTimeMillis
}

val now = clock.time
// now: Long = 1594032605030
```

Although it looks like `now` is being assigned `clock.time` as a
value, it is actually being assigned the *value returned by*
calling `clock.time`. We can demonstrate this by calling the
method again:

```scala
val aBitLaterThanNow = clock.time
// aBitLaterThanNow: Long = 1594032605068
```

As we saw above, references to fields and calls to argumentless
methods look identical in Scala. This is by design, to allow us
to swap the implementation of a field for a method (and vice versa)
without affecting other code. It is a „programming language feature
called the [uniform access principle](https://en.wikipedia.org/wiki/Uniform_access_principle).

So, in summary, *calls to methods* are *expressions* but *methods*
themselves *are not expressions*. In addition to methods, Scala also
has a concept called *functions*, which are objects that can be
invoked like methods. As we know objects are values, so functions
are also values and can be treated as data. As you may have guessed,
functions are a critical part of *functional programming*, which is
one of Scala’s major strengths. We will learn about functions and
functional programming in a bit.

The Anwser was fully taken from "Essential Scala" book.
