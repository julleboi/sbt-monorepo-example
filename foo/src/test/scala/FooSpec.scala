import org.scalatest.funspec._

class FooSpec extends AnyFunSpec {
  describe("1 + 1") {
    it("should equal 2") {
      1 + 1 equals 2
    }
  }
}
