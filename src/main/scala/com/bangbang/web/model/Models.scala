package com.bangbang.web.model

import java.sql.Timestamp
import java.lang.{Double => JDouble}

import com.bangbang.web.controller.mapper._
import com.bangbang.web.model.MissionStatus.MissionStatus
import org.springframework.beans.factory.annotation.Autowired

import scala.beans.BeanProperty

class User {
  @BeanProperty var id: Integer = _
  @BeanProperty var username: String = _
  @BeanProperty var password: String = _
  @BeanProperty var realname: String = _
  @BeanProperty var phone: String = _
  @BeanProperty var coin: Integer = _
  override def toString = username
}

class Place {
  @BeanProperty var id: Integer = _
  @BeanProperty var name: String = _
  @BeanProperty var longitude: JDouble = _
  @BeanProperty var latitude: JDouble = _
  override def toString = name
}

class Mission {
  @BeanProperty var id: Integer = _
  @BeanProperty var start: Place = _
  @BeanProperty var dest: Place = _
  @BeanProperty var price: Integer = _
  @BeanProperty var description: String = _
  @BeanProperty var due: Timestamp = _
  @BeanProperty var producer: User = _
  @BeanProperty var consumer: User = _
  @BeanProperty var status: MissionStatus = _
  def getPhone = producer.phone
}

class SimpleMission {
  @BeanProperty var start: Integer = _
  @BeanProperty var dest: Integer = _
  @BeanProperty var price: Integer = _
  @BeanProperty var description: String = _
  @BeanProperty var producer: Integer = _
  @BeanProperty var consumer: Integer = _
}


object MissionStatus extends Enumeration {
  type MissionStatus = Value
  val Submitted = Value
}

class Group {
  @BeanProperty var id: Integer = _
  @BeanProperty var name: String = _
  @BeanProperty var description: String = _
  @BeanProperty var location: Place = _
  @BeanProperty var admins: java.util.List[User] = _
  @BeanProperty var members: java.util.List[User] = _
}