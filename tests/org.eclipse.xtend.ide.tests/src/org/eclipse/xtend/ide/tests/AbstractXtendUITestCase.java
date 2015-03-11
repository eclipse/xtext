/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests;

import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public abstract class AbstractXtendUITestCase extends Assert {

	private static Injector injector = XtendActivator.getInstance().getInjector("org.eclipse.xtend.core.Xtend");
	
	@Before
	public void setUp() throws Exception {
		getInjector().injectMembers(this);
	}
	
	@After
	public void tearDown() throws Exception {
	}
	
	@BeforeClass
	public static void setUpProject() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
		WorkbenchTestHelper.createPluginProject(WorkbenchTestHelper.TESTPROJECT_NAME);
	}

	@AfterClass
	public static void tearDownProject() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	public Injector getInjector() {
		return injector;
	}
	
	public <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

}
