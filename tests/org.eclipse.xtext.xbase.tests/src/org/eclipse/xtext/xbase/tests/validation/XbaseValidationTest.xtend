/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation

import com.google.inject.Inject
import org.eclipse.xtext.common.types.TypesPackage
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XbaseValidationTest extends AbstractXbaseTestCase {

	@Inject
	extension ValidationTestHelper

	@Test def void testDuplicateCases_int() {
		'''
			switch x : 1 {
				case 1: 1
				case 1: 1
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_int_2() {
		'''
			switch x : 1 {
				case 1: 1
				case 2: 2
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_int_3() {
		'''
			{
				val int a = 1
				val char b = 1 as char
				val byte c = 1 as byte
				val short d = 1 as short
				switch x : 1 {
					case a: 1
					case b: 1
					case c: 1
					case d: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_int_4() {
		'''
			{
				val int a = 1
				val char b = 2 as char
				val byte c = 3 as byte
				val short d = 4 as short
				switch x : 1 {
					case a: 1
					case b: 2
					case c: 3
					case d: 4
				}
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_int_5() {
		'''
			{
				switch x : 1 {
					case 1: 1
					case [|1].apply: 1
				}
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_int_6() {
		'''
			{
				val Integer x = 1
				switch x {
					Integer case 1: 1
					Integer case 1: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_int_7() {
		'''
			{
				val Integer x = 1
				switch x {
					Integer case 1: 1
					case 1: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_int_8() {
		'''
			{
				switch x : 1 {
					case x: ''
					case x: '1'
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_enum() {
		'''
			{
				switch x : Thread.State.NEW {
					case NEW: 1
					case NEW: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_enum_2() {
		'''
			{
				switch x : Thread.State.NEW {
					case NEW: 1
					case Thread.State.NEW: 1
				}
			}
		'''.expression.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_enum_3() {
		'''
			{
				val state = Thread.State.NEW
				switch x : Thread.State.NEW {
					case NEW: 1
					case state: 1
				}
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_enum_4() {
		'''
			{
				switch x : Thread.State.NEW {
					case NEW: 1
					case RUNNABLE: 2
				}
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_double() {
		'''
			switch x : 1d {
				case 1: 1
				case 1: 1
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_double_2() {
		'''
			switch x : 1.5d {
				case 1.5d: 1
				case 1.5d: 1
			}
		'''.expression.assertError(XbasePackage.Literals.XNUMBER_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_double_3() {
		'''
			switch x : 1.5d {
				case 1.5d: 1
				case 1.6d: 1
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_number() {
		'''
			switch x : 1 {
				case 1: 1
				case 1l: 1
				case 1f: 1
				case 1d: 1
			}
		'''.expression.assertNoErrors
	}
	
	@Test def void testDuplicateCases_string() {
		'''
			switch x : 'lalala' {
				case 'A': 1
				case 'A': 1
			}
		'''.expression.assertError(XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.DUPLICATE_CASE)
	}

	@Test def void testDuplicateCases_object() {
		'''
			switch x : new Object {
				case 'A': 1
				case 'A': 1
			}
		'''.expression.assertError(XbasePackage.Literals.XSTRING_LITERAL, IssueCodes.DUPLICATE_CASE)
	}
	
	@Test def void testUnreachableCase() {
		'''
			switch x : new Exception {
				Exception: 1
				java.io.IOException: 2
				java.io.FileNotFoundException: 3
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE)
	}
	
	@Test def void testUnreachableCase_2() {
		'''
			switch x : new Exception {
				java.io.IOException: 2
				Exception: 1
				java.io.FileNotFoundException: 3
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE)
	}
	
	@Test def void testUnreachableCase_3() {
		'''
			switch x : new Exception {
				java.io.IOException: 2
				java.io.FileNotFoundException: 3
				Exception: 1
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CASE)
	}
	
	@Test def void testUnreachableCase_4() {
		'''
			switch x : new Exception {
				java.io.FileNotFoundException: 3
				java.io.IOException: 2
				Exception: 1
			}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableCase_5() {
		'''
			switch x : new Exception {
				Exception case true: 1
				java.io.IOException case false: 2
				java.io.FileNotFoundException: 3
			}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableCatchClause() {
		'''
			try {
				
			} catch (Exception e) {
				
			} catch (java.io.IOException e) {
				
			} catch (java.io.FileNotFoundException e) {
				
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK)
	}
	
	@Test def void testUnreachableCatchClause_2() {
		'''
			try {
				
			} catch (java.io.IOException e) {
				
			} catch (Exception e) {
				
			} catch (java.io.FileNotFoundException e) {
				
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK)
	}
	
	@Test def void testUnreachableCatchClause_3() {
		'''
			try {
				
			} catch (java.io.IOException e) {

			} catch (java.io.FileNotFoundException e) {
				
			} catch (Exception e) {
				
			}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_CATCH_BLOCK)
	}
	
	@Test def void testUnreachableCatchClause_4() {
		'''
			try {
				
			} catch (java.io.FileNotFoundException e) {
				
			} catch (java.io.IOException e) {

			} catch (Exception e) {
				
			}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf() {
		'''
		{
			val x = new Object
			if (x instanceof Exception) {
				1
			} else if (x instanceof java.io.IOException) {
				2
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			}
		}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK)
	}
	
	@Test def void testUnreachableInstanceOf_2() {
		'''
		{
			val x = new Object
			if (x instanceof java.io.IOException) {
				2
			} else if (x instanceof Exception) {
				1
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			}
		}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK)
	}
	
	@Test def void testUnreachableInstanceOf_3() {
		'''
		{
			val x = new Object
			if (x instanceof java.io.IOException) {
				2
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			} else if (x instanceof Exception) {
				1
			}
		}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK)
	}
	
	@Test def void testUnreachableInstanceOf_4() {
		'''
		{
			val x = new Object
			if (x instanceof java.io.FileNotFoundException) {
				3
			} else if (x instanceof java.io.IOException) {
				2
			} else if (x instanceof Exception) {
				1
			}
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf_5() {
		'''
		{
			val x = new Object
			if (x instanceof Exception && true) {
				1
			} else if (x instanceof java.io.IOException && false) {
				2
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			}
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf_6() {
		'''
		{
			val x = new Object
			if (x instanceof java.util.List) {
				1
			} else if (x instanceof int[]) {
				2
			}
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf_7() {
		'''
		{
			val x = new Object
			val y = new Object
			if (x instanceof java.io.IOException) {
				1
			} else if (y instanceof java.io.FileNotFoundException) {
				2
			}
		}
		'''.expression.assertNoErrors
	}
	
	@Test def void testUnreachableInstanceOf_8() {
		'''
		{
			val x = new Object
			val y = new Object
			if (x instanceof java.io.IOException) {
				1
			} else if (y instanceof java.io.IOException) {
				2
			} else if (x instanceof java.io.FileNotFoundException) {
				3
			} else if (y instanceof java.io.FileNotFoundException) {
				4
			}
		}
		'''.expression.assertError(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.UNREACHABLE_IF_BLOCK)
	}
	
	@Test def void testIncompleteCasesOnEnum() {
		'''
		{
			switch x : org.eclipse.xtext.xbase.tests.validation.Color.RED {
				case RED: {
					1
				}
			}
		}
		'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.INCOMPLETE_CASES_ON_ENUM)
	}
	
	@Test def void testIncompleteCasesOnEnum_2() {
		'''
		{
			switch x : org.eclipse.xtext.xbase.tests.validation.Color.RED {
				case RED: {
					1
				}
				case GREEN: {
					1
				}
				case BLUE: {
					1
				}
			}
		}
		'''.expression.assertNoIssues
	}
	
	@Test def void testIncompleteCasesOnEnum_3() {
		'''
		{
			val y = 1
			switch x : org.eclipse.xtext.xbase.tests.validation.Color.RED {
				case RED: {
					1
				}
				case y == 2: {
					2
				}
			}
		}
		'''.expression.assertNoIssues
	}
	
	@Test def void testIncompleteCasesOnEnum_4() {
		'''
		{
			switch x : org.eclipse.xtext.xbase.tests.validation.Color.RED {
				case RED: {
					1
				}
				default: {
					2
				}
			}
		}
		'''.expression.assertNoIssues
	}

}
