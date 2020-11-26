import sbt.Keys.useCoursier

name := "authentikat-jwt"

crossScalaVersions := Seq("2.11.11", "2.12.10", "2.13.3") //sbt '+ publish'
scalafixDependencies in ThisBuild += "com.geirsson" %% "example-scalafix-rule" % "1.3.0"
addCompilerPlugin(scalafixSemanticdb)

inThisBuild(
  List(
    scalaVersion := "2.13.3", // 2.11.12, or 2.13.3
    Global / onChangedBuildSource := ReloadOnSourceChanges,
    semanticdbEnabled := true, // enable SemanticDB
    semanticdbVersion := scalafixSemanticdb.revision, // use Scalafix compatible version
    parallelExecution := false,
    useCoursier := false
  )
)

scalacOptions ++= Seq(
  "-unchecked",
  "-deprecation",
//  "-Yrangepos", // required by SemanticDB compiler plugin
  "-Ywarn-unused" // required by `RemoveUnused` rule
)

libraryDependencies ++= Seq(
  "commons-codec" % "commons-codec" % "1.15",
  "org.json4s" %% "json4s-native" % "3.7.0-M7",
  "org.json4s" %% "json4s-jackson" % "3.7.0-M7",
  "org.scalatest" %% "scalatest" % "3.2.3" % Test
)

pomExtra := (
  <url>http://github.com/jason-goodwin.com/authentikat-jwt</url>
  <licenses>
    <license>
      <name>Apache2</name>
      <url>http://www.apache.org/licenses/LICENSE-2.0.html</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:jasongoodwin/authentikat-jwt.git</url>
    <connection>scm:git:git@github.com:jasongoodwin/authentikat-jwt.git</connection>
  </scm>
  <developers>
    <developer>
      <id>jasongoodwin</id>
      <name>Jason Goodwin</name>
      <url>http://refactoringfactory.wordpress.com</url>
    </developer>
  </developers>)