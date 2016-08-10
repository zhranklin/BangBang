package com.bangbang.mapper

import com.bangbang.web.controller.MainController
import com.github.scalaspring.scalatest.TestContextManagement
import org.scalatest.{FlatSpec, Matchers}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.TestContextManager
import org.springframework.test.context.web.WebAppConfiguration

/**
  * Created by Zhranklin on 16/7/5.
  */

@SpringApplicationConfiguration(classes = Array(classOf[MainController]))
@WebAppConfiguration
class UserMapperTest extends FlatSpec with TestContextManagement with Matchers {

  @Autowired var userMapper: UserMapper = _

  lazy val user = userMapper.findByUserName("user1")
  "a user with username of user1" should "have password be psw" in {
    assert(user.password == "psw")
  }

  it should "have id be 1" in {
    assert(user.id == 1)
  }

  it should "have realname be xiaoming1" in {
    assert(user.realname == "xiaoming1")
  }

  it should "have phone be 123" in {
    assert(user.phone == "123")
  }

  it should "have no coin" in {
    assert(user.coin == 0)
  }

}
