/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtend2.ui.tests.performance;

import static org.eclipse.xtext.ui.junit.util.IResourcesSetupUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import junit.framework.Test;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtext.xtend2.ui.tests.AbstractXtend2UITestCase;
import org.eclipse.xtext.xtend2.ui.tests.WorkbenchTestHelper;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class PerformanceTest extends AbstractXtend2UITestCase {

	public static Test suite() {
		return WorkbenchTestHelper.suite(PerformanceTest.class);
	}

	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Inject
	private XtendFileGenerator fileGenerator;
	
	public void testBuildProject() throws Exception {
		
		new WorkspaceModifyOperation() {
			@Override
			protected void execute(IProgressMonitor monitor) throws CoreException, InvocationTargetException,
					InterruptedException {
				try {
					int num = 50;
					Map<String, ? extends CharSequence> map = fileGenerator.getDependencies();
					for (String key : map.keySet()) {
							workbenchTestHelper.createFile(key, map.get(key).toString());
					}
					GeneratorConfig config = new GeneratorConfig();
					config.packageName = "generated";
					config.noTypeInference = true;
					for (int i = 0;i < num; i++) {
						config.className = "MyGeneratedType"+i;
						workbenchTestHelper.createFile(config.packageName+"/"+config.className+".xtend", fileGenerator.getContents(config).toString());
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}.run(null);
		waitForAutoBuild();
		assertNoErrorsInWorkspace();
		final long min = min(
				measureCleanBuild(), 
				measureCleanBuild(), 
				measureCleanBuild());
		System.out.println("min was "+min);
		assertFasterThen(10000l, min);
	}

	protected void assertFasterThen(long expected, long min) {
		assertTrue("Expected execution faster then "+expected+"ms. but was "+min+"ms",  expected > min );
	}
	
	protected long min(long ...ls) {
		long min = Long.MAX_VALUE;
		for (long l : ls) {
			min = Math.min(min, l);
		}
		return min;
	}
	
	protected long measureCleanBuild() throws CoreException {
		long before = System.currentTimeMillis();
		cleanBuild();
		fullBuild();
		return System.currentTimeMillis() - before;
	}

	protected void assertNoErrorsInWorkspace() throws CoreException {
		final IMarker[] findMarkers = ResourcesPlugin.getWorkspace().getRoot().findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		for (IMarker iMarker : findMarkers) {
			assertFalse(MarkerUtilities.getMessage(iMarker), MarkerUtilities.getSeverity(iMarker) == IMarker.SEVERITY_ERROR);
		}
	}
}
