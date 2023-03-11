/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*
import static org.eclipse.xtext.xbase.validation.IssueCodes.*

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
class ValidationBug378818Test extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper helper
	
	@Test def void testAbstractMethodInvocation_01() {
		file('''
			abstract class AbstractTest {
				abstract def void foo()
			}
			class Test extends AbstractTest {
				override foo() {
					super.foo
				}
			}
		''').assertError(XMEMBER_FEATURE_CALL, ABSTRACT_METHOD_INVOCATION,
			"Cannot directly invoke the abstract method foo() of the type AbstractTest")
	}
	
	@Test def void testAbstractMethodInvocation_02() {
		file('''
			abstract class AbstractTest {
				abstract def void foo()
			}
			class Test extends AbstractTest {
				override foo() {
					Test.super.foo
				}
			}
		''').assertError(XMEMBER_FEATURE_CALL, ABSTRACT_METHOD_INVOCATION,
			"Cannot directly invoke the abstract method foo() of the type AbstractTest")
	}
	
}