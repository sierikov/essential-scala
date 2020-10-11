package json

sealed trait Json

case class JNumber(value: Double) extends Json
case class JString(value: String) extends Json
case class JBoolean(value: Boolean) extends Json
case object JNull extends Json

sealed trait JSequence extends Json

case class SeqSell(head: Json, tail: JSequence) extends JSequence
case object SeqEnd extends JSequence

sealed trait JObject extends Json

case class ObjectCell(key: String, value: Json, tail: JObject)
case object ObjectEnd
