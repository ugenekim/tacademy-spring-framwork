package myspring.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import myspring.user.vo.UserVO;

//@Repository("userDao")
public class UserDaoImplJDBC implements UserDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	class UserMapper implements RowMapper<UserVO> {
		public UserVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			UserVO user = new UserVO();
			user.setUserId(rs.getString("userid"));
			user.setName(rs.getString("name"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			return user;
		}
	}
	
	@Override
	public void insert(UserVO user) {
		String SQL = "insert into tacademy_users (userid, name, gender,city) values (?, ?, ?, ?)";
		jdbcTemplate.update(SQL, user.getUserId(), user.getName(), user.getGender(), user.getCity());
		System.out.println("등록된 Record UserId=" + user.getUserId() + " Name=" + user.getName());
	}

	@Override
	public List<UserVO> readAll() {
		String SQL = "select * from tacademy_users";
		List<UserVO> userList = jdbcTemplate.query(SQL, new UserMapper());
		return userList;
	}

	@Override
	public void update(UserVO user) {
		String SQL = "update tacademy_users  set name = ?, gender = ?, city = ? where userid = ?"; 
		jdbcTemplate.update(SQL, user.getName(), user.getGender(), user.getCity(), user.getUserId());
		System.out.println("수정된 Record UserId=" + user.getUserId());
	}

	@Override
	public void delete(String id) {
		String SQL = "delete from tacademy_users where userid = ?"; 
		jdbcTemplate.update(SQL, id); 
		System.out.println("삭제된 Record with ID = " + id ); 
	}

	@Override
	public UserVO read(String id) {
		String SQL = "select * from tacademy_users where userid = ?";
		try {
			UserVO user = jdbcTemplate.queryForObject(SQL, new Object[] { id }, new UserMapper());
			return user;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
