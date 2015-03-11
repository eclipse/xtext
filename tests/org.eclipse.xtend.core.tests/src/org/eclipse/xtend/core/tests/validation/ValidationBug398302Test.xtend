/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ValidationBug398302Test extends AbstractXtendTestCase {
	
	@Inject ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val String s = '''
			class C {
				def m() {
					String.CASE_INSENSITIVE_ORDER = null
				}
			}
		''';
		val file = parser.parse(s)
		val fieldName = 'CASE_INSENSITIVE_ORDER'
		helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, s.indexOf(fieldName), fieldName.length)
	}
	
	@Test def void test_02() {
		val String s = '''
			class C {
				def m() {
					String::CASE_INSENSITIVE_ORDER = null
				}
			}
		''';
		val file = parser.parse(s)
		val fieldName = 'CASE_INSENSITIVE_ORDER'
		helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, s.indexOf(fieldName), fieldName.length)
	}
	
	
	@Test def void test_03() {
		val String s = '''
			import static java.lang.String.*
			class C {
				def m() {
					CASE_INSENSITIVE_ORDER = null
				}
			}
		''';
		val file = parser.parse(s)
		val fieldName = 'CASE_INSENSITIVE_ORDER'
		helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, s.indexOf(fieldName), fieldName.length)
	}
	
	@Test def void test_04() {
		val String s = '''
			class C {
				val string = ''
				def m() {
					string = null
				}
			}
		''';
		val file = parser.parse(s)
		val assignment = 'string = null'
		helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, s.indexOf(assignment), 6)
	}
	
	@Test def void test_05() {
		val String s = '''
			class C {
				val string = ''
				def m() {
					this.string = null
				}
			}
		''';
		val file = parser.parse(s)
		val assignment = 'string = null'
		helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.ASSIGNMENT_TO_FINAL, s.indexOf(assignment), 6)
	}
}