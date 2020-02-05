/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib.internal

import java.lang.annotation.RetentionPolicy
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder
import org.junit.Test

import static org.junit.Assert.*
import org.eclipse.xtend.lib.annotations.ToString

/**
 * @author Karsten Thoms - Initial contribution and API
 */
class ToStringBuilderTest {

	@Test def void testToString() {
		val builder = new ToStringBuilder(new MyEntity(new MyEntity)).addAllFields
		assertEquals(toUnix(
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
		]'''), builder.toString())
	}

	@Test def void testSingleLine() {
		val builder = new ToStringBuilder(new MyEntity).singleLine.addAllFields

		assertEquals(
			'MyEntity [boolProp = true, intProp = 42, myList = ArrayList ("foo","bar","baz"), friend = null, policy = CLASS]',
			builder.toString())
	}

	@Test def void testHideFieldNames() {
		val builder = new ToStringBuilder(new MyEntity).singleLine.hideFieldNames.addAllFields

		assertEquals('MyEntity [true, 42, ArrayList ("foo","bar","baz"), null, CLASS]', builder.toString())
	}

	@Test def void testSkipNulls() {
		val builder = new ToStringBuilder(new MyEntity).skipNulls.addAllFields

		assertEquals(toUnix(
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
		]'''), builder.toString)
	}

	@Test def void testExplicitFieldListing() {
		val builder = new ToStringBuilder(new MyEntity).add("boolProp", false).addField("intProp")

		assertEquals(toUnix(
				'''
		MyEntity [
		  boolProp = false
		  intProp = 42
		]'''), builder.toString)
	}

	@Test def void recursionHandling() {
		val obj = new OtherClass
		obj.name = 'foo'
		obj.other = obj
		val builder = new ToStringBuilder(obj).addDeclaredFields

		assertEquals(toUnix(
				'''
		OtherClass [
		  other = «obj.toString»
		  name = "foo"
		]'''), builder.toString)
	}

	@Test def void recursionHandling_02() {
		val obj = new DataClass()
		obj.other = obj
		obj.name = "test"
		val builder = new ToStringBuilder(obj).addDeclaredFields
		assertEquals(toUnix(
				'''
		DataClass [
		  other = DataClass@«System::identityHashCode(obj)»
		  name = "test"
		]'''), builder.toString)
	}

	static class OtherClass {
		public OtherClass other
		public String name
	}

	@Accessors @ToString static class DataClass {
		public DataClass other
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

	def static String toUnix(String s) {
		var StringConcatenation result = new StringConcatenation("\n")
		result.append(s)
		return result.toString()
	}
}
