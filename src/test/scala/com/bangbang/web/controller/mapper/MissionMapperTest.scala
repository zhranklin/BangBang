package com.bangbang.web.controller.mapper

import com.github.scalaspring.scalatest.TestContextManagement
import org.scalatest._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.web.WebAppConfiguration

/**
  * Created by Zhranklin on 16/7/6.
  */
@SpringApplicationConfiguration(classes = Array(classOf[com.bangbang.web.controller.MainController]))
@WebAppConfiguration
class MissionMapperTest extends FlatSpec with TestContextManagement with Matchers {
  @Autowired var missionMapper: MissionMapper = _

  lazy val mission = missionMapper.findById(1)

  "the first mission" should "have id be 1" in {
    assert(mission.id == 1)
  }

  it should "have price be 10" in {
    assert(mission.price == 10)
  }

}
