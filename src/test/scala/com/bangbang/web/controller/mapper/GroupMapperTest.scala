package com.bangbang.web.controller.mapper

import com.bangbang.web.model.Group
import com.github.scalaspring.scalatest.TestContextManagement
import org.scalatest._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.web.WebAppConfiguration

import scala.collection.JavaConverters._


/**
  * Created by Zhranklin on 16/7/6.
  */
@SpringApplicationConfiguration(classes = Array(classOf[com.bangbang.web.controller.MainController]))
@WebAppConfiguration
class GroupMapperTest extends FlatSpec with TestContextManagement with Matchers {
  @Autowired var groupMapper: GroupMapper = _

  lazy val group = {
    groupMapper.findById(1)
  }

  "the first group" should "have id be 1" in {
    assert(group.id == 1)
  }

  it should "have name be scu_group" in {
    assert(group.name == "scu_group")
  }

  it should "have 1 admin and 3 members with proper usernames" in {
    val admins = groupMapper.findAdminsByGroupId(1).asScala
    val members = groupMapper.findMembersByGroupId(1).asScala
    assert(admins.nonEmpty)
    assert(members.size >= 3)
    println(admins.head.username)
    assert(admins.exists(_.username == "user1"))
    assert(members.exists(_.username == "user2"))
    assert(members.exists(_.username == "user3"))
    assert(members.exists(_.username == "user4"))
  }

  "user1" should "be an admin of scu_group" in {
    assert(groupMapper.isGroupMember(1, 1) > 0)
  }

}
