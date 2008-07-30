/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.ui.indexer;

import java.sql.SQLException;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.index.internal.WorkspaceModelIndex;
import org.eclipse.xtext.ui.indexer.internal.IndexTestPlugin;
import org.eclipse.xtext.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.util.PluginUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class WorkspaceModelIndexTest extends TestCase {

	private static final String TEST_PROJECT_NAME = "test";
	protected static final String MODEL_FILE = "simple.ecore";
	protected static final String JAR_FILE = "simple.jar";

	private WorkspaceModelIndex workspaceElementIndexer;
	private IProject project;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		workspaceElementIndexer = new WorkspaceModelIndex(false);
		workspaceElementIndexer.indexEPackage(EcorePackage.eINSTANCE);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		JavaProjectSetupUtil.deleteProject(project);
	}

	public void testIndexModelInPlainProject() throws Exception {
		project = JavaProjectSetupUtil.createProject(TEST_PROJECT_NAME);
		PluginUtil.copyFileToWorkspace(IndexTestPlugin.getDefault(), "/testfiles/" + MODEL_FILE, project, MODEL_FILE);
		String expectedURI = "platform:/resource/" + TEST_PROJECT_NAME + "/" + MODEL_FILE + "#//SimpleEClass";
		performTestSimpleEClass(project, expectedURI);
	}

	public void testIndexModelInSrcFolder() throws Exception {
		IJavaProject javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		project = javaProject.getProject();
		PluginUtil.copyFileToWorkspace(IndexTestPlugin.getDefault(), "/testfiles/" + MODEL_FILE, project, "src/"
				+ MODEL_FILE);
		String expectedURI = "platform:/resource/" + TEST_PROJECT_NAME + "/src/" + MODEL_FILE + "#//SimpleEClass";
		performTestSimpleEClass(project, expectedURI);
	}

	public void testIndexModelInJar() throws Exception {
		IJavaProject javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		project = javaProject.getProject();
		IFile jarFile = PluginUtil.copyFileToWorkspace(IndexTestPlugin.getDefault(), "/testfiles/" + JAR_FILE,
				project, JAR_FILE);
		JavaProjectSetupUtil.addJarToClasspath(javaProject, jarFile);
		
		String expectedURI = "jar:" +jarFile.getLocationURI() + "!/testfiles/" + MODEL_FILE + "#//SimpleEClass";
		performTestSimpleEClass(project, expectedURI);
	}

	private void performTestSimpleEClass(IProject project, String expectedURI) throws SQLException {
		workspaceElementIndexer.indexWorkspace();
		List<URI> eClasses = workspaceElementIndexer.findInstances(EcorePackage.Literals.ECLASS, project);
		assertFalse(eClasses.isEmpty());
		URI expected = URI.createURI(expectedURI);
		assertTrue(eClasses.contains(expected));
		assertEquals(expectedURI, expected.toString());
		ResourceSet resourceSet = new ResourceSetImpl();
		EObject object = resourceSet.getEObject(expected, true);
		assertNotNull(object);
	}

}
