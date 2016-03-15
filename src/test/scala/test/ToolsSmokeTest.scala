package test

class ToolsSmokeTest extends BaseSuite {
  println("--------------Start of Smoke Tests--------------")

  s"composer daashboard @ $composerBaseUrl" should "return a 200" in {
    val connection = GET(s"$composerBaseUrl")

    connection.responseCode should be (200)
  }

}
