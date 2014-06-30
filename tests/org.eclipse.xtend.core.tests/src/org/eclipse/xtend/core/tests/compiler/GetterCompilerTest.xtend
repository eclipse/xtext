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
import org.junit.Test
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage
import org.eclipse.xtend.core.xtend.XtendPackage

class GetterCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper

	@Test
	def void testCreateSingleGetter() {
		'''
			import org.eclipse.xtend.lib.annotations.Getter
			class Foo {
				@Getter int foo = 1
			}
		'''.compile[
			val instance = compiledClass.newInstance
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(1, getFoo.invoke(instance))
		]
	}

	@Test
	def void testCreateGenericGetter() {
		'''
			import org.eclipse.xtend.lib.annotations.Getter
			class Foo<T> {
				@Getter T foo = null
			}
		'''.compile[
			assertTrue(singleGeneratedCode.contains("T getFoo"))
			val instance = compiledClass.newInstance
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(null, getFoo.invoke(instance))
		]
	}
	@Test
	def void testCreateStaticGetter() {
		'''
			import org.eclipse.xtend.lib.annotations.Getter
			class Foo {
				@Getter static int foo = 1
			}
		'''.compile[
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(1, getFoo.invoke(null))
		]
	}

	@Test
	def void testCreateAllGetters() {
		'''
			import org.eclipse.xtend.lib.annotations.Getter
			@Getter class Foo {
				static String ignoreMe
				def create {} ignoreMe2() {}
				int foo = 1
				String bar = "bar"
				
				def getFoo() {
					2
				}
			}
		'''.compile[
			assertFalse(compiledClass.declaredMethods.exists[name == "getIgnoreMe"])
			val instance = compiledClass.newInstance
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			val getBar = compiledClass.getDeclaredMethod("getBar")
			assertEquals(2, getFoo.invoke(instance))
			assertEquals("bar", getBar.invoke(instance))
		]
	}

	@Test
	def void testExistingGetter() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.Getter
			class Foo {
				@Getter int foo = 1
				def getFoo() {
					2
				}
			}
		'''
		text.clazz.assertWarning(XAnnotationsPackage.Literals.XANNOTATION, "user.issue", "no effect")
		text.compile[
			val instance = compiledClass.newInstance
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(2, getFoo.invoke(instance))
		]
	}
	
	@Test
	def void testCannotOverrideFinalGetter() {
		file('''
			import org.eclipse.xtend.lib.annotations.Getter
			class Fizz {
				def final String getFoo() {"foo"}
			}
			
			class Buzz extends Fizz {
				@Getter String foo
			}
		''').assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "final","Fizz", "getFoo")
	}
	
	@Test
	def void testCannotOverrideWithConflictingReturnType() {
		file('''
			import org.eclipse.xtend.lib.annotations.Getter
			class Foo {
				def String getFoo() {"foo"}
			}
			
			class Bar extends Foo {
				@Getter int foo
			}
		''').assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "incompatible","Foo", "getFoo")
	}
	
	@Test
	def void testCanSpecializeReturnType() {
		file('''
			import org.eclipse.xtend.lib.annotations.Getter
			class Foo {
				def CharSequence getFoo() {"foo"}
			}
			
			class Bar extends Foo {
				@Getter String foo
			}
		''').assertNoErrors
	}
}