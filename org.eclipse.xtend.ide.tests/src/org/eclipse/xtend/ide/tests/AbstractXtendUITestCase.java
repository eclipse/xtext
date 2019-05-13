/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jdt.launching.environments.IExecutionEnvironment;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.util.JavaVersion;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@InjectWith(XtendIDEInjectorProvider.class)
@RunWith(XtextRunner.class)
public abstract class AbstractXtendUITestCase extends Assert {

	private static final boolean isJava11OrLater = determineJava11OrLater();

	public static boolean isJava11OrLater() {
		return isJava11OrLater;
	}

	private static boolean determineJava11OrLater() {
		String javaVersion = System.getProperty("java.version");
		try {
			Pattern p = Pattern.compile("(\\d+)(.)*");
			Matcher matcher = p.matcher(javaVersion);
			if (matcher.matches()) {
				String first = matcher.group(1);
				int version = Integer.parseInt(first);
				return version >= 11;
			}
		} catch (NumberFormatException e) {
			// ok
		}
		return false;
	}

	@Inject
	private Injector injector;
	
	@Before
	public void setUp() throws Exception {
		// nothing to do so far
	}

	@After
	public void tearDown() throws Exception {
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
	}

	@BeforeClass
	public static void setUpProject() throws Exception {
		TargetPlatformUtil.setTargetPlatform(AbstractXtendTestCase.class);
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
