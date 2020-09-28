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

sealed trait Rectangular extends Shape {
  val sides = 4
  override val perimeter: Double = 2 * (width + height)
  override val area: Double = width * height

  def width: Double

  def height: Double
}

case class Rectangle(width: Double, height: Double) extends Rectangular

case class Square(size: Double) extends Rectangular {
  val width: Double = size
  val height: Double = size
}

object solution extends App {
  Square(4).perimeter
  Square(4).area
}
