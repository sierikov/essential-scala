# A Tree

**Reference**: 5.3.4

**Description**:  
A binary tree can be defined as follows:

A `Tree` of type `A` is a `Node` with a left and right `Tree`
or a `Leaf` with an element of type `A`.

Implement this algebraic data type along with a `fold` method.

*Stage 2*: Using `fold` convert the following `Tree` to a `String`

```scala
val tree: Tree[String] =
  Node(Node(Leaf("To"), Leaf("iterate")),
       Node(Node(Leaf("is"), Leaf("human,")),
            Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))
```

Remember you can append `Strings` using the `+` method.
