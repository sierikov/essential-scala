# Printing Shapes

**Reference**: 4.2.2.1

**Description**:  
First make `Shape` a *sealed trait*. Then write a singleton 
object called `Draw` with an `apply` method that takes a `Shape`
as an argument and returns a description of it on the console.
For example:
```scala
Draw(Circle(10))
// res1: String = A circle of radius 10.0cm

Draw(Rectangle(3, 4))
// res2: String = A rectangle of width 3.0cm and height 4.0cm
```

Finally, verify that the compiler complains when you comment
out a case clause. 
