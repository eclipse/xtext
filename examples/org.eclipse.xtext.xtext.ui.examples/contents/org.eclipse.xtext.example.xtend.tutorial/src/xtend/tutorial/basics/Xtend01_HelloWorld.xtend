package xtend.tutorial.basics

/*
 * The classical hello world example
 */
import junit.framework.TestCase
import org.junit.Test$None
import junit.framework.Assert

class Xtend01_HelloWorld extends TestCase {
	
	void testHelloWorld() {
		Assert::assertEquals('Hello Joe!', sayHelloTo('Joe'))
	}
	/**
	 * Hello World with explicit return type and explicit return expression.
	 */
	String sayHelloTo(String to) {
		return "Hello "+to+"!"
	}
	
	/**
	 * Hello World with explicit return type and explicit return expression.
	 */
	sayHelloTo2(String to) {
		"Hello "+to+"!"
	}
	
	/**
	 * prints hello world to System.out
	 */
	void sayHelloToSystemOut(String to) {
		System::out.println(sayHelloTo(to))
	}
	
	/**
	 * using the shorter extension method.
	 */
	void sayHelloToSystemOut2(String to) {
		println(sayHelloTo(to))
	}
	
}