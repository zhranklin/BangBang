scalaVersion := "2.12.0-M4"
libraryDependencies ++= {
  val springBootVersion = "1.3.5.RELEASE"
  val scala = "2.12.0-M4"
  Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-thymeleaf" % springBootVersion,
  "org.mybatis.spring.boot" % "mybatis-spring-boot-starter" % "1.1.1",
  //runtime
  "mysql" % "mysql-connector-java" % "5.1.38",
  "org.scalaz" % s"scalaz-core_$scala" % "7.2.4",
  //runtime
  "com.h2database" % "h2" % "1.4.191",
  "org.scalatest" % s"scalatest_$scala" % "2.2.6",
  "org.springframework" % "spring-test" % "4.2.6.RELEASE",
  "junit" % "junit" % "4.12",
//  "org.springframework.boot" % "spring-boot-starter-security" % springBootVersion,
//  "org.springframework.security" % "spring-security-core" % "4.1.0.RELEASE",
//  "org.springframework.security.oauth" % "spring-security-oauth2" % "2.0.10.RELEASE",
  "org.apache.httpcomponents" % "httpclient" % "4.5.2"

  )
}

mainClass in assembly := Some("com.zhranklin.blog.Boot")



assemblyMergeStrategy in assembly := {
  case PathList("org", "apache", "commons", "logging", xs @ _*)         => MergeStrategy.first
  case PathList("org", "springframework", xs @ _*)         => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".json" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".xml" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".provides" => MergeStrategy.first
  case PathList(ps @ _*) if ps.last endsWith ".factories" => MergeStrategy.first
  case "application.conf"                            => MergeStrategy.concat
  case "unwanted.txt"                                => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}
