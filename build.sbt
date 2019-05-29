

name := "kafkaLLproducer"

version := "0.1"

scalaVersion := "2.12.8"
enablePlugins(UniversalPlugin)
enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

mainClass in Compile := Some("it.sabbio93.RandomGenerator")

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.1.0"