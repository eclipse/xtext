package org.eclipse.xtext.ui.integration;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Runs all tests in this plug-in. Delegates to eclipse auto-generated test
 * suites (New->TestSuite) in the contained packages.
 * 
 * @author Jan Koehnlein
 */
public class PluginTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.xtext.ui.integration");
		// $JUnit-BEGIN$
		suite.addTest(org.eclipse.xtext.ui.core.util.AllTests.suite());
		suite.addTest(org.eclipse.xtext.ui.integration.editor.AllTests.suite());
		suite.addTest(org.eclipse.xtext.ui.integration.editor.outline.AllTests.suite());
		// $JUnit-END$
		return suite;
	}

}
