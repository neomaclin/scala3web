ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.1"

val Http4sVersion = "0.23.16"
val LogbackVersion = "1.4.5"
val WeaverVersion = "0.8.1"
val DoobieVersion = "1.0.0-RC2"
val KittenVersion = "3.0.0"
val CirisVersion = "3.0.0"
val CatsMTLVersion = "1.3.0"
val Log4CatsVersion = "2.5.0"
val CatsRetryVersion = "3.1.0"
val RefinedVersion = "0.10.1"
val CirceVersion = "0.14.3"
val DeclineVersion = "2.4.0"
val TsecVersion = "0.4.0"

lazy val root = (project in file("."))
  .settings(
    name := "scala3web",
    idePackagePrefix := Some("com.group.quasi"),
    libraryDependencies ++= Seq(
      "org.http4s" %% "http4s-ember-server" % Http4sVersion,
      "org.http4s" %% "http4s-ember-client" % Http4sVersion,
      "org.http4s" %% "http4s-circe" % Http4sVersion,
      "org.http4s" %% "http4s-dsl" % Http4sVersion,
      "org.typelevel" %% "kittens" % KittenVersion,
      "org.typelevel" %% "cats-mtl" % CatsMTLVersion,
      "org.typelevel" %% "log4cats-slf4j" % Log4CatsVersion, // Direct Slf4j Support - Recommended
      "ch.qos.logback" % "logback-classic" % LogbackVersion,
      "is.cir" %% "ciris" % CirisVersion,
      "is.cir" %% "ciris-refined" % CirisVersion,
      "com.github.cb372" %% "cats-retry" % CatsRetryVersion,
      "eu.timepit" %% "refined" % RefinedVersion,
      "eu.timepit" %% "refined-cats" % RefinedVersion, // optional
      "io.circe" %% "circe-refined" % CirceVersion,
      "com.monovore" %% "decline" % DeclineVersion,
      "com.monovore" %% "decline-refined" % DeclineVersion,
      "org.tpolecat" %% "doobie-core" % DoobieVersion,
      "org.tpolecat" %% "doobie-h2" % DoobieVersion,
      "org.tpolecat" %% "doobie-hikari" % DoobieVersion,
      "org.tpolecat" %% "doobie-postgres" % DoobieVersion,
      "io.github.jmcardon" %% "tsec-http4s" % TsecVersion,
      "com.disneystreaming" %% "weaver-cats" % WeaverVersion % Test
    ),
    testFrameworks += new TestFramework("weaver.framework.CatsEffect")

  )
