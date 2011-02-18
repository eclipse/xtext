/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests;

import junit.framework.TestCase;

import org.eclipse.xtext.xtend2.ui.internal.Xtend2Activator;

import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractXtend2UITestCase extends TestCase {

	private static Injector injector = Xtend2Activator.getInstance().getInjector("org.eclipse.xtext.xtend2.Xtend2");
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		getInjector().injectMembers(this);
	}

	public Injector getInjector() {
		return injector;
	}
	
	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

}
