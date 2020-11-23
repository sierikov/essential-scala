# Intranet Movie Database

**Reference**: 6.1.9

**Description**:  
Let’s revisit our films and directors example from the
[Directorial Debut](../09-directorial-debut/task.md)
task.

The code below is a partial rewrite of the previous sample
code in which `Films` is stored as a field of `Director` instead
of the other way around.

Structure:

```scala
case class Film(
  name: String,
  yearOfRelease: Int,
  imdbRating: Double)

case class Director(
  firstName: String,
  lastName: String,
  yearOfBirth: Int,
  films: Seq[Film])
```

Some `Film`s:

```scala
val memento           = new Film("Memento", 2000, 8.5)
val darkKnight        = new Film("Dark Knight", 2008, 9.0)
val inception         = new Film("Inception", 2010, 8.8)
val highPlainsDrifter = new Film("High” “Plains Drifter", 1973, 7.7)
val outlawJoseyWales  = new Film("The Outlaw Josey Wales", 1976, 7.9)
val unforgiven        = new Film("Unforgiven", 1992, 8.3)
val granTorino        = new Film("Gran Torino", 2008, 8.2)
val invictus          = new Film("Invictus", 2009, 7.4)
val predator          = new Film("Predator", 1987, 7.9)
val dieHard           = new Film("Die Hard", 1988, 8.3)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8)
```

Directors:

```scala
val eastwood = new Director(
    "Clint",
    "Eastwood",
    1930,
    Seq(
        highPlainsDrifter,
        outlawJoseyWales,
        unforgiven,
        granTorino,
        invictus
    )
)

val mcTiernan = new Director(
    "John",
    "McTiernan",
    1951,
    Seq(
        predator,
        dieHard,
        huntForRedOctober,
        thomasCrownAffair
    )
)

val nolan = new Director(
    "Christopher",
    "Nolan",
    1970,
    Seq(memento, darkKnight, inception)
)

val someGuy = new Director("Just", "Some Guy", 1990, Seq())

val directors = Seq(eastwood, mcTiernan, nolan, someGuy)
```

Now let's write some code!

Using this sample code, write implementations of the following methods:

- Accept a parameter `numberOfFilms` of type `Int` — find all directors
  who have directed more than `numberOfFilms`.
- Accept a parameter `year` of type `Int` — find a director
  who was born before that year.
- Accept two parameters, `year` and `numberOfFilms`, and return a list of
  directors who were born before `year` who have also directed more than
  than `numberOfFilms`.
- Accept a parameter `ascending` of type `Boolean` that defaults to true.
  Sort the directors by age in the specified order.
