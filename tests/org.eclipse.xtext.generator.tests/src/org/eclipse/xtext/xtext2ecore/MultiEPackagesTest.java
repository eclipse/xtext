package org.eclipse.xtext.xtext2ecore;

import org.eclipse.xtext.XtextLanguageFacade;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

public abstract class MultiEPackagesTest extends AbstractGeneratorTest {
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		XtextStandaloneSetup.doSetup();
		with(XtextLanguageFacade.LANGUAGE_ID);
	}
	
	
}
