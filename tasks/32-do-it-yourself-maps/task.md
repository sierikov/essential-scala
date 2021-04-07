# Do it yourself

**Reference**: 6.8.4

**Description**:  

Here we try to implement some useful library functions. 
They will help us to work with `Map`s.

*Union of Sets*:
Write a method that takes two sets and returns a set
containing the union of the elements. Use iteration,
like `map` or `foldLeft`, not the built-in `union` method to 
do so!

*Union of Maps*:
Now let’s write union for maps. 
Assume we have two `Map[A, Int]` and add corresponding
elements in the two maps. So the union of
`Map('a' -> 1, 'b' -> 2)` and `Map('a' -> 2, 'b' -> 4)` should be
`Map('a' -> 3, 'b' -> 6)`.

*Generic Union*:
There are many things that can be added, such as strings 
(string concatenation), sets (union), and of course numbers. 
It would be nice if we could generalise our `union` method on 
maps to handle anything for which a sensible `add` operation 
can be defined. How can we go about doing this?
