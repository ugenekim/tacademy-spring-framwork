package myspring.di.annot;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/annot.xml")
public class HelloBeanJunitSpringTest {

	@Autowired
	private ApplicationContext context;
	
	@Test
	public void test1() {
		Hello hello = context.getBean("hello", Hello.class);
		assertEquals("Hello Spring", hello.sayHello());
	}
}
