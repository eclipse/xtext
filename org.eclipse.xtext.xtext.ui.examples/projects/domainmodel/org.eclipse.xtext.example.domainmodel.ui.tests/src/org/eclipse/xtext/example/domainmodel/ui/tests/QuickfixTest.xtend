/*******************************************************************************
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.domainmodel.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.example.domainmodel.validation.IssueCodes.INVALID_FEATURE_NAME
import static org.eclipse.xtext.example.domainmodel.validation.IssueCodes.INVALID_TYPE_NAME
import static org.eclipse.xtext.xbase.validation.IssueCodes.IMPORT_UNUSED
import static org.eclipse.xtext.xbase.validation.IssueCodes.IMPORT_WILDCARD_DEPRECATED

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

/**
 * @author miklossy - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class QuickfixTest extends AbstractQuickfixTest {

	@Before def void setup() throws Exception {
		/*
		 * Xbase-based languages require java project
		 */
		projectName.createJavaProject
	}

	@Test def fix_invalid_entity_name() {
		'''
			entity blog {
			}
		'''.testQuickfixesOn(INVALID_TYPE_NAME, new Quickfix("Capitalize name", "Capitalize name of 'blog'", '''
			entity Blog {
			}
		'''))
	}

	@Test def fix_invalid_property_name() {
		'''
			entity Blog {
				Title : String
			}
		'''.testQuickfixesOn(INVALID_FEATURE_NAME, new Quickfix("Uncapitalize name", "Uncapitalize name of 'Title'", '''
			entity Blog {
				title : String
			}
		'''))
	}

	@Test def fix_invalid_operation_name() {
		'''
			entity Blog {
				title : String
				op SetTitle(String title) {}
			}
		'''.testQuickfixesOn(INVALID_FEATURE_NAME, new Quickfix("Uncapitalize name", "Uncapitalize name of 'SetTitle'", '''
			entity Blog {
				title : String
				op setTitle(String title) {}
			}
		'''))
	}

	@Test def fix_unused_imports1() {
		'''
			import java.util.Date
			
			entity Blog {}
		'''.testQuickfixesOn(IMPORT_UNUSED,
			new Quickfix(
				"Organize imports",
				"Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.",
				'''
					entity Blog {}
				'''
			)
		)
	}

	@Test def fix_unused_imports2() {
		'''
			import java.util.Date
			import java.util.List
			
			entity Blog {
				posts : List<Post>
			}
			
			entity Post {}
		'''.testQuickfixesOn(IMPORT_UNUSED,
			new Quickfix(
				"Organize imports",
				"Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.",
				'''
					import java.util.List
					
					entity Blog {
						posts : List<Post>
					}
					
					entity Post {}
				'''
			)
		)
	}

	@Test def fix_wildcard_imports() {
		'''
			import java.util.*
			
			entity Blog {
				posts : List<Post>
			}
			
			entity Post {}
		'''.testQuickfixesOn(IMPORT_WILDCARD_DEPRECATED,
			new Quickfix(
				"Organize imports",
				"Organizes the whole import section. Removes wildcard imports as well as duplicates and unused ones.",
				'''
					import java.util.List
					
					entity Blog {
						posts : List<Post>
					}
					
					entity Post {}
				'''
			)
		)
	}
}