name := "scaldi-akka"
organization := "org.scaldi"
version := "0.5.7"

description := "Scaldi-Akka - Scaldi integration for Akka"
homepage := Some(url("http://scaldi.org"))
licenses := Seq("Apache License, ASL Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))

scalaVersion := "2.11.6"
scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.4.1" % "provided",
  "org.scaldi" %% "scaldi" % "0.5.7",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

// Publishing

publishMavenStyle := true
publishArtifact in Test := false
pomIncludeRepository := (_ => false)
publishTo <<= version { v: String =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

git.remoteRepo := "git@github.com:scaldi/scaldi-akka.git"
site.settings
site.includeScaladoc()
ghpages.settings

// Other stuff

// nice prompt!
shellPrompt in ThisBuild := { state =>
  scala.Console.BLUE + Project.extract(state).currentRef.project + "> " + scala.Console.RESET
}

startYear := Some(2011)
organizationHomepage := Some(url("https://github.com/scaldi"))
scmInfo := Some(ScmInfo(
  browseUrl = url("https://github.com/scaldi/scaldi-akka"),
  connection = "scm:git:git@github.com:scaldi/scaldi-akka.git"
))
pomExtra := <xml:group>
  <developers>
    <developer>
      <id>OlegIlyenko</id>
      <name>Oleg Ilyenko</name>
    </developer>
  </developers>
</xml:group>