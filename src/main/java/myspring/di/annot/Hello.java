package myspring.di.annot;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("hello")
public class Hello {

	@Value("${myname}")
	private String name;
	
//	@Autowired
//	@Qualifier("stringPrinter")
	@Resource(name="${printer1}")
	private Printer printer;
	
	public String sayHello() {
		return "Hello " + name;
	}
	
}
