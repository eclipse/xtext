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
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage

class WitherCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper
	
	@Test
	def void testCreateSingleWither() {
		'''
			import org.eclipse.xtend.lib.annotations.Wither
			class Foo {
				static String ignoreMe
				transient String ignoreMe2
				def create {} ignoreMe3() {}
				@Wither String foo
				new(String foo) {
					this.foo = foo
				}
				def getFoo() {
					foo
				}
			}
		'''.compile[
			val first= compiledClass.getDeclaredConstructor(String).newInstance("foo")
			val withFoo = compiledClass.getDeclaredMethod("withFoo", String)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			val second = withFoo.invoke(first, "bar")
			
			assertNotSame(first, second)
			assertEquals("bar", getFoo.invoke(second))
		]
	}
	
	@Test
	def void testCreateAllWithers() {
		'''
			import org.eclipse.xtend.lib.annotations.Wither
			@Wither
			class Foo {
				static String ignoreMe
				transient String ignoreMe2
				String foo
				int x
				new(String foo, int x) {
					this.foo = foo
					this.x = x
				}
				
				def withX(int x) {
					new Foo(foo, 5)
				}
				
				def getFoo() {
					foo
				}
				
				def getX() {
					x
				}
			}
		'''.compile[
			val first= compiledClass.getDeclaredConstructor(String, int).newInstance("foo", 1)
			val withFoo = compiledClass.getDeclaredMethod("withFoo", String)
			val withX = compiledClass.getDeclaredMethod("withX", int)
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			val getX = compiledClass.getDeclaredMethod("getX")
			val second = withX.invoke(withFoo.invoke(first, "bar"), 2)
			
			assertEquals("bar", getFoo.invoke(second))
			assertEquals(5, getX.invoke(second))
		]
	}
	
	@Test
	def void testExstingWither() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.Wither
			class Foo {
				@Wither int x
				
				new(int x) {
					this.x = x
				}
				
				def withX(int x) {
					new Foo(5)
				}
				
				def getX() {
					x
				}
			}
		'''
		text.clazz.assertWarning(XAnnotationsPackage.Literals.XANNOTATION, "user.issue", "no effect")
		text.compile[
			val first= compiledClass.getDeclaredConstructor(int).newInstance(1)
			val withX = compiledClass.getDeclaredMethod("withX", int)
			val getX = compiledClass.getDeclaredMethod("getX")
			val second = withX.invoke(first , 2)
			
			assertEquals(5, getX.invoke(second))
		]
	}
	
	@Test
	def void testExstingMethodNotMatching() {
		'''
			import org.eclipse.xtend.lib.annotations.Wither
			class Foo {
				@Wither String foo
				new(String foo) {
					this.foo = foo
				}
				def withFoo() {
					null
				}
				def withFoo(int x) {
					null
				}
			}
		'''.compile[
			compiledClass.getDeclaredMethod("withFoo", String)
		]
	}
	
	@Test
	def void testGenericClass() {
		'''
			import org.eclipse.xtend.lib.annotations.Wither
			class Foo<T> {
				@Wither T foo
				new(T foo) {
					this.foo = foo
				}
			}
		'''.compile[
			assertTrue(singleGeneratedCode.contains("Foo<T> withFoo(final T foo)"))
		]
	}
	
	@Test
	def void testInferredType() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.Wither
			class Foo {
				@Wither var x = 1
				
				new(int x) {
					this.x = x
				}
			}
		'''
		text.clazz.assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred")
	}
}
