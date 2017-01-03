name := """play-mongo-bson"""

version := "0.2-SNAPSHOT"

organization := "ai.snips"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  "com.typesafe.play" %% "play" % "2.5.8" % "provided",
  "org.mongodb" % "mongo-java-driver" % "3.2.2" % "provided",
  "org.mongodb.scala" %% "mongo-scala-driver" % "1.1.1" % "provided",
  "org.scalatest" %% "scalatest" % "2.2.4" % "test"
)

publishTo <<= version { v: String =>
  val nexus = "https://oss.sonatype.org/"
  if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
  else                             Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishMavenStyle := true

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://snips.ai</url>
    <licenses>
      <license>
        <name>MIT</name>
        <url>https://opensource.org/licenses/MIT</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:snipsco/play-mongo-bson.git</url>
      <connection>scm:git:git@github.com:snipsco/play-mongo-bson.git</connection>
    </scm>
    <developers>
      <developer>
        <id>kali</id>
        <name>Mathieu Poumeyrol</name>
        <url>https://snips.ai</url>
      </developer>
      <developer>
        <id>gstraymond</id>
        <name>Guillaume Saint-Raymond</name>
        <url>http://www.eigengo.com</url>
      </developer>
    </developers>
  )