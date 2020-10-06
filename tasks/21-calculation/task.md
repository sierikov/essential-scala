# Calculation

**Reference**: 4.5.6.2

**Description**:  
A calculation may succeed (with an `Int` result) or fail (with a `String` message).
Implement this.

*Stage 2*: We’re now going to write some methods that use
a `Calculation` to perform a larger calculation. These
methods will have a somewhat unusual shape — this is
a precursor to things we’ll be exploring soon — but if
you follow the patterns you will be fine.

Create a `Calculator` object. On `Calculator` define methods `+`
and `-` that accept a `Calculation` and an `Int`, and return a
`new Calculation`. Here are some examples

```scala
assert(Calculator.+(Success(1), 1) == Success(2))
assert(Calculator.-(Success(1), 1) == Success(0))
assert(Calculator.+(Failure("Badness"), 1) == Failure("Badness"))
```
