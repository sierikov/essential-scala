# Directorial Debut

**Reference**: 3.1.6.3

**Description**:  

Write two classes, `Director` and `Film`, with fields and methods as follows:

- `Director` should contain:
  - a field `firstName` of type `String`
  - a field `lastName` of type `String`
  - a field `yearOfBirth` of type `Int`
  - a method called `name` that accepts no parameters and returns the full name
- `Film` should contain:
  - a field `name` of type `String`
  - a field `yearOfRelease` of type `Int`
  - a field `imdbRating` of type `Double`
  - a field `director` of type `Director`
  - a method `directorsAge` that returns the age of the director at the time of release
  - a method `isDirectedBy` that accepts a `Director` as a parameter and returns a `Boolean`

Copy-and-paste the following demo data into your code and adjust your constructors
so that the code works without modification:

```scala
val eastwood          = new Director("Clint", "Eastwood", 1930)
val mcTiernan         = new Director("John", "McTiernan", 1951)
val nolan             = new Director("Christopher", "Nolan", 1970)
val someBody          = new Director("Just", "Some Body", 1990)

val memento           = new Film("Memento", 2000, 8.5, nolan)
val darkKnight        = new Film("Dark Knight", 2008, 9.0, nolan)
val inception         = new Film("Inception", 2010, 8.8, nolan)

val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales  = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven        = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino        = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus          = new Film("Invictus", 2009, 7.4, eastwood)

val predator          = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard           = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

eastwood.yearOfBirth
// res16: Int = 1930

dieHard.director.name
// res17: String = John McTiernan

invictus.isDirectedBy(nolan)
// res18: Boolean = false
```

Implement a method of `Film` called `copy`. This method should accept the
same parameters as the constructor and create a new copy of the film. Give
each parameter a default value so you can copy a film changing any subset
of its values:

```scala
highPlainsDrifter.copy(name = "L'homme des hautes plaines")
// res19: Film = Film(L'homme des hautes plaines,1973,7.7,Director(Clint,Eastwood,1930))

thomasCrownAffair.copy(yearOfRelease = 1968,
  director = new Director("Norman", "Jewison", 1926))
// res20: Film = Film(The Thomas Crown Affair,1968,6.8,Director(Norman,Jewison,1926))

inception.copy().copy().copy()
// res21: Film = Film(Inception,2010,8.8,Director(Christopher,Nolan,1970))
```
