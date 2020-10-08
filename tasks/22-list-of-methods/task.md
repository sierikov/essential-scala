# List of methods

**Reference**: 4.6.3

**Description**:  
Using our definition of IntList:

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
