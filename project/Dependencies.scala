import sbt._
import Keys._

object Dependencies {

  lazy val jodaTime     = Seq(
    "joda-time" % "joda-time"    % "2.9.9",
    "org.joda"  % "joda-convert" % "1.8.1"
  )
  lazy val jackson      = Seq(
    "com.fasterxml.jackson.core" % "jackson-databind" % "2.8.7"
  )
  lazy val scalaz_core  = "org.scalaz"                   %% "scalaz-core"          % "7.2.12"
  lazy val paranamer    = "com.thoughtworks.paranamer"   %  "paranamer"            % "2.8"
  lazy val specs        = Def.setting{
    Seq("org.specs2" %% "specs2-scalacheck" % "3.9.0" % "test")
  }
  lazy val mockito      = "org.mockito"                  %  "mockito-core"         % "2.7.19" % "test"

  def scalaXml(scalaVersion: String) = {
    PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion)){
      case Some((2, scalaMajor)) if scalaMajor >= 11 =>
        Seq("org.scala-lang.modules" %% "scala-xml" % "1.0.6")
    }.toList.flatten
  }

}
