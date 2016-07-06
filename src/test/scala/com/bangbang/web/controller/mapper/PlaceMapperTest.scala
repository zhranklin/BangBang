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
class PlaceMapperTest extends FlatSpec with TestContextManagement with Matchers {
  @Autowired var placeMapper: PlaceMapper = _

  lazy val place = placeMapper.findByName("scu")

  "a place named scu" should "have id be 1" in {
    assert(place.id == 1)
  }

  it should "have latitude be 111.111" in {
    assert(place.latitude == 111.111)
  }

}
