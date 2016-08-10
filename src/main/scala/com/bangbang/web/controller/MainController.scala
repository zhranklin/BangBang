package com.bangbang.web.controller

import java.security.Principal
import java.util.{List => JList}
import javax.servlet.http.HttpServletRequest

import com.bangbang.mapper._
import com.bangbang.web.model._
import org.apache.http.client.methods.HttpGet
import org.apache.http.impl.client.HttpClients
import org.apache.http.util.EntityUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.ui.Model
import org.springframework.web.bind.annotation._
import org.springframework.web.client.RestTemplate

import scala.collection.JavaConverters._

@RequestMapping(Array("/"))
@RestController class MainController {
  @Autowired val missionMapper: MissionMapper = null

  @Autowired val userMapper: UserMapper = null

  @Autowired val placeMapper: PlaceMapper = null

  @Autowired val request: HttpServletRequest = null


  @RequestMapping(Array("/")) def root(model: Model): String = "redirect:/home"

  @RequestMapping(value = Array("/user"), method = Array(RequestMethod.GET))
  def user(username: String) = userMapper.findByUserName(username)

  @RequestMapping(value = Array("/user"), method = Array(RequestMethod.POST))
  def user(user: User) = userMapper.insertUser(user)

  @RequestMapping(value = Array("/mission"), method = Array(RequestMethod.GET))
  def missions = missionMapper.findAllMissions

  @RequestMapping(value = Array("/mission"), method = Array(RequestMethod.POST))
  def missions(simpleMission: SimpleMission) = missionMapper.addMission(simpleMission)

  @RequestMapping(value = Array("/place"), method = Array(RequestMethod.GET))
  def place = placeMapper.findAll

  @RequestMapping(value = Array("/place"), method = Array(RequestMethod.POST))
  def place(place: Place) = placeMapper.insertPlace(place)

  @RequestMapping(Array("/qq/token"))
  def token(code: String) = {
    println(request)
    println(s"code: $code")
    val client = HttpClients.createDefault
    val tokenUrl = "https://graph.qq.com/oauth2.0/token"
    val grantType = "authorization_code"
    val redirect = "http://zhranklin.com/login"
    val clientId = "101339782"
    val secret = "bc16b19fbbeb7f1d85b8e962aa713ed5"
    val url = s"$tokenUrl?grant_type=$grantType&code=$code&redirect_uri=$redirect&client_id=$clientId&client_secret=$secret"
    val httpGet = new HttpGet(url)
    val entity = client.execute(httpGet).getEntity
    val content = EntityUtils.toString(entity, "utf-8")
    println(content)
    queryToMap(content).asJava
  }

  val QUERY = "(\\w+)=(\\w+)".r
  def queryToMap(content: String) =
    content.split("&").map { param ⇒
      val QUERY(key, value) = param
      key → value
    }.toMap


  val BEARER = "Bearer\\s*(\\w+)".r
  val CALLBACK = "callback\\((.*)\\);".r
  @RequestMapping(value = Array("/qq/me"),
    produces = Array("application/json"))
  @ResponseBody def me(access_token: String, @RequestHeader headers: HttpHeaders) = {
    val BEARER(token) = headers.getFirst("authorization").trim
    val url = s"https://graph.qq.com/oauth2.0/me?access_token=$token"
    val httpGet = new HttpGet(url)
    val entity = HttpClients.createDefault.execute(httpGet).getEntity
    val content = EntityUtils.toString(entity, "utf-8")
    val CALLBACK(json) = content.trim
    json
  }

}