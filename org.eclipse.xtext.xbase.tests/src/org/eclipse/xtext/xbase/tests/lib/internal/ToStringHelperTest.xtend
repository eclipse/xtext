package org.eclipse.xtext.xbase.tests.lib.internal

import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtext.xbase.lib.util.ToStringHelper
import java.lang.annotation.RetentionPolicy
import org.eclipse.xtext.util.Wrapper
import static org.eclipse.xtext.xbase.junit.LineDelimiters.*
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder
import org.eclipse.xtend.lib.annotations.Data

class ToStringHelperTest {

	@Test def void testToString() {
		val helper = new ToStringHelper
		assertEquals(
			toUnix(
				'''
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
				]'''), helper.toString(new MyEntity(new MyEntity)))
	}
	
	@Test def void testSingleLine() {
		val helper = new ToStringBuilder(new MyEntity)
		.singleLine
		.addAllFields
		
		assertEquals('MyEntity [boolProp = true, intProp = 42, myList = ArrayList ("foo","bar","baz"), friend = null, policy = CLASS]', helper.toString())
	}
	
	@Test def void testHideFieldNames() {
		val helper = new ToStringBuilder(new MyEntity)
		.singleLine
		.hideFieldNames
		.addAllFields
		
		assertEquals('MyEntity [true, 42, ArrayList ("foo","bar","baz"), null, CLASS]', helper.toString())
	}
	
	@Test def void testSkipNulls() {
		val helper = new ToStringBuilder(new MyEntity)
		.skipNulls
		.addAllFields
		
		assertEquals(
			toUnix(
				'''
				MyEntity [
				  boolProp = true
				  intProp = 42
				  myList = ArrayList (
				    "foo",
				    "bar",
				    "baz"
				  )
				  policy = CLASS
				]'''), helper.toString())
	}
	
	@Test def void testExplicitFieldListing() {
		val helper = new ToStringBuilder(new MyEntity)
		.add("boolProp", false)
		.addField("intProp")
		
		assertEquals(
			toUnix(
				'''
				MyEntity [
				  boolProp = false
				  intProp = 42
				]'''), helper.toString())
	}

	@Test def void recursionHandling() {
		val helper = new ToStringHelper
		val obj = new OtherClass
		obj.name = 'foo'
		obj.other = obj

		assertEquals(
			toUnix(
				'''
				OtherClass [
				  other = «obj.toString»
				  name = "foo"
				]'''), helper.toString(obj))
	}

	@Test def void recursionHandling_02() {
		val helper = new ToStringHelper
		val ref = new Wrapper<DataClass>
		val obj = new DataClass(ref, "test")
		ref.set(obj)
		assertEquals(
			toUnix(
				'''
				DataClass [
				  other = Wrapper of (DataClass@«System::identityHashCode(obj)»)
				  name = "test"
				]'''), helper.toString(obj))
	}

	static class OtherClass {
		public OtherClass other
		public String name
	}

	@Data static class DataClass {
		public Wrapper<DataClass> other
		public String name
	}

	static class MyEntity {
		val boolProp = true
		val intProp = 42
		val myList = newArrayList('foo', 'bar', 'baz')
		val MyEntity friend
		val RetentionPolicy policy = RetentionPolicy::CLASS

		new() {
			this.friend = null
		}

		new(MyEntity friend) {
			this.friend = friend;
		}

		override toString() {
			return boolProp + '\n' + intProp + '\n' + myList + '\n' + friend + '\n' + policy
		}
	}
}
