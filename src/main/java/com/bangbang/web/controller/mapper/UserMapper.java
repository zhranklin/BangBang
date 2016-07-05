package com.bangbang.web.controller.mapper;

import com.bangbang.web.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface UserMapper {

  @Select("SELECT * FROM city WHERE state = #{state}")
  User findByUserName(@Param("username") String state);

  @Insert("INSERT INSERT")

}
