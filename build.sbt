name := "editorial-tools-production-monitoring"

version := "1.0"

scalaVersion := "2.11.8"

resolvers ++= Seq(
  "saucelabs-repository" at "https://repository-saucelabs.forge.cloudbees.com/release",
  "typesafe-repo" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.apache.httpcomponents" % "httpclient" % "4.3.4",
  "com.typesafe.play" %% "play" % "2.3.4",
  "org.seleniumhq.selenium" % "selenium-java" % "2.35.0",
  "com.gu" %% "pan-domain-auth-play" % "0.2.11",
  "com.amazonaws" % "aws-java-sdk" % "1.7.5",
  "com.typesafe" % "config" % "1.2.1"
)
    