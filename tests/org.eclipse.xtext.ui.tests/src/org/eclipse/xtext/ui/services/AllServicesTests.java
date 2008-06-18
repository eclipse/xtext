package org.eclipse.xtext.ui.services;

import org.eclipse.xtext.ui.services.bearing.LanguageDescriptorRegistrationTest;
import org.eclipse.xtext.ui.services.bearing.ServiceInjectionTest;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllServicesTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui.services");
		// $JUnit-BEGIN$
		suite.addTestSuite(ResourceFactoryTest.class);
		suite.addTestSuite(TokenTypeDefTest.class);
		suite.addTestSuite(LanguageDescriptorRegistrationTest.class);
		suite.addTestSuite(ServiceInjectionTest.class);
		// $JUnit-END$
		return suite;
	}

}
