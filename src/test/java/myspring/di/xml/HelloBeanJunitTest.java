package myspring.di.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloBeanJunitTest {

	private ApplicationContext context;
	
	@Before
	public void init() {
		context = new GenericXmlApplicationContext("classpath:config/beans.xml");
	}
	
	@Test @Ignore
	public void test1() {
		Hello hello = context.getBean("hello", Hello.class);
		assertEquals("Hello Spring", hello.sayHello());
		hello.print();
		
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}
	
	@Test
	public void test2() {
		Hello hello = context.getBean("hello", Hello.class);
		Hello hello2 = context.getBean("hello", Hello.class);
		assertSame(hello, hello2);
	}
}
