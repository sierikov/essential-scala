// Polimorphic
sealed trait Tree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B
}

case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B =
    node(left.fold(node, leaf), right.fold(node, leaf))
}
final case class Leaf[A](value: A) extends Tree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B =
    leaf(value)
}

object solution extends App {
  val tree: Tree[String] =
    Node(
      Node(Leaf("To"), Leaf("iterate")),
      Node(
        Node(Leaf("is"), Leaf("human,")),
        Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))
      )
    )

  val t = tree.fold[String]((a, b) => a + " " + b, str => str)
  print(t)
}
