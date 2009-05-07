/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.emf.index.guice;

import junit.framework.TestCase;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Base class for all tests depending on Google Guice for dependency injection. Subclasses can be run in standalone or
 * from a {@link AbstractEmfIndexTestSuite}.
 * 
 * @author Jan Köhnlein - Initial contribution and API
 */
public abstract class AbstractEmfIndexTest extends TestCase {

	protected Injector injector;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// each test should have its own instance of the dependencies, so we create a new Injector
		this.injector = Guice.createInjector(AbstractEmfIndexTestSuite.getModule());
		injector.injectMembers(this);
	}

}
