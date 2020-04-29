/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.editor;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.TargetPlatformUtil;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractXbaseContentAssistBugTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {
	private IProject demandCreateProject;

	private static IProject staticProject;

	@BeforeClass
	public static void createTestProject() throws Exception {
		TargetPlatformUtil.setTargetPlatform(AbstractXbaseContentAssistBugTest.class);
		staticProject = AbstractXbaseUITestCase
				.createPluginProject(AbstractXbaseContentAssistBugTest.class.getName());
	}

	@AfterClass
	public static void deleteTestProject() throws Exception {
		JavaProjectSetupUtil.deleteProject(staticProject);
	}

	@Override
	public void tearDown() throws Exception {
		if (demandCreateProject != null) {
			JavaProjectSetupUtil.deleteProject(demandCreateProject);
		}
		super.tearDown();
	}

	@Override
	public boolean doCleanWorkspace() {
		return false;
	}

	@Override
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		String projectName = getProjectName();
		IJavaProject javaProject = JavaProjectSetupUtil.findJavaProject(projectName);
		if (javaProject == null || !javaProject.exists()) {
			try {
				demandCreateProject = createPluginProject(projectName);
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
		XtextResource result = super.getResourceFor(stream);
		initializeTypeProvider(result);
		return result;
	}

	protected void initializeTypeProvider(XtextResource result) {
		XtextResourceSet resourceSet = (XtextResourceSet) result.getResourceSet();
		JdtTypeProviderFactory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		resourceSet.setClasspathURIContext(getJavaProject(resourceSet));
	}

	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return new ContentAssistProcessorTestBuilder(getInjector(), this);
	}
}
