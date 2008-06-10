package org.eclipse.xtext.ui.language;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllLanguageTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui.language");
		//$JUnit-BEGIN$
		suite.addTestSuite(ReferenceGrammarTest.class);
		suite.addTestSuite(LanguageFactoryTest.class);
		suite.addTestSuite(ServiceFactoryTest.class);
		//$JUnit-END$
		return suite;
	}

}
