// Pattern match solution
sealed trait TrafficLight {
  def next: TrafficLight =
    this match {
      case RedTrafficLight => YellowTrafficLight
      case YellowTrafficLight => GreenTrafficLight
      case GreenTrafficLight => RedTrafficLight
    }
}

case object RedTrafficLight extends TrafficLight
case object YellowTrafficLight extends TrafficLight
case object GreenTrafficLight extends TrafficLight
