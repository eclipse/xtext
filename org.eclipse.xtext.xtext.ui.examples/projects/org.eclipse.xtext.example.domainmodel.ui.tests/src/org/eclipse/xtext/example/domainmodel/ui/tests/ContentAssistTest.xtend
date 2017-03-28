package org.eclipse.xtext.example.domainmodel.ui.tests

import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.ui.testing.AbstractContentAssistTest
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Jan Koehnlein - copied and adapted from Xtend
 */
@RunWith(XtextRunner)
@InjectWith(DomainmodelUiInjectorProvider)
class ContentAssistTest extends AbstractContentAssistTest {
	
	@Test def void testImportCompletion() {
		newBuilder.append('import java.util.Da').assertText('java.util.Date')
	}
	
	@Test def void testImportCompletion_1() {
		newBuilder.append('import LinkedHashSet').assertText('java.util.LinkedHashSet')
	}
	
	@Test def void testTypeCompletion() {
		newBuilder.append('entity Foo { bar: LinkedHashSet').assertText('java.util.LinkedHashSet')
	}
	
	@Test def void testTemplateProposal() {
		newBuilder.applyProposal("Entity - template for an Entity").expectContent('''
		entity name {
			 
		}''')
	}
}
