package org.eclipse.xtext.xbase.tests.lib.internal

import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.xbase.lib.util.ToStringHelper
import java.lang.annotation.RetentionPolicy

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
		  CLASS
		  policy = CLASS
		]'''.toString,helper.toString(new MyEntity(new MyEntity)))
	}
	
	@Test def void recursionHandling() {
		val helper = new ToStringHelper
		val obj = new OtherClass
		obj.name = 'foo'
		obj.other = obj
		
		assertEquals('''
		OtherClass [
		  other = OtherClass@«System::identityHashCode(obj)»
		  name = "foo"
		]'''.toString,helper.toString(obj))
	}
}

class OtherClass {
	public OtherClass other
	public String name
}

class MyEntity {
	val boolProp = true
	val intProp = 42
	val myList = newArrayList('foo','bar','baz')
	val MyEntity friend
	val RetentionPolicy policy = RetentionPolicy::CLASS
	
	new() {
		this.friend = null
	}
	new(MyEntity friend) {
		this.friend = friend;
	}
	
	override toString() {
		return boolProp+'\n'+intProp+'\n'+myList+'\n'+friend+'\n'+policy
	}
}

