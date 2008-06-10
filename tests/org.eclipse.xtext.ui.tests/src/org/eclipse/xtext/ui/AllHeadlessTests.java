package org.eclipse.xtext.ui;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xtext.ui.language.AllLanguageTests;
import org.eclipse.xtext.ui.services.AllServicesTests;
import org.eclipse.xtext.ui.util.AllUtilTests;

public class AllHeadlessTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui");
		// $JUnit-BEGIN$
		suite.addTest(AllServicesTests.suite());
		suite.addTest(AllUtilTests.suite());
		suite.addTest(AllLanguageTests.suite());
		// $JUnit-END$
		return suite;
	}

}
