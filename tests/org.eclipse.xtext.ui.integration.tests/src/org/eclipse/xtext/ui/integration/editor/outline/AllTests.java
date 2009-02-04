package org.eclipse.xtext.ui.integration.editor.outline;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.xtext.ui.integration.editor.outline");
		//$JUnit-BEGIN$
		suite.addTestSuite(OutlineViewTest.class);
		//$JUnit-END$
		return suite;
	}

}
