package com.example.demoAPI.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.example.demoAPI.model.User;

@Mapper
public interface UserMapper {

	@Select("select * from user")
	public List<User> findAll();

	@Insert("insert into user(id,name, status) values(#{id},#{name}, #{status})")
	void insert(User user);

	@Update("update user set name = #{name}, status = #{status} where id = #{id}")
	void update(User user);

	@Delete("delete from user where id=#{id}")
	void delete(int id);
}
