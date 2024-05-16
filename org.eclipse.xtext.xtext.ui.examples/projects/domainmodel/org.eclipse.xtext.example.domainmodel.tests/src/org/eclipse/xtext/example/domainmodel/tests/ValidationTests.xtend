/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.tests

import com.google.inject.Inject
import org.eclipse.xtext.example.domainmodel.domainmodel.DomainModel
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage.Literals.PROPERTY
import static org.eclipse.xtext.example.domainmodel.domainmodel.DomainmodelPackage.Literals.OPERATION
import static org.eclipse.xtext.xbase.validation.IssueCodes.*
import static org.eclipse.xtext.xtype.XtypePackage.Literals.*

import static extension org.junit.Assert.assertEquals

@RunWith(XtextRunner)
@InjectWith(DomainmodelInjectorProvider)
/**
 * @author Jan Koehnlein - copied and adapted from Xtend
 */
class ValidationTests {

	@Inject extension ParseHelper<DomainModel>

	@Inject extension ValidationTestHelper

	@Test def testImportUnused() throws Exception {
		'''
			import java.util.List
			entity X {}
		'''.parse.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED)
	}

	@Test def testImportUnused_1() throws Exception {
		'''
			import java.util.List
			entity X {
				sb: java.util.List<String>
			}
		'''.parse.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED)
	}

	@Test def testImportUnused_2() throws Exception {
		'''
			import java.util.List
			entity X {
				sb : List<String>
				op foo() : List<String> {
					sb
				}
			}
		'''.parse.assertNoIssues
	}

	@Test def testImportUnused_3() throws Exception {
		'''
			import java.util.Map$Entry
			entity X {
				sb: Entry<String, String>
				op foo() : Entry<String, String> {
					sb
				}
			}
		'''.parse.assertNoIssues
	}

	@Test def testImportUnused_4() throws Exception {
		'''
			import java.util.Map
			entity X { 
				sb: Map$Entry<String, String> 
				op foo() : Map$Entry<String, String> {
					sb
				}
			}
		'''.parse.assertNoIssues
	}

	@Test def testImportUnused_5() throws Exception {
		'''
			import java.util.Map$Entry
			entity X {
				sb: Map$Entry<String, String>
				op foo(): Map$Entry<String, String> {
					sb
				}
			}
		'''.parse.assertNoIssues
	}

	@Test def testImportUnused_6() throws Exception {
		'''
			import java.awt.Label
			/** {@link Label} */ 
			entity X{}
		'''.parse.assertNoIssues
	}

	@Test def testImportUnused_7() throws Exception {
		'''
			import java.awt.Label
			/** @see Label */
			entity X{}
		'''.parse.assertNoIssues
	}

	@Test def testImportDuplicate() throws Exception {
		'''
			import java.util.List
			import java.util.List
			entity X {
				sb: List<String>
				op foo() : List<String> {
					sb
				}
			}
		'''.parse.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED)
	}

	@Test def testImportCollision() throws Exception {
		'''
			import java.util.List
			import java.awt.List
			entity X {
				sb: List
				op foo() : List {
					sb
				}
			}
		'''.parse.assertError(XIMPORT_DECLARATION, IMPORT_COLLISION)
	}

	@Test def testImportWildcard() throws Exception {
		'''
			import java.util.*
			import java.util.List
			entity X {
				sb: List<String>
				op foo() : List<String> {
					sb
				}
			}
		'''.parse.assertWarning(XIMPORT_DECLARATION, IMPORT_WILDCARD_DEPRECATED)
	}

	@Test def testImportConflictWithTypeInSameFile() throws Exception {
		'''
			import java.util.List 
			entity List {
				
			}
		'''.parse.assertError(XIMPORT_DECLARATION, IMPORT_CONFLICT)
	}

	@Test def testImportNoConflictWithTypeInSameFile() throws Exception {
		'''
			import java.util.List
			entity List2 {
			}
		'''.parse.assertNoErrors
	}

	@Test def void testDuplicatedProperty() throws Exception {
		val model = '''
			entity E {
				p : String
				p : String
			}
		'''
		model.parse => [
			// coming from org.eclipse.xtext.xbase.validation.JvmGenericTypeValidator
			assertNumberOfIssues(2)
			assertError(PROPERTY, DUPLICATE_FIELD, model.indexOf("p"), 1, "Duplicate field p")
			assertError(PROPERTY, DUPLICATE_FIELD, model.lastIndexOf("p"), 1, "Duplicate field p")
		]
	}

	@Test def void testDuplicatedOperation() throws Exception {
		val model = '''
			entity E {
				op foo() {}
				op foo() {}
			}
		'''
		model.parse => [
			// coming from org.eclipse.xtext.xbase.validation.JvmGenericTypeValidator
			assertNumberOfIssues(2)
			assertError(OPERATION, DUPLICATE_METHOD, model.indexOf("foo"), 3, "Duplicate method foo")
			assertError(OPERATION, DUPLICATE_METHOD, model.lastIndexOf("foo"), 3, "Duplicate method foo")
		]
	}

	@Test def void testDuplicatedOperationWithDifferentSignatureIsAllowed() throws Exception {
		'''
			entity E {
				op m(int i) {}
				op m() {}
			}
		'''.parse.assertNoErrors
	}

	@Test def void testFeatureAndOperationWithSameNameIsAllowed() throws Exception {
		'''
			entity E {
				m : String
				op m() {}
			}
		'''.parse.assertNoErrors
	}

	@Test def void testExplicitGetterReplacesTheGeneratedOne() throws Exception {
		'''
			entity E {
				name : String
				op getName() {
					return name
				}
			}
		'''.parse.assertNoErrors
	}

	@Test def void testExplicitSetterReplacesTheGeneratedOne() throws Exception {
		'''
			entity E {
				name : String
				// even if it's not void
				op setName(String n) : String {
					this.name = n
				}
			}
		'''.parse.assertNoErrors
	}

	@Test def void testDuplicatedOperationWithDifferentSignatureWithSameTypeErasure() throws Exception {
		val model = '''
			entity E {
				op m(java.util.List<String> l1) {}
				op m(java.util.List<Integer> l2) {}
			}
		'''
		model.parse => [
			// coming from org.eclipse.xtext.xbase.validation.JvmGenericTypeValidator
			assertNumberOfIssues(2)
			assertError(OPERATION, DUPLICATE_METHOD, model.indexOf("m"), 1, "The method m(List<String>) has the same erasure")
			assertError(OPERATION, DUPLICATE_METHOD, model.lastIndexOf("m"), 1, "The method m(List<Integer>) has the same erasure")
		]
	}

	private def assertNumberOfIssues(DomainModel domainModel, int expectedNumberOfIssues) {
		expectedNumberOfIssues.assertEquals(domainModel.validate.size)
	}
}