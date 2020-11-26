ThisBuild / organization := "com.jason-bunyod"
ThisBuild / organizationName := "Veact"
ThisBuild / organizationHomepage := Some(url("https://veact.com/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/Bunyod/authentikat-jwt"),
    "scm:git@github.com:Bunyod/authentikat-jwt.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "bunic",
    name  = "Bunyod",
    email = "bunyodreal@gmail.com",
    url   = url("https://github.com/Bunyod")
  )
)

ThisBuild / description := "Some Claims Based JWT Implementation for Scala"
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/Bunyod/authentikat-jwt"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true