# Order of evaluation

## Question

When entered on the console, what does the following program output,
and what is the type and value of the final expression? Think
carefully about the types, dependencies, and evaluation behaviour
of each field and method.

Code:

```scala
object argh {
  def a = {
    println("a")
    1
  }

  val b = {
    println("b")
    a + 2
  }

  def c = {
    println("c")
    a
    b + "c"
  }
}
```

Execution:

```scala
argh.c + argh.b + argh.a
```

## Anwser

The order of calls will be following:

- We calculate the main sum at the end of the program, which...
  - Loads `argh`, which...
    - Calculates all the fields in `argh`, which...
      - Calculates `b`, which...
        - Prints `"b"`
        - Evaluates `a + 2`, which...
          - Calls `a`, which...
            - Prints `"a"`
            - Returns `1`
          - Returns `1 + 2`
        - Stores the value `3` in `b`
  - Calls `argh.c`, which...
    - Prints `"c"`
    - Evaluates `a`
      - Prints `"a"`
      - Returns `1` - Which we discard
    - Evaluates `b + "c"`, which...
      - Retrieves the value `3` from `b`
        - Retrieves the value `"c"`
        - Evaluates the `+`, determining that it actually refers to string
          concatenation and converting `3` to `"3"`
        - Returns the `String` `"3c"`
  - Calls `argh.b`, which...
    - Retrieves the value `3` from `b`
  - Evaluates the first `+`, determining that it actually refers to string
    concatentation, and yielding `"3c3"`
  - Calls `argh.a`, which...
    - Prints `"a"`
    - Returns `1`
  - Evaluates the first `+`, determining that it actually refers to string concatentation, and yielding `"3c31"`
