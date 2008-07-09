/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.automated.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.rcpquickstart.bundletestcollector.BundleTestCollector;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class AllCoreTests {

	private static final String[] TEST_BUNDLES = new String[] {
		//"org.eclipse.xtext.generator.tests", "org.eclipse.xtext.service.tests", 
		"org.eclipse.xtext.tests"
	};
	
	public static Test suite() {
		BundleTestCollector bundleTestCollector = new BundleTestCollector();
		TestSuite allTests = new TestSuite("AllCoreTests");
		for (String testBundle: TEST_BUNDLES) {
			TestSuite bundleTestSuite = new TestSuite(testBundle);
			bundleTestCollector.collectTests(bundleTestSuite, testBundle, "", "*");
			allTests.addTest(bundleTestSuite);
		}
		return allTests;
	}
	
}
