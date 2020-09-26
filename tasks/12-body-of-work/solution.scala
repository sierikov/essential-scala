class Director(
    val firstName: String,
    val lastName: String,
    val yearOfBirth: Int
) {
  def name =
    firstName + " " + lastName
}
object Director {
  def apply(firstName: String, lastName: String, yearOfBirth: Int) =
    new Director(firstName, lastName, yearOfBirth)

  def older(d1: Director, d2: Director): Director =
    if (d1.yearOfBirth <= d2.yearOfBirth) d1 else d2
}

class Film(
    val name: String,
    val yearOfRelease: Int,
    val imdbRating: Double,
    val director: Director
) {
  def directorsAge =
    yearOfRelease - director.yearOfBirth

  def isDirectedBy(director: Director) =
    this.director == director

  def copy(
      name: String = this.name,
      yearOfRelease: Int = this.yearOfRelease,
      imdbRating: Double = this.imdbRating,
      director: Director = this.director
  ): Film =
    new Film(name, yearOfRelease, imdbRating, director)
}
object Film {
  def apply(
      name: String,
      yearOfRelease: Int,
      imdbRating: Double,
      director: Director
  ): Film =
    new Film(name, yearOfRelease, imdbRating, director)

  def highestRating(f1: Film, f2: Film): Double =
    if (f1.imdbRating >= f2.imdbRating) f1.imdbRating else f2.imdbRating

  def oldestDirectorAtTheTime(f1: Film, f2: Film): Director = {
    if (f1.directorsAge >= f2.directorsAge) f1.director else f2.director
  }
}

object solution extends App {
  val eastwood = new Director("Clint", "Eastwood", 1930)
  val mcTiernan = new Director("John", "McTiernan", 1951)
  val nolan = new Director("Christopher", "Nolan", 1970)
  val someBody = new Director("Just", "Some Body", 1990)

  val memento = new Film("Memento", 2000, 8.5, nolan)
  val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
  val inception = new Film("Inception", 2010, 8.8, nolan)

  val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
  val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
  val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
  val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
  val invictus = new Film("Invictus", 2009, 7.4, eastwood)

  val predator = new Film("Predator", 1987, 7.9, mcTiernan)
  val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
  val huntForRedOctober =
    new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
  val thomasCrownAffair =
    new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

  eastwood.yearOfBirth // res16: Int = 1930
  dieHard.director.name // res17: String = John McTiernan
  invictus.isDirectedBy(nolan) // res18: Boolean = false

  highPlainsDrifter.copy(name = "L'homme des hautes plaines")
  // res19: Film = Film(L'homme des hautes plaines,1973,7.7,Director(Clint,Eastwood,1930))

  thomasCrownAffair.copy(
    yearOfRelease = 1968,
    director = new Director("Norman", "Jewison", 1926)
  )
  // res20: Film = Film(The Thomas Crown Affair,1968,6.8,Director(Norman,Jewison,1926))

  inception.copy().copy().copy()
  // res21: Film = Film(Inception,2010,8.8,Director(Christopher,Nolan,1970))
}
