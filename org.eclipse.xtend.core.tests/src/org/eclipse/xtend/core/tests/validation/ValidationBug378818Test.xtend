/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import com.google.inject.Inject
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
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