/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.junit.Ignore
import org.junit.Test

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class LambdaValidationTest extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper
	
	@Test 
	def void testIncompatibleParameterType_01() {
		file('''
			class C {
				val I<Integer> f = [String k| 1]
			}
			interface I<T> {
				def T m(int u);
			}
		''').assertError(XCLOSURE, INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (String)=>int to I<Integer>")
	}
	
	@Test 
	def void testIncompatibleParameterType_02() {
		file('''
			class C {
				val I<Integer> f = [String k| 1]
			}
			interface I<T> {
				def T m(T u);
			}
		''').assertError(XNUMBER_LITERAL, INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from int to String")
	}
	
	@Test
	def void testIncompatibleReturnType_01() {
		file('''
			class C {
				val I<Integer> f = [int k| '']
			}
			interface I<T> {
				def T m(int u);
			}
		''').assertError(XCLOSURE, INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (int)=>String to I<Integer>")
	}
	
	@Test
	def void testIncompatibleReturnType_02() {
		file('''
			class C {
				val I<Integer> f = [int k| return '']
			}
			interface I<T> {
				def T m(int u);
			}
		''').assertError(XCLOSURE, INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (int)=>String to I<Integer>")
	}
	
	@Test 
	def void testIncompatibleReturnType_03() {
		file('''
			class C {
				val I<Integer> f = [int k| '']
			}
			interface I<T> {
				def T m(T u);
			}
		''').assertError(XSTRING_LITERAL, INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from String to Integer")
	}
	
	@Test 
	def void testIncompatibleReturnType_04() {
		file('''
			class C {
				val I<Integer> f = [k| '']
			}
			interface I<T> {
				def T m(int u);
			}
		''').assertError(XSTRING_LITERAL, INCOMPATIBLE_TYPES, "Type mismatch: cannot convert from (int)=>String to I<Integer>")
	}
	
	@Ignore("TODO")
	@Test
	def void testIncompatibleBounds_01() {
		file('''
			class C {
				val I<Integer> f = [String k| return 1]
			}
			interface I<T extends Number> {
				def <U extends Number> T m(U u);
			}
		''').assertError(XCLOSURE, INCOMPATIBLE_TYPES, "zonk")
	}

}