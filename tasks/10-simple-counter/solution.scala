class Counter(val count: Int) {
  def inc = new Counter(count + 1)
  def dec = new Counter(count - 1)
}

object solution extends App {
  new Counter(10).inc.dec.inc.inc.count // res23: Int = 12
}
