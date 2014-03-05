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
 * @author Anton Kosyakov - Initial contribution and API
 */
class PostfixOperatorValidationTest extends AbstractXtendTestCase {

	@Inject extension ParseHelper<XtendFile>
	@Inject extension ValidationTestHelper

	@Test def void test_1() {
		'''
			class Foo {
				
				def foo() {
					var i = 2
					i++
				}
				
			}
		'''.parse.assertNoIssues
	}

	@Test def void test_2() {
		'''
			class Foo {
				
				def foo() {
					val i = 2
					i++
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL)
	}

	@Test def void test_3() {
		'''
			class Foo {
				
				def foo(int i) {
					i++
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL)
	}

	@Test def void test_4() {
		'''
			class Foo {
				
				val i = 1
				
				def foo() {
					i++
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL)
	}

	@Test def void test_5() {
		'''
			class Foo {
				
				val i = 1
				
				new() {
					i++
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL)
	}

	@Test def void test_6() {
		'''
			class Foo {
				
				var i = 1
				
				new() {
					i++
				}
				
			}
		'''.parse.assertNoErrors
	}

	@Test def void test_7() {
		'''
			class Foo {
				
				new() {
					(1 + 2)++
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.ASSIGNMENT_TO_NO_VARIABLE)
	}

	@Test def void test_8() {
		'''
			class Foo {
				
				new() {
					foo()++
				}
				
				def int foo() {
					0
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.ASSIGNMENT_TO_NO_VARIABLE)
	}

}
