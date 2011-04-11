package xtext.tutorial.basics

import java.util.List

class Xtend05_Loops {
	/**
	 * for expressions are just like in Java.
	 * The only difference is that they are expressions (of type void) and that type inference is supported
	 */
	forLoop(List<String> strings) {
		// like in Java
		for (String s : strings) {
			println("Hi "+s)
		}
		// with type inference
		for (s : strings) {
			println("Hi "+s)
		}
	}
	
	/**
	 * there is nothing special about the while loop expect that again it is an expression of type void.
	 */
	whileLoop(List<String> strings) {
		val iter = strings.iterator
		while (iter.hasNext) {
			println("Hi "+iter.next)
		}
	}
}