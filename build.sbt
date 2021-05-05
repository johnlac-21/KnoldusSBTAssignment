name := "KnoldusSBTAssignment"

version := "0.1"

scalaVersion := "2.12.12"

lazy val core = project.in(file("common")).settings(libraryDependencies += "net.manub" %% "scalatest-embedded-kafka" % "2.0.0" % "test",
  libraryDependencies += "org.json4s" %% "json4s-jackson" % "3.2.11", libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.7",
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % "test", libraryDependencies += "org.mockito" % "mockito-scala_2.11" % "0.3.0" % "test")
val AkkaVersion = "2.6.14"
lazy val util = project.in(file("actor")).settings(libraryDependencies +=  "com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  libraryDependencies += "com.typesafe.akka" %% "akka-stream" % AkkaVersion, libraryDependencies +=   "com.typesafe.akka" %% "akka-persistence-typed" % AkkaVersion,
  libraryDependencies += "com.typesafe.akka" %% "akka-actor-testkit-typed" % AkkaVersion % Test,
  libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.7" % "test" ).dependsOn(core)


addSbtPlugin("io.github.knoldus" % "codesquad-sbt-plugin" % "0.2.1")
addSbtPlugin("org.scalastyle" % "scalastyle-sbt-plugin" % "1.0.0")

lazy val root = project.in(file("root")).aggregate(core, util)