package com.bangbang.web.controller.mapper;

import com.bangbang.web.model.Place;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
interface PlaceMapper {
  @Select("SELECT * FROM place WHERE name = #{name}")
  Place findPlaceByName(String name);

  @Insert("INSERT INTO place(name, longitude, latitude) VALUES (#{name}, #{long}, #{latitude})")
  int insertPlace(Place place);
}

