name := "PsychotechnikaSpike"

version := "1.0"

scalaVersion := "2.11.5"

libraryDependencies += "org.scalafx" %% "scalafx" % "8.0.0-R4"



libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.9",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.9",
  "org.scalatest" %% "scalatest" % "2.2.1" % "test",
  "junit" % "junit" % "4.11" % "test",
  "com.novocode" % "junit-interface" % "0.10" % "test"
)