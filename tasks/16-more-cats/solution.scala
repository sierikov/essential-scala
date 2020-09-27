trait Feline {
  def colour: String
  def sound: String
}

trait BigCat extends Feline {
  override val sound: String = "roar"
}

case class Tiger(colour: String) extends BigCat

case class Lion(colour: String, maneSize: Int) extends BigCat

case class Panter(colour: String) extends BigCat

case class Cat(colour: String, favouriteFood: String) extends Feline {
  val sound = "meow"
}
