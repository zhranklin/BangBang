package com.bangbang.web.controller;

import com.bangbang.web.controller.mapper.MissionMapper;
import com.bangbang.web.controller.mapper.UserMapper;
import com.bangbang.web.model.Mission;
import com.bangbang.web.model.SimpleMission;
import com.bangbang.web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.autoconfigure.security.SpringBootWebSecurityConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

  @RequestMapping("/")
  String root(Model model) {
    return "redirect:/home";
  }

  private int userId = 1;

  @RequestMapping("/home")
  String home(Model model) {
    User user = getCurrentUser();
    model.addAttribute("user", user);
    model.addAttribute("missions", missionMapper.findByProducerId(userId));
    return "index";
  }

  @RequestMapping("info")
  String info(Model model) {
    User user = getCurrentUser();
    model.addAttribute("user", user);
    return "info";
  }

  @RequestMapping("cur-missions")
  String curMissions(Model model) {
    List<Mission> missions = missionMapper.findAll();
    model.addAttribute("missions", missions);
    return "cur-missions";
  }

  User getCurrentUser() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
      .getAuthentication()
      .getPrincipal();
    if (userDetails == null)
      return null;
    return userMapper.findByUserName(userDetails.getUsername());
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

  @RequestMapping("login")
  String login(Model model) {
    return "log-in";
  }

  public static void main(String[] args) throws Exception {
    SpringApplication.run(MainController.class, args);
  }

  @Configuration
  @Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
  protected static class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin()
        .loginPage("/login").failureUrl("/login?error").permitAll().and()
        .logout().permitAll();
    }

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth
        .jdbcAuthentication()
        .dataSource(dataSource)
        .usersByUsernameQuery(
          "SELECT username, password, TRUE " +
          "FROM user WHERE username=?")
        .authoritiesByUsernameQuery(
          "SELECT username, 'ROLE_USER' FROM user WHERE username=?");
    }

  }
}