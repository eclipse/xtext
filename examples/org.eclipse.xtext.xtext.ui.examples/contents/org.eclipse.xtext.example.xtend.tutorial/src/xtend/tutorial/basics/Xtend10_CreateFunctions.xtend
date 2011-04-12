package xtend.tutorial.basics

import xtend.tutorial.util.Person
import java.util.Set
import org.eclipse.xtext.xbase.lib.Pair
import junit.framework.TestCase
import junit.framework.Assert

/**
 * create functions are used to transform object graphs to nw object graphs in jsut one pass 
 * instead of the usual two pass was, where you first create a tree and then establish cross links.
 * 
 * It solves the m2m transformation problem.
 */
class Xtend10_CreateFunctions extends TestCase {
	
	void testCreateFunctions() {
		val person = newPerson('Joe'->'Developer', newHashSet('Darcy' -> 'Smith'))
		Assert::assertEquals('Darcy', person.friends.head.forename)
		Assert::assertEquals('Joe', person.friends.head.friends.head.forename)
		Assert::assertSame(person, person.friends.head.friends.head)
	}
	
	/**
	 * create a new person for a pair of strings
	 * return the same person for an equals pair of strings.
	 */
	create new Person(name.key, name.value) newPerson(Pair<String,String> name, Set<Pair<String,String>> friends) {
		this.friends = friends.map(pair | newPerson(pair, newHashSet(name))).toSet
	}
}