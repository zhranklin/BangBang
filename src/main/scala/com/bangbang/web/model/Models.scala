package com.bangbang.web.model

import java.sql.Timestamp
import java.lang.{Double => JDouble}

import com.bangbang.web.model.MissionStatus.MissionStatus

import scala.beans.BeanProperty

class User() {
  @BeanProperty var id: Integer = _
  @BeanProperty var username: String = _
  @BeanProperty var password: String = _
  @BeanProperty var realname: String = _
  @BeanProperty var phone: String = _
  @BeanProperty var coin: Integer = _
}

class Place {
  @BeanProperty var id: Integer = _
  @BeanProperty var name: String = _
  @BeanProperty var longitude: JDouble = _
  @BeanProperty var latitude: JDouble = _
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
}


object MissionStatus extends Enumeration {
  type MissionStatus = Value
  val Submitted = Value
}

case class Group(id: Integer, name: String, description: String, location: Place)