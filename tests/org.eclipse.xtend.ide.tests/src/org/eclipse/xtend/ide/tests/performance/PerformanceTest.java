/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.performance;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.internal.StopWatchRule;
import org.eclipse.xtext.util.internal.StopWatches;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
/*

2012-12-04 / Sebastian

Task 'build' took 49446ms (10 measurements).
Task 'parsing' took 1491ms (250 measurements).
Task 'primary JVM Model inference' took 1236ms (500 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 397ms (500 measurements).
Task 'Crosslink resolution' took 26765ms (55750 measurements).
Task 'validation' took 16913ms (250 measurements).

2012-12-04 / Sven

Task 'build' took 82157ms (10 measurements).
Task 'parsing' took 2533ms (250 measurements).
Task 'primary JVM Model inference' took 2306ms (500 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 670ms (500 measurements).
Task 'Crosslink resolution' took 45668ms (55750 measurements).
Task 'validation' took 28262ms (250 measurements).

2013-01-17 / Sven

Task 'build' took 76871ms (10 measurements).
Task 'parsing' took 3124ms (250 measurements).
Task 'primary JVM Model inference' took 3729ms (500 measurements).
Task '[macros] findActiveAnnotations' took 1702ms (500 measurements).
Task 'Crosslink resolution' took 42519ms (58750 measurements).
Task 'resolve param names' took 21ms (5 measurements).
Task 'resolve annotations' took 330ms (8920 measurements).
Task 'resolve members' took 3419ms (875 measurements).
Task 'resolve typeParams' took 45ms (1600 measurements).
Task 'resolve binding' took 615ms (305 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 3ms (500 measurements).
Task 'validation' took 18758ms (250 measurements).

 */

public class PerformanceTest extends AbstractXtendUITestCase {
	
	@Rule public static StopWatchRule stopWatch = new StopWatchRule(true);

	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Inject
	private XtendFileGenerator fileGenerator;
	
	
	@Test public void testBuildProject() throws Exception {
		final long warmUp = measureReferenceTime();
		assertTrue(warmUp > 0);
		final long reference1 = measureReferenceTime();
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
					config.noTypeInference = false;
					for (int i = 0;i < num; i++) {
						config.className = "MyGeneratedType"+i;
						String content = fileGenerator.getContents(config).toString();
						workbenchTestHelper.createFile(config.packageName+"/"+config.className+".xtend", content);
					}
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}.run(null);
		waitForAutoBuild();
		assertNoErrorsInWorkspace();
		final long reference2 = measureReferenceTime();
		final long min = min(
				measureCleanBuild(), 
				measureCleanBuild(), 
				measureCleanBuild());
		
		final long reference3 = measureReferenceTime();
		// take the average reference duration times 100 and add 5% buffer
		// and assume that approx 15 secs are ok (IO etc)
		final long reference = Math.max(avg(reference1, reference2, reference3) * 105 , 15000);
		//TODO log the numbers somewhere, such that we can see how the execution time evolves over time.
		assertFasterThen(reference, min);
	}

	protected void assertFasterThen(long expected, long min) {
		// TODO remove sysouts as soon as we know that the expected time was calculated from a reasonable metric
		System.out.println("Expected execution faster then "+expected+"ms.");
		System.out.println("min was "+min + "ms.");
//		assertTrue("Expected execution faster then "+expected+"ms. but was "+min+"ms",  expected > min );
	}
	
	protected long min(long ...ls) {
		long min = Long.MAX_VALUE;
		for (long l : ls) {
			min = Math.min(min, l);
		}
		return min;
	}
	
	protected long avg(long ...ls) {
		long sum = 0;
		for (long l : ls) {
			sum+=l;
		}
		return sum / ls.length;
	}
	
	
	protected long measureCleanBuild() throws CoreException {
		long before = System.currentTimeMillis();
		cleanBuild();
		fullBuild();
		return System.currentTimeMillis() - before;
	}
	
	protected long measureReferenceTime() {
		long before = System.currentTimeMillis();
		int counter = 0;
		int max = 100000000;
		for(int i = 0; i < max; i++) {
			// the compiler will hopefully not eliminate the loop ;-)
			counter = counter + 1 - i;
			counter = counter + i;
		}
		assertEquals(max, counter);
		return System.currentTimeMillis() - before;
	}

	protected void assertNoErrorsInWorkspace() throws CoreException {
		final IMarker[] findMarkers = ResourcesPlugin.getWorkspace().getRoot().findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
		for (IMarker iMarker : findMarkers) {
			assertFalse(MarkerUtilities.getMessage(iMarker), MarkerUtilities.getSeverity(iMarker) == IMarker.SEVERITY_ERROR);
		}
	}
}
