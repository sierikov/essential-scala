// Pattern match
sealed trait Tree[A] {
  def fold[B](node: (B, B) => B, leaf: A => B): B =
    this match {
      case Leaf(value) => leaf(value)
      case Node(left, right) =>
        node(left.fold(node, leaf), right.fold(node, leaf))
    }
}

case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]

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
