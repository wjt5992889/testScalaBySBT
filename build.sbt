name := "testScalaBySBT"

version := "0.1"

scalaVersion := "2.11.11"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.4.3"
libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.4.3"
libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.11"
libraryDependencies += "org.scala-lang" % "scala-reflect" % "2.11.11"
libraryDependencies += "org.apache.spark" % "spark-core_2.11" % "2.2.0"
libraryDependencies += "org.apache.spark" % "spark-sql_2.11" % "2.2.0"