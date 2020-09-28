# Shaping Up With Traits

**Reference**: 4.1.4.2

**Description**:  
Define a trait called `Shape` and give it three abstract methods:

- `sides` returns the number of sides;
- `perimeter` returns the total length of the sides;
- `area` returns the area.

Implement Shape with three classes: `Circle`, `Rectangle`, and `Square`.
In each case provide implementations of each of the three methods.
Ensure that the main constructor parameters of each shape (e.g. the radius of the circle) 
are accessible as fields.

Tip: The value of π is accessible as `math.Pi`.

*Stage 2*: The solution from the exercise delivered three distinct types of shape.
However, it doesn’t model the relationships between the three correctly. A `Square`
isn’t just a `Shape` — it’s also a type of `Rectangle` where the width and height are
the same.
           
Refactor the solution to the last exercise so that `Square` and `Rectangle` are subtypes
of a common type `Rectangular`. 
