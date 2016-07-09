package com.bangbang.web.controller.mapper;

import com.bangbang.web.model.Mission;
import com.bangbang.web.model.SimpleMission;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.javassist.bytecode.annotation.IntegerMemberValue;

import java.util.List;

@Mapper
public interface MissionMapper {

  @Select("SELECT * FROM mission")
  @Results({
    @Result(property = "start", column = "start",
      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
    @Result(property = "dest", column = "dest",
      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
    @Result(property = "producer", column = "producer",
      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById")),
    @Result(property = "consumer", column = "consumer",
      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById"))})
  List<Mission> findAllMissions();


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

  @Select("SELECT * FROM mission WHERE producer = #{producer}")
  @Results({
    @Result(property = "start", column = "start",
      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
    @Result(property = "dest", column = "dest",
      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
    @Result(property = "producer", column = "producer",
      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById")),
    @Result(property = "consumer", column = "consumer",
      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById"))})
  List<Mission> findByProducerId(Integer producer);

  @Select("SELECT * FROM mission")
  @Results({
    @Result(property = "start", column = "start",
      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
    @Result(property = "dest", column = "dest",
      one = @One(select = "com.bangbang.web.controller.mapper.PlaceMapper.findById")),
    @Result(property = "producer", column = "producer",
      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById")),
    @Result(property = "consumer", column = "consumer",
      one = @One(select = "com.bangbang.web.controller.mapper.UserMapper.findById"))})
  List<Mission> findAll();

  @Select("SELECT * FROM mission")
  List<SimpleMission> findAllSimple();

  @Insert("INSERT INTO mission(start, dest, price, description, producer, consumer, status)" +
    "VALUES (#{start}, #{dest}, #{price}, #{description}, #{producer}, #{consumer}, 0)")
  int addMission(SimpleMission mission);


}
