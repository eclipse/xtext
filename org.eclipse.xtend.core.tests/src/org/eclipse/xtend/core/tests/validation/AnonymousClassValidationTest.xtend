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
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AnonymousClassValidationTest extends AbstractXtendTestCase {

	@Inject extension ParseHelper<XtendFile>
	@Inject extension ValidationTestHelper

	@Test def void testBug447125() {
		'''
			class C {
				def m() {
					var String s = ''
					new D(s) {}
				}
			}
			class D {
				new(String s) {}
			}
		'''.parse.assertNoIssues
	}

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
	
	@Test def void test_09() {'''
			class C {
				def m() {
					var x = ''
					val f = new Runnable() {
						override run() { x.toString }
					}
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, "Cannot refer to the non-final variable x inside a local class")
	}
	
	@Test def void test_10() {'''
			class C {
				def m() {
					val x = ''
					new Runnable() {
						override run() { x.toString }
					}
				}
			}
		'''.parse.assertNoIssues()
	}
	
	@Test def void testBug436248_01() {
		'''
			class Bar {
				public val r = new Runnable() {
					override run() {
						println(x)
					}
				}
				public val x = 1
			}
		'''.parse.assertNoIssues
	}
	
	@Test def void testInvalidSuper() {
		'''
			class Bar {
				public val r = new Runnable() {
					override run() {
						[| super.toString ].apply
					}
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_SUPER_CALL, 'Cannot call super of an anonymous class from a lambda expression')
	}
	
	@Test
	def void testExtensions_01() {
		'''
			class Test {
				def getRunnable() {
					var extension Util u = null
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
				static class Util {
					def sayHello() {
						'Hello'
					}
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, "Cannot implicitly refer to the non-final variable u inside a local class")
	}
	
	@Test
	def void testExtensions_02() {
		'''
			class Test {
				extension Util = null
				def getRunnable() {
					var String it = null
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
				static class Util {
					def void sayHello(String s) {}
				}
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, "Cannot implicitly refer to the non-final variable it inside a local class")
	}
	
	@Test
	def void testExtensions_03() {
		'''
			import static extension Util.*
			class Test {
				def getRunnable() {
					var String it = null
					new Runnable {
						override run() {
							sayHello
						}
					}
				}
			}
			class Util {
				static def void sayHello(String s) {}
			}
		'''.parse.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_MUTABLE_VARIABLE_ACCESS, "Cannot implicitly refer to the non-final variable it inside a local class")
	}
}
