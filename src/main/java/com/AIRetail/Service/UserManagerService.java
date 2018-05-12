package com.AIRetail.Service;

import java.util.Set;
import org.springframework.stereotype.Service;
import com.AIRetail.Entity.UserEntity;

public interface UserManagerService {
	public UserEntity createUser(UserEntity user); //创建账户
	public void deleteUser(Integer userId);//通过用户ID删除对应用户
	public void changePassword(Integer userId, String newPassword);//修改密码
	public UserEntity findByUsername(String userlabel);// 根据用户名查找用户
	public UserEntity findByUserId(Integer userlabel);// 根据用户名查找用户
	public Integer getRankIdById(Integer userId);//通过用户ID获得rankid
	public Set<UserEntity> getUsersByRankid(Integer rankid);//通过rankid获得对应的用户
	public Set<String> getRoles(Integer userId);//通过用户ID获得用户角色
}
