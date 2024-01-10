/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.performance.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.ui.texteditor.MarkerUtilities;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.StopwatchRule;
import org.eclipse.xtext.builder.nature.ToggleXtextNatureCommand;
import org.eclipse.xtext.ui.testing.util.IResourcesSetupUtil;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PerformanceTest extends AbstractXtendUITestCase {
	@Rule
	public StopwatchRule rule = new StopwatchRule(true);

	@BeforeClass
	public static void createTestProject() throws Exception {
		// This shadows org.eclipse.xtend.ide.tests.AbstractXtendUITestCase.setUpProject()
		// see https://junit.org/junit4/javadoc/latest/org/junit/BeforeClass.html
		// The class passed to TargetPlatformUtil.setTargetPlatform must be in the same bundle
		// of the running test, while AbstractXtendUITestCase is in another bundle.
		// Manually setting the TP allows the Tycho build to succeed
		// otherwise, the required bundles taken from the workspace
		// have a wrong layout in "Plug-in Dependencies", and their
		// classes cannot be resolved
		TargetPlatformUtil.setTargetPlatform(PerformanceTest.class);
		PerformanceTestProjectSetup.setUp();
		IResourcesSetupUtil.waitForBuild();
		PerformanceTest.assertNoErrorsInWorkspace();
	}

	@AfterClass
	public static void deleteTestProject() throws Exception {
		PerformanceTestProjectSetup.tearDown();
	}

	@Test
	public void testCleanBuild() throws Exception {
		IProject project = PerformanceTestProjectSetup.testProject.getProject();
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
		Stopwatches.resetAll();
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
	}

	@Test
	public void testIncrementalBuild() throws Exception {
		internalTestIncrementalBuild();
		internalTestIncrementalBuild();
		Stopwatches.resetAll();
		internalTestIncrementalBuild();
	}

	public void internalTestIncrementalBuild() throws Exception {
		IProject project = PerformanceTestProjectSetup.testProject.getProject();
		IFile file = project.getFile("src/org/eclipse/xtext/xbase/formatting/XbaseFormatter2.xtend");
		file.appendContents(new StringInputStream("//foo\n"), true, true, null);
		PerformanceTestProjectSetup.waitForBuild();
	}

	@Test
	public void testBuildOfDownstreamProject() throws Exception {
		IJavaProject project = PerformanceTestProjectSetup.testProject;
		IJavaProject downStreamProject = PerformanceTestProjectSetup.createJavaProject("performance.test.project.downstream",
				new String[] { JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature" });
		JavaProjectSetupUtil.addProjectReference(downStreamProject, project);
		new ToggleXtextNatureCommand().toggleNature(downStreamProject.getProject());
		IFolder sourceFolder = JavaProjectSetupUtil.addSourceFolder(downStreamProject, "src");
		JavaProjectSetupUtil.addSourceFolder(downStreamProject, "xtend-gen");
		sourceFolder.getFolder("foo").create(true, true, null);
		IFile sourceFile = sourceFolder.getFile("foo/MyFile.xtend");
		sourceFile.create(new StringInputStream(
			  "package foo\n"
			+ "\n"
			+ "import org.eclipse.xtext.xbase.formatting.BasicFormatterPreferenceKeys\n"
			+ "import org.eclipse.xtext.xbase.formatting.FormattableDocument\n"
			+ "import org.eclipse.xtext.xbase.formatting.HiddenLeafAccess\n"
			+ "import org.eclipse.xtext.xbase.formatting.NodeModelAccess\n"
			+ "import org.eclipse.xtext.xbase.formatting.XbaseFormatter2\n"
			+ "\n"
			+ "class MyFile extends XbaseFormatter2 {\n"
			+ "\n"
			+ "	def a(BasicFormatterPreferenceKeys keys) {\n"
			+ "		BasicFormatterPreferenceKeys::indentation\n"
			+ "	}\n"
			+ "\n"
			+ "	def b(FormattableDocument doc) {\n"
			+ "		doc.cfg.get(BasicFormatterPreferenceKeys::indentation)\n"
			+ "	}\n"
			+ "\n"
			+ "	def c(HiddenLeafAccess x) {\n"
			+ "		x.getHiddenLeafsAfter(null).newLines\n"
			+ "	}\n"
			+ "\n"
			+ "	def d(NodeModelAccess x) {\n"
			+ "		x.nodeForEObject(null).asTreeIterable\n"
			+ "	}\n"
			+ "}"), true, null);
		IProject p = downStreamProject.getProject();
		p.build(IncrementalProjectBuilder.FULL_BUILD, null);
		p.build(IncrementalProjectBuilder.FULL_BUILD, null);
		Stopwatches.resetAll();
		p.build(IncrementalProjectBuilder.FULL_BUILD, null);
	}

	@Test
	public void testFullBuild() throws Exception {
		IProject project = PerformanceTestProjectSetup.testProject.getProject();
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
		Stopwatches.resetAll();
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
	}

	@Test
	public void testCleanFullBuild() throws Exception {
		IProject project = PerformanceTestProjectSetup.testProject.getProject();
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
		Stopwatches.resetAll();
		project.build(IncrementalProjectBuilder.CLEAN_BUILD, null);
		project.build(IncrementalProjectBuilder.FULL_BUILD, null);
	}

	protected static void assertNoErrorsInWorkspace() throws CoreException {
		IMarker[] markers = PerformanceTestProjectSetup.testProject.getProject().findMarkers(IMarker.PROBLEM, true,
				IResource.DEPTH_INFINITE);
		for (IMarker marker : markers) {
			assertFalse(MarkerUtilities.getMessage(marker),
					MarkerUtilities.getSeverity(marker) == IMarker.SEVERITY_ERROR);
		}
	}
}
