# Simple Counter

**Reference**: 3.1.6.4

**Description**:  
Implement a `Counter` class. The constructor should take an `Int`.
The methods `inc` and `dec` should increment and decrement the counter
respectively returning a new `Counter`. Here’s an example of the usage:

```scala
new Counter(10).inc.dec.inc.inc.count
// res23: Int = 12
```

*Stage 2*: Counting Faster  
Augment the `Counter` from the previous exercise to allow the user can
optionally pass an `Int` parameter to `inc` and `dec`. If the parameter is
omitted it should default to `1`.

*Stage 3*: Additional Counting  
Here is a simple class called `Adder`.

```scala
class Adder(amount: Int) {
  def add(in: Int) = in + amount
}
```

Extend `Counter` to add a method called `adjust`. This method should accept an `Adder` and return a new `Counter` with the result of applying the `Adder` to the `count`.
