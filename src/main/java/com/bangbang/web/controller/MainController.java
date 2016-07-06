package com.bangbang.web.controller;

import com.bangbang.web.controller.mapper.MissionMapper;
import com.bangbang.web.controller.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;

@Controller
@SpringBootApplication()

public class MainController {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  MissionMapper missionMapper;

  @RequestMapping("/home")
  String home(Model model) {
    model.addAttribute("city", userMapper.findByUserName("user1"));
    return "home";
  }

  @RequestMapping("/missions")
  @ResponseBody
  String missions(Model model) {
//    model.addAttribute(missionMapper.findAllMissions());
    return "missions";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(MainController.class, args);
  }
}