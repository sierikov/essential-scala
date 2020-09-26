# Case Classes

## Question 1

Reimplement `Counter` as a case class, using
copy where appropriate. Additionally initialise
`count` to a default value of `0`.

## Anwser 1

```scala
case class Counter(count: Int = 0) {
  def dec = copy(count = count - 1)
  def inc = copy(count = count + 1)
}
```

This is almost a trick exercise there are very few
differences with the previous implementation.
However, notice the extra functionality we got for free:

```scala
Counter(0) // construct objects without `new`
// res16: Counter = Counter(0)

Counter().inc // printout shows the value of `count`
// res17: Counter = Counter(1)

Counter().inc.dec == Counter().dec.inc // semantic equality check
// res18: Boolean = true
```

---

## Question 2

What happens when we define a companion object for a case class? Let’s see.

Take our `Person` class from the previous section and
turn it into a case class. Make sure you still have
the companion object with the alternate `apply`
method as well.

## Anwser 2

```scala
case class Person(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    apply(parts(0), parts(1))
  }
}
```

Even though we are defining a companion object for `Person`,
Scala’s case class code generator is still working as
expected: it adds the auto-generated companion methods to
the object we have defined, which is why we need to place
the class and companion in a single compilation unit.

This means we end up with a companion object with an overloaded `apply` method with two possible type signatures:

```scala
def apply(name: String): Person =
  // etc...

def apply(firstName: String, lastName: String): Person =
  // etc...“
```

---

Was taken from Essential Scala book.
