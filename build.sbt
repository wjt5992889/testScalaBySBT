name := "testScalaBySBT"

version := "0.1"

scalaVersion := "2.11.8"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.3"
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.4.3"
