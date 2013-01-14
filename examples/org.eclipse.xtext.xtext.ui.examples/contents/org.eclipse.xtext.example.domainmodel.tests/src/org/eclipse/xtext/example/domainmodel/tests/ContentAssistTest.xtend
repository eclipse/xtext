package org.eclipse.xtext.example.domainmodel.tests

import org.eclipse.xtext.example.domainmodel.DomainmodelUiInjectorProvider
import org.eclipse.xtext.junit4.InjectWith
import org.eclipse.xtext.junit4.XtextRunner
import org.eclipse.xtext.xbase.junit.ui.AbstractContentAssistTest
import org.junit.runner.RunWith
import org.junit.Test

@RunWith(typeof(XtextRunner))
@InjectWith(typeof(DomainmodelUiInjectorProvider))
/**
 * @author Jan Koehnlein - copied and adapted form Xtend
 */
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
}