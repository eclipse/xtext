/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import org.eclipse.emf.index.internal.LogFacade;

import junit.framework.TestCase;

/**
 * This test should run as JUnit test as well as as JUnit Plug-in test.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 *
 */
public class TestLogging extends TestCase {

	public void testLoggingDoesntThrowException() throws Exception {
		LogFacade.logError("This message should be logged");
		LogFacade.logError("This exception should be logged", new RuntimeException());
	}
}
