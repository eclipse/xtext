/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package example2

import org.junit.Test
import static org.junit.Assert.*


class BasicExpressions {
	
	@Test def void literals() {
		// string literals work with single or double quotes
		assertEquals('Hello', "Hello")
		
		// number literals (big decimals in this case)
		assertEquals(42, 20 + 20 + 1 * 2)
		assertEquals(42.00bd, 0.00bd + 42bd)
		
		// boolean literals
		assertEquals(true, !false)
		
		// class literals
		assertEquals(getClass(), BasicExpressions)
	}
	
	@Test def void operators() {
		// infix Operators 
		var i = 5
		
		// all Java infix operators are supported
		
		// additive
		assertEquals(6, i + 1)
		assertEquals(4, i - 1)
		
		// multiplicative
		assertEquals(1, i / 5)
		assertEquals(15, i * 3)
		assertEquals(0, i % 5)
		
		// assignment operators
		assertEquals(10, i *= 2)
		
		// relational operators
		assertFalse(i < 0)
		
		// shift operators
		assertEquals(5, i >> 1)
		
		// postfix operators are also the same as in Java
		var j = 4
		assertEquals(4, j--)
		assertEquals(3, j)
		assertEquals(3, j++)
		assertEquals(4, j)
		
		// More operators in Xtend described here http://www.eclipse.org/xtend/documentation.html?operators#operators
	}
	
	@Test def void collections() {
		// There are literals for lists, sets and maps
		// and numerous extension methods which make working with them
		// convenient.
		val list = #['Hello', 'World']
		assertEquals('HELLO', list.map[toUpperCase].head)
		
		val set  = #{1, 3, 5}
		assertEquals(2, set.filter[ it >= 3].size)
		
		val map  = #{'one' -> 1, 'two' -> 2, 'three' -> 3}
		assertEquals( 2 , map.get('two'))
		
		/*the literals produce immutable collections. 
		* There are also factory methods to produce mutable ones
		* Note that their type (seen when hovering over the name)
		* is inferred from the control flow
		*/
		val mutableList = newArrayList
		mutableList.add("Foo")
		val mutableSet = newHashSet
		mutableSet.add("Bar")
		val mutableMap = newHashMap
		mutableMap.put("Fizz", "Buzz")
	}
	
	@Test def void controlStructures() {
		// 'if' looks like in Java
		if ('text'.length == 4) {
			// but it's an expression so it can be used in more flexible ways:
			assertEquals( 42 , if ('foo' != 'BAR'.toLowerCase) 42 else -24 )
		} else {
			fail('Never happens!')
		}
		
		// in a switch the first match wins
		switch (t : 'text') {
			// use predicates
			case t.length > 8 :
				fail('Never happens!')
			// use equals
			case 'text' :
				assertTrue(true)
			default :
				fail('never happens!')
		}
		
		// switch also supports type guards, which provide a safe 
		// and convenient alternative to Java's 'instanceof'-cascades.
		val Object someValue = 'a string typed to Object'
		assertEquals('string', 
			switch someValue {
				Number : 'number'
				String : 'string' 
			})
		
		//there also is an explicit fallthrough syntax
		val num = 3
		assertEquals('not a divisor of 4', switch num {
			case 1,
			case 2,
			case 4: 'divisor of 4'
			default: 'not a divisor of 4'
		})	
	}
	
	@Test def void loops() {
		// for loop
		var counter = 1
		for (i : 1 .. 10) {
			assertEquals(counter, i)
			counter = counter + 1
		}
		
		//traditional for loop
		for(var i = 11; i > 0; i--) {
			assertEquals(counter, i)
			counter -=  1 //compound assignment
		}
		
		// while loop
		val iterator = #[1,2,3,4,5].iterator
		counter = 1
		while(iterator.hasNext) {
			val i = iterator.next
			assertEquals(counter, i)
			counter = counter + 1
		}
	}
}