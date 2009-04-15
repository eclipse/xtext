/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xtext.xtend.crossref.XtendScopeProviderTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class PluginTestSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.xtend.tests");
		//$JUnit-BEGIN$
//		suite.addTestSuite(XtendContentAssistProcessorTest.class);
		suite.addTestSuite(XtendScopeProviderTest.class);
		//$JUnit-END$
		return suite;
	}

}
