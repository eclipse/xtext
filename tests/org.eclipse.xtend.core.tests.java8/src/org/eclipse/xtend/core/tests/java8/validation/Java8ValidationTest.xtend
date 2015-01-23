/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.java8.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.tests.java8.Java8RuntimeInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Test

import static org.eclipse.xtend.core.validation.IssueCodes.*
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@InjectWith(Java8RuntimeInjectorProvider)
class Java8ValidationTest extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper
	
	@Test
	def void testInheritedDefaultMethod() {
		file('''
			interface A {
				def void foo() { }
			}
			class C implements A {
				def bar() { foo }
			}
		''').assertNoErrors
	}
	
	@Test
	def void testConflictingDefaultMethods01() {
		file('''
			interface A {
				def void foo() { }
			}
			interface B {
				def void foo() { }
			}
			class C implements A, B { }
		''').assertError(XTEND_CLASS, CONFLICTING_DEFAULT_METHODS,
			"The type C inherits the conflicting non-abstract methods foo() from A and foo() from B.")
	}
	
	@Test
	def void testConflictingDefaultMethods02() {
		file('''
			interface A {
				def void foo() { }
			}
			interface B {
				def void foo() { }
			}
			interface C extends A, B  { }
		''').assertError(XTEND_INTERFACE, CONFLICTING_DEFAULT_METHODS,
			"The type C inherits the conflicting non-abstract methods foo() from A and foo() from B.")
	}
	
	@Test
	def void testConflictingDefaultMethods03() {
		file('''
			interface A {
				def void foo() { }
			}
			interface B {
				def void foo()
			}
			class C implements A, B { }
		''').assertError(XTEND_CLASS, CONFLICTING_DEFAULT_METHODS,
			"The non-abstract method foo() inherited from A conflicts with the method foo() inherited from B.")
	}
	
	@Test
	def void testConflictingDefaultMethods04() {
		file('''
			interface A {
				def void foo() { }
			}
			interface B {
				def void foo()
			}
			interface C extends A, B  { }
		''').assertError(XTEND_INTERFACE, CONFLICTING_DEFAULT_METHODS,
			"The non-abstract method foo() inherited from A conflicts with the method foo() inherited from B.")
	}
	
	@Test
	def void testConflictingDefaultMethods05() {
		file('''
			interface A {
				def int foo(java.util.List<String> list) { 0 }
			}
			interface B {
				def double foo(java.util.List<Class<?>> list) { 0 }
			}
			class C implements A, B { }
		''').assertError(XTEND_CLASS, CONFLICTING_DEFAULT_METHODS,
			"The type C inherits the conflicting non-abstract methods foo(List<String>) from A and foo(List<Class<?>>) from B.")
	}
	
	@Test
	def void testConflictingDefaultMethods06() {
		file('''
			interface A {
				def int foo(java.util.List<String> list) { 0 }
			}
			interface B {
				def double foo(java.util.List<Class<?>> list) { 0 }
			}
			interface C extends A, B  { }
		''').assertError(XTEND_INTERFACE, CONFLICTING_DEFAULT_METHODS,
			"The type C inherits the conflicting non-abstract methods foo(List<String>) from A and foo(List<Class<?>>) from B.")
	}
	
}