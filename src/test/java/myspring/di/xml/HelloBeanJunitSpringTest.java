package myspring.di.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanJunitSpringTest {

	@Autowired
	private ApplicationContext context;
	
	@Test @Ignore
	public void test1() {
		Hello hello = context.getBean("hello", Hello.class);
		assertEquals("Hello Spring", hello.sayHello());
		
		Hello hello2 = context.getBean("hello", Hello.class);
		assertSame(hello, hello2);
	}
	
	@Test @Ignore
	public void test2() {
		Hello hello = context.getBean("hello2", Hello.class);
		assertEquals("Hello Spring", hello.sayHello());
	}
	
	@Test @Ignore
	public void test3() {
		Hello hello = context.getBean("hello3", Hello.class);
		assertEquals("Hello Spring", hello.sayHello());
	}
	
	@Test @Ignore
	public void test4() {
		Hello hello = context.getBean("hello4", Hello.class);
		assertEquals(3, hello.getNames().size());
		
		List<String> list = hello.getNames();
		for (String value : list) {
			System.out.println(value);
		}
	}
	
	@Test
	public void test5() {
		Hello hello = context.getBean("hello5", Hello.class);
		assertEquals(3, hello.getNames().size());
		
		List<String> list = hello.getNames();
		for (String value : list) {
			System.out.println(value);
		}
	}
}
