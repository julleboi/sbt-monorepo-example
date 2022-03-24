package foo

import common.models.Test

object Main extends App {
  println("Hello from foo!")
  val common = Test(message = "foo")
  println(s"${common.message}")
}
