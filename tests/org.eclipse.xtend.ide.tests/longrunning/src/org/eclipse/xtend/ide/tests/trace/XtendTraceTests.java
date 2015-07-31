/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.trace;

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.junit4.Flaky;
import org.eclipse.xtext.ui.generator.trace.IEclipseTrace;
import org.eclipse.xtext.ui.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.generator.trace.TraceMarkers;
import org.eclipse.xtext.util.TextRegion;
import org.junit.Rule;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class XtendTraceTests extends AbstractXtendUITestCase {

	@Inject
	private WorkbenchTestHelper testHelper;

	@Inject
	private TraceMarkers traceMarkers;

	@Inject
	private ITraceForStorageProvider traceInformation;

	@Rule
	public Flaky.Rule flakyRule = new Flaky.Rule();

	@Flaky
	@Test
	public void testMarkerForTraceIsInstalled() throws Exception {
		IFile file = testHelper.createFile("test/Test", "package test\nclass Test {}");
		waitForBuild();
		List<IPath> traces = traceMarkers.findTraceFiles(file);
		assertEquals(1, traces.size());
	}

	@Test
	public void testTraceFound() throws Exception {
		IFile file = testHelper.createFile("test/Test", "package test\nclass Test {}");
		waitForBuild();
		IEclipseTrace traceToTarget = traceInformation.getTraceToTarget(file);
		assertNotNull(traceToTarget);
		Iterable<? extends ILocationInResource> locations = traceToTarget.getAllAssociatedLocations(new TextRegion(20, 0));
		assertTrue( locations.iterator().hasNext());
		IFile generatedFile = testHelper.getProject().getFile("/xtend-gen/test/Test.java");
		Iterable<? extends ILocationInResource> locationsByURI = traceToTarget.getAllAssociatedLocations(new TextRegion(20, 0), generatedFile);
		assertTrue(locationsByURI.iterator().hasNext());
	}
	
	@Test
	public void testNoEmptyTraces() throws Exception {
		testHelper.createFile("test/Foo.java", 
				"package test;\n"
				+ "public class Foo {\n"
				+ "	public void foo(Object it) {}\n"
				+ "	public void _foo(Object it) {}\n"
				+ "}");
		IFile sourceFile = testHelper.createFile("test/Zar", 
				"package test\n"
				+ "class Bar extends Foo {\n"
				+ "	def dispatch foo(String it) {print(it)}\n"
				+ "}");
		waitForBuild();
		ITrace trace = traceInformation.getTraceToTarget(sourceFile);
		assertNotNull(trace);
		trace.getBestAssociatedLocation(new TextRegion(65, 0));
	}
}