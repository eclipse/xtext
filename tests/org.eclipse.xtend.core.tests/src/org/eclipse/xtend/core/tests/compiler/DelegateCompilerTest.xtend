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
import org.eclipse.xtend.core.xtend.XtendPackage

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class DelegateCompilerTest extends AbstractXtendCompilerTest {

	@Inject
	extension ValidationTestHelper

	@Test
	def void testDelegateField() {
		val text = ''' 
			interface A {
				def void m()
			}
			class B implements A {
				override m() {}
			}
			class C implements A{
				@Delegate B delegate
			}
		'''
		text.file.assertNoIssues
		text.compile [
			assertTrue(compiledClass.declaredMethods.exists[name == "m" && parameterTypes.empty && returnType == void])
		]
	}
	@Test
	def void testMethodWithReturnType() {
		val text = ''' 
			interface A {
				def int m()
			}
			class B implements A {
				override m() {1}
			}
			class C implements A{
				@Delegate B delegate
			}
		'''
		text.file.assertNoIssues
		text.compile [
			assertTrue(compiledClass.declaredMethods.exists[name == "m" && parameterTypes.empty && returnType == int])
		]
	}
	@Test
	def void testMethodWithParameters() {
		val text = ''' 
			interface A {
				def void m(String foo, Object bar)
			}
			class B implements A {
				override m(String foo, Object bar) {}
			}
			class C implements A{
				@Delegate B delegate
			}
		'''
		text.file.assertNoIssues
		text.compile [
			assertTrue(compiledClass.declaredMethods.exists[name == "m" && parameterTypes.toList == #[String, Object] && returnType == void])
		]
	}

	@Test
	def testDelegateMethod() {
		val text = ''' 
			interface A {
				def void m()
			}
			class B implements A {
				override m() {}
			}
			class C implements A{
				@Delegate def B delegate() {null}
			}
		'''
		text.file.assertNoIssues
		text.compile [
			assertTrue(compiledClass.declaredMethods.exists[name == "m"])
		]
	}

	@Test
	def testDelegateMethod2() {
		val text = ''' 
			interface A {
				def void m()
			}
			class B implements A {
				override m() {}
			}
			class C implements A{
				@Delegate def B delegate(String name) {null}
			}
		'''
		text.file.assertNoIssues
		text.compile [
			assertTrue(compiledClass.declaredMethods.exists[name == "m"])
		]
	}

	@Test
	def testDelegateMethod3() {
		val text = ''' 
			interface A {
				def void m()
			}
			class B implements A {
				override m() {}
			}
			class C implements A{
				@Delegate def B delegate(String name, Object... args) {null}
			}
		'''
		text.file.assertNoIssues
		text.compile [
			assertTrue(compiledClass.declaredMethods.exists[name == "m"])
		]
	}
	
	@Test
	def testDelegateMethodWithParameters() {
		val text = ''' 
			interface A {
				def void m(String foo)
			}
			class B implements A {
				override m(String foo) {}
			}
			class C implements A{
				@Delegate def B delegate(String name, Object... args) {null}
			}
		'''
		text.file.assertNoIssues
		text.compile [
			assertTrue(compiledClass.declaredMethods.exists[name == "m"])
		]
	}

	@Test
	def testIllegalDelegateSignature() {
		file(
			''' 
				interface A {
					def void m()
				}
				class B implements A {
					override m() {}
				}
				class C implements A{
					@Delegate def B delegate(int i) {null}
				}
			''').assertError(XtendPackage.Literals.XTEND_FUNCTION, "user.issue", "signature")
	}

	@Test
	def void testInterfacesAreImplementedTransitively() {
		file(
			''' 
				interface A {
					def void m()
				}
				interface B extends A{
					def void f()
				}
				class C implements B {
					override m() {}
					override f() {}
				}
				class D implements B{
					@Delegate C delegate
				}
			''').assertNoIssues
	}

	@Test
	def testDuplicateInterfacesAreDetected() {
		file(
			''' 
				interface A {
					def void m()
				}
				interface B extends A {
					def void f()
				}
				interface C extends A {
					def void g()
				}
				class D implements B {
					override m() {}
					override f() {}
				}
				class E implements C {
					override m() {}
					override f() {}
					override g() {}
				}
				class F implements B,C {
					@Delegate D delegate1
					@Delegate E delegate2
				}
			''').assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "interface A", "also implemented")
	}

	@Test
	def testIgnoreNonDelegates() {
		file(
			''' 
				interface A {
					def void m()
				}
				class B implements A {
					override m() {}
				}
				class C implements A {
					override m() {}
				}
				class F implements A {
					@Delegate B delegate
					C notADelegate
				}
			''').assertNoErrors
	}

	@Test
	def testIgnoreInterfacesNotDeclaredOnTargetClass() {
		''' 
			interface A {
				def void m()
			}
			interface B {
				def void f()
			}
			class C implements A, B {
				override m() {}
				override f() {}
			}
			class D implements A {
				@Delegate C delegate
			}
		'''.compile[
			assertFalse(compiledClass.declaredMethods.exists[name == "f"])
		]
	}
	
	@Test
	def testInferredType() {
		file(''' 
			interface A {
				def void m()
			}
			class B implements A {
				override m() {}
			}
			class C implements A{
				@Delegate val delegate = new B
			}
		''').assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred")
	}

	@Test
	def testListedInterfaceNotImplemented() {
		val file = file(''' 
			interface A {
				def void m()
			}
			interface B {
				def void f()
			}
			class C implements A {
				override m() {}
			}
			class D implements A {
				@Delegate(#[A, B]) C delegate
			}
		''')
		file.assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "C", "does not implement", "B")
		file.assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "D", "does not implement", "B")
	}

	@Test
	def testExplicitInterfaceListing() {
		file(
			''' 
				interface A {
					def void m()
				}
				interface B {
					def void f()
				}
				class C implements A, B {
					override m() {}
					override f() {}
				}
				class D implements A, B {
					override m() {}
					override f() {}
				}
				class E implements A, B{
					@Delegate(#[A]) C delegate1
					@Delegate(#[B]) D delegate2
				}
			''').assertNoIssues
	}

	@Test
	def void testNoCommonInterfaces() {
		file(
			''' 
				interface A {
					def void m()
				}
				class B {
				}
				class C implements A{
					@Delegate B delegate
				}
			''').assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "common", "interface")
	}

	@Test
	def testObjectMethodsAreIgnored() {
		''' 
			interface A {
				override int hashCode()
				override boolean equals(Object other)
				override String toString()
			}
			class B implements A {
			}
			class C implements A{
				@Delegate B delegate
			}
		'''.compile [
			/*
			 * the Object methods are always included in #getDeclaredMethods, 
			 * even when they are not actually declared in that class.
			 */
			assertTrue(compiledClass.declaredMethods.forall[declaringClass.simpleName == "A"])
		]
	}

	@Test
	def testObjectMethodsAreIgnored2() {
		''' 
			interface A {
				override Object clone() throws CloneNotSupportedException
				override void finalize() throws Throwable
			}
			class B implements A {
				override clone() throws CloneNotSupportedException {
					super.clone
				}
				override finalize() throws Throwable {
					super.finalize
				}
			}
			class C implements A {
				@Delegate B delegate
			}
		'''.compile [
			assertEquals(
			'''
				import org.eclipse.xtend.lib.Delegate;

				@SuppressWarnings("all")
				public class C implements A {
				  @Delegate
				  private B delegate;
				}
			'''.toString, getGeneratedCode("C"))
		]
	}
}
