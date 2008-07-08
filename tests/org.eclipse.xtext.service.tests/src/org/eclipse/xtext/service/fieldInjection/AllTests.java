/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.service.fieldInjection;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.eclipse.xtext.service.fieldInjection");
		//$JUnit-BEGIN$
		suite.addTestSuite(FieldInjectionTest.class);
		//$JUnit-END$
		return suite;
	}

}
