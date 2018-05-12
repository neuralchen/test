package com.AIRetail.Service.Implement;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.AIRetail.Entity.UserEntity;
import com.AIRetail.Service.UserManagerService;
import com.AIRetail.DAO.*;

@Service
public class UserManagerServiceImp implements UserManagerService {
	@Autowired
	private UserDAO userdao; 

	public UserEntity createUser(UserEntity user) {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteUser(Integer userId) {
		// TODO Auto-generated method stub
		
	}

	public void changePassword(Integer userId, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	public UserEntity findByUsername(String userlabel) {
		return userdao.selectByUserlabel(userlabel);
	}

	public Integer getRankIdById(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<UserEntity> getUsersByRankid(Integer rankid) {
		// TODO Auto-generated method stub
		return null;
	}

	public Set<String> getRoles(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserEntity findByUserId(Integer userid) {
		return userdao.selectByUserid(userid);
	}

}
