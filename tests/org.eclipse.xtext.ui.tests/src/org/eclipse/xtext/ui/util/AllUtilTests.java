package org.eclipse.xtext.ui.util;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllUtilTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui.util");
		//$JUnit-BEGIN$
		suite.addTestSuite(JdtClasspathUriResolverTests.class);
		suite.addTestSuite(WorkspaceClasspathUriResolverTests.class);
		suite.addTestSuite(BundleClasspathUriResolverTests.class);
		//$JUnit-END$
		return suite;
	}

}
