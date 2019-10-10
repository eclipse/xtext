/*******************************************************************************
 * Copyright (c) 2013, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
import static org.eclipse.xtext.example.domainmodel.validation.IssueCodes.DUPLICATE_PROPERTY
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

	@Test def testImportUnused() {
		'''
			import java.util.List
			entity X {}
		'''.parse.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED)
	}

	@Test def testImportUnused_1() {
		'''
			import java.util.List
			entity X {
				sb: java.util.List<String>
			}
		'''.parse.assertWarning(XIMPORT_DECLARATION, IMPORT_UNUSED)
	}

	@Test def testImportUnused_2() {
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

	@Test def testImportUnused_3() {
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

	@Test def testImportUnused_4() {
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

	@Test def testImportUnused_5() {
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

	@Test def testImportUnused_6() {
		'''
			import java.awt.Label
			/** {@link Label} */ 
			entity X{}
		'''.parse.assertNoIssues
	}

	@Test def testImportUnused_7() {
		'''
			import java.awt.Label
			/** @see Label */
			entity X{}
		'''.parse.assertNoIssues
	}

	@Test def testImportDuplicate() {
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

	@Test def testImportCollision() {
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

	@Test def testImportWildcard() {
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

	@Test def testImportConflictWithTypeInSameFile() {
		'''
			import java.util.List 
			entity List {
				
			}
		'''.parse.assertError(XIMPORT_DECLARATION, IMPORT_CONFLICT)
	}

	@Test def testImportNoConflictWithTypeInSameFile() {
		'''
			import java.util.List
			entity List2 {
			}
		'''.parse.assertNoErrors
	}

	@Test def void testDuplicatedProperty() {
		val model = '''
			entity E {
				p : String
				p : String
			}
		'''
		model.parse => [
			assertNumberOfIssues(2)
			assertError(PROPERTY, DUPLICATE_PROPERTY, model.indexOf("p"), 1, "Duplicate property p")
			assertError(PROPERTY, DUPLICATE_PROPERTY, model.lastIndexOf("p"), 1, "Duplicate property p")
		]
	}

	private def assertNumberOfIssues(DomainModel domainModel, int expectedNumberOfIssues) {
		expectedNumberOfIssues.assertEquals(domainModel.validate.size)
	}
}