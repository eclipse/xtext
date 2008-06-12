package org.eclipse.xtext.ui;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xtext.ui.services.BISyntaxColorerTest;

public class AllStandaloneTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui Standalone");
		// $JUnit-BEGIN$
		suite.addTestSuite(BISyntaxColorerTest.class);
		// $JUnit-END$
		return suite;
	}

}
