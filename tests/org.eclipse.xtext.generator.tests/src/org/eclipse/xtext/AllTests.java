/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext;

import junit.framework.Test;
import junit.framework.TestSuite;

import com.rcpquickstart.bundletestcollector.BundleTestCollector;


/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class AllTests {

	public static boolean isPluginContext = false;
	
	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext");
		new BundleTestCollector().collectTests(suite, "org.eclipse.xtext.generator.tests", "", "*");
		isPluginContext = true;
		return suite;
	}

}
