object calc {
  def square(x: Double) = x * x
  def cube(x: Double) = x * square(x)

  def square(x: Int) = x * x
  def cube(x: Int) = x * square(x)
}
