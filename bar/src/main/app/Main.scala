package bar

import common.models.Test

object Main extends App {
  println("Hello from bar!")
  val common = Test(message = "bar")
  println(s"${common.message}")
}
