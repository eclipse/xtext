/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
import org.junit.Test

import static org.eclipse.xtext.junit4.internal.LineDelimiters.*

class ToStringCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testDefault() {
		'''
			import org.eclipse.xtend.lib.annotations.ToString
			@ToString class Foo {
				static String ignoreMe
				transient String ignoreMe2
				def create {} ignoreMe3() {}
				int a = 1
			}
		'''.compile [
			val instance = compiledClass.newInstance
			
			assertEquals(toUnix('''
				Foo [
				  a = 1
				]'''), instance.toString)
		]
	}
	
	@Test
	def void testSingleLine() {
		'''
			import org.eclipse.xtend.lib.annotations.ToString
			@ToString(singleLine=true) class Foo {
				static String ignoreMe
				transient String ignoreMe2
				def create {} ignoreMe3() {}
				int a = 1
			}
		'''.compile [
			val instance = compiledClass.newInstance
			
			assertEquals(toUnix('''Foo [a = 1]'''), instance.toString)
		]
	}
	
	@Test
	def void testHideFieldNames() {
		'''
			import org.eclipse.xtend.lib.annotations.ToString
			@ToString(singleLine=true, hideFieldNames = true) class Foo {
				static String ignoreMe
				transient String ignoreMe2
				def create {} ignoreMe3() {}
				int a = 1
			}
		'''.compile [
			val instance = compiledClass.newInstance
			
			assertEquals(toUnix('''Foo [1]'''), instance.toString)
		]
	}
	@Test
	def void testVerbatimValues() {
		'''
			import org.eclipse.xtend.lib.annotations.ToString
			@ToString(singleLine=true, verbatimValues = true) class Foo {
				int[] a = #[1, 2, 3]
			}
		'''.compile [
			val instance = compiledClass.newInstance
			
			assertTrue(instance.toString.contains('[I@'))
		]
	}
	
	@Test
	def void testSkipNulls() {
		'''
			import org.eclipse.xtend.lib.annotations.ToString
			@ToString(skipNulls = true) class Foo {
				static String ignoreMe
				transient String ignoreMe2
				def create {} ignoreMe3() {}
				Integer b = null
			}
		'''.compile [
			val instance = compiledClass.newInstance
			
			assertEquals(toUnix('''
				Foo [
				]'''), instance.toString)
		]
	}
	
	@Test
	def void testToStringWithSuperClass() {
		'''
			import org.eclipse.xtend.lib.annotations.ToString
			class Foo {
				int a = 1
			}
			@ToString class Bar extends Foo {
				String b = "Bar"
			}
		'''.compile [
			val instance = getCompiledClass("Bar").newInstance
			
			assertEquals('Bar [\n'+'  b = "Bar"\n' +'  a = 1\n' + ']', instance.toString)
		]
	}
	
	@Test
	def void testExistingToString() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.ToString
			@ToString class Foo {
				int a = 1
				override toString() {
					"foo"
				}
			}
		'''
		text.clazz.assertWarning(XAnnotationsPackage.Literals.XANNOTATION,"user.issue", "no effect")
		text.compile [
			val instance = compiledClass.newInstance
			assertEquals("foo", instance.toString)
		]
	}
	
	@Test
	def void testIntegrationWithData() {
		'''
			import org.eclipse.xtend.lib.annotations.ToString
			import org.eclipse.xtend.lib.annotations.Data
			@ToString(hideFieldNames=true) @Data class Foo {
				String b = "Bar"
			}
		'''.compile [
			val instance = compiledClass.newInstance
			
			assertEquals('Foo [\n'+'  "Bar"\n' +']', instance.toString)
		]
	}
}