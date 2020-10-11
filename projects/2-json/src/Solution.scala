import json._

object Solution extends App {

  val res0 = SeqCell(
    JString("a string"),
    SeqCell(JNumber(1.0), SeqCell(JBoolean(true), SeqEnd))
  ).print
  println(res0)
  // res0: String = ["a string", 1.0, true]

  val res1 = ObjectCell(
    "a",
    SeqCell(JNumber(1.0), SeqCell(JNumber(2.0), SeqCell(JNumber(3.0), SeqEnd))),
    ObjectCell(
      "b",
      SeqCell(
        JString("a"),
        SeqCell(JString("b"), SeqCell(JString("c"), SeqEnd))
      ),
      ObjectCell(
        "c",
        ObjectCell(
          "doh",
          JBoolean(true),
          ObjectCell(
            "ray",
            JBoolean(false),
            ObjectCell("me", JNumber(1.0), ObjectEnd)
          )
        ),
        ObjectEnd
      )
    )
  ).print
  println(res1);
  // res1: String = {"a": [1.0, 2.0, 3.0], "b": ["a", "b", "c"], "c": {"doh": true, "ray": false, "me": 1.0}}
}
