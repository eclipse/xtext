package org.eclipse.xtext.ui.integration.editor;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.xtext.ui.integration.editor");
		//$JUnit-BEGIN$
		suite.addTestSuite(EditorTest.class);
		//$JUnit-END$
		return suite;
	}

}
