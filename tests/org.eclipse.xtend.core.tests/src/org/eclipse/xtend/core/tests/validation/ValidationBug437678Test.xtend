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
class ValidationBug437678Test extends AbstractXtendTestCase {
	
	@Inject extension ValidationTestHelper helper
	@Inject ParseHelper<XtendFile> parser
	
	@Test def void test_01() {
		val file = parser.parse('''
			class C {
				static String s
				def static String m() {
					s + m
				}
			}
		''')
		file.assertNoErrors
	}
	
	@Test def void test_02() {
		val file = parser.parse('''
			class C {
				static String s
				def static String m() {
					s + m2
				}
				def String m2() {''}
			}
		''')
		file.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, 'Cannot make a static reference to the non-static method m2 from the type C')
	}
	
	@Test def void test_03() {
		val file = parser.parse('''
			class C {
				String s
				def static String m() {
					s + m
				}
			}
		''')
		file.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, 'Cannot make a static reference to the non-static field s from the type C')
	}
	
	@Test def void test_04() {
		val file = parser.parse('''
			class A {
				def methodA() {
				}
			}
			class C {
				static extension A
				def static void m() {
					methodA
				}
			}
		''')
		file.assertNoErrors
	}
	
	@Test def void test_05() {
		val file = parser.parse('''
			class A {
				def methodA() {
				}
			}
			class C {
				extension A
				def static void m() {
					methodA
				}
			}
		''')
		file.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, 'Cannot make an implicit static reference to the non-static extension methodA')
	}
	
	@Test def void test_06() {
		val file = parser.parse('''
			class A {
				def methodA(C c) {
				}
			}
			class C {
				static extension A
				def static void m() {
					methodA
				}
			}
		''')
		file.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.INVALID_NUMBER_OF_ARGUMENTS, 'Invalid number of arguments. The method methodA(C) is not applicable without arguments')
	}
	
	@Test def void test_07() {
		val file = parser.parse('''
			class A {
				def methodA() {
				}
			}
			class C {
				static extension A
				def void m() {
					methodA
				}
			}
		''')
		file.assertNoErrors
	}
	
	@Test def void test_08() {
		val file = parser.parse('''
			class A {
				def methodA(B b) {
				}
			}
			class B {}
			class C {
				static extension A
				def static void m(B b) {
					b.methodA
				}
			}
		''')
		file.assertNoErrors
	}
	
	@Test def void test_09() {
		val file = parser.parse('''
			class A {
				def methodA(B b) {
				}
			}
			class B {}
			class C {
				extension A
				def static void m(B b) {
					b.methodA
				}
			}
		''')
		file.assertError(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, 'Cannot make an implicit static reference to the non-static extension methodA')
	}
	
	@Test def void test_10() {
		val file = parser.parse('''
			class A {
				def methodA(B b) {
				}
			}
			class B {}
			class C {
				static extension A
				def static void m(B it) {
					methodA
				}
			}
		''')
		file.assertNoErrors
	}
	
	@Test def void test_11() {
		val file = parser.parse('''
			class A {
				def methodA(B b) {
				}
			}
			class B {}
			class C {
				extension A
				def static void m(B it) {
					methodA
				}
			}
		''')
		file.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, 'Cannot make an implicit static reference to the non-static extension methodA')
	}
	
	@Test def void test_12() {
		val file = parser.parse('''
			class C {
				def static void m() {
					m2
				}
				def static void m2(Object o) {}
			}
		''')
		file.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, 'Cannot make an implicit reference to this from a static context')
	}
	
	@Test def void test_13() {
		val file = parser.parse('''
			class C {
				private static val privateField = 1
				private static def privateMethod() { 2 }
				def static m() {
					privateField + privateMethod
				}
			}
		''')
		file.assertNoIssues
	}
	
	@Test def void test_14() {
		val file = parser.parse('''
			class C {
				def static void m(Object it) {
					m2
				}
				def static void m2(Object o) {}
			}
		''')
		file.assertNoIssues
	}
	
	@Test def void test_15() {
		val file = parser.parse('''
			class C {
				def static void m() {
					m2
				}
				def void m2(Object o) {}
			}
		''')
		file.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, 'Cannot make a static reference to the non-static method m2 from the type C')
	}
	
	@Test def void test_16() {
		val file = parser.parse('''
			class C {
				def static void m(Object it) {
					m2
				}
				def void m2(Object o) {}
			}
		''')
		file.assertError(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.STATIC_ACCESS_TO_INSTANCE_MEMBER, 'Cannot make a static reference to the non-static method m2 from the type C')
	}
	
}