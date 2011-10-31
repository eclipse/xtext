package xtend.tutorial.basics

import java.util.Collections
import java.util.List
import xtend.tutorial.util.Person

class Xtend06_Closures {
	
	/**
	 * Xbase (and so Xtend) supports closures.
	 * A closure is very similar to Java's anonymous classes, but has a 
	 * much more convenient and readable syntax.
	 */
	def closures_01(List<Person> persons) {
		persons.personsToString(p | p.name+", "+p.forename )
	}
	
	/**
	 * A function accepting a closure
	 *   (Person)=>String 
	 * is a synonym for 
	 *   org.eclipse.xtext.xbase.lib.Functions$Function1<Person,String>.
	 * The general syntax is
	 *   (typeParam1 ,... typeParamN) => returnType
	 */
	def personsToString(List<Person> persons, (Person)=>String toString) {
		val result = newArrayList()
		for (p : persons) 
			result += toString.apply(p)
		return result
	}
	
	/**
	 * Xtend can coerce function types into any other type, as long as
	 * such a type has only one method defined (in addition to the 
	 * methods inherited from 'java.lang.Object')
	 * 
	 * In the following example 
	 *   java.util.Collections#sort(List<T>, Comparator<T>) 
	 * is invoked with a closure as second parameter. 
	 * The closure is automatically converted to an instance of 
	 *   Comparator<Person>.
	 * 
	 * Note also that you have to put a closure into square brackets is
	 * it isn't the only argument of a function call.
	 */
	def closures_02(List<Person> persons) {
		Collections::sort(persons, [ a, b | a.name.compareTo( b.name ) ])
	}
	
	/**
	 * Sometimes one need to explicitly specify the parameter types,
	 * because there is no context from which they could be inferred. 
	 */
	def closures_withoutTypeInference() {
		return [String s | s.toUpperCase]
	}
}