package myspring.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

@Repository("userDao")
public class UserDaoImplMapper implements UserDao {
	
	@Autowired
	private UserMapper mapper; 

	@Override
	public void insert(UserVO user) {
		mapper.insertUser(user);
		System.out.println("등록된 Record UserId=" + user.getUserId() + " Name=" + user.getName());
	}

	@Override
	public List<UserVO> readAll() {
		List<UserVO> userList = mapper.selectUserList();
		return userList;
	}

	@Override
	public void update(UserVO user) {
		mapper.updateUser(user);
		System.out.println("수정된 Record UserId=" + user.getUserId());
	}

	@Override
	public void delete(String id) {
		mapper.deleteUser(id);
		System.out.println("삭제된 Record with ID = " + id ); 
	}

	@Override
	public UserVO read(String id) {
		UserVO user = mapper.selectUserById(id);
		return user;
	}

}
