object Task extends App {
  // Literal just Literals
  val res0: Int = 42
  val res1: Boolean = true
  val res2: Long = 123L
  val res3: Double = 42.0

  // Quotes ans Misquotes
  val res4: Char = 'a'
  val res5: String = "a"

  // An Aside on Side-Effects
  val res6: String = "Hello World!"
  println("Hello World!") // Type: Unit, no value, side-effect

  // Learning By Mistakes
  /* 'Hello world!' will produce an error. String
  literal must be wraped in double quotes */
}
