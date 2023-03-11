/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class ValidationBug419050Test extends AbstractXtendTestCase {
	
	@Inject ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val file = parser.parse('''
			class C {
				def m(boolean b) { 
				   var boolean y = if (b) return true else return false
				}
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XVARIABLE_DECLARATION, IssueCodes.UNREACHABLE_CODE)
	}
	
	@Test def void test_02() {
		val file = parser.parse('''
			class C {
				def m(boolean b) { 
				   var boolean y = false
				   y = if (b) return true else return false
				}
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.UNREACHABLE_CODE)
	}
	
	@Test def void test_03() {
		val file = parser.parse('''
			class C {
				def m(boolean b) { 
				   var boolean y = false
				   y = return false
				}
			}
		''')
		helper.assertError(file, XbasePackage.Literals.XASSIGNMENT, IssueCodes.UNREACHABLE_CODE)
	}
	
	@Test def void test_04() {
		val file = parser.parse('''
			class C {
				def m(boolean b) { 
				   var boolean y = if (b) return true
				}
			}
		''')
		helper.assertWarning(file, XbasePackage.Literals.XIF_EXPRESSION, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE)
	}
	
	@Test def void test_05() {
		val file = parser.parse('''
			class C {
				def m(boolean b) { 
				   var boolean y = false
				   y = if (b) return true
				}
			}
		''')
		helper.assertWarning(file, XbasePackage.Literals.XIF_EXPRESSION, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE)
	}
	
	@Test
	def testBug417371_01() {
		val file = parser.parse('''
			class C {
				def m(Iterable<String> iter) {
					iter.filter [
						if (length < 2) {
							return true
						} else if (length > 2) {
							return false
						}
					] 
				}
			}
		''')
		helper.assertWarning(file, XbasePackage.Literals.XIF_EXPRESSION, IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE)
	}
	
}