name := "PsychotechnikaSpike"

version := "1.0"

scalaVersion := "2.11.5"

addCompilerPlugin("org.scalamacros" % "paradise" % "2.0.1" cross CrossVersion.full)

libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.0-R4"

libraryDependencies += "org.scalafx" %% "scalafxml-core-sfx8" % "0.2.2"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.9",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test"
)

// Fork a new JVM for 'run' and 'test:run', to avoid JavaFX double initialization problems
fork := true
