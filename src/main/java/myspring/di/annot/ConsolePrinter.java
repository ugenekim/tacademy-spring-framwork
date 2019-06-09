package myspring.di.annot;

import org.springframework.stereotype.Component;

import myspring.di.annot.Printer;

@Component("consolePrinter")
public class ConsolePrinter implements Printer {

	@Override
	public void print(String message) {
		System.out.println(message);
	}

}
