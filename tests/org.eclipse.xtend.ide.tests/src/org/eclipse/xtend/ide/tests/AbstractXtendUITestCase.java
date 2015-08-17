/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.xtend.ide.internal.XtendActivator;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.compiler.JavaVersion;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
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

	public final Injector getInjector() {
		return injector;
	}

	public final <T> T get(Class<T> clazz) {
		return getInjector().getInstance(clazz);
	}

	protected void setJavaVersion(JavaVersion javaVersion) throws Exception {
		IJavaProject javaProject = JavaProjectSetupUtil.findJavaProject(WorkbenchTestHelper.TESTPROJECT_NAME);
		Pair<String,Boolean> result = WorkbenchTestHelper.changeBree(javaProject, javaVersion);
		IExecutionEnvironment execEnv = JavaRuntime.getExecutionEnvironmentsManager().getEnvironment(result.getKey());
		Assume.assumeNotNull("Execution environment not found for: " + javaVersion.getLabel(), execEnv);
		Assume.assumeTrue("No compatible VM was found for: " + javaVersion.getLabel(),
				execEnv.getCompatibleVMs().length > 0);
		if(result.getValue()) {
			WorkbenchTestHelper.makeCompliantFor(javaProject, javaVersion);
			IResourcesSetupUtil.reallyWaitForAutoBuild();
		}
	}

}
