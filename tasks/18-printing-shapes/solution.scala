sealed trait Color {
  def r: Int
  def g: Int
  def b: Int

  // Define that rgb(127, 127, 127) is neutral color
  def isLight: Boolean = (r + g + b) > (127 + 127 + 127)
  def isDark: Boolean = !isLight
}

case object Red extends Color {
  val r = 255
  val g = 0
  val b = 0
}

case object Yellow extends Color {
  val r = 255
  val g = 255
  val b = 0
}

case object Pink extends Color {
  val r = 255
  val g = 0
  val b = 255
}

final case class CustomColor(r: Int, g: Int, b: Int) extends Color

sealed trait Shape {
  def sides: Int
  def perimeter: Double
  def area: Double
  def color: Color
}

final case class Circle(radius: Double, color: Color) extends Shape {
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

final case class Rectangle(width: Double, height: Double, color: Color) extends Rectangular

final case class Square(size: Double, color: Color) extends Rectangular {
  val width: Double = size
  val height: Double = size
}

object Draw {
  def apply(shape: Shape): String = shape match {
    case Circle(radius, color) => s"A ${Draw(color)} circle of radius ${radius}cm"
    case Rectangle(width, height, color) => s"A ${Draw(color)} rectangle of width ${width}cm" +
      s"and height ${height}cm"
    case Square(size, color) => s"A ${Draw(color)} square with size ${size}cm"
  }

  def apply(color: Color): String = color match {
    case Pink => "pink"
    case Red => "red"
    case Yellow => "yellow"
    case c => if (c.isLight) "light" else "dark"
  }

}

object solution extends App {
  Square(4, Red).perimeter
  Square(4, CustomColor(100, 200, 55)).area
  println (Draw(Circle(10, Yellow)))
}
