package xtend.tutorial.basics

import java.util.Collections
import java.util.List
import xtend.tutorial.util.Person

class Xtend06_Closures {
	
	/**
	 * Xbase (and so soed Xtend) supports closures.
	 * A closure is very similar to Java's anonymous classes, but has 
	 * a much more convenient and readable syntax.
	 * 
	 */
	closures_01(List<Person> persons) {
		persons.personsToString(p | p.name+", "+p.forename )
	}
	
	/**
	 * a function accepting a closure
	 * (Person)=>String is a synonym for org.eclipse.xtext.xbase.lib.Functions$Function1<Person,String>
	 * The general syntax if
	 * (typeParam1 ,... typeParamN) => returnType
	 */
	personsToString(List<Person> persons, (Person)=>String toString) {
		val result = newArrayList()
		for (p : persons) 
			result += toString.apply(p)
		return result
	}
	
	/**
	 * Xtend can coerce function types into any other type, 
	 * as long as such a type has only one method defined 
	 * (in addition to the methods inherited from java.lang.Object)
	 * 
	 * In the following example java.util.Collections#sort(List<T>, Comparator<T>) is invoked.
	 * Where a closure is passed in as second parameter and automatically 
	 * converted to an instance of Comparator<Person>.
	 * 
	 * Note also that you have to put a closure into square brackets is it isn't the only argument to a function.
	 */
	closures_02(List<Person> persons) {
		// sort by name 
		Collections::sort(persons, [ a, b | a.name.compareTo( b.name ) ] )
	}
	
	/**
	 * sometimes one need to explicitly specify the parameter types, 
	 * because there is no context to they can be inferred from. 
	 */
	closures_withoutTypeInference() {
		return [String s | s.toUpperCase]
	}
}