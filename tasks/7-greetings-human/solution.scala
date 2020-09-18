object person {
  val firstName = "John"
  val lastName = "Doe"
}

object alien {
  def greet(p: person.type): String = s"Greetings, " + p.firstName + " " + p.lastName
}
