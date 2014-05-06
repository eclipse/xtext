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
import org.junit.Test
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.validation.IssueCodes

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AnonymousClassValidationTest extends AbstractXtendTestCase {

	@Inject extension ParseHelper<XtendFile>
	@Inject extension ValidationTestHelper

	@Test def void test_01() {
		'''
			class C {
				def m() {
					C.this.toString
				}
			}
		'''.parse.assertNoIssues
	}

	@Test def void test_02() {
		'''
			class C {
				def m() {
					C.super.toString
				}
			}
		'''.parse.assertNoIssues
	}
	
	@Test def void test_03() {
		'''
			class C {
				def m() {
					String.this.toString
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type String is accessible in scope")
	}

	@Test def void test_04() {
		'''
			class C {
				def m() {
					String.super.toString
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type String is accessible in scope")
	}
	

	@Test def void test_05() {
		'''
			class C {
				def m() {
					new Object { def void m() { C.this.toString } }
				}
			}
		'''.parse.assertNoIssues
	}

	@Test def void test_06() {
		'''
			class C {
				def m() {
					new Object { def void m() { C.super.toString } }
				}
			}
		'''.parse.assertNoIssues
	}
	
	@Test def void test_07() {
		'''
			class C {
				def m() {
					new Object { def void m() { Object.this.toString } }
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type Object is accessible in scope")
	}

	@Test def void test_08() {
		'''
			class C {
				def m() {
					new Object { def void m() { Object.super.toString } }
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.NO_ENCLOSING_INSTANCE_AVAILABLE, "No enclosing instance of the type Object is accessible in scope")
	}

}
