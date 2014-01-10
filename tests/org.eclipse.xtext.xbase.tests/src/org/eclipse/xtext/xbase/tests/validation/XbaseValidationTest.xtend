/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation

import com.google.inject.Inject
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
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_string() {
		'''
			switch x : 'lalala' {
				case 'A': 1
				case 'A': 1
			}
		'''.expression.assertNoErrors
	}

	@Test def void testDuplicateCases_object() {
		'''
			switch x : new Object {
				case 'A': 1
				case 'A': 1
			}
		'''.expression.assertNoErrors
	}

}
