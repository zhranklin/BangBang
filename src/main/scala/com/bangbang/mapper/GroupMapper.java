package com.bangbang.mapper;

import com.bangbang.web.model.Group;
import com.bangbang.web.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupMapper {

  @Select("SELECT * FROM `group` WHERE id = #{id}")
  @Results({
    @Result(id = true, column = "id", property = "id"),
    @Result(property = "location", column = "location",
      one = @One(select = "com.bangbang.mapper.PlaceMapper.findById")),
    @Result(property = "admins", column = "id",
      many = @Many(select = "GroupMapper.findAdminsByGroupId")),
    @Result(property = "members", column = "id",
      many = @Many(select = "GroupMapper.findMembersByGroupId"))
  })
  Group findById(Integer id);

  @Select("SELECT * FROM `group`, group_admin WHERE user_id = #{userId} && `group`.id = group_id")
  List<Group> findGroupsByAdminId(Integer userId);

  @Select("SELECT * FROM `group`, group_member WHERE user_id = #{userId} && `group`.id = group_id")
  List<Group> findGroupsByMemberId(Integer userId);

  @Select("SELECT * FROM user, group_admin WHERE group_id = #{groupId} && user.id = user_id")
  List<User> findAdminsByGroupId(Integer groupId);

  @Select("SELECT * FROM user, group_member WHERE group_id = #{groupId} && user.id = user_id")
  List<User> findMembersByGroupId(Integer groupId);

  @Insert("INSERT INTO group_admin (user_id, group_id) VALUES (#{userId}, #{groupId})")
  int addGroupAdmin(@Param("userId") Integer userId, @Param("groupId") Integer groupId);

  @Insert("INSERT INTO group_member (user_id, group_id) VALUES (#{userId}, #{groupId})")
  int addGroupMember(@Param("userId") Integer userId, @Param("groupId") Integer groupId);

  @Select("SELECT count(*) FROM group_admin WHERE (user_id = #{userId} && group_id = #{groupId})")
  int isGroupMember(@Param("userId") Integer userId, @Param("groupId") Integer groupId);

}
