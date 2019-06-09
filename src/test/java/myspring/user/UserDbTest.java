package myspring.user;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class UserDbTest {
	
	@Autowired
	private ApplicationContext context;

	@Test
	public void dataSourceTest() {
		DataSource ds = context.getBean("dataSource", DataSource.class);
		try {
			System.out.println(ds.getConnection());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	UserService userService;
	
	@Test @Ignore 
	public void getUserTest() {
		UserVO user = userService.getUser("gildong");
		System.out.println(user);
		assertEquals("홍길동", user.getName());
	}
	
	@Test @Ignore
	public void insertUserTest() {
		userService.insertUser(new UserVO("dooly", "둘리", "남", "경기"));
		for (UserVO	user : userService.getUserList()) {
			System.out.println(user);
		}
	}

	@Test @Ignore
	public void updateUserTest() {
		userService.updateUser(new UserVO("dooly", "김둘리2", "여", "부산"));
		for (UserVO	user : userService.getUserList()) {
			System.out.println(user);
		}
	}

	@Test
	public void deleteUserTest() {
		userService.deleteUser("dooly");
		for (UserVO	user : userService.getUserList()) {
			System.out.println(user);
		}
	}
}
