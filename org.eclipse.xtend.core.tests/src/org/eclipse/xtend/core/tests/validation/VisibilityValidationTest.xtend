/*******************************************************************************
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
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
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class VisibilityValidationTest extends AbstractXtendTestCase {

	@Inject extension ParseHelper<XtendFile>
	@Inject extension ValidationTestHelper

	@Test def void test_01() {
		'''
			class Foo { protected int foo = 1 }
			class Bar { public val bar = new Foo().foo }
		'''.parse.assertNoIssues
	}
	
	@Test def void test_02() {
		'''
			class Test {
				def assertFooBar() {
					val bar = new Bar
					bar.somePublicMethodInFoo
					bar.someProtectedMethodInBar()
					(bar as Foo).someProtectedMethodInFoo
				}
			}
			class Foo {
				protected def someProtectedMethodInFoo() {}
				def somePublicMethodInFoo() {}
			}
			class Bar extends Foo {
				protected def someProtectedMethodInBar() {}
			}
		'''.parse.assertNoIssues
	}

}
