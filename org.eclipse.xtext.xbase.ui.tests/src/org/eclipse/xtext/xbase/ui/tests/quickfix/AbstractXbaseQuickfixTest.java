/**
 * Copyright (c) 2012, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.quickfix;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.shared.SharedStateModule;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.xbase.XbaseRuntimeModule;
import org.eclipse.xtext.xbase.ui.internal.XbaseActivator;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.Assert;

import com.google.inject.Guice;
import com.google.inject.Injector;

public abstract class AbstractXbaseQuickfixTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {
	private IProject demandCreateProject;

	private static Injector injector = Guice.createInjector(
			Modules2.mixin(new XbaseRuntimeModule(), new SharedStateModule(), new TestQuickfixXbaseUIModule(XbaseActivator.getInstance())));

	@Override
	public void tearDown() throws Exception {
		if (demandCreateProject != null) {
			JavaProjectSetupUtil.deleteProject(demandCreateProject);
		}
		super.tearDown();
	}

	@Override
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		String projectName = getProjectName();
		IJavaProject javaProject = JavaProjectSetupUtil.findJavaProject(projectName);
		if (javaProject == null || !javaProject.exists()) {
			try {
				demandCreateProject = AbstractXbaseUITestCase.createPluginProject(projectName);
				javaProject = JavaProjectSetupUtil.findJavaProject(projectName);
			} catch (CoreException e) {
				Assert.fail("cannot create java project due to: " + e.getMessage() + " / " + e);
			}
		}
		return javaProject;
	}

	protected String getProjectName() {
		return getClass().getSimpleName() + "Project";
	}

	@Override
	public XtextResource getResourceFor(InputStream stream) {
		try {
			XtextResource result = (XtextResource) getResourceSet().createResource(URI.createURI("Test." + fileExtension));
			result.load(stream, null);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public XtextResourceSet getResourceSet() {
		XtextResourceSet set = get(XtextResourceSet.class);
		set.setClasspathURIContext(getJavaProject(set));
		return set;
	}

	@Override
	public Injector getInjector() {
		return AbstractXbaseQuickfixTest.injector;
	}
}
