case class Cat(colour: String, food: String)

object ChipShop {
  def willServe(cat: Cat) =
    cat match {
      case Cat(_, "Chips") => true
      case _ => false
    }
}

object solution extends App {
  val oswald = new Cat("Black", "Milk")
  val henderson = new Cat("Ginger", "Chips")
  val quentin = new Cat("Tabby", "Curry")

  ChipShop.willServe(henderson)
  ChipShop.willServe(quentin)
}
