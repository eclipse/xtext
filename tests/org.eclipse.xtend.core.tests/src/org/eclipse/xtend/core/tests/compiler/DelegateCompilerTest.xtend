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
import org.eclipse.xtend.core.validation.IssueCodes

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class DelegateCompilerTest extends AbstractXtendCompilerTest {

	@Inject
	extension ValidationTestHelper

	@Test
	def void testDelegateField() {
		val text = ''' 
			import org.eclipse.xtend.lib.annotations.Delegate
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
			import org.eclipse.xtend.lib.annotations.Delegate
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
			import org.eclipse.xtend.lib.annotations.Delegate
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
			import org.eclipse.xtend.lib.annotations.Delegate
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
	def testDelegateMethodWithParameters() {
		val text = ''' 
			import org.eclipse.xtend.lib.annotations.Delegate
			interface A {
				def void m(String foo)
			}
			class B implements A {
				override m(String foo) {}
			}
			class C implements A{
				@Delegate def B delegate(String name, Class<?>[] argTypes, Object... args) {null}
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
				import org.eclipse.xtend.lib.annotations.Delegate
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
				import org.eclipse.xtend.lib.annotations.Delegate
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
				import org.eclipse.xtend.lib.annotations.Delegate
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
				import org.eclipse.xtend.lib.annotations.Delegate
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
			import org.eclipse.xtend.lib.annotations.Delegate
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
			import org.eclipse.xtend.lib.annotations.Delegate
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
			import org.eclipse.xtend.lib.annotations.Delegate
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
				import org.eclipse.xtend.lib.annotations.Delegate
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
				import org.eclipse.xtend.lib.annotations.Delegate
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
			import org.eclipse.xtend.lib.annotations.Delegate
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
			import org.eclipse.xtend.lib.annotations.Delegate
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
				import org.eclipse.xtend.lib.annotations.Delegate;

				@SuppressWarnings("all")
				public class C implements A {
				  @Delegate
				  private B delegate;
				}
			'''.toString, getGeneratedCode("C"))
		]
	}
	
	@Test
	def testGenericInterface() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.Delegate
			interface I<T, U extends T, E extends Throwable> {
				def <V extends T> T foo(U foo, V bar) throws E
			}
			class B implements I<CharSequence, String, Exception> {
				override <V extends CharSequence> foo(String foo, V bar) throws Exception {foo}
			}
			class C implements I<CharSequence, String, Exception> {
				@Delegate(#[I]) B delegate = new B
			}
		'''
		text.file.assertNoIssues
		text.compile[
			assertTrue(getGeneratedCode("C"), getGeneratedCode("C").contains("<V extends CharSequence> CharSequence foo(final String foo, final V bar) throws Exception"))
			val instance = getCompiledClass("C").newInstance
			val method = getCompiledClass("C").getDeclaredMethod("foo", String, CharSequence)
			assertEquals("bar", method.invoke(instance, "bar", "bar"))
			assertEquals(Exception, method.exceptionTypes.head)
			assertEquals(CharSequence, method.returnType)
			assertEquals(String, method.parameterTypes.head)
			assertEquals(CharSequence, method.parameterTypes.get(1))
		]
	}
	
	@Test
	def testGenericInterfaceAndClass() {
		val text = '''
			import org.eclipse.xtend.lib.annotations.Delegate
			interface I<T> {
				def T foo(T foo)
			}
			class B<X> implements I<X> {
				override X foo(X foo) {foo}
			}
			class C<Y extends CharSequence> implements I<Y> {
				@Delegate B<Y> delegate = new B<Y>
			}
		'''
		text.file.assertNoIssues
		text.compile[
			assertTrue(getGeneratedCode("C").contains("Y foo(final Y foo)"))
			val instance = getCompiledClass("C").newInstance
			val method = getCompiledClass("C").getDeclaredMethod("foo", CharSequence)
			assertEquals("bar", method.invoke(instance, "bar"))
		]
	}
	
	@Test 
	def testGenericSignatureNotMatching() {
		file('''
			import org.eclipse.xtend.lib.annotations.Delegate
			interface I<T> {
				def T foo(T foo)
			}
			class B implements I<Integer> {
				override Integer foo(Integer foo) {1}
			}
			class C implements I<String> {
				@Delegate B delegate
			}
		''').assertError(XtendPackage.Literals.XTEND_FIELD, "user.issue", "no", "common", "interfaces")
	}
	
	@Test 
	def testMethodAlreadyDefined() {
		file('''
			import org.eclipse.xtend.lib.annotations.Delegate
			interface I<T> {
				def T foo(T foo)
			}
			class B implements I<String> {
				override String foo(String foo) {""}
			}
			class C implements I<String> {
				@Delegate B delegate
				override String foo(String foo) {""}
			}
		''').assertWarning(XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNUSED_PRIVATE_MEMBER, "delegate")
	}
}