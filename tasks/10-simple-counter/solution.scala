class Counter(val count: Int) {
  // Backward compatibility for new Counter(20).inc
  def inc: Counter = inc()
  def dec: Counter = dec()

  def inc(value: Int = 1) = new Counter(count + value)
  def dec(value: Int = 1) = new Counter(count - value)

  def adjust(adder: Adder) = new Counter(adder.add(count))
}

class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

object solution extends App {
  new Counter(10).inc.dec.inc.inc.count // res23: Int = 12
  new Counter(10).inc.inc(10).count // Stage 2 - res25: Int = 21
}
