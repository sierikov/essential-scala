object Diy {
  def unionSets[A](a: Set[A], b: Set[A]): Set[A] =
    a.foldLeft(b) { (bset, element) => bset + element }

  def unionMapInt[A](a: Map[A, Int], b: Map[A, Int]): Map[A, Int] =
    a.foldLeft(b) { (bmap, apair) =>
      val (akey, avalue) = apair
      val newValue = avalue + bmap.getOrElse(akey, 0)
      bmap + (akey -> newValue)
    }

  def unionMapG[A, B](a: Map[A, B], b: Map[A, B], add: (B, B) => B): Map[A, B] =
    a.foldLeft(b) { (map, pair) =>
      val (k, v1) = pair
      val n = map.get(k).map(v2 => add(v1, v2)).getOrElse(v1)
      map + (k -> n)
    }
}

object solution extends App {
  val a = Set(1, 3, 5, 9)
  val b = Set(2, 4, 6, 9)

  println(Diy.unionSets(a, b))

  val c = Map('a' -> 1, 'b' -> 2)
  val d = Map('a' -> 2, 'b' -> 4)

  println(Diy.unionMapInt(c, d)) // Map('a' -> 3, 'b' -> 6)

  println(Diy.unionMapG(c, d, (a: Int, b: Int) => a + b))
}
