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

*Stage 2*: Write a sealed trait `Color` to make our shapes more interesting.
           
Give `Color` three properties for its `RGB` values;

- create three predefined colours: `Red`, `Yellow`, and `Pink`;
- provide a means for people to produce their own custom `Color`s with their own RGB values;
- provide a means for people to tell whether any Color is “light” or “dark”.

A lot of this exercise is left deliberately open to interpretation. 
The important thing is to practice working with traits, classes, and objects.
           
Decisions such as how to model colours and what is considered a light or dark colour
can be left up to you.
           
Edit the code for `Shape` and its subtypes to add a colour to each shape.
           
Finally, update the code for `Draw.apply` to print the colour of the argument as well as its shape and dimensions:

- if the argument is a predefined colour, print that colour by name:
  ```scala 
  Draw(Circle(10, Yellow))
  // res8: String = A yellow circle of radius 10.0cm
  ``` 
- if the argument is a custom colour rather than a predefined one, print the word “light” or “dark” instead.
