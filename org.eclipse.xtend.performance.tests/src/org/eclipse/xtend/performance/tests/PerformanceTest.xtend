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
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.util.internal.Stopwatches
import org.eclipse.jdt.core.JavaCore
import org.eclipse.xtext.builder.nature.ToggleXtextNatureAction
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class PerformanceTest extends AbstractXtendUITestCase {
	
	@Rule public val rule = new StopwatchRule(true)
	
	@BeforeClass
	def static void createTestProject() {
		PerformanceTestProjectSetup::setUp
		waitForBuild();
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
		project.build(IncrementalProjectBuilder::CLEAN_BUILD, null)
		Stopwatches::resetAll
		project.build(IncrementalProjectBuilder::CLEAN_BUILD, null)
	}
	
	@Test 
	def void testIncrementalBuild() throws Exception {
		internalTestIncrementalBuild();
		internalTestIncrementalBuild();
		Stopwatches::resetAll
		internalTestIncrementalBuild();
	}
	
	def void internalTestIncrementalBuild() throws Exception {
		val project = PerformanceTestProjectSetup::testProject.project
		val file = project.getFile("src/org/eclipse/xtext/xbase/formatting/XbaseFormatter2.xtend");
		file.appendContents(new StringInputStream("//foo\n"), true, true, null);
		PerformanceTestProjectSetup::waitForBuild
	}
	
	@Test 
	def void testBuildOfDownstreamProject() throws Exception {
		val project = PerformanceTestProjectSetup::testProject
		val downStreamProject = PerformanceTestProjectSetup::createJavaProject("performance.test.project.downstream", 
						#[JavaCore::NATURE_ID, "org.eclipse.pde.PluginNature"]);
		JavaProjectSetupUtil::addProjectReference(downStreamProject, project);
		new ToggleXtextNatureAction().toggleNature(downStreamProject.getProject());
		val sourceFolder = JavaProjectSetupUtil::addSourceFolder(downStreamProject, "src");
		JavaProjectSetupUtil::addSourceFolder(downStreamProject, "xtend-gen");
		sourceFolder.getFolder("foo").create(true,true,null)
		val sourceFile = sourceFolder.getFile("foo/MyFile.xtend")
		sourceFile.create(new StringInputStream('''
			package foo
			
			import org.eclipse.xtext.xbase.formatting.BasicFormatterPreferenceKeys
			import org.eclipse.xtext.xbase.formatting.FormattableDocument
			import org.eclipse.xtext.xbase.formatting.HiddenLeafAccess
			import org.eclipse.xtext.xbase.formatting.NodeModelAccess
			import org.eclipse.xtext.xbase.formatting.XbaseFormatter2
			
			class MyFile extends XbaseFormatter2 {
				
				def a(BasicFormatterPreferenceKeys keys) {
					BasicFormatterPreferenceKeys::indentation
				}
				
				def b(FormattableDocument doc) {
					doc.cfg.get(BasicFormatterPreferenceKeys::indentation)
				}
				
				def c(HiddenLeafAccess x) {
					x.getHiddenLeafsAfter(null).newLines
				}
				
				def d(NodeModelAccess x) {
					x.nodeForEObject(null).asTreeIterable
				}
			}
		'''), true, null)
		
		val p = downStreamProject.project
		p.build(IncrementalProjectBuilder::FULL_BUILD, null)
		p.build(IncrementalProjectBuilder::FULL_BUILD, null)
		Stopwatches::resetAll
		p.build(IncrementalProjectBuilder::FULL_BUILD, null)
	}
	
	@Test 
	def void testFullBuild() throws Exception {
		val project = PerformanceTestProjectSetup::testProject.project
		project.build(IncrementalProjectBuilder::FULL_BUILD, null)
		project.build(IncrementalProjectBuilder::FULL_BUILD, null)
		Stopwatches::resetAll
		project.build(IncrementalProjectBuilder::FULL_BUILD, null)
	}
	
	@Test 
	def void testCleanFullBuild() throws Exception {
		val project = PerformanceTestProjectSetup::testProject.project
		project.build(IncrementalProjectBuilder::CLEAN_BUILD, null)
		project.build(IncrementalProjectBuilder::FULL_BUILD, null)
		project.build(IncrementalProjectBuilder::CLEAN_BUILD, null)
		project.build(IncrementalProjectBuilder::FULL_BUILD, null)
		Stopwatches::resetAll
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

