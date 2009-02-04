package org.eclipse.xtext.ui.core.util;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(
				"Test for org.eclipse.xtext.ui.core.util");
		//$JUnit-BEGIN$
		suite.addTestSuite(JdtClasspathUriResolverTest.class);
		suite.addTestSuite(WorkspaceClasspathUriResolverTest.class);
		suite.addTestSuite(BundleClasspathUriResolverTest.class);
		//$JUnit-END$
		return suite;
	}

}
