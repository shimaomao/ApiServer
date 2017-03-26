package com.chinaopensource.apiserver.system.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.chinaopensource.apiserver.system.user.data.User;

@Mapper
public interface UserMapper {

	int save(User user);

	void delete(Integer id);

	User findUserById(Integer id);

	List<User> findAllUser();

	void update(User user);

	String findPasswordByLoginName(String loginName);

	User findUserByLoginName(String loginName);
}
