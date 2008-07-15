package org.eclipse.xtext.ui.services;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllServicesTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui.services");
		// $JUnit-BEGIN$
		suite.addTestSuite(ResourceFactoryTest.class);
		suite.addTestSuite(TokenTypeDefTest.class);
		// $JUnit-END$
		return suite;
	}

}
