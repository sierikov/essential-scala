trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
}

case class Circle(radius: Double) extends Shape {
  val sides = 1
  val perimeter: Double = 2 * math.Pi * radius
  val area: Double = math.Pi * math.pow(radius, 2)
}

case class Rectangle(width: Double, height: Double) extends Shape {
  val sides = 4
  val perimeter: Double = 2 * (width + height)
  val area: Double = width * height
}

case class Square(side: Double) extends Shape {
  val sides = 4
  val perimeter: Double = 4 * side
  val area: Double = math.pow(side, 2)
}
