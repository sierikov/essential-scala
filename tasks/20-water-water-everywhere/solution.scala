sealed trait Source

case object Well extends Source
case object Spring extends Source
case object Tap extends Source

case class Water(size: Int, source: Source, carbonated: Boolean)
