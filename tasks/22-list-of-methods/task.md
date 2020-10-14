# List of methods

**Reference**: 4.6.3

**Description**:  
Using our definition of `IntList`:

```scala
sealed trait IntList
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList
```

define a method `length` that returns the length of the list.
There is test data below you can use to check your solution.
For this exercise it is best to use pattern matching in the
base trait.

```scala
val example = Pair(1, Pair(2, Pair(3, End)))

assert(example.length == 3)
assert(example.tail.length == 2)
assert(End.length == 0)
```

*Stage 2*: Define a method to compute the product of the elements
in an `IntList`. Test cases are below.

```scala
assert(example.product == 6)
assert(example.tail.product == 6)
assert(End.product == 1)
```

*Stage 3*: Define a method to double the value of each element
in an `IntList`, returning a `new IntList`. The following test
cases should hold:

```scala
assert(example.double == Pair(2, Pair(4, Pair(6, End))))
assert(example.tail.double == Pair(4, Pair(6, End)))
assert(End.double == End)
```

*Stage 4*: Change the name to `LinkedList` and make it generic in the
type of data stored in the list. Delete `product` and `double` methods.

*Stage 5*: On the JVM we can compare all values for
equality. Implement a method `contains` that determines
whether or not a given item is in the list. Ensure your
code works with the following test cases:

```scala
val example = Pair(1, Pair(2, Pair(3, End())))
assert(example.contains(3) == true)
assert(example.contains(4) == false)
assert(End().contains(0) == false)
// This should not compile
// example.contains("not an Int")
```

*Stage 6*: Implement a method `apply` that returns the
`n`-th item in the list

Tests:

```scala
val example = Pair(1, Pair(2, Pair(3, End())))
assert(example(0) == 1)
assert(example(1) == 2)
assert(example(2) == 3)
assert(try {
  example(3)
  false
} catch {
  case e: Exception => true
})
```

*Stage 7*: Throwing an **exception isn’t cool**.
Whenever we throw an exception we **lose type safety** as
there is nothing in the type system that will remind us
to deal with the error. It would be much better to return
some kind of result that encodes we can succeed or failure.
We introduced such a type in this very section.

Define ADT for `Result`. The operation can `Success` with `result` or `Failure` with `reason`. Make it generic - so
we can return any results.

Change `apply` so it returns a `Result`, with a failure
case indicating what went wrong. Here are some test cases
to help you:

```scala
assert(example(0) == Success(1))
assert(example(1) == Success(2))
assert(example(2) == Success(3))
assert(example(3) == Failure("Index out of bounds"))
```
