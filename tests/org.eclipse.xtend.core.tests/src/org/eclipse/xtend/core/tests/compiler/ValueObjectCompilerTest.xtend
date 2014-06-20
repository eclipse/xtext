/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test
import org.junit.Ignore

class ValueObjectCompilerTest extends AbstractXtendCompilerTest {
	
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testExistingValueObjectConstructor() {
		'''
			@ValueObject class Foo {
				int foo
				new (int foo) {
					this.foo = foo * 2
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(4, getFoo.invoke(instance))
		]
	}
	
	@Test
	def void testInitializedField() {
		'''
			@ValueObject class Foo {
				int foo = 2
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor.newInstance
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(2, getFoo.invoke(instance))
		]
	}
	
	@Test
	def void testIgnoredFields() {
		'''
			@ValueObject class Foo {
				transient int foo
				def create {} ignoreMe() {}
			}
		'''.compile[
			compiledClass.getDeclaredConstructor
			assertFalse(compiledClass.declaredMethods.exists[name.startsWith("get")])
		]
	}
	
	@Test
	def void testExistingGetter() {
		'''
			@ValueObject class Foo {
				int foo
				def getFoo() {
					5
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(5, getFoo.invoke(instance))
		]
	}
	
	@Test
	def void testExistingToString() {
		'''
			@ValueObject class Foo {
				int foo
				override toString() {
					"5"
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val toString = compiledClass.getDeclaredMethod("toString")
			assertEquals("5", toString.invoke(instance))
		]
	}
	
	@Test
	def void testExistingEquals() {
		'''
			@ValueObject class Foo {
				int foo
				override equals(Object o) {
					true
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val equals = compiledClass.getDeclaredMethod("equals", Object)
			assertEquals(true, equals.invoke(instance, 1))
		]
	}
	
	@Test
	def void testExistingHashCode() {
		'''
			@ValueObject class Foo {
				int foo
				override hashCode() {
					0
				}
			}
		'''.compile[
			val instance = compiledClass.getDeclaredConstructor(int).newInstance(2)
			val hashCode = compiledClass.getDeclaredMethod("hashCode")
			assertEquals(0, hashCode.invoke(instance))
		]
	}
	
	@Test
	def void testExistingMethodsNotMatchingExactly() {
		'''
			@ValueObject class Foo {
				int foo
				
				new(String bar) {
					foo = 1
				}
				
				def getFoo(String bar) {
					1
				}
				
				def toString(String bar) {
					"1"
				}
				
				def hashCode(String bar) {
					1
				}
				
				def equals(String bar) {
					true
				}
				
				def equals(Object foo, String bar) {
					true
				}
			}
		'''.compile[
			compiledClass=>[
				getDeclaredConstructor(int)
				getDeclaredMethod("equals", Object)
				getDeclaredMethod("hashCode")
				getDeclaredMethod("toString")
				getDeclaredMethod("getFoo")
			]
		]
	}
	
	
	
	@Ignore
	@Test
	def void testWithCreateExtension() {
		val text = '''
			@ValueObject class Foo {
				def create {} foo() {
				}
			}
		'''
		clazz(text).assertNoIssues
		text.compile[
			assertFalse(compiledClass.declaredMethods.exists[name.startsWith("get")])
		]
	}
	
	@Test def testInheritanceForbidden() {
		clazz('''
			import java.util.ArrayList
			
			@ValueObject class Foo extends ArrayList{
				String foo
			}
		''').assertError(XtendPackage.Literals.XTEND_CLASS, "user.issue", "inheritance")
	}
	
	@Test
	def testValueObjectWithStaticField() {
		'''
			@ValueObject class Foo {
				static int foo = 1
			}
		'''.compile[
			compiledClass => [
				assertTrue(declaredFields.exists[name == "foo"])
				assertFalse(declaredMethods.exists[name == "getFoo"])
				assertTrue(declaredConstructors.exists[parameterTypes.length == 0])
			]
		]
	}
	
	@Test
	def testBooleanProperties() {
		'''
			@ValueObject class Foo {
				boolean foo
				Boolean bar
			}
		'''.compile[
			compiledClass => [
				assertTrue(declaredFields.exists[name == "foo"])
				assertTrue(declaredFields.exists[name == "bar"])
				assertTrue(declaredMethods.exists[name == "isFoo"])
				assertTrue(declaredMethods.exists[name == "isBar"])
			]
		]
	}
}