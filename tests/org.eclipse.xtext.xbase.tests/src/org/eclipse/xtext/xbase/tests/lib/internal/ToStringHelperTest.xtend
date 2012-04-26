package org.eclipse.xtext.xbase.tests.lib.internal

import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.xbase.lib.internal.ToStringHelper

class ToStringHelperTest {
	
	@Test def void testToString() {
		val helper = new ToStringHelper
		assertEquals('''
		MyEntity [
		  boolProp = true
		  intProp = 42
		  myList = ArrayList (
		    "foo",
		    "bar",
		    "baz"
		  )
		  friend = true
		  42
		  [foo, bar, baz]
		  null
		]'''.toString,helper.toString(new MyEntity(new MyEntity)))
	}
}

class MyEntity {
	val boolProp = true
	val intProp = 42
	val myList = newArrayList('foo','bar','baz')
	val MyEntity friend
	
	new() {
		this.friend = null
	}
	new(MyEntity friend) {
		this.friend = friend;
	}
	
	override toString() {
		return ''+boolProp+'\n'+intProp+'\n'+myList+'\n'+friend
	}
}

