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
