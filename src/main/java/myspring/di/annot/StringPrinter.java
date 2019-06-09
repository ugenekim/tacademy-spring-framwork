package myspring.di.annot;

import org.springframework.stereotype.Component;

import myspring.di.annot.Printer;

@Component("stringPrinter")
public class StringPrinter implements Printer {

	private StringBuffer buffer = new StringBuffer();
	
	@Override
	public void print(String message) {
		this.buffer.append(message);
	}
	
	public String toString() {
		return this.buffer.toString();
	}

}
