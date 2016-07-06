package com.bangbang.web.controller.mapper;

import com.bangbang.web.model.Mission;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MissionMapper {

  @Select("SELECT * FROM mission")
  List<Mission> findAllMissions();
}
