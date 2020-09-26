# Extended Body of Work

**Reference**: 3.3.2.2

**Description**:  
Write companion objects for `Director` and `Film` as follows:

- the `Director` companion object should contain:
  - an `apply` method that accepts the same parameters as
  the constructor of the class and returns a new `Director`;
  - a method `older` that accepts two `Directors` and returns the
  oldest of the two.
- the `Film` companion object should contain:
  - an `apply` method that accepts the same parameters as
  the constructor of the class and returns a new `Film`;
  - a method `highestRating` that accepts two `Films` and
  returns the highest `imdbRating` of the two;
  - a method `oldestDirectorAtTheTime` that accepts two `Film`s
  and returns the `Director` who was oldest at the respective time
  of filming.
