package org.eclipse.xtext.service;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AutoTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.xtext.service.tests");
		suite.addTestSuite(org.eclipse.xtext.service.DependencyInjectionTest.class);
		suite.addTestSuite(org.eclipse.xtext.service.NestedServiceScopesTest.class);
		suite.addTestSuite(org.eclipse.xtext.service.PriorityTest.class);
		suite.addTestSuite(org.eclipse.xtext.service.RegistrationTest.class);
		suite.addTestSuite(org.eclipse.xtext.service.ServiceScopeFactoryTest.class);
		suite.addTestSuite(org.eclipse.xtext.service.StatefulServiceTest.class);
		suite.addTestSuite(org.eclipse.xtext.service.fieldInjection.FieldInjectionTest.class);
		return suite;
	}
}
