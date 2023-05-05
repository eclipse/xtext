/*******************************************************************************
 * Copyright (c) 2018, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation

import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.core.tests.AbstractXtendTestCase
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test

import static org.eclipse.xtend.core.validation.IssueCodes.INVALID_RETURN_TYPE_IN_CASE_OF_JUNIT_ANNOTATION
import static org.eclipse.xtend.core.xtend.XtendPackage.Literals.*
import static org.eclipse.xtext.diagnostics.Diagnostic.LINKING_DIAGNOSTIC
import static org.eclipse.xtext.xbase.XbasePackage.Literals.*
import com.google.inject.Inject

class JUnitMethodReturnTypeValidationTest extends AbstractXtendTestCase {

	@Inject extension ValidationTestHelper
	@Inject extension ParseHelper<XtendFile>

	@Test def test001() {
		'''
			class Foo {
				
				def test() {
					1
				}
			}
		'''.hasNoValidationIssue
	}

	@Test def test002() {
		'''
			class Foo {
				
				def int test() {
					1
				}
			}
		'''.hasNoValidationIssue
	}

	@Test def test003() {
		'''
			import org.junit.Test
			
			class Foo {
				
				@Test def void test() {}
			}
		'''.hasNoValidationIssue
	}

	@Test def test004() {
		'''
			import org.junit.Test
			
			class Foo {
				
				@Test def test() {
					return
				}
			}
		'''.hasNoValidationIssue
	}
	
	@Test def test005() {
		'''
			import org.junit.Before
			
			class Foo {
				
				@Before def void before() {}
			}
		'''.hasNoValidationIssue
	}

	@Test def test006() {
		'''
			import org.junit.Before
			
			class Foo {
				
				@Before def before() {
					return
				}
			}
		'''.hasNoValidationIssue
	}
	
	@Test def test007() {
		'''
			import org.junit.After
			
			class Foo {
				
				@After def void after() {}
			}
		'''.hasNoValidationIssue
	}

	@Test def test008() {
		'''
			import org.junit.After
			
			class Foo {
				
				@After def after() {
					return
				}
			}
		'''.hasNoValidationIssue
	}
	
	@Test def test009() {
		'''
			import org.junit.BeforeClass
			
			class Foo {
				
				@BeforeClass def static void beforeClass() {}
			}
		'''.hasNoValidationIssue
	}

	@Test def test010() {
		'''
			import org.junit.BeforeClass
			
			class Foo {
				
				@BeforeClass def static beforeClass() {
					return
				}
			}
		'''.hasNoValidationIssue
	}
	
	@Test def test011() {
		'''
			import org.junit.AfterClass
			
			class Foo {
				
				@AfterClass def static void afterClass() {}
			}
		'''.hasNoValidationIssue
	}

	@Test def test012() {
		'''
			import org.junit.AfterClass
			
			class Foo {
				
				@AfterClass def static afterClass() {
					return
				}
			}
		'''.hasNoValidationIssue
	}

	@Test def test013() {
		'''
			import org.junit.Test
			
			class Foo {
				
				@Test def int test() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method test() must be void but is int.")
	}

	@Test def test014() {
		'''
			import org.junit.Test
			
			class Foo {
				
				@Test def m() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method m() must be void but is int.")
	}

	@Test def test015() {
		'''
			import org.junit.Test
			
			class Foo {
				
				@Test def Object test() {
					"foo"
				}
			}
		'''.hasOneValidationIssue("JUnit method test() must be void but is Object.")
	}

	@Test def test016() {
		'''
			import org.junit.Test
			
			class Foo {
				
				@Test def test() {
					
				}
			}
		'''.hasOneValidationIssue("JUnit method test() must be void but is Object.")
	}
	
	@Test def test017() {
		'''
			import org.junit.Before
			
			class Foo {
				
				@Before def int before() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method before() must be void but is int.")
	}

	@Test def test018() {
		'''
			import org.junit.Before
			
			class Foo {
				
				@Before def before() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method before() must be void but is int.")
	}

	@Test def test019() {
		'''
			import org.junit.Before
			
			class Foo {
				
				@Before def Object before() {
					"foo"
				}
			}
		'''.hasOneValidationIssue("JUnit method before() must be void but is Object.")
	}

	@Test def test020() {
		'''
			import org.junit.Before
			
			class Foo {
				
				@Before def before() {
					
				}
			}
		'''.hasOneValidationIssue("JUnit method before() must be void but is Object.")
	}

	@Test def test021() {
		'''
			import org.junit.After
			
			class Foo {
				
				@After def int after() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method after() must be void but is int.")
	}

	@Test def test022() {
		'''
			import org.junit.After
			
			class Foo {
				
				@After def after() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method after() must be void but is int.")
	}

	@Test def test023() {
		'''
			import org.junit.After
			
			class Foo {
				
				@After def Object after() {
					"foo"
				}
			}
		'''.hasOneValidationIssue("JUnit method after() must be void but is Object.")
	}

	@Test def test024() {
		'''
			import org.junit.After
			
			class Foo {
				
				@After def after() {
					
				}
			}
		'''.hasOneValidationIssue("JUnit method after() must be void but is Object.")
	}

	@Test def test025() {
		'''
			import org.junit.BeforeClass
			
			class Foo {
				
				@BeforeClass def static int beforeClass() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method beforeClass() must be void but is int.")
	}

	@Test def test026() {
		'''
			import org.junit.BeforeClass
			
			class Foo {
				
				@BeforeClass def static beforeClass() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method beforeClass() must be void but is int.")
	}

	@Test def test027() {
		'''
			import org.junit.BeforeClass
			
			class Foo {
				
				@BeforeClass def static Object beforeClass() {
					"foo"
				}
			}
		'''.hasOneValidationIssue("JUnit method beforeClass() must be void but is Object.")
	}

	@Test def test028() {
		'''
			import org.junit.BeforeClass
			
			class Foo {
				
				@BeforeClass def static beforeClass() {
					
				}
			}
		'''.hasOneValidationIssue("JUnit method beforeClass() must be void but is Object.")
	}

	@Test def test029() {
		'''
			import org.junit.AfterClass
			
			class Foo {
				
				@AfterClass def static int afterClass() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method afterClass() must be void but is int.")
	}

	@Test def test030() {
		'''
			import org.junit.AfterClass
			
			class Foo {
				
				@AfterClass def static afterClass() {
					1
				}
			}
		'''.hasOneValidationIssue("JUnit method afterClass() must be void but is int.")
	}

	@Test def test031() {
		'''
			import org.junit.AfterClass
			
			class Foo {
				
				@AfterClass def static Object afterClass() {
					"foo"
				}
			}
		'''.hasOneValidationIssue("JUnit method afterClass() must be void but is Object.")
	}

	@Test def test032() {
		'''
			import org.junit.AfterClass
			
			class Foo {
				
				@AfterClass def static afterClass() {
					
				}
			}
		'''.hasOneValidationIssue("JUnit method afterClass() must be void but is Object.")
	}
	
	@Test def test033() {
		/**
		 * Ensure that the 'JUnit Method Return Type Validation Check'
		 * does not report a follow up issue of an unknown return type.
		 */
		'''
			import org.junit.Test
			
			class Foo {
				
				@Test def test() {
					foo
				}
			}
		'''.hasOneValidationIssue(XFEATURE_CALL, LINKING_DIAGNOSTIC, "The method or field foo is undefined")
	}

	private def void hasNoValidationIssue(CharSequence it) {
		assertNumberOfValidationIssues(0)
	}

	private def hasOneValidationIssue(CharSequence it, String message) {
		it.hasOneValidationIssue(XTEND_FUNCTION, INVALID_RETURN_TYPE_IN_CASE_OF_JUNIT_ANNOTATION, message)
	}

	private def hasOneValidationIssue(CharSequence it, EClass objectType, String issueCode, String message) {
		assertNumberOfValidationIssues(1).
		assertError(objectType, issueCode, message)
	}

	private def assertNumberOfValidationIssues(CharSequence it, int expectedNumberOfIssues) {
		val xtendFile = parse
		expectedNumberOfIssues.assertEquals(xtendFile.validate.size)
		xtendFile
	}
}