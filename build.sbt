
//	compile 'org.springframework.boot:spring-boot-starter-aop'
//	compile 'org.springframework.boot:spring-boot-starter-security'
scalaVersion := "2.12.0-M5"
libraryDependencies ++= {
  val springBootVersion = "1.3.5.RELEASE"
  val scala = "2.12.0-M5"
  Seq(
  "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-thymeleaf" % springBootVersion,
  "org.mybatis.spring.boot" % "mybatis-spring-boot-starter" % "1.1.1",
  //runtime
  "mysql" % "mysql-connector-java" % "5.1.38",
  "org.scalaz" % s"scalaz-core_$scala" % "7.2.4",
  //runtime
  "com.h2database" % "h2" % "1.4.191",
  "org.scalatest" % s"scalatest_$scala" % "3.0.0-RC4",
    "org.springframework" % "spring-test" % "4.2.6.RELEASE",
    "junit" % "junit" % "4.12"
  )
}
