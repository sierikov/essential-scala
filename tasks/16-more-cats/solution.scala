trait Feline {
  def colour: String
  def sound: String
}

case class Tiger(colour: String) extends Feline {
  val sound = "roar"
}

case class Lion(colour: String, maneSize: Int) extends Feline {
  val sound = "roar"
}

case class Panter(colour: String) extends Feline {
  val sound = "roar"
}

case class Cat(colour: String, favouriteFood: String) extends Feline {
  val sound = "meow"
}
