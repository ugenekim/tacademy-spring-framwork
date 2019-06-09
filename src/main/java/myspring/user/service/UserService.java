package myspring.user.service;

import java.util.List;

import myspring.user.vo.UserVO;

public interface UserService {

	public void insertUser(UserVO user);
	
	public List<UserVO> getUserList();
	
	public UserVO getUser(String id);
	
	public void updateUser(UserVO user);
	
	public void deleteUser(String id);
	
}
