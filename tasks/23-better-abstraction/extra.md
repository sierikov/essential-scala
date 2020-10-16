# Better Abstraction

## Question 1

Is it more convenient to rewrite methods in terms of `fold`
if they were implemented using pattern matching or polymorphic? What does this tell us about the best
use of fold?

## Anwser 1

When using `fold` in polymorphic implementations we have
a lot of **duplication**; the polymorphic implementations
without `fold` were simpler to write.

The pattern matching implementations benefitted from `fold`
as we removed the duplication in the pattern matching.

In general fold makes a good interface for users *outside*
the class, but not necessarily for use *inside* the class.

---

## Question 2

Why can’t we write our double method in terms of fold? Is it feasible we could if we made some change to fold?

## Anwser 2

The types tell us it won’t work. `fold` returns an `Int` and `double`
returns an `IntList`. However the general structure of `double` is
captured by `fold`. This is apparent if we look at them side-by-side:

```scala
def double: IntList =
  this match {
    case End => End
    case Pair(hd, tl) => Pair(hd * 2, tl.double)
  }

def fold(end: Int, f: (Int, Int) => Int): Int =
  this match {
    case End => end
    case Pair(hd, tl) => f(hd, tl.fold(end, f))
  }
```

If we could generalise the types of `fold` from `Int` to some general
type then we could write `double`.
