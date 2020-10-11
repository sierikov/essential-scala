# JSON

> Note: This is just exercise for practice ADT and Pattern Matching.
> This is **not** exhaustive JSON parser.

Design an ADT for JSON.

Here are some examples of JSON you’ll need to be able to represent

```json
{
  "a": [1,2,3],
  "b": ["a","b","c"],
  "c": { "doh":true, "ray":false, "me":["a string", 1.0, true]}
}
```

You can use yours or this [BNF](https://en.wikipedia.org/wiki/Backus%E2%80%93Naur_form) representation

```bnf
Json ::= JNumber value:Double
       | JString value:String
       | JBoolean value:Boolean
       | JNull
       | JSequence
       | JObject
JSequence ::= SeqCell head:Json tail:JSequence
             | SeqEnd
JObject ::= ObjectCell key:String value:Json tail:JObject
           | ObjectEnd“
```

Transform it into scala code

---

Now add a method to convert your JSON representation to a String. Make sure you enclose strings in quotes, and handle arrays and objects properly. And test it.

```scala
SeqCell(JString("a string"), SeqCell(JNumber(1.0), SeqCell(JBoolean(true), SeqEnd))).print
// res0: String = ["a string", 1.0, true]

ObjectCell(
  "a", SeqCell(JNumber(1.0), SeqCell(JNumber(2.0), SeqCell(JNumber(3.0), SeqEnd))),
  ObjectCell(
    "b", SeqCell(JString("a"), SeqCell(JString("b"), SeqCell(JString("c"), SeqEnd))),
    ObjectCell(
      "c", ObjectCell("doh", JBoolean(true),
        ObjectCell("ray", JBoolean(false),
          ObjectCell("me", JNumber(1.0), ObjectEnd))),
      ObjectEnd
    )
  )
).print
// res1: String = {"a": [1.0, 2.0, 3.0], "b": ["a", "b", "c"], "c": {"doh": true, "ray": false, "me": 1.0}}
```
