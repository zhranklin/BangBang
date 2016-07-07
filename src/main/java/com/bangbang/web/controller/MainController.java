package com.bangbang.web.controller;

import com.bangbang.web.controller.mapper.MissionMapper;
import com.bangbang.web.controller.mapper.UserMapper;
import com.bangbang.web.model.Mission;
import com.bangbang.web.model.SimpleMission;
import com.bangbang.web.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@Controller
@SpringBootApplication(exclude = SpringBootWebSecurityConfiguration.class)

public class MainController {

  @Autowired
  private DataSource dataSource;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  MissionMapper missionMapper;

  private int userId = 1;
  @RequestMapping("/home")
  String home(Model model) {
    User user = userMapper.findById(userId);
    model.addAttribute("user", user);
    model.addAttribute("missions", missionMapper.findByProducerId(userId));
    return "index";
  }

  @RequestMapping("info")
  String info(Model model) {
    User user = userMapper.findById(userId);
    model.addAttribute("user", user);
    return "info";
  }

  @RequestMapping("cur-missions")
  String curMissions(Model model) {
    List<Mission> missions = missionMapper.findAll();
    model.addAttribute("missions", missions);
    return "cur-missions";
  }

  @RequestMapping("my-missions")
  String myMissions(Model model) {
    model.addAttribute("missions", missionMapper.findByProducerId(1));
    return "my-missions";
  }

  @RequestMapping(value = "create", method = RequestMethod.POST)
  String create(SimpleMission mission) {
    missionMapper.addMission(mission);
    return "redirect:/home";
  }

  @RequestMapping(value = "create", method = RequestMethod.GET)
  String create_page(SimpleMission mission) {
    return "create";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(MainController.class, args);
  }
}