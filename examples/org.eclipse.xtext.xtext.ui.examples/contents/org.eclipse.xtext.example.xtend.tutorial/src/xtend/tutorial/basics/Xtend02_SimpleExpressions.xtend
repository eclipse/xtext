package xtend.tutorial.basics

import java.util.ArrayList

class Xtend02_SimpleExpressions {
	
	/**
	 * string literals can be multi line and 
	 * can be terminated by either single quotes or double quotes
	 */
	def stringLiteral() {
		'Hello World'
	}
	
	def booleanLiteral() {
		true || false
	}
	
	def intLiteral() {
		42 + 21
	}
	
	def nullLiteral() {
		null
	}
	
	def objectConstruction() {
		new ArrayList<String>()
	}
	
	/**
	 * The equivalent to Java's String.class is typeof(String)
	 */
	def clazzLiteral() {
		typeof(String)
	}
	
	/**
	 * the equivalent to Java's ((String)null) is (null as String)
	 */
	def casts() {
		(null as String).toString() // results in a NullPointerException
	}
	
	/**
	 * variable declaration can occure within a block expression.
	 * Which in turn can occure everywhere an expression can occure.
	 */
	def variableDeclaration() {
		val myString = 'Hello World'
		var modifiable = {
			val myOther = myString.toLowerCase
			myOther
		}
		// myOther is not visible anymore
		// modifiable is 'hello world'
		modifiable = myString.toUpperCase
		// modifiable is 'HELLO WORLD'
	}
	
}