package xtend.tutorial.basics

import xtend.tutorial.util.Amount
import xtend.tutorial.util.Person

import static extension java.util.Collections.*

class Xtend03_MethodInvocation {
	
	/**
	 * Xtend supports the Java syntax for method calls.
	 */
	def simpleMethodCall_01(Object myObject) {
		myObject.toString()
	}
	
	/**
	 * If a method does not take arguments you can leave out the 
	 * parentheses.
	 */
	def simpleMethodCall_02(Object myObject) {
		myObject.toString
	}
	
	/**
	 * Static property or method access is done via '::'.
	 */
	def staticProperties() {
		System::out.println("Hello World!")
		
		//Note: there is a preferred built in library for this
		println("Hello World!")
	}
	
	/**
	 * Properties (i.e. getter and setter) can be accessed using the 
	 * more readable property-syntax.
	 */
	def propertAccess(Person person) {
		person.forename = 'Joe'
		person.name = 'Developer'
		return person.forename+" "+person.name
	}
	
	/**
	 * Xtend supports operator overloading.
	 * An operator is just a mapping to a method with a special name 
	 * (starting with the prefix 'operator_') and the correct number of
	 * arguments. A table of supported operators and their precedence 
	 * can be found in the Xbase language reference 
	 * (see Help->Help Contents).
	 * 
	 * (Tip: Hover or use F3 over an operator to go to its declaration)
	 */
	def operatorOverloading(Amount a, Amount b) {
		return (a + b) * 2
	}
	
	/**
	 * Extension methods are a special Xtend feature.
	 * They allow for adding functions to existing types withot modifying 
	 * them. Local functions within Xtend classes can be used using the 
	 * extension syntax by default.
	 */
	def extensionMethods(String string) {
		string.splitOnUnderscore
	}
	
	def splitOnUnderscore(String s) {
		return s.split('_')
	}
	
	/**
	 * If you put the keyword 'extension' in a 'static' import, the 
	 * imported static functions can be accessed using the extension 
	 * syntax as well.
	 */
	def staticExtensionMethods(String string) {
		'foo'.singletonList
	}
	
}