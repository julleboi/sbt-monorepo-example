name := "multi-project-test"
organization := "lol"
scalaVersion := "2.13.8"

lazy val global = project
  .in(file("."))
  .settings(settings)
  .disablePlugins(AssemblyPlugin)
  .aggregate(
    common,
    foo,
    bar
  )

lazy val common = project
  .settings(
    name := "common",
    settings,
    libraryDependencies ++= commonDependencies
  )
  .disablePlugins(AssemblyPlugin)

lazy val foo = project
  .settings(
    name := "foo",
    settings,
    assemblySettings,
    libraryDependencies ++= commonDependencies ++ Seq(
      "com.typesafe.play" %% "play"      % "2.8.13",
      "com.typesafe.play" %% "play-test" % "2.8.13"
    )
  )
  .dependsOn(common)

lazy val bar = project
  .settings(
    name := "foo",
    settings,
    assemblySettings,
    libraryDependencies ++= commonDependencies ++ Seq(
      // dependencies ...
    )
  )
  .dependsOn(common)

lazy val commonDependencies = Seq(
  "com.amazonaws" %  "aws-java-sdk-core" % "1.12.184",
  "org.scalatest" %% "scalatest"         % "3.2.11"    % "test"
)

lazy val settings = Seq(
  scalacOptions ++= compilerOptions
  // ...
)

lazy val compilerOptions = Seq(
  "-deprecation",
  "-feature",
  "-unchecked",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps",
  "-Ywarn-unused"
)

lazy val assemblySettings = Seq(
  assembly / assemblyJarName := s"${name.value}.jar",
  assembly / assemblyMergeStrategy := {
    case PathList("META-INF", xs @ _*) => MergeStrategy.discard
    case "application.conf"            => MergeStrategy.concat
    case _                             => MergeStrategy.first
  }
)