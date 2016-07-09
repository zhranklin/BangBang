package com.bangbang.web.controller.mapper;

import com.bangbang.web.model.Mission;
import com.bangbang.web.model.SimpleMission;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by Zhranklin on 16/7/7.
 */
public class MissionMapper1 {

  @Autowired
  private PlaceMapper placeMapper;

  @Autowired
  private UserMapper userMapper;

  public Mission toMission(SimpleMission sm) {
    Mission m = new Mission();
    m.setStart(placeMapper.findById(sm.getStart()));
    m.setDest(placeMapper.findById(sm.getDest()));
    m.setDescription(sm.getDescription());
    m.setConsumer(userMapper.findById(sm.consumer()));
    m.setProducer(userMapper.findById(sm.producer()));
    return m;
  }

  static MissionMapper1 mm = new MissionMapper1();

  public static MissionMapper1 ins() {
    return mm;
  }
}
