package com.bangbang.web.controller.mapper;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Zhranklin on 16/7/5.
 */
public class Mappers {
  private static Mappers ourInstance = new Mappers();

  public UserMapper getUserMapper() {
    return userMapper;
  }

  @Autowired
  private UserMapper userMapper;

  public static Mappers getInstance() {
    return ourInstance;
  }

  private Mappers() { }
}
