// Set the Scala version
ThisBuild / scalaVersion := "2.13.14"

// Define global project information
ThisBuild / organization := "org.physics"
ThisBuild / version      := "1.0"

// Define the project
lazy val root = (project in file("."))
  .settings(
    name := "simulations", // Project name
    libraryDependencies ++= Seq(
      "org.scala-lang.modules" %% "scala-parser-combinators" % "2.4.0",
      "org.scalafx" %% "scalafx" % "22.0.0-R33"
    )
  )
