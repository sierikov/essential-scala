sealed trait Shape {
  def sides: Int

  def perimeter: Double

  def area: Double
}

final case class Circle(radius: Double) extends Shape {
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

final case class Rectangle(width: Double, height: Double) extends Rectangular

final case class Square(size: Double) extends Rectangular {
  val width: Double = size
  val height: Double = size
}

object Draw {
  def apply(shape: Shape): Unit =
    println(shape match {
      case Circle(radius) => s"A circle of radius ${radius}cm"
      case Rectangle(width, height) => s"A rectangle of width ${width}cm" +
        s"and height ${height}cm"
      case Square(size) => s"A square with size ${size}cm"
    })
}

object solution extends App {
  Square(4).perimeter
  Square(4).area
  Draw(Circle(2))
}
