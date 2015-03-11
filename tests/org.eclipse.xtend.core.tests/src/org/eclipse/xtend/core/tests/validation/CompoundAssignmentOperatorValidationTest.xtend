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
class CompoundAssignmentOperatorValidationTest extends AbstractXtendTestCase {

	@Inject extension ParseHelper<XtendFile>
	@Inject extension ValidationTestHelper

	@Test def void test_1() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				def foo() {
					var i = 2
					i += i *= 2
				}
				
			}
		'''.parse.assertNoIssues
	}

	@Test def void test_2() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				def foo() {
					val i = 2
					i *= 2
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL)
	}

	@Test def void test_3() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				def foo(int i) {
					i *= 2
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL)
	}

	@Test def void test_4() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				val i = 1
				
				def foo() {
					i *= 2
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL)
	}

	@Test def void test_5() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				val i = 1
				
				new() {
					i *= 2
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XABSTRACT_FEATURE_CALL, IssueCodes.ASSIGNMENT_TO_FINAL)
	}

	@Test def void test_6() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				var i = 1
				
				new() {
					i *= 2
				}
				
			}
		'''.parse.assertNoErrors
	}

	@Test def void test_7() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				new() {
					(1 + 2) *= 2
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XBINARY_OPERATION, IssueCodes.ASSIGNMENT_TO_NO_VARIABLE)
	}

	@Test def void test_8() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				new() {
					foo() *= 2
				}
				
				def int foo() {
					0
				}
				
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.ASSIGNMENT_TO_NO_VARIABLE)
	}

	@Test def void test_9() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				def foo() {
					var foo = new Foo
					foo += new Foo
				}
				
				def operator_plus(Foo other) {
					other
				}
			}
		'''.parse.assertNoErrors
	}

	@Test def void test_10() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				def foo() {
					var foo = new Foo
					foo += new Foo
				}
				
				def operator_plus(Foo one, Foo another) {
					another
				}
			}
		'''.parse.assertNoErrors
	}

	@Test def void test_11() {
		'''
			import static extension compound.IntCompoundExtensions.*
			
			class Foo {
				
				def foo() {
					var foo = new Foo
					foo += 1
				}
				
				def operator_plus(int i) {
					this
				}
			}
		'''.parse.assertNoErrors
	}

}
