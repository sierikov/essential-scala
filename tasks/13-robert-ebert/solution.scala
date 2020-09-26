case class Director(
    firstName: String,
    lastName: String,
    yearOfBirth: Int
) {
  def name =
    firstName + " " + lastName
}
object Director {
  def older(d1: Director, d2: Director): Director =
    if (d1.yearOfBirth <= d2.yearOfBirth) d1 else d2
}

case class Film(
    name: String,
    yearOfRelease: Int,
    imdbRating: Double,
    director: Director
) {
  def directorsAge =
    yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) =
    this.director == director
}
object Film {
  def highestRating(f1: Film, f2: Film): Double =
    if (f1.imdbRating >= f2.imdbRating) f1.imdbRating else f2.imdbRating

  def oldestDirectorAtTheTime(f1: Film, f2: Film): Director = {
    if (f1.directorsAge >= f2.directorsAge) f1.director else f2.director
  }
}

object solution extends App {
  val nolan = new Director("Christopher", "Nolan", 1970)

  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)

  nolan.yearOfBirth // res16: Int = 1970
  memento.director.name // res17: String = Christopher Nolan
  inception.isDirectedBy(nolan) // res18: Boolean = true

  darkKnight.copy(name = "L'homme des hautes plaines")
  // res19: Film = Film(L'homme des hautes plaines,2008,9.0,Director(Christopher,Nolan,1970))

  darkKnight.copy(
    yearOfRelease = 1968,
    director = new Director("Norman", "Jewison", 1926)
  )
  // res20: Film = Film(Dark Knight,1968,9.0,Director(Norman,Jewison,1926))

  inception.copy().copy().copy()
  // res21: Film = Film(Inception,2010,8.8,Director(Christopher,Nolan,1970))
}
