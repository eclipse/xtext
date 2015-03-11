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
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ValidationBug434409Test extends AbstractXtendTestCase {
	
	@Inject ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val file = parser.parse('''
			class UnreachableCode {
				def m(Object x) {
					val y = if (x == "bar") {
							return "asdf"
						} else {
							return "foo"
						}
				}
			}
		''')
		helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, 'Dead code: The variable y will never be assigned.')
	}
	
	@Test def void test_02() {
		val file = parser.parse('''
			class UnreachableCode {
				def m(Object x) {
					val y = switch (x) {
						String: throw new RuntimeException()
						Integer: return "foo"
						default: return "bar"
					}
				}

			}
		''')
		helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, 'the var')
	}
	
	@Test def void test_03() {
		val file = parser.parse('''
			class UnreachableCode {
				def m(Object x) {
					val y = {
						return "bar"
					}
				}
			}
		''')
		helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, 'the var')
	}
	
	@Test def void test_04() {
		val file = parser.parse('''
			class UnreachableCode {
				def m(Object x) {
					val y = try {
						return "bar"
					} finally {
						// do nothing
					}
				}
			}
		''')
		helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, 'the var')
	}
	
	@Test def void test_05() {
		val file = parser.parse('''
			class UnreachableCode {
				def m(Object x) {
					val y = try {
						// do nothing
					} finally {
						// do nothing
					}
				}
			}
		''')
		helper.assertNoErrors(file)
	}
	
	@Test def void test_06() {
		val file = parser.parse('''
			class UnreachableCode {
				def m(Object x) {
					val Object y = if (x == "bar") {
							return "asdf"
						} else {
							return "foo"
						}
				}
			}
		''')
		helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, 'Dead code: The variable y will never be assigned.')
	}
	
	@Test def void test_07() {
		val file = parser.parse('''
			class UnreachableCode {
				def m(Object x) {
					val y = try {
						// do nothing
						'a'.substring(1)
						return null;
					} catch(Exception e) {
						return null;
					}
				}
			}
		''')
		helper.assertError(file, XtendPackage.Literals.XTEND_VARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE, 'the var')
	}
}