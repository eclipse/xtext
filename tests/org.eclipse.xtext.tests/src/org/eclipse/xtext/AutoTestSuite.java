package org.eclipse.xtext;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AutoTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.xtext.tests");
		suite.addTestSuite(org.eclipse.xtext.resource.ClassloaderClasspathUriResolverTests.class);
		return suite;
	}
}
