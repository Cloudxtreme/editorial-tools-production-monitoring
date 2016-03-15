package lib

import java.util.Date

import com.amazonaws.auth._
import com.amazonaws.auth.profile.ProfileCredentialsProvider
import com.gu.pandomainauth.PanDomainAuth
import com.gu.pandomainauth.model.{AuthenticatedUser, User}
import com.gu.pandomainauth.service.LegacyCookie

object PanDomainAuthService extends PanDomainAuth {
  lazy val system    = Config.system
  lazy val domain    = Config.domain

  override lazy val awsCredentialsProvider: AWSCredentialsProvider =
    new AWSCredentialsProviderChain(
      new EnvironmentVariableCredentialsProvider(),
      new ProfileCredentialsProvider("workflow"))

  val oneDaysMillis: Long = 1000 * 60 * 60 * 24

  def generateCookie(email: String, firstName: String, lastName: String): String = {

    val authedUser = AuthenticatedUser(
      user = User(firstName, lastName, email, None),
      authenticatingSystem = system,
      authenticatedIn = Set(system),
      expires = new Date().getTime + oneDaysMillis,
      multiFactor = true
    )

    LegacyCookie.generateCookieData(authedUser, settings.secret)
  }
}

case class PandaCookie(key: String, value: String)
object PandaCookie {
  def apply(
             firstName:String = Config.userFirstName,
             lastName:String  = Config.userSecondName,
             email:String     = Config.userEmail
             ): PandaCookie  = {
    val cookieValue = PanDomainAuthService.generateCookie(email, firstName, lastName)

    PandaCookie("gutoolsAuth", cookieValue)
  }
}
