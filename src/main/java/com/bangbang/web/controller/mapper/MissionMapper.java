package com.bangbang.web.controller.mapper;

import com.bangbang.web.model.Mission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MissionMapper {

//  @Select("SELECT * FROM mission")
//  @Results({
//    @Result(property = "start", column = "start",
//      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
//    @Result(property = "dest", column = "dest",
//      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
//    @Result(property = "producer", column = "producer",
//      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById")),
//    @Result(property = "consumer", column = "consumer",
//      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById"))})
//  List<Mission> findAllMissions();

  @Select("SELECT * FROM mission WHERE id = #{id}")
  @Results({
    @Result(property = "start", column = "start",
      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
    @Result(property = "dest", column = "dest",
      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
    @Result(property = "producer", column = "producer",
      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById")),
    @Result(property = "consumer", column = "consumer",
      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById"))})
  Mission findById(Integer id);
}
