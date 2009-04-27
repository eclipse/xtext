/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.tests;

import org.eclipse.xtext.ui.core.editor.reconciler.ReplaceRegionTest;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Dennis Huebner - Initial contribution and API
 * 
 */
public class AllUITests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui.core.tests");
		// $JUnit-BEGIN$
		suite.addTestSuite(ReplaceRegionTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.core.DefaultLabelProviderTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.core.editor.contentassist.CamelCasePrefixMatcherTest.class);
		suite.addTestSuite(org.eclipse.xtext.ui.core.editor.contentassist.IgnoreCasePrefixMatcherTest.class);
		// $JUnit-END$
		return suite;
	}

}
