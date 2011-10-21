package xtend.tutorial.basics

import com.google.inject.Inject
import xtend.tutorial.util.Person

class Xtend11_Modularization {
	
	/**
	 * Other Java or Xtend methods are made accessible by means of an
	 * @Inject declaration. If you add the extension keyword the 
	 * methods can be accessed using the extension syntax.
	 * 
	 * The nice thing is that you only program against the type 
	 * signatures but can switch the actual implementation without 
	 * touching the client code.
	 */
	@Inject extension Xtend11_PersonExtensions extensions
	
	def void printTheName(Person person) {
		println( person.fullName )
	}
	
}