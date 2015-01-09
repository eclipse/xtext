package org.eclipse.xtext.idea.sdomain.idea.tests.issues

import org.eclipse.xtext.idea.sdomain.idea.lang.SDomainFileType
import org.eclipse.xtext.idea.tests.LightToolingTest

class IssueAnnotatorTest extends LightToolingTest {
	
	new() {
		super(SDomainFileType.INSTANCE)
	}
	
	def void testErrorsAndWarnings() {
		configureByText('''
			entity <warning descr="Name should start with a capital">foo</warning> {
				<error descr="Couldn't resolve reference to Type 'Bar'.">Bar</error> bar
			}
		''')
		checkHighlighting
	}
	
	def void testNoDuplicateSyntaxErrors() {
		configureByText('''
			{}<EOLError descr="missing EOF at '{'"></EOLError>''')
		checkHighlighting
	}
	
}