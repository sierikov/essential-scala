# Intranet Movie Database

**Reference**: 6.2.7

**Description**:  
We know the essential methods of `Seq`, we can
write our own versions of some other library methods.

*Minimum*: Write a method to find the smallest element of a `Seq[Int]`.

*Unique* : Given `Seq(1, 1, 2, 4, 3, 4)` create the sequence containing
each number only once. Order is not important, so `Seq(1, 2, 4, 3)` or
`Seq(4, 3, 2, 1)` are equally valid answers.  
Hint: Use contains to check if a sequence contains a value.

*Reverse*: Write a function that reverses the elements of a sequence.
Your output does not have to use the same concrete implementation as
the input. Hint: use `foldLeft`.

*Map*: Write map in terms of `foldRight`.

*Fold Left*: Write your own implementation of foldLeft that uses `foreach`
and mutable state. Remember you can create a mutable variable using the `var`
keyword, and assign a new value using `=`. For example

```scala
var mutable = 1
// mutable: Int = 1

mutable = 2
// mutable: Int = 2
```
