package lib

import com.typesafe.config.ConfigFactory

object Config {
  val config = ConfigFactory.load()

  val stage = config.getString("stage")

  val composerBaseUrl = config.getString(s"$stage.composer-base-url")

  val domain          = config.getString(s"$stage.panda.domain")
  val system          = config.getString(s"$stage.panda.system")

  val userFirstName            = config.getString("user.firstName")
  val userSecondName           = config.getString("user.secondName")
  val userEmail                = config.getString("user.email")
}
