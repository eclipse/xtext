/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.tests.buildpath;

import java.util.Collections;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.ide.buildpath.XtendLibClasspathAdder;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtext.junit4.ui.util.IResourcesSetupUtil;
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.JREContainerProvider;
import org.eclipse.xtext.ui.util.JavaProjectFactory;
import org.eclipse.xtext.ui.util.PluginProjectFactory;
import org.eclipse.xtext.util.StringInputStream;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Stéphane Galland - fixing for supporting "deprecated feature use" warning.
 */
public class XtendLibClasspathAdderTest extends AbstractXtendUITestCase {
	@Inject
	private XtendLibClasspathAdder adder;
	@Inject
	private MarkerAssertions markerAssert;

	@Inject
	private JavaProjectFactory javaProjectFactory;

	@Inject
	private PluginProjectFactory pluginProjectFactory;

	@Override
	public void tearDown() throws Exception {
		IResourcesSetupUtil.cleanWorkspace();
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		pluginProjectFactory.setBreeToUse(JREContainerProvider.PREFERRED_BREE);
	}
	
	@Test
	public void testAddToJavaProject() throws Exception {
		javaProjectFactory.setProjectName("test");
		javaProjectFactory.addFolders(Collections.singletonList("src"));
		javaProjectFactory.addBuilderIds(JavaCore.BUILDER_ID, XtextProjectHelper.BUILDER_ID);
		javaProjectFactory.addProjectNatures(JavaCore.NATURE_ID, XtextProjectHelper.NATURE_ID);
		IProject project = javaProjectFactory.createProject(null, null);
		IJavaProject javaProject = JavaCore.create(project);
		JavaProjectSetupUtil.makeJava5Compliant(javaProject);
		IFile file = project.getFile("src/Foo.xtend");
		file.create(new StringInputStream("import org.eclipse.xtend.lib.Property class Foo { @Property int bar }"),
				true, null);
		IResourcesSetupUtil.waitForAutoBuild();
		markerAssert.assertErrorMarker(file, IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
		adder.addLibsToClasspath(javaProject, null);
		IResourcesSetupUtil.waitForAutoBuild();
		MarkerAssertions markers = markerAssert.createCollection();
		markers.assertErrorMarker(file, org.eclipse.xtext.xbase.validation.IssueCodes.DEPRECATED_FEATURE);
		markers.assertNoErrorMarker(file);
	}

	@Test
	public void testAddToPlugin() throws Exception {
		pluginProjectFactory.setProjectName("test");
		pluginProjectFactory.addFolders(Collections.singletonList("src"));
		pluginProjectFactory.addBuilderIds(JavaCore.BUILDER_ID, "org.eclipse.pde.ManifestBuilder",
				"org.eclipse.pde.SchemaBuilder", XtextProjectHelper.BUILDER_ID);
		pluginProjectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature",
				XtextProjectHelper.NATURE_ID);
		IProject project = pluginProjectFactory.createProject(null, null);
		IJavaProject javaProject = JavaCore.create(project);
		JavaProjectSetupUtil.makeJava5Compliant(javaProject);
		IFile file = project.getFile("src/Foo.xtend");
		file.create(new StringInputStream("import org.eclipse.xtend.lib.Property class Foo { @Property int bar }"),
				true, null);
		IResourcesSetupUtil.waitForAutoBuild();
		markerAssert.assertErrorMarker(file, IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
		adder.addLibsToClasspath(javaProject, null);
		IResourcesSetupUtil.waitForAutoBuild();
		MarkerAssertions markers = markerAssert.createCollection();
		markers.assertErrorMarker(file, org.eclipse.xtext.xbase.validation.IssueCodes.DEPRECATED_FEATURE);
		markers.assertNoErrorMarker(file);
	}

	@Test
	public void testAddToBrokenPlugin() throws Exception {
		pluginProjectFactory.setProjectName("test");
		pluginProjectFactory.addFolders(Collections.singletonList("src"));
		pluginProjectFactory.addBuilderIds(JavaCore.BUILDER_ID, "org.eclipse.pde.ManifestBuilder",
				"org.eclipse.pde.SchemaBuilder", XtextProjectHelper.BUILDER_ID);
		pluginProjectFactory.addProjectNatures(JavaCore.NATURE_ID, "org.eclipse.pde.PluginNature",
				XtextProjectHelper.NATURE_ID);
		IProject project = pluginProjectFactory.createProject(null, null);
		IJavaProject javaProject = JavaCore.create(project);
		JavaProjectSetupUtil.makeJava5Compliant(javaProject);
		project.findMember("META-INF").delete(true, null);
		IFile file = project.getFile("src/Foo.xtend");
		file.create(new StringInputStream("import org.eclipse.xtend.lib.Property class Foo { @Property int bar }"),
				true, null);
		IResourcesSetupUtil.waitForAutoBuild();
		markerAssert.assertErrorMarker(file, IssueCodes.XBASE_LIB_NOT_ON_CLASSPATH);
		adder.addLibsToClasspath(javaProject, null);
		IResourcesSetupUtil.waitForAutoBuild();
		MarkerAssertions markers = markerAssert.createCollection();
		markers.assertErrorMarker(file, org.eclipse.xtext.xbase.validation.IssueCodes.DEPRECATED_FEATURE);
		markers.assertNoErrorMarker(file);
	}

}
