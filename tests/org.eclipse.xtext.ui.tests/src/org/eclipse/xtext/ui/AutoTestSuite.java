package org.eclipse.xtext.ui;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * DO NOT MODIFY MANUALLY! This class has been automatically generated. 
 * Install org.eclipse.xtext.testcollector and use the Xtext Tools/Create Test Suite
 * action on the source folder to regenerate this.
 */
public class AutoTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.xtext.ui.tests");
		//suite.addTestSuite(org.eclipse.xtext.ui.editor.EditorTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.language.LanguageFactoryTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.language.ReferenceGrammarTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.language.ServiceFactoryTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.services.BISyntaxColorerTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.services.ResourceFactoryTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.services.TokenTypeDefTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.util.BundleClasspathUriResolverTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.util.JdtClasspathUriResolverTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.util.WorkspaceClasspathUriResolverTest.class);
		return suite;
	}
}
