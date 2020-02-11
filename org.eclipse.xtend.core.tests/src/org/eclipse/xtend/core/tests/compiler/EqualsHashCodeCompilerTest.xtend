/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
import org.junit.Test

class EqualsHashCodeCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testEqualsHashCode() {
		'''
			import org.eclipse.xtend.lib.annotations.EqualsHashCode
			@EqualsHashCode class Foo {
				static String ignoreMe
				transient String ignoreMe2
				def create {} ignoreMe3() {}
				
				int a = 1
				char b = 'a'
				short c = 2 as short
				byte d = 3 as byte
				long e = 4
				float f = 5
				double g = 6
				boolean h = true
				Object i = "Foo"
			}
		'''.compile [
			val first = compiledClass.getDeclaredConstructor().newInstance
			val second = compiledClass.getDeclaredConstructor().newInstance
			compiledClass.getDeclaredField("ignoreMe") => [
				accessible = true
				set(null, "Bar")
			]
			compiledClass.getDeclaredField("ignoreMe2") => [
				accessible = true
				set(second, "Bar")
			]
			val third = compiledClass.getDeclaredConstructor().newInstance
			compiledClass.getDeclaredField("i") => [
				accessible = true
				set(third, "Bar")
			]
			
			assertEquals(first, second)
			assertFalse(first.equals(third))
			assertEquals(first.hashCode, second.hashCode)
			assertFalse(first.hashCode == third.hashCode)
		]
	}
	
	@Test
	def void testEqualsWithSuperClass() {
		'''
			import org.eclipse.xtend.lib.annotations.EqualsHashCode
			@EqualsHashCode class Foo {
				int foo = 1
			}
			@EqualsHashCode class Bar extends Foo{
				String bar = "Foo"
			}
		'''.compile[
			val foo = getCompiledClass("Foo")
			val bar = getCompiledClass("Bar")
			
			val first = bar.getDeclaredConstructor().newInstance 
			val second = bar.getDeclaredConstructor().newInstance
			val third = bar.getDeclaredConstructor().newInstance
			bar.getDeclaredField("bar") => [
				accessible = true
				set(third, "Bar")
			]
			val fourth = foo.getDeclaredConstructor().newInstance
			
			assertEquals(first, second)
			assertFalse(first.equals(third))
			assertFalse(first.equals(fourth))
			assertFalse(fourth.equals(first))
		]
	}
	
	@Test def void testSuperClassWithoutEquals() {
		'''
			import org.eclipse.xtend.lib.annotations.EqualsHashCode
			class Foo {
			}
			@EqualsHashCode class Bar extends Foo {
				String bar = "Foo"
			}
		'''.compile[
			assertFalse(getGeneratedCode("Bar"),getGeneratedCode("Bar").contains("super.equals"))
			assertFalse(getGeneratedCode("Bar").contains("super.hashCode"))
		]
	}
	
	@Test
	def void testExistingEquals() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.EqualsHashCode
			@EqualsHashCode class Foo {
				int a = 1
				override equals(Object o) {
					true
				}
			}
		'''
		text.clazz.assertWarning(XAnnotationsPackage.Literals.XANNOTATION,"user.issue", "no effect")
		text.compile [
			val instance = compiledClass.getDeclaredConstructor().newInstance
			assertEquals(instance, "foo")
		]
	}
	
	@Test
	def void testExistingHashCode() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.EqualsHashCode
			@EqualsHashCode class Foo {
				int a = 1
				override hashCode() {
					0
				}
			}
		'''
		text.clazz.assertWarning(XtendPackage.Literals.XTEND_CLASS,"user.issue", "no effect")
		text.compile [
			val instance = compiledClass.getDeclaredConstructor().newInstance
			assertEquals(0, instance.hashCode)
		]
	}
	
	@Test
	def void testGenericClass() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.EqualsHashCode
			@EqualsHashCode class Foo<T> {
				int a = 1
			}
		'''
		text.compile [
			assertTrue(singleGeneratedCode.contains("Foo<?> other = (Foo<?>) obj"))
		]
	}
	
	@Test
	def void testArray() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.EqualsHashCode
			@EqualsHashCode class Foo {
				int[] a = #[1]
			}
		'''
		text.compile [
			val instance = compiledClass.getDeclaredConstructor().newInstance
			val instance2 = compiledClass.getDeclaredConstructor().newInstance
			assertEquals(instance, instance2)
			assertEquals(instance.hashCode, instance2.hashCode)
		]
	}
}