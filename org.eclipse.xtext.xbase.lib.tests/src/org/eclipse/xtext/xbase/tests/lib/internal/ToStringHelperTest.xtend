/*******************************************************************************
 * Copyright (c) 2018, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.lib.internal

import java.lang.annotation.RetentionPolicy
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtend.lib.annotations.ToString
import org.eclipse.xtend2.lib.StringConcatenation
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder
import org.junit.Test

import static org.junit.Assert.*

@Deprecated
class ToStringHelperTest {

	@Test def void testToString() {
		val helper = new org.eclipse.xtext.xbase.lib.util.ToStringHelper
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
		]'''), helper.toString(new MyEntity(new MyEntity)))
	}

	@Test def void testSingleLine() {
		val helper = new ToStringBuilder(new MyEntity).singleLine.addAllFields

		assertEquals(
			'MyEntity [boolProp = true, intProp = 42, myList = ArrayList ("foo","bar","baz"), friend = null, policy = CLASS]',
			helper.toString())
	}

	@Test def void testHideFieldNames() {
		val helper = new ToStringBuilder(new MyEntity).singleLine.hideFieldNames.addAllFields

		assertEquals('MyEntity [true, 42, ArrayList ("foo","bar","baz"), null, CLASS]', helper.toString())
	}

	@Test def void testSkipNulls() {
		val helper = new ToStringBuilder(new MyEntity).skipNulls.addAllFields

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
		]'''), helper.toString())
	}

	@Test def void testExplicitFieldListing() {
		val helper = new ToStringBuilder(new MyEntity).add("boolProp", false).addField("intProp")

		assertEquals(toUnix(
				'''
		MyEntity [
		  boolProp = false
		  intProp = 42
		]'''), helper.toString())
	}

	@Test def void recursionHandling() {
		val helper = new org.eclipse.xtext.xbase.lib.util.ToStringHelper
		val obj = new OtherClass
		obj.name = 'foo'
		obj.other = obj

		assertEquals(toUnix(
				'''
		OtherClass [
		  other = «obj.toString»
		  name = "foo"
		]'''), helper.toString(obj))
	}

	@Test def void recursionHandling_02() {
		val helper = new org.eclipse.xtext.xbase.lib.util.ToStringHelper
		val obj = new DataClass()
		obj.other = obj
		obj.name = "test"
		assertEquals(toUnix(
				'''
		DataClass [
		  other = DataClass@«System::identityHashCode(obj)»
		  name = "test"
		]'''), helper.toString(obj))
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
