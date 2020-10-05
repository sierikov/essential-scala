// Polymorphism solution
sealed trait TrafficLight {
  def next: TrafficLight
}

case object RedTrafficLight extends TrafficLight {
  def next: TrafficLight = YellowTrafficLight
}
case object YellowTrafficLight extends TrafficLight {
  def next: TrafficLight = GreenTrafficLight
}
case object GreenTrafficLight extends TrafficLight {
  def next: TrafficLight = RedTrafficLight
}
