package com.bangbang.mapper;

import com.bangbang.web.model.Place;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlaceMapper {
  @Select("SELECT * FROM place")
  List<Place> findAll();

  @Select("SELECT * FROM place WHERE name = #{name}")
  Place findByName(String name);

  @Select("SELECT * FROM place WHERE id = #{id}")
  Place findById(Integer id);

  @Insert("INSERT INTO place(name, longitude, latitude) VALUES (#{name}, #{long}, #{latitude})")
  int insertPlace(Place place);
}

