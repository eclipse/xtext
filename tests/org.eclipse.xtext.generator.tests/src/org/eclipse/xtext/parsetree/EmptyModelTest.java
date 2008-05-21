package org.eclipse.xtext.parsetree;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.testlanguages.OptionalEmptyLanguageLanguageFacade;
import org.eclipse.xtext.testlanguages.OptionalEmptyLanguageStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public class EmptyModelTest extends AbstractGeneratorTest {
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		OptionalEmptyLanguageStandaloneSetup.doSetup();
		with(OptionalEmptyLanguageLanguageFacade.LANGUAGE_ID);
	}
	
	public void testParseEmpty() throws Exception {
		EObject model = getModel("");
		assertNull(model);
		model = getModel("hallo welt");
		assertWithXtend("'welt'", "child.name", model);
	}
	
}
