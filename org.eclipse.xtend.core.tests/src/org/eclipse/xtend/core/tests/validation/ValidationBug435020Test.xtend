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
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
class ValidationBug435020Test extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val c = parser.parse('''
			class Foo {
				def void foo() {
					new Object {
						static val x = 1
						def void bar() {
							println(x)
						}
					}
				}
			}
		''')
		c.assertNoIssues
	}
	
	@Test def void test_02() {
		val source = '''
			class Foo {
				def void foo() {
					new Object {
						static var x = 1
					}
				}
			}
		'''
		val c = parser.parse(source)
		c.assertError(XtendPackage.Literals.XTEND_FIELD, IssueCodes.ANONYMOUS_CLASS_STATIC_FIELD,
			source.indexOf("x"), 1,
			"A static field of an anonymous class must be final"
		)
	}
	
	@Test def void test_03() {
		val source = '''
			class Foo {
				def void foo() {
					new Object {
						static val x = Math.max(1, 2)
					}
				}
			}
		'''
		val c = parser.parse(source)
		c.assertError(XtendPackage.Literals.XTEND_FIELD, IssueCodes.ANONYMOUS_CLASS_STATIC_FIELD,
			source.indexOf("Math.max(1, 2)"), "Math.max(1, 2)".length,
			"must be initialized with a constant expression"
		)
	}
	
	@Test def void test_04() {
		val source = '''
			class Foo {
				def void foo() {
					new Object {
						static def bar() {
						}
					}
				}
			}
		'''
		val c = parser.parse(source)
		c.assertError(XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.ANONYMOUS_CLASS_STATIC_METHOD,
			source.indexOf("bar"), "bar".length,
			"A method of an anonymous class cannot be static"
		)
	}
	
}