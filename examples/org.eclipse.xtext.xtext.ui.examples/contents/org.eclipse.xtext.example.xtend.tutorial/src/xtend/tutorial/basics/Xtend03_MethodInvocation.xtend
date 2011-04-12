package xtend.tutorial.basics

/**
 * Xtend binds directly to Java types, so you can call
 * everything which is compile to Java.
 */
import xtend.tutorial.util.Person
import xtend.tutorial.util.Amount
import static extension java.util.Collections.*

class Xtend03_MethodInvocation {
	
	/**
	 * Xtend supports the Java syntax
	 */
	simpleMethodCall_01(Object myObject) {
		myObject.toString()
	}
	
	/**
	 * if a method does not take arguments you can leave out the parenthesis
	 */
	simpleMethodCall_02(Object myObject) {
		myObject.toString
	}
	
	/**
	 * Static property or method access is done using th
	 */
	staticProperties() {
		System::out.println("Hello World!")
		
		//Note: there is a preferred built in library for this
		println("Hello World!")
	}
	
	/**
	 * properties (i.e. getter and setter) can be accessed using the more readable property-syntax
	 */
	propertAccess(Person person) {
		person.forename = 'Joe'
		person.name = 'Developer'
		return person.forename+" "+person.name
	}
	
	/**
	 * Xtend supports operator overloading.
	 * An operator is just a mapping to a method with a special name (starting with the prefix 'operator_') and the correct number of arguments.
	 * A table of supported operators and their precedence can be found in the Xbase language reference (see Help->Help Contents).
	 * 
	 * (Tip: Hover or use F3 over an operator to go to its declaration)
	 */
	operatorOverloading(Amount a, Amount b) {
		return (a + b) * 2
	}
	
	/**
	 * Extension methods are a special Xtend feature.
	 * They allow for adding functions to existing types withot modifying them.
	 * Local functions within Xtend classes can be used using the extension syntax by default.
	 */
	extensionMethods(String string) {
		string.splitOnUnderscore
	}
	
	splitOnUnderscore(String s) {
		return s.split('_')
	}
	
	/**
	 * If you put the keyword 'extension' in a 'static' import, the imported static functions
	 * can be accessed using the extension syntax as well.
	 */
	staticExtensionMethods(String string) {
		'foo'.singletonList
	}
	
}