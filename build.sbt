val Http4sVersion = "0.23.6"
val CirceVersion = "0.14.1"
val MunitVersion = "0.7.29"
val LogbackVersion = "1.2.6"
val ScalaLoggingVersion = "3.9.4"
val MunitCatsEffectVersion = "1.0.6"

lazy val root = (project in file("."))
  .settings(
    organization := "net.ulteum",
    name := "quantum-millionaire",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.13.6",
    libraryDependencies ++= Seq(
      "org.http4s"                  %% "http4s-ember-server"  % Http4sVersion,
      "org.http4s"                  %% "http4s-ember-client"  % Http4sVersion,
      "org.http4s"                  %% "http4s-circe"         % Http4sVersion,
      "org.http4s"                  %% "http4s-dsl"           % Http4sVersion,
      "io.circe"                    %% "circe-generic"        % CirceVersion,
      "org.scalameta"               %% "munit"                % MunitVersion            % Test,
      "org.typelevel"               %% "munit-cats-effect-3"  % MunitCatsEffectVersion  % Test,
      "org.scalatest"               %% "scalatest"            % "3.2.11"                % Test,
      "ch.qos.logback"               % "logback-classic"      % LogbackVersion,
      "org.fusesource.jansi"         % "jansi"                % "2.4.0",
      "com.typesafe.scala-logging"  %% "scala-logging"        % ScalaLoggingVersion,
      "org.scalameta"               %% "svm-subs"             % "20.2.0"
    ),
    addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.13.0" cross CrossVersion.full),
    addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1"),
    testFrameworks += new TestFramework("munit.Framework")
  )
