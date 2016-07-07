//package com.bangbang.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//  @Autowired
//  private DataSource
//    dataSource;
//
////  @Override
////  public void configure(WebSecurity web) {
////    web.ignore("/");
////  }
//
////  @Override
////  protected void configure(HttpSecurity http) throws Exception {
////    http
////      .authorizeRequests()
////        .antMatchers("/**").hasRole("USER").anyRequest().permitAll();
////
//////      .and()
//////      .formLogin()
//////      .and()
//////      .httpBasic();
////  }
//
////  @Autowired
////  protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
////    auth
////      .jdbcAuthentication()
////      .dataSource(dataSource)
////      .usersByUsernameQuery("select username, password, true from user where username=?")
////      .authoritiesByUsernameQuery(
////        "select username, 'ROLE_USER' from user where usernameasdf=?"
////      );
////  }
//  @Autowired
//  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
//    auth
//      .inMemoryAuthentication()
//      .withUser("user").password("password").roles("USER").and()
//      .withUser("admin").password("password").roles("USER", "ADMIN");
//  }
//
//  @Configuration
//  @Order(1)
//  public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
//    protected void configure(HttpSecurity http) throws Exception {
//      http
//        .antMatcher("/api/**")
//        .authorizeRequests()
//        .anyRequest().hasRole("ADMIN")
//        .and()
//        .antMatcher("/**")
//        .authorizeRequests()
//        .anyRequest().hasRole("ADMIN")
//        .and()
//        .httpBasic();
//    }
//  }
//
//  @Configuration
//  public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//      http
//        .authorizeRequests()
//        .anyRequest().authenticated()
//        .and()
//        .formLogin();
//    }
//  }
//}
