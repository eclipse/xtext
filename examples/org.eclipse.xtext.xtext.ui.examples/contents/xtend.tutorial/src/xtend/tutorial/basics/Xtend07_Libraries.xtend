package xtend.tutorial.basics

import junit.framework.TestCase

/**
 * Xbase and Xtend come with libraies which are automatically on the
 * extension scope.
 */
class Xtend07_Libraries extends TestCase {
	
	def void testCollectionLiterals() {
		println(newArrayList('foo','bar','baz'))
		println(newHashMap( 2 -> 'two', 42 -> 'fourty two'))
		println(newHashSet(1,2,3,3,3))
	}
	
	def void testStringUtilities() {
		println('foo'.toFirstUpper)
	}
	
	def testHigherOrderFunctions(Iterable<String> myStrings) {
		
		// Find the first string with length 3.
		println(myStrings.findFirst(e|e.length == 3))
		
		// Convert all to uppercase.
		println(myStrings.map(e|e.toUpperCase))
		
		// Filter out strings longer than 3 characters.
		println(myStrings.filter(e| e.length <= 3 ))
	}
	
	/**
	 * all operator are built via library
	 */
	def operators() {
		// String concatenation is built via library.
		println('Hello'+' '+'World!')
		
		// arithemetics
		println(42 + 8 / (46+2))
		
		// boolean arithemetic
		println(true && 42 > 13)
	}
}