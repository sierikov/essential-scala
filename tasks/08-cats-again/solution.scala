class Cat(val colour: String, val food: String)

object ChipShop {
  def willServe(cat: Cat) = cat.food == "Chips"
}

object solution extends App {
  val oswald = new Cat("Black", "Milk")
  val henderson = new Cat("Ginger", "Chips")
  val quentin = new Cat("Tabby", "Curry")

  ChipShop.willServe(henderson)
  ChipShop.willServe(quentin)
}
