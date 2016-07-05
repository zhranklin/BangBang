package com.bangbang.web.model

import java.sql.Timestamp
import java.lang.{Double => JDouble}

import com.bangbang.web.model.MissionStatus.MissionStatus

case class User(id: Integer, username: String, password: String, realname: String, phone: String, coin: Integer)

case class Place(id: Integer, name: String, longitude: JDouble, latitude: JDouble)

case class Mission(id: Integer, start: Place, dest: Place, price: Integer, description: String, due: Timestamp, producer: User, consumer: User, status: MissionStatus)

object MissionStatus extends Enumeration {
  type MissionStatus = Value
  val Submitted = Value
}

case class Group(id: Integer, name: String, description: String, location: Place)