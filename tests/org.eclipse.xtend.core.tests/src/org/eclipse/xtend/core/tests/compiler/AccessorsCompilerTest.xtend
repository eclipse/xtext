/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.compiler

import com.google.inject.Inject
import java.lang.reflect.Modifier
import org.eclipse.xtend.core.validation.IssueCodes
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test

class AccessorsCompilerTest extends AbstractXtendCompilerTest {
	@Inject
	extension ValidationTestHelper

	@Test
	def void testCreateSingleGetter() {
		'''
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo {
				@Accessors int foo = 1
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
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo<T> {
				@Accessors T foo = null
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
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo {
				@Accessors static int foo = 1
			}
		'''.compile[
			val getFoo = compiledClass.getDeclaredMethod("getFoo")
			assertEquals(1, getFoo.invoke(null))
		]
	}
	
	@Test
	def void testCannotOverrideFinalGetter() {
		file('''
			import org.eclipse.xtend.lib.annotations.Accessors
			class Fizz {
				def final String getFoo() {"foo"}
			}
			
			class Buzz extends Fizz {
				@Accessors String foo
			}
		''').assertError(XtendPackage.Literals.XTEND_FIELD, IssueCodes.OVERRIDDEN_FINAL, "final", "getFoo")
	}
	
	@Test
	def void testCannotOverrideWithConflictingReturnType() {
		file('''
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo {
				def String getFoo() {"foo"}
			}
			
			class Bar extends Foo {
				@Accessors int foo
			}
		''').assertError(XtendPackage.Literals.XTEND_FIELD, org.eclipse.xtext.xbase.validation.IssueCodes.INCOMPATIBLE_RETURN_TYPE, "incompatible", "getFoo")
	}
	
	@Test
	def void testCanSpecializeReturnType() {
		file('''
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo {
				def CharSequence getFoo() {"foo"}
			}
			
			class Bar extends Foo {
				@Accessors String foo
			}
		''').assertNoErrors
	}
	
	@Test
	def void testCreateSingleSetter() {
		'''
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo {
				@Accessors int foo
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
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo<T extends CharSequence> {
				@Accessors T foo
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
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo {
				@Accessors static int foo
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
	def void testCannotOverrideFinalSetter() {
		file('''
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo {
				def final void setFoo(String foo) {}
			}
			
			class Bar extends Foo {
				@Accessors String foo
			}
		''').assertError(XtendPackage.Literals.XTEND_FIELD, IssueCodes.OVERRIDDEN_FINAL, "setFoo(String)", "final")
	}

	@Test
	def void testCannotOverrideSetterWithIncompatibleReturnType() {
		file('''
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo {
				def Object setFoo(String foo) {null}
			}
			
			class Bar extends Foo {
				@Accessors String foo
			}
		''').assertError(XtendPackage.Literals.XTEND_FIELD, org.eclipse.xtext.xbase.validation.IssueCodes.INCOMPATIBLE_RETURN_TYPE, "setFoo(String)", "incompatible")
	}

	@Test
	def void testNoErrorsOnOverloadedSetter() {
		file('''
			import org.eclipse.xtend.lib.annotations.Accessors
			class Foo {
				def Object setFoo(String foo) {null}
			}
			
			class Bar extends Foo {
				@Accessors int foo
			}
		''').assertNoErrors
	}
	
	@Test
	def void testSpecifyingVisiblity() {
		'''
			import org.eclipse.xtend.lib.annotations.Accessors
			import static org.eclipse.xtend.lib.annotations.AccessorType.*
			@Accessors(PROTECTED_GETTER, PROTECTED_SETTER)
			class C {
				int a
				@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) int b
				@Accessors(NONE) int c
			}
		'''.compile[
			compiledClass => [
				assertTrue(Modifier.isProtected(getDeclaredMethod("getA").modifiers))
				assertTrue(Modifier.isProtected(getDeclaredMethod("setA", int).modifiers))
				
				assertTrue(Modifier.isPrivate(getDeclaredMethod("getB").modifiers))
				assertTrue(Modifier.isPublic(getDeclaredMethod("setB", int).modifiers))
				
				assertFalse(declaredMethods.exists[name == "getC"])
				assertFalse(declaredMethods.exists[name == "setC"])
			]
		]
	}
	
	@Test
	def void testSpecifyingVisiblityNoStaticImport() {
		'''
			import org.eclipse.xtend.lib.annotations.Accessors
			@Accessors(PROTECTED_GETTER, PROTECTED_SETTER)
			class C {
				int a
				@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) int b
				@Accessors(NONE) int c
			}
		'''.compile[
			compiledClass => [
				assertTrue(Modifier.isProtected(getDeclaredMethod("getA").modifiers))
				assertTrue(Modifier.isProtected(getDeclaredMethod("setA", int).modifiers))
				
				assertTrue(Modifier.isPrivate(getDeclaredMethod("getB").modifiers))
				assertTrue(Modifier.isPublic(getDeclaredMethod("setB", int).modifiers))
				
				assertFalse(declaredMethods.exists[name == "getC"])
				assertFalse(declaredMethods.exists[name == "setC"])
			]
		]
	}
	
	@Test
	def void testIntegrationWithData() {
		'''
			import org.eclipse.xtend.lib.annotations.Accessors
			import org.eclipse.xtend.lib.annotations.Data
			import static org.eclipse.xtend.lib.annotations.AccessorType.*
			@Accessors(PROTECTED_GETTER, PROTECTED_SETTER)
			@Data
			class C {
				int a
			}
		'''.compile[
			compiledClass => [
				assertTrue(Modifier.isProtected(getDeclaredMethod("getA").modifiers))
				assertFalse(declaredMethods.exists[name == "setA"])
			]
		]
	}
}