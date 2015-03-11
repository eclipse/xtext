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
import org.eclipse.xtend.core.tests.performance.GeneratorConfig;
import org.eclipse.xtend.core.tests.performance.XtendFileGenerator;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.junit4.internal.StopwatchRule;
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

2013-01-18 / Sebastian - access restriction based on index query

Task 'build' took 38074ms (7 measurements).
Task 'parsing' took 1460ms (200 measurements).
Task 'primary JVM Model inference' took 1615ms (400 measurements).
Task '[macros] findActiveAnnotations' took 791ms (400 measurements).
Task 'Crosslink resolution' took 22793ms (47000 measurements).
Task 'resolve param names' took 101ms (4 measurements).
Task 'resolve annotations' took 128ms (6348 measurements).
Task 'resolve members' took 929ms (688 measurements).
Task 'resolve typeParams' took 26ms (1208 measurements).
Task 'resolve binding' took 237ms (240 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 2ms (400 measurements).
Task 'validation' took 10002ms (200 measurements).

2013-01-18 / Sebastian - access restriction based on IClasspathEntry

Task 'build' took 33002ms (8 measurements).
Task 'parsing' took 1361ms (200 measurements).
Task 'primary JVM Model inference' took 1507ms (400 measurements).
Task '[macros] findActiveAnnotations' took 736ms (400 measurements).
Task 'Crosslink resolution' took 22774ms (47000 measurements).
Task 'resolve param names' took 154ms (4 measurements).
Task 'resolve annotations' took 108ms (6348 measurements).
Task 'resolve members' took 931ms (688 measurements).
Task 'resolve typeParams' took 22ms (1208 measurements).
Task 'resolve binding' took 252ms (240 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 3ms (400 measurements).
Task 'validation' took 5203ms (200 measurements).

2013-01-18 / Sebastian - new type system

Task 'build' took 34014ms (7 measurements).
Task 'parsing' took 1405ms (200 measurements).
Task 'primary JVM Model inference' took 1393ms (400 measurements).
Task '[macros] findActiveAnnotations' took 749ms (400 measurements).
Task 'Crosslink resolution' took 2699ms (16600 measurements).
Task 'resolve param names' took 0ms (0 measurements).
Task 'resolve annotations' took 382ms (11876 measurements).
Task 'resolve members' took 1598ms (920 measurements).
Task 'resolve typeParams' took 13ms (1360 measurements).
Task 'resolve binding' took 334ms (316 measurements).
Task 'JdtBasedTypeFactory.createType' took 1690ms (316 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 3ms (400 measurements).
Task 'DefaultReentrantTypeResolver.resolve' took 18305ms (200 measurements).
Task 'LightweightTypeReference.copyInto' took 235ms (1591000 measurements).
Task 'LightweightTypeReference#internalIsAssignableFrom' took 3539ms (1102600 measurements).
Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 275ms (124600 measurements).
Task 'UnboundTypeReference.copyInto' took 41ms (99200 measurements).
Task 'LightweightTypeReference#collectSuperTypes' took 13ms (1000 measurements).
Task 'validation' took 2789ms (200 measurements).

(7 vs 10 measurements for the build ... huh?!?)

Task 'build' took 40698ms (10 measurements).
Task 'parsing' took 1475ms (250 measurements).
Task 'primary JVM Model inference' took 1604ms (500 measurements).
Task '[macros] findActiveAnnotations' took 889ms (500 measurements).
Task 'Crosslink resolution' took 3010ms (20750 measurements).
Task 'resolve param names' took 0ms (0 measurements).
Task 'resolve annotations' took 391ms (14845 measurements).
Task 'resolve members' took 1582ms (1150 measurements).
Task 'resolve typeParams' took 20ms (1700 measurements).
Task 'resolve binding' took 383ms (395 measurements).
Task 'JdtBasedTypeFactory.createType' took 1658ms (395 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 2ms (500 measurements).
Task 'DefaultReentrantTypeResolver.resolve' took 21187ms (250 measurements).
Task 'LightweightTypeReference.copyInto' took 304ms (1988750 measurements).
Task 'LightweightTypeReference#internalIsAssignableFrom' took 4050ms (1378250 measurements).
Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 335ms (155750 measurements).
Task 'UnboundTypeReference.copyInto' took 46ms (124000 measurements).
Task 'LightweightTypeReference#collectSuperTypes' took 18ms (1250 measurements).
Task 'validation' took 3221ms (250 measurements).

2013-01-18 / Sebastian - old type system

Task 'build' took 39030ms (10 measurements).
Task 'parsing' took 1487ms (250 measurements).
Task 'primary JVM Model inference' took 1732ms (500 measurements).
Task '[macros] findActiveAnnotations' took 841ms (500 measurements).
Task 'Crosslink resolution' took 26299ms (58750 measurements).
Task 'resolve param names' took 110ms (5 measurements).
Task 'resolve annotations' took 152ms (7925 measurements).
Task 'resolve members' took 1008ms (850 measurements).
Task 'resolve typeParams' took 28ms (1510 measurements).
Task 'resolve binding' took 290ms (295 measurements).
Task 'JdtBasedTypeFactory.createType' took 1087ms (295 measurements).
Task 'secondary (i.e. Macros) JVM Model inference' took 2ms (500 measurements).
Task 'validation' took 5988ms (250 measurements).
-------------------------------------------------------------------------------------------------------------------------

2013-01-18 / Sebastian - new type system /7 measurments

Task 'XtextBuilder.build' took 29509ms (7 measurements).
Task 'AbstractParser.parse' took 1476ms (224 measurements).
Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 1529ms (448 measurements).
Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 844ms (448 measurements).
Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 3012ms (16784 measurements).
Task 'resolve annotations (JdtBasedTypeFactory)' took 551ms (12200 measurements).
Task 'resolve members (JdtBasedTypeFactory)' took 1828ms (920 measurements).
Task 'resolve typeParams (JdtBasedTypeFactory)' took 30ms (1488 measurements).
Task 'resolve binding (JdtBasedTypeFactory)' took 270ms (316 measurements).
Task 'JdtBasedTypeFactory.createType (JdtBasedTypeFactory)' took 1942ms (316 measurements).
Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 3ms (448 measurements).
Task 'resolve param names (JdtBasedTypeFactory)' took 0ms (0 measurements).
Task 'DefaultReentrantTypeResolver.resolve' took 11429ms (448 measurements).
Task 'LightweightTypeReference.copyInto' took 121ms (488296 measurements).
Task 'LightweightTypeReference#internalIsAssignableFrom' took 2085ms (300500 measurements).
Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 182ms (46348 measurements).
Task 'ResourceValidatorImpl.validation' took 4002ms (224 measurements).
Task 'LightweightTypeReference#collectSuperTypes' took 6ms (244 measurements).
-------------------------------------------------------------------------------------------------------------------------

2013-02-15 / Sebastian - new type system /10 measurments
-------------------------------------------------------------------------------------------------------------------------
Task 'XtextBuilder.build' took 35369ms (10 measurements).
Task 'AbstractParser.parse' took 1783ms (280 measurements).
Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 1971ms (560 measurements).
Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 981ms (560 measurements).
Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 3511ms (20980 measurements).
Task 'resolve annotations (JdtBasedTypeFactory)' took 472ms (15250 measurements).
Task 'resolve members (JdtBasedTypeFactory)' took 1924ms (1150 measurements).
Task 'resolve typeParams (JdtBasedTypeFactory)' took 27ms (1860 measurements).
Task 'resolve binding (JdtBasedTypeFactory)' took 311ms (395 measurements).
Task 'JdtBasedTypeFactory.createType (JdtBasedTypeFactory)' took 2041ms (395 measurements).
Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 3ms (560 measurements).
Task 'resolve param names (JdtBasedTypeFactory)' took 0ms (0 measurements).
Task 'DefaultReentrantTypeResolver.resolve' took 12379ms (560 measurements).
Task 'LightweightTypeReference.copyInto' took 150ms (610370 measurements).
Task 'LightweightTypeReference#internalIsAssignableFrom' took 2206ms (375625 measurements).
Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 185ms (58525 measurements).
Task 'ResourceValidatorImpl.validation' took 4647ms (280 measurements).
Task 'LightweightTypeReference#collectSuperTypes' took 6ms (305 measurements).
-------------------------------------------------------------------------------------------------------------------------
2013-02-19 / Sebastian - new type system /10 measurments
-------------------------------------------------------------------------------------------------------------------------
Task 'DebugSourceInstallingCompilationParticipant.install' took 1646ms (9 measurements).
Task 'XtextBuilder.build' took 36462ms (10 measurements).
Task 'AbstractParser.parse' took 1781ms (280 measurements).
Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 1951ms (560 measurements).
Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 1000ms (560 measurements).
Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 3418ms (20980 measurements).
Task 'resolve annotations (JdtBasedTypeFactory)' took 483ms (15250 measurements).
Task 'resolve members (JdtBasedTypeFactory)' took 1995ms (1150 measurements).
Task 'resolve typeParams (JdtBasedTypeFactory)' took 29ms (1860 measurements).
Task 'resolve binding (JdtBasedTypeFactory)' took 311ms (395 measurements).
Task 'JdtBasedTypeFactory.createType (JdtBasedTypeFactory)' took 2116ms (395 measurements).
Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 2ms (560 measurements).
Task 'resolve param names (JdtBasedTypeFactory)' took 0ms (0 measurements).
Task 'DefaultReentrantTypeResolver.resolve' took 12718ms (560 measurements).
Task 'LightweightTypeReference.copyInto' took 135ms (640495 measurements).
Task 'LightweightTypeReference#internalIsAssignableFrom' took 2225ms (371625 measurements).
Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 207ms (57935 measurements).
Task 'ResourceValidatorImpl.validation' took 4767ms (280 measurements).
Task 'LightweightTypeReference#collectSuperTypes' took 5ms (305 measurements).
-------------------------------------------------------------------------------------------------------------------------
2013-02-25 / Sebastian - DerivedStateAwareResourceValidator
Task 'DebugSourceInstallingCompilationParticipant.install' took 1567ms (9 measurements).
Task 'XtextBuilder.build' took 32258ms (10 measurements).
Task 'AbstractParser.parse' took 1624ms (280 measurements).
Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 1667ms (560 measurements).
Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 910ms (560 measurements).
Task 'Crosslink resolution (DefaultLinkingService.getLinkedObjects)' took 3152ms (20980 measurements).
Task 'resolve annotations (JdtBasedTypeFactory)' took 439ms (15250 measurements).
Task 'resolve members (JdtBasedTypeFactory)' took 1680ms (1150 measurements).
Task 'resolve typeParams (JdtBasedTypeFactory)' took 34ms (1860 measurements).
Task 'resolve binding (JdtBasedTypeFactory)' took 261ms (395 measurements).
Task 'JdtBasedTypeFactory.createType (JdtBasedTypeFactory)' took 1784ms (395 measurements).
Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 5ms (560 measurements).
Task 'resolve param names (JdtBasedTypeFactory)' took 0ms (0 measurements).
Task 'DefaultReentrantTypeResolver.resolve' took 11492ms (560 measurements).
Task 'LightweightTypeReference.copyInto' took 149ms (647905 measurements).
Task 'LightweightTypeReference#internalIsAssignableFrom' took 2067ms (377665 measurements).
Task 'DeclaratorTypeArgumentCollector.getTypeParameterMapping' took 187ms (57940 measurements).
Task 'ResourceValidatorImpl.validation' took 3901ms (280 measurements).
Task 'LightweightTypeReference#collectSuperTypes' took 10ms (305 measurements).
-------------------------------------------------------------------------------------------------------------------------
2014-01-02 / Sebastian - Baseline
Task 'XtextBuilder.build[AUTO]' took 11257ms (1 measurements).
Task 'AbstractParser.parse' took 1604ms (280 measurements).
Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 838ms (280 measurements).
Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 3646ms (560 measurements).
Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 2656ms (560 measurements).
Task 'resolve annotations (JdtBasedTypeFactory)' took 379ms (20775 measurements).
Task 'resolve members (JdtBasedTypeFactory)' took 2387ms (1175 measurements).
Task 'resolve typeParams (JdtBasedTypeFactory)' took 25ms (2465 measurements).
Task 'resolve binding (JdtBasedTypeFactory)' took 291ms (405 measurements).
Task 'JdtBasedTypeFactory.createType (JdtBasedTypeFactory)' took 2557ms (405 measurements).
Task 'resolve param names (JdtBasedTypeFactory)' took 0ms (0 measurements).
Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 4ms (560 measurements).
Task 'DefaultReentrantTypeResolver.resolve' took 8206ms (560 measurements).
Task 'ResourceValidatorImpl.validation' took 2526ms (280 measurements).
Task 'XtextBuilder.build[FULL]' took 15285ms (4 measurements).
Task 'DebugSourceInstallingCompilationParticipant.install' took 1097ms (4 measurements).
Task 'XtextBuilder.build[INCREMENTAL]' took 3ms (3 measurements).
-------------------------------------------------------------------------------------------------------------------------
2014-01-02 / Sebastian - Skip Linker#clearReferences in builder context
Task 'XtextBuilder.build[AUTO]' took 11261ms (1 measurements).
Task 'AbstractParser.parse' took 1665ms (280 measurements).
Task 'installing proxies (AbstractCleaningLinker.linkModel)' took 635ms (280 measurements).
Task 'primary JVM Model inference (JvmModelAssociator.installDerivedState)' took 3604ms (560 measurements).
Task '[macros] findActiveAnnotations (ActiveAnnotationContextProvider.computeContext)' took 2677ms (560 measurements).
Task 'resolve annotations (JdtBasedTypeFactory)' took 435ms (20775 measurements).
Task 'resolve members (JdtBasedTypeFactory)' took 2573ms (1175 measurements).
Task 'resolve typeParams (JdtBasedTypeFactory)' took 33ms (2465 measurements).
Task 'resolve binding (JdtBasedTypeFactory)' took 349ms (405 measurements).
Task 'JdtBasedTypeFactory.createType (JdtBasedTypeFactory)' took 2740ms (405 measurements).
Task 'resolve param names (JdtBasedTypeFactory)' took 0ms (0 measurements).
Task 'secondary (i.e. Macros) JVM Model inference (JvmModelAssociator.installDerivedState)' took 0ms (560 measurements).
Task 'DefaultReentrantTypeResolver.resolve' took 8586ms (560 measurements).
Task 'ResourceValidatorImpl.validation' took 2706ms (280 measurements).
Task 'XtextBuilder.build[FULL]' took 15560ms (4 measurements).
Task 'DebugSourceInstallingCompilationParticipant.install' took 1219ms (4 measurements).
Task 'XtextBuilder.build[INCREMENTAL]' took 3ms (3 measurements).
-------------------------------------------------------------------------------------------------------------------------
 */

public class PerformanceTest extends AbstractXtendUITestCase {
	
	@Rule public StopwatchRule stopwatch = new StopwatchRule(true);

	@Inject 
	private WorkbenchTestHelper workbenchTestHelper;
	
	@Inject
	private XtendFileGenerator fileGenerator;
	
	@Override
	public void tearDown() throws Exception {
		workbenchTestHelper.tearDown();
	}
	
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
