# Better Abstraction

**Reference**: 5.2.3

**Description**:  
Using our definition of `IntList`:

```scala
sealed trait IntList
case object End extends IntList
final case class Pair(head: Int, tail: IntList) extends IntList
```

By developing methods `length`, `double`, `sum` and `product` you wrote something like this:

```scala
sealed trait IntList {
  def length: Int =
    this match {
      case End => 0
      case Pair(hd, tl) => 1 + tl.length
    }
  def double: IntList =
    this match {
      case End => End
      case Pair(hd, tl) => Pair(hd * 2, tl.double)
    }
  def product: Int =
    this match {
      case End => 1
      case Pair(hd, tl) => hd * tl.product
    }
  def sum: Int =
    this match {
      case End => 0
      case Pair(hd, tl) => hd + tl.sum
    }
}

case object End extends IntList
case class Pair(hd: Int, tl: IntList) extends IntList
```

Now we are trying to abstract methods with help of functions
to reduce boilerplate code in our trait.

We started developing an abstraction over `sum`, `length`,
and `product` which we sketched out as:

```scala
def abstraction(end: Int, f: ???): Int =
  this match {
    case End => end
    case Pair(hd, tl) => f(hd, tl.abstraction(end, f))
  }
```

Rename this function to `fold`, which is the name it is
usually known as, and finish the implementation.

*Stage 2*: Now reimplement `sum`, `length`, and `product`
in terms of `fold`.

*Stage 3*: Implement a generalised version of `fold` and
rewrite `double` in terms of it.
