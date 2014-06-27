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

class SetterCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper

	@Test
	def void testCreateSingleSetter() {
		'''
			class Foo {
				@Setter int foo
			}
		'''.compile[
			val instance = compiledClass.newInstance
			val setFoo = compiledClass.getDeclaredMethod("setFoo", int)
			val fooField = compiledClass.getDeclaredField("foo") => [
				accessible = true
			]
			setFoo.invoke(instance, 1)
			assertEquals(1, fooField.get(instance))
		]
	}

	@Test
	def void testCreateGenericSingleSetter() {
		'''
			class Foo<T extends CharSequence> {
				@Setter T foo
			}
		'''.compile[
			assertTrue(singleGeneratedCode.contains("setFoo(final T foo)"))
			val instance = compiledClass.newInstance
			val setFoo = compiledClass.getDeclaredMethod("setFoo", CharSequence)
			val fooField = compiledClass.getDeclaredField("foo") => [
				accessible = true
			]
			setFoo.invoke(instance, "bar")
			assertEquals("bar", fooField.get(instance))
		]
	}
	
	@Test
	def void testCreateStaticSetter() {
		'''
			class Foo {
				@Setter static int foo
			}
		'''.compile[
			val setFoo = compiledClass.getDeclaredMethod("setFoo", int)
			val fooField = compiledClass.getDeclaredField("foo") => [
				accessible = true
			]
			setFoo.invoke(null, 1)
			assertEquals(1, fooField.get(null))
		]
	}

	@Test
	def void testCreateAllSetters() {
		'''
			@Setter class Foo {
				static String ignoreMe
				def create {} ignoreMe2() {}
				int foo
				String bar
				
				def setFoo(int foo) {
					this.foo = 2
				}
			}
		'''.compile[
			assertFalse(compiledClass.declaredMethods.exists[name == "setIgnoreMe"])
			val instance = compiledClass.newInstance
			val setFoo = compiledClass.getDeclaredMethod("setFoo", int)
			val fooField = compiledClass.getDeclaredField("foo") => [accessible = true]
			val setBar = compiledClass.getDeclaredMethod("setBar", String)
			val barField = compiledClass.getDeclaredField("bar") => [accessible = true]
			setFoo.invoke(instance, 1)
			setBar.invoke(instance, "bar")
			assertEquals(2, fooField.get(instance))
			assertEquals("bar", barField.get(instance))
		]
	}

	@Test
	def void testExistingSetter() {
		val text = '''
			class Foo {
				@Setter int foo
				def setFoo(int foo) {
					this.foo = 2
				}
			}
		'''
		text.clazz.assertWarning(XAnnotationsPackage.Literals.XANNOTATION, "user.issue", "no effect")
		text.compile[
			val instance = compiledClass.newInstance
			val setFoo = compiledClass.getDeclaredMethod("setFoo", int)
			val fooField = compiledClass.getDeclaredField("foo") => [accessible = true]
			setFoo.invoke(instance, 1)
			assertEquals(2, fooField.get(instance))
		]
	}

	@Test
	def void testFinalField() {
		val text = '''
			class Foo {
				@Setter val int foo
			}
		'''
		text.clazz.assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "final")
	}
}