/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.xtext.ui.editor.EditorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class AllWorkbenchTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.ui Workbench");
		// $JUnit-BEGIN$
		suite.addTestSuite(EditorTest.class);
		// $JUnit-END$
		return suite;
	}

}
