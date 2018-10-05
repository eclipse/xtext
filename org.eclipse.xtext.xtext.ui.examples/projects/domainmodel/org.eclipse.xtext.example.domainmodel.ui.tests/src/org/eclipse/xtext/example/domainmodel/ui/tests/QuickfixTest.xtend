package org.eclipse.xtext.example.domainmodel.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.example.domainmodel.validation.IssueCodes.INVALID_FEATURE_NAME
import static org.eclipse.xtext.example.domainmodel.validation.IssueCodes.INVALID_TYPE_NAME

import static extension org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil.createJavaProject

@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class QuickfixTest extends AbstractQuickfixTest {

	@Before def void setup() {
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
}