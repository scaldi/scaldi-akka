name := "scaldi-akka"

description := "Scaldi-Akka - Scaldi integration for Akka"

organization := "org.scaldi"

version := "0.3.2"

crossScalaVersions := Seq("2.10.4", "2.11.0")

scalaVersion := "2.11.0"

scalacOptions += "-deprecation"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.2" % "provided",
  "org.scaldi" %% "scaldi" % "0.3.1",
  "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

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

pomExtra := <xml:group>
  <url>http://scaldi.github.io/scaldi/Scaldi.html</url>
  <inceptionYear>2014</inceptionYear>
  <licenses>
    <license>
      <name>Apache License, ASL Version 2.0</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <developers>
    <developer>
      <id>OlegIlyenko</id>
      <name>Oleg Ilyenko</name>
    </developer>
  </developers>
  <issueManagement>
    <system>GitHub</system>
    <url>http://github.com/scaldi/scaldi-akka/issues</url>
  </issueManagement>
  <scm>
    <connection>scm:git:git@github.com:scaldi/scaldi-akka.git</connection>
    <url>git@github.com:scaldi/scaldi-akka.git</url>
  </scm>
</xml:group>

resolvers += "Typesafe Releases Repository" at "http://repo.typesafe.com/typesafe/releases/"