package xtend.tutorial.basics

import java.util.List

class Xtend05_Loops {
	
	/**
	 * For expressions are just like in Java. The only difference is 
	 * that they are expressions (of type 'void') and that type 
	 * inference is supported.
	 */
	def forLoop(List<String> strings) {
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
	 * There is nothing special about the while loop expect that again 
	 * it is an expression of type 'void'.
	 */
	def whileLoop(List<String> strings) {
		val iter = strings.iterator
		while (iter.hasNext) {
			println("Hi "+iter.next)
		}
	}
}