/*******************************************************************************
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
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
class NestedClassValidationTest extends AbstractXtendTestCase {

	@Inject extension ParseHelper<XtendFile>
	@Inject extension ValidationTestHelper
	
	@Test def void test_01() {
		'''
			class C {
				static class D {
					def m() {
						D.this.toString
					}
				}
			}
		'''.parse.assertNoIssues
	}

	@Test def void test_02() {
		'''
			class C {
				static class D {
					def m() {
						D.super.toString
					}
				}
			}
		'''.parse.assertNoIssues
	}
	
	@Test def void test_03() {
		'''
			class C {
				static class D {
					def m() {
						C.this.toString
					}
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type C is accessible in scope")
	}
	
	@Test def void test_04() {
		'''
			class C {
				static class D {
					def m() {
						C.super.toString
					}
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type C is accessible in scope")
	}
	
	@Test def void test_05() {
		'''
			interface I {
				class D {
					def m() {
						I.this.toString
					}
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type I is accessible in scope")
	}

	@Test def void test_06() {
		'''
			class C {
				static class D {
					def m(C c) {
						c.m
					}
				}
				private def void m() {}
			}
		'''.parse.assertNoIssues
	}
	
	@Test def void test_07() {
		'''
			class C {
				static class D {
					private new() {}
					def m() {
						new C()
					}
				}
				private new() {
					d = null
				}
				D d = new D
				def somethingWithD() {
					println(d)
				}
			}
		'''.parse.assertNoIssues
	}
	
}
