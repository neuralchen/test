package com.AIRetail.DAO;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.AIRetail.Entity.*;

@Repository
public interface UserDAO {
	UserEntity selectByUserlabel(String userlabel);
	UserEntity selectByUserid(Integer userid);
	List<UserEntity> selectByRankid(Integer rankid);
}
