package xtend.tutorial.basics

/**
 * Xtend supports dependency injection as a first clazz language feature.
 */
import junit.framework.TestCase
import com.google.inject.Guice
import junit.framework.Assert
import xtend.tutorial.util.Person
import xtend.tutorial.util.XtendModule

class Xtend11_Modularization {
	
	/**
	 * Other Java or Xtend methods are made accessible by means of an @Inject declaration.
	 * If you add the extension keyword the methods can be accessed using the extension syntax.
	 * 
	 * The nice thing is that you only program against the typoe signatures but can switch the actual implmentation without touching the code.
	 */
	@Inject extension Xtend11_PersonExtensions
	
	void printTheName(Person person) {
		println( person.fullName )
	}
	
}