package org.eclipse.xtext.ui;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllHeadlessTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui Headless");
		// $JUnit-BEGIN$
		suite.addTestSuite(org.eclipse.xtext.ui.services.BISyntaxColorerTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.services.ResourceFactoryTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.services.TokenTypeDefTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.util.WorkspaceClasspathUriResolverTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.util.BundleClasspathUriResolverTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.util.JdtClasspathUriResolverTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.language.ReferenceGrammarTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.language.LanguageFactoryTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.language.ServiceFactoryTest.class);
		// $JUnit-END$
		return suite;
	}

}
