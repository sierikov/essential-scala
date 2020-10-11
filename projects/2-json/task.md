# JSON

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
