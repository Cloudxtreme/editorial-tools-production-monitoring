package test

import _root_.lib.{Config, Http}
import org.scalatest._
import play.api.libs.json.{Json, JsValue}

class BaseSuite extends FlatSpec with Matchers with ShouldMatchers with Http {
  val testRunId       = java.util.UUID.randomUUID.toString

  val composerBaseUrl = Config.composerBaseUrl

  def getJs(path: String, expectedCode: Int = 200): JsValue = {

    println("GET: " + path)

    val connection = GET(path)
    connection.responseCode should be (expectedCode)

    Json.parse(connection.body)
  }
}

class LocalSuite extends Suites(
  new ToolsSmokeTest
)
