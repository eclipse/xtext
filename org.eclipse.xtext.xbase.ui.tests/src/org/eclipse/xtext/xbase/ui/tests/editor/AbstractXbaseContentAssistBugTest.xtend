/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.core.resources.IProject
import org.junit.BeforeClass
import org.junit.AfterClass
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.core.runtime.CoreException
import java.io.InputStream
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AbstractXbaseContentAssistBugTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {

	IProject demandCreateProject;
	
	static IProject staticProject;
	
	@BeforeClass
	def static void createTestProject() throws Exception {
		staticProject = AbstractXbaseUITestCase::createPluginProject(typeof(AbstractXbaseContentAssistBugTest).name);
	}
	
	@AfterClass
	def static void deleteTestProject() throws Exception {
		deleteProject(staticProject);
	}
	
	override void tearDown() throws Exception {
		if (demandCreateProject != null)
			deleteProject(demandCreateProject);
		super.tearDown();
	}
	
	override boolean doCleanWorkspace() {
		return false;
	}

	override getJavaProject(ResourceSet resourceSet) {
		val projectName = getProjectName();
		var javaProject = findJavaProject(projectName);
		if (javaProject == null || !javaProject.exists()) {
			try {
				demandCreateProject = AbstractXbaseUITestCase::createPluginProject(projectName);
				javaProject = findJavaProject(projectName);
			} catch (CoreException e) {
				fail("cannot create java project due to: " + e.getMessage() + " / " + e);
			}
		}
		return javaProject;
	}

	def protected String getProjectName() {
		return getClass().getSimpleName() + "Project";
	}
	
	override getResourceFor(InputStream stream) {
		val result = super.getResourceFor(stream);
		initializeTypeProvider(result);
		return result;
	}
	
	def protected void initializeTypeProvider(XtextResource result) {
		val resourceSet = result.getResourceSet() as XtextResourceSet
		val typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		resourceSet.setClasspathURIContext(getJavaProject(resourceSet));
	}
	
	def protected newBuilder() throws Exception {
		return new ContentAssistProcessorTestBuilder(getInjector(), this);
	}
	
}
