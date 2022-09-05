lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.4"
    )),
    name := "scalatest-example"
  )

libraryDependencies += "co.fs2" %% "fs2-core" % "3.2.12"
libraryDependencies += "co.fs2" %% "fs2-io" % "3.2.12"
libraryDependencies += "co.fs2" %% "fs2-reactive-streams" % "3.2.12"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.9" % Test
