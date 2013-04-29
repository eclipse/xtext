/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.performance.tests

import org.eclipse.core.resources.IMarker
import org.eclipse.core.resources.IResource
import org.eclipse.core.resources.IncrementalProjectBuilder
import org.eclipse.core.runtime.CoreException
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase
import org.eclipse.xtext.junit4.internal.StopwatchRule
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test

import static org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil.*

import static extension org.eclipse.ui.texteditor.MarkerUtilities.*

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PerformanceTest extends AbstractXtendUITestCase {
	
	@Rule public val rule = new StopwatchRule(true)
	
	@BeforeClass
	def static void createTestProject() {
		PerformanceTestProjectSetup::setUp
		waitForAutoBuild();
		assertNoErrorsInWorkspace();
	}
	
	@AfterClass
	def static void deleteTestProject() {
		PerformanceTestProjectSetup::tearDown		
	}
	
	@Test 
	def void testCleanBuild() throws Exception {
		val project = PerformanceTestProjectSetup::testProject.project
		project.build(IncrementalProjectBuilder::CLEAN_BUILD, null)
	}
	
	@Test 
	def void testFullBuild() throws Exception {
		val project = PerformanceTestProjectSetup::testProject.project
		project.build(IncrementalProjectBuilder::FULL_BUILD, null)
	}
	
	@Test 
	def void testFullBuildAgain() throws Exception {
		val project = PerformanceTestProjectSetup::testProject.project
		project.build(IncrementalProjectBuilder::FULL_BUILD, null)
	}
	
	@Test 
	def void testCleanBuildTwice() throws Exception {
		val project = PerformanceTestProjectSetup::testProject.project
		project.build(IncrementalProjectBuilder::CLEAN_BUILD, null)
		project.build(IncrementalProjectBuilder::FULL_BUILD, null)
		project.build(IncrementalProjectBuilder::CLEAN_BUILD, null)
		project.build(IncrementalProjectBuilder::FULL_BUILD, null)
	}
	
	protected static def void assertNoErrorsInWorkspace() throws CoreException {
		val markers = PerformanceTestProjectSetup::testProject.project.findMarkers(IMarker::PROBLEM, true, IResource::DEPTH_INFINITE);
		for (marker: markers) {
			assertFalse(marker.message, marker.severity == IMarker::SEVERITY_ERROR);
		}
	}
	
}

