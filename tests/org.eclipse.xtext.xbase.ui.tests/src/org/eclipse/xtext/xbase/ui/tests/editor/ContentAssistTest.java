/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.editor;

import static org.eclipse.xtext.ui.junit.util.JavaProjectSetupUtil.*;

import java.io.InputStream;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestSuite;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.IJvmTypeProvider;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.junit.ui.AbstractXbaseContentAssistTest;
import org.eclipse.xtext.xbase.ui.internal.XtypeActivator;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;

import com.google.inject.Injector;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ContentAssistTest extends AbstractXbaseContentAssistTest implements IJavaProjectProvider  {

	protected static final String PROJECT_NAME = "ContentAssistTestProject";

	private IProject demandCreateProject;
	
	@Override
	protected Injector getInjector() {
		return XtypeActivator.getInstance().getInjector("org.eclipse.xtext.xbase.Xbase");
	}
	
	@Override
	protected void tearDown() throws Exception {
		if (demandCreateProject != null)
			deleteProject(demandCreateProject);
		super.tearDown();
	}

	@Override
	protected boolean doCleanWorkspace() {
		return false;
	}
	
	protected void initializeTypeProvider(XtextResource result) {
		XtextResourceSet resourceSet = (XtextResourceSet) result.getResourceSet();
		IJvmTypeProvider.Factory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
	}
	
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		IJavaProject javaProject = findJavaProject(PROJECT_NAME);
		if (javaProject == null || !javaProject.exists()) {
			try {
				demandCreateProject = AbstractXbaseUITestCase.createPluginProject(PROJECT_NAME);
				javaProject = findJavaProject(PROJECT_NAME);
			} catch (CoreException e) {
				fail("cannot create java project due to: " + e.getMessage() + " / " + e);
			}
		}
		return javaProject;
	}
	
	@Override
	public XtextResource getResourceFor(InputStream stream) {
		XtextResource result = super.getResourceFor(stream);
		initializeTypeProvider(result);
		return result;
	}
	
	public static Test suite() {
		return new TestSetup(new TestSuite(ContentAssistTest.class)) {
			private IProject project;

			@Override
			protected void setUp() throws Exception {
				super.setUp();
				project = AbstractXbaseUITestCase.createPluginProject(PROJECT_NAME);
				
			}
			
			@Override
			protected void tearDown() throws Exception {
				deleteProject(project);
				super.tearDown();
			}
		};
	}
	
}
