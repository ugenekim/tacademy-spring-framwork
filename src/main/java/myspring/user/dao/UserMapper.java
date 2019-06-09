package myspring.user.dao;

import java.util.List;

import myspring.user.vo.UserVO;

@MyMapper
public interface UserMapper {

	UserVO selectUserById(String id);
	List<UserVO> selectUserList();
	void insertUser(UserVO user);
	void updateUser(UserVO user);
	void deleteUser(String id);
	
}
