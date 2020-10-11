package json

sealed trait Json {

  private def quote(str: String): String =
    "\"" ++ str ++ "\""

  def toString(seq: JSequence): String =
    seq match {
      case SeqCell(head, tail @ SeqCell(_, _)) =>
        s"${head.print}, ${toString(tail)}"
      case SeqCell(head, SeqEnd) => head.print
      case SeqEnd                => ""
    }

  def toString(obj: JObject): String =
    obj match {
      case ObjectCell(key, value, tail @ ObjectCell(_, _, _)) =>
        s"${quote(key)}: ${value.print}, ${toString(tail)}"
      case ObjectCell(key, value, ObjectEnd) => s"${quote(key)}: ${value.print}"
      case ObjectEnd                         => ""
    }

  def print: String =
    this match {
      case s @ SeqCell(_, _) => "[" ++ toString(s) ++ "]"
      case SeqEnd            => "[]"

      case o @ ObjectCell(_, _, _) => "{" ++ toString(o) ++ "}"
      case ObjectEnd               => "{}"

      case JNumber(value)  => value.toString
      case JString(value)  => quote(value)
      case JBoolean(value) => value.toString
      case JNull           => "null"
    }

}

case class JNumber(value: Double) extends Json
case class JString(value: String) extends Json
case class JBoolean(value: Boolean) extends Json
case object JNull extends Json

sealed trait JSequence extends Json

case class SeqCell(head: Json, tail: JSequence) extends JSequence
case object SeqEnd extends JSequence

sealed trait JObject extends Json

case class ObjectCell(key: String, value: Json, tail: JObject) extends JObject
case object ObjectEnd extends JObject
