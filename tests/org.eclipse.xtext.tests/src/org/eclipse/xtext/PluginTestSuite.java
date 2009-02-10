package org.eclipse.xtext;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Runs all tests in this plug-in. Delegates to eclipse auto-generated test
 * suites (New->TestSuite) in the contained packages.
 * 
 * @author Jan Koehnlein
 */
public class PluginTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("org.eclipse.xtext.tests");
		return suite;
	}
}
