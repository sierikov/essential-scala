# Simple Calculator

**Reference**: 6.5.1

**Description**:  
Write a method called `calculator` that accepts three string parameters:

```scala
def calculator(operand1: String, operator: String, operand2: String): Unit = ???
```

and behaves as follows:

1. Convert the operands to Ints;
1. Perform the desired mathematical operator on the two operands:
    - provide support for at least four operations: `+`, `-`, `*` and `/`;
    - use `Option` to guard against errors (invalid inputs or division by zero).
1. Finally print the result or a generic error message.

> *Tip*: Start by supporting just one operator before extending your method to other cases.

*Stage 2*: For the enthusiastic only, write a second version of your code
using `flatMap` and `map`.
