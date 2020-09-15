# Substitution

## Question

What is the difference between the following expressions? What are the similarities?

```scala
1 + 2 + 3
6
```

## Anwser

The expressions have the same result type and return value.
The difference is in the arriving at this value. The *first* computes
its result and the *second* is just literal.

These expressions also have **no side-effects**. They are
independent of a user's point of view. Where you can write `6`
you can also write `1 + 2 + 3` and vice versa.

> If we know the types and values of each component of expression,
> we know the type and value of the expression as a whole.

This is known as **substitution**. This model always works in the
absence of side-effects. Substitution model makes code easier to
understand.
