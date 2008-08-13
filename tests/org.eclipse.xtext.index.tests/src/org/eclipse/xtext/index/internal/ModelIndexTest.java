/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.index.internal;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.ui.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.util.PluginUtil;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class ModelIndexTest extends TestCase {

	protected static final String TEST_PROJECT_NAME = "test";
	protected static final String REFERENCING_PROJECT_NAME = "referencing";
	protected static final String MODEL_FILE = "simple.ecore";
	protected static final String JAR_FILE = "simple.jar";

	private IProject project;
	private ModelIndex modelIndex;
	private ResourceSet resourceSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		modelIndex = new ModelIndex(false);
		modelIndex.getEcoreRegistryIndexer().indexEPackage(EcorePackage.eINSTANCE);
		modelIndex.stopListening();
		resourceSet = new ResourceSetImpl();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
		modelIndex.clearAll();
		modelIndex.close();
		JavaProjectSetupUtil.deleteProject(project);
	}

	public void testIndexModelInPlainProject() throws Exception {
		project = JavaProjectSetupUtil.createProject(TEST_PROJECT_NAME);
		PluginUtil.copyFileToWorkspace(IndexTestPlugin.getDefault(), "/testfiles/" + MODEL_FILE, project, MODEL_FILE);
		String expectedURI = "platform:/resource/" + TEST_PROJECT_NAME + "/" + MODEL_FILE + "#//SimpleEClass";
		EObject simpleEClass = performTestSimpleEClass(project, expectedURI);
		performReferenceTest(simpleEClass);
		
		IProject referencingProject = JavaProjectSetupUtil.createProject(REFERENCING_PROJECT_NAME);
		modelIndex.getWorkspaceModelIndexer().indexWorkspace();
		Collection<URI> eClasses = modelIndex.findInstances(EcorePackage.Literals.ECLASS, referencingProject);
		assertTrue(eClasses.isEmpty());
		
		JavaProjectSetupUtil.addProjectReference(referencingProject, project);
		performTestSimpleEClass(referencingProject, expectedURI);
		JavaProjectSetupUtil.deleteProject(referencingProject);
	}

	public void testIndexModelInSrcFolder() throws Exception {
		IJavaProject javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		project = javaProject.getProject();
		PluginUtil.copyFileToWorkspace(IndexTestPlugin.getDefault(), "/testfiles/" + MODEL_FILE, project, "src/"
				+ MODEL_FILE);
		String expectedURI = "platform:/resource/" + TEST_PROJECT_NAME + "/src/" + MODEL_FILE + "#//SimpleEClass";
		EObject simpleEClass = performTestSimpleEClass(project, expectedURI);
		performReferenceTest(simpleEClass);
	}

	public void testIndexModelInJar() throws Exception {
		IJavaProject javaProject = JavaProjectSetupUtil.createJavaProject(TEST_PROJECT_NAME);
		project = javaProject.getProject();
		IFile jarFile = PluginUtil.copyFileToWorkspace(IndexTestPlugin.getDefault(), "/testfiles/" + JAR_FILE, project,
				JAR_FILE);
		JavaProjectSetupUtil.addJarToClasspath(javaProject, jarFile);

		String expectedURI = "jar:" + jarFile.getLocationURI() + "!/testfiles/" + MODEL_FILE + "#//SimpleEClass";
		performTestSimpleEClass(project, expectedURI);
	}

	private EObject performTestSimpleEClass(IProject project, String expectedURI) throws SQLException, IOException {
		modelIndex.getWorkspaceModelIndexer().indexWorkspace();
		Collection<URI> eClasses = modelIndex.findInstances(EcorePackage.Literals.ECLASS, project);
		assertFalse(eClasses.isEmpty());
		URI expected = URI.createURI(expectedURI);
		assertTrue(eClasses.contains(expected));
		assertEquals(expectedURI, expected.toString());

		EObject object = resourceSet.getEObject(expected, true);
		assertNotNull(object);
		return object;

	}

	@SuppressWarnings("unchecked")
	private void performReferenceTest(EObject object) throws IOException {
		Collection<URI> references = modelIndex.findReferencesTo(object, project);
		assertFalse(references.isEmpty());
		URI referenceURI = references.iterator().next();
		assertTrue(modelIndex.exists(referenceURI));
		EObject referencingObject = resourceSet.getEObject(referenceURI, false);
		assertNotNull(referencingObject);
		EObject parent = referencingObject.eContainer();
		Resource resource = referencingObject.eResource();
		((List<EObject>) parent.eGet(referencingObject.eContainingFeature())).remove(referencingObject);
		resource.save(null);
		modelIndex.getWorkspaceModelIndexer().indexWorkspace();
		assertFalse(modelIndex.exists(referenceURI));
	}

}
