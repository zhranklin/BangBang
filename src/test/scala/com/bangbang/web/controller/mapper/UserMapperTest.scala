package com.bangbang.web.controller.mapper

import com.github.scalaspring.scalatest.TestContextManagement
import org.scalatest.{FlatSpec, Matchers}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.TestContextManager
import org.springframework.test.context.web.WebAppConfiguration

/**
  * Created by Zhranklin on 16/7/5.
  */

@SpringApplicationConfiguration(classes = Array(classOf[com.bangbang.web.controller.MainController]))
@WebAppConfiguration
class UserMapperTest extends FlatSpec with TestContextManagement with Matchers {

  @Autowired var userMapper: UserMapper = _

  lazy val user = userMapper.findByUserName("user1")
  "a user with username of user1" should "have password be psw" in {
    user.password == "psw"
  }

  it should "have realname be xiaoming1" in {
    user.realname == "xiaoming1"
  }

  it should "have phone be 123" in {
    user.phone == "123"
  }

  it should "have no coin" in {
    user.coin == 0
  }

}
