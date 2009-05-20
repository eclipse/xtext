/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index;

import junit.framework.TestSuite;

import org.eclipse.emf.index.guice.AbstractEmfIndexTestSuite;

/**
 * @author Jan Köhnlein - Initial contribution and API
 */
public class MemoryTestSuite extends AbstractEmfIndexTestSuite {

	public static TestSuite suite() {
		return new MemoryTestSuite();
	}
}
