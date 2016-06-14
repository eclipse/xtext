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
import org.eclipse.xtend.core.validation.IssueCodes
import org.eclipse.xtend.core.xtend.XtendFile
import org.eclipse.xtend.core.xtend.XtendPackage
import org.eclipse.xtext.junit4.util.ParseHelper
import org.eclipse.xtext.junit4.validation.ValidationTestHelper
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping
import org.junit.Test

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class OperatorDeclarationTest extends AbstractXtendTestCase {
	
	@Inject extension ParseHelper<XtendFile>
	@Inject extension ValidationTestHelper
	@Inject OperatorMapping operatorMapping
	
	@Test def void testOperatorDeclaration_returnType() {
		val file = '''
			class A {
				«FOR op: operatorMapping.operators»
					def String «op»() { return null }
				«ENDFOR»
			}
		'''.parse
		assertTrue(file.eResource.errors.join('\n'), file.eResource.errors.empty)		
	}
	
	@Test def void testOperatorDeclaration_genericReturnType() {
		val file = '''
			class A {
				«FOR op: operatorMapping.operators»
					def Iterable<String> «op»() { return null }
				«ENDFOR»
			}
		'''.parse
		assertTrue(file.eResource.errors.join('\n'), file.eResource.errors.empty)		
	}
	
	@Test def void testOperatorDeclaration_genericReturnTypeWithFunctionType_01() {
		val file = '''
			class A {
				«FOR op: operatorMapping.operators»
					def Iterable<(String)=>void> «op»() { return null }
				«ENDFOR»
			}
		'''.parse
		assertTrue(file.eResource.errors.join('\n'), file.eResource.errors.empty)		
	}
	
	@Test def void testOperatorDeclaration_genericReturnTypeWithFunctionType_02() {
		val file = '''
			class A {
				«FOR op: operatorMapping.operators»
					def Iterable< =>void> «op»() { return null }
				«ENDFOR»
			}
		'''.parse
		assertTrue(file.eResource.errors.join('\n'), file.eResource.errors.empty)		
	}
	
	@Test def void testOperatorDeclaration_genericReturnTypeWithFunctionType_03() {
		val file = '''
			class A {
				«FOR op: operatorMapping.operators»
					def Iterable<()=>void> «op»() { return null }
				«ENDFOR»
			}
		'''.parse
		assertTrue(file.eResource.errors.join('\n'), file.eResource.errors.empty)		
	}
	
	@Test def void testOperatorDeclaration_typeParam() {
		val file = '''
			class A {
				«FOR op: operatorMapping.operators»
					def <T> «op»() { return null }
				«ENDFOR»
			}
		'''.parse
		assertTrue(file.eResource.errors.join('\n'), file.eResource.errors.empty)		
	}
	
	@Test def void testNotOperatorDeclaration_instance() {
		val file = '''
			class A {
				def String !() {
				}
				// extension
				def String !(Object o) {
				}
			}
		'''.parse
		file.assertNoErrors()		
	}
	
	@Test def void testNotOperatorDeclaration_instance_error() {
		val file = '''
			class A {
				def String !(String first, String second) {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The unary operator '!' allows at most one argument."
		)		
	}
	
	@Test def void testNotOperatorDeclaration_static() {
		val file = '''
			class A {
				def static String !(Object o) {
				}
			}
		'''.parse
		file.assertNoErrors()		
	}
	
	@Test def void testNotOperatorDeclaration_static_error_01() {
		val file = '''
			class A {
				def static String !(String first, String second) {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The static unary operator '!' requires exactly one argument."
		)		
	}
	
	@Test def void testNotOperatorDeclaration_static_error_02() {
		val file = '''
			class A {
				def static String !() {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The static unary operator '!' requires exactly one argument."
		)		
	}
	
	@Test def void testAndOperatorDeclaration_instance() {
		val file = '''
			class A {
				def String &&(Object o) {
				}
				// extension
				def String &&(Object o, Object p) {
				}
			}
		'''.parse
		file.assertNoErrors()		
	}
	
	@Test def void testAndOperatorDeclaration_instance_error_01() {
		val file = '''
			class A {
				def String &&() {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The binary operator '&&' requires at least one argument."
		)		
	}
	
	@Test def void testAndOperatorDeclaration_instance_error_02() {
		val file = '''
			class A {
				def String &&(Object o, Object p, Object q) {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The binary operator '&&' allows at most two arguments."
		)		
	}
	
	@Test def void testAndOperatorDeclaration_static() {
		val file = '''
			class A {
				def static String &&(Object o, Object p) {
				}
			}
		'''.parse
		file.assertNoErrors()		
	}
	
	@Test def void testAndOperatorDeclaration_static_error_01() {
		val file = '''
			class A {
				def static String &&(String s) {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The static binary operator '&&' requires exactly two arguments."
		)		
	}
	
	@Test def void testAndOperatorDeclaration_static_error_02() {
		val file = '''
			class A {
				def static String &&(Object o, Object p, Object q) {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The static binary operator '&&' requires exactly two arguments."
		)		
	}
	
	@Test def void testPlusOperatorDeclaration_instance() {
		val file = '''
			class A {
				// unary
				def String +() {
				}
				// binary or extension unary
				def String +(Object o) {
				}
				// extension binary
				def String +(Object o, Object p) {
				}
			}
		'''.parse
		file.assertNoErrors()		
	}
	
	@Test def void testPlusOperatorDeclaration_instance_error() {
		val file = '''
			class A {
				def String +(Object o, Object p, Object q) {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The operator '+' allows at most two arguments."
		)
	}
	
	@Test def void testPlusOperatorDeclaration_static() {
		val file = '''
			class A {
				def static String +(String s) {
				}
				def static String +(Object o, Object p) {
				}
			}
		'''.parse
		file.assertNoErrors()		
	}
	
	@Test def void testPlusOperatorDeclaration_static_error_01() {
		val file = '''
			class A {
				def static String +(Object o, Object p, Object q) {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The static operator '+' allows at most two arguments."
		)		
	}
	
	@Test def void testPlusPlusOperatorDeclaration_static() {
		val file = '''
			class A {
				def static String ++(Object o) {
				}
			}
		'''.parse
		file.assertNoErrors
	}
	
	@Test def void testPlusPlusOperatorDeclaration_instance() {
		val file = '''
			class A {
				def String ++() {
				}
				// extension
				def String ++(Object o) {
				}
			}
		'''.parse
		file.assertNoErrors
	}
	
	@Test def void testPlusPlusOperatorDeclaration_static_error_01() {
		val file = '''
			class A {
				def static String ++(Object o, Object p) {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The static unary operator '++' requires exactly one argument."
		)		
	}
	
	@Test def void testPlusPlusOperatorDeclaration_instance_error_01() {
		val file = '''
			class A {
				def String ++(Object o, Object o2) {
				}
			}
		'''.parse
		file.assertError(
			XtendPackage.Literals.XTEND_FUNCTION,
			IssueCodes.INVALID_OPERATOR_SIGNATURE,
			"The unary operator '++' allows at most one argument."
		)		
	}
}