package com.bangbang.web.controller.mapper;

import com.bangbang.web.model.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserMapper {

  @Select("SELECT * FROM user WHERE username = #{username}")
  @Results({
    @Result(column = "realname", property = "realname")
  })
  User findById(@Param("username") String username);

  @Select("SELECT * FROM user WHERE username = #{username}")
  @Results({
    @Result(column = "realname", property = "realname")
  })
  User findByUserName(@Param("username") String username);

  @Insert("INSERT INTO user (username, password, realname, phone, coin) " +
    "VALUES (#{username}, #{password}, #{realname}, #{phone}, #{coin})")
  @Options(useGeneratedKeys = true)
  int insertUser(User user);

}
