# Friendly Person Factory

**Reference**: 3.1.6.4

**Description**:  
Implement a companion object for `Person` containing an `apply` method that
accepts a whole name as a single string rather than individual first and
last names. So following works:

```scala
Person("John Doe").firstName // sugared apply syntax
// res6: String = John
```
