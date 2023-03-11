/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test

/**
 * @author Christian Dietrich - Initial contribution and API
 */
class ValidationIssue265Test extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val file = parser.parse('''
			class C {
				def static native String doSomething()
			}
		''')
		file.assertNoIssues
	}
	
	@Test def void test_02() {
		val file = parser.parse('''
			class C {
				def final native String doSomething()
			}
		''')
		file.assertNoIssues
	}
	
	@Test def void test_03() {
		val file = parser.parse('''
			class C {
				def private native String doSomething()
			}
		''')
		file.assertNoErrors
	}
	
	@Test def void test_04() {
		val file = parser.parse('''
			abstract class C {
				def static String doSomething()
			}
		''')
		file.assertError(XtendPackage.Literals.XTEND_FUNCTION, org.eclipse.xtend.core.validation.IssueCodes.INVALID_MODIFIER)
	}
	
	@Test def void test_05() {
		val file = parser.parse('''
			abstract class C {
				def final String doSomething()
			}
		''')
		file.assertError(XtendPackage.Literals.XTEND_FUNCTION, org.eclipse.xtend.core.validation.IssueCodes.INVALID_MODIFIER)
	}
	
	@Test def void test_06() {
		val file = parser.parse('''
			abstract class C {
				def private String doSomething()
			}
		''')
		file.assertError(XtendPackage.Literals.XTEND_FUNCTION, org.eclipse.xtend.core.validation.IssueCodes.INVALID_MODIFIER)
	}
	
}