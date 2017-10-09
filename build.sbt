// Build definition for the project.

lazy val root = (project in file("."))
  .settings(
    name 		 := "programmers-notes",
    organization := "io.github.kaushikrroy.programmers.notes",
    scalaVersion := "2.12.1",
    version      := "0.0.1-SNAPSHOT"
  )

// The sequence of library dependencies.
libraryDependencies ++= Seq(
  	"org.scalatest" % "scalatest_2.12" % "3.0.4" % "test" withSources()
)

// Scala compile options to enable certain language features.
// These are some Functional Programming features which eases coding.
scalacOptions ++= Seq( 
    "-feature", 
    "-language:implicitConversions", 
    "-language:higherKinds", 
    "-language:existentials", 
    "-language:postfixOps"
)
