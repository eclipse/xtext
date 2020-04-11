/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.testing;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.ui.testing.util.ResourceLoadHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @since 2.12
 */
@SuppressWarnings("restriction")
public abstract class AbstractContentAssistTest implements ResourceLoadHelper, IJavaProjectProvider {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private Injector injector;

	private static IJavaProject javaProject;

	@BeforeClass
	@BeforeAll
	public static void setUp() throws CoreException {
		javaProject = JavaProjectSetupUtil.createJavaProject("contentAssistTest");
	}

	@AfterClass
	@AfterAll
	public static void tearDown() throws CoreException {
		IProject project = AbstractContentAssistTest.javaProject.getProject();
		project.delete(true, new NullProgressMonitor());
	}

	@Override
	public XtextResource getResourceFor(InputStream stream) {
		XtextResourceSet resourceSet = resourceSetProvider.get();
		initializeTypeProvider(resourceSet);
		try {
			URI resourceUri = URI.createURI("Test." + fileExtensionProvider.getPrimaryFileExtension());
			Resource resource = resourceSet.createResource(resourceUri);
			resource.load(stream, null);
			return (XtextResource) resource;
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public IJavaProject getJavaProject(ResourceSet resourceSet) {
		return javaProject;
	}

	protected List<String> expect(String[]... arrays) {
		List<String> expectation = new ArrayList<>();
		for (String[] array : arrays) {
			expectation.addAll(Arrays.asList(array));
		}
		return expectation;
	}

	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return new ContentAssistProcessorTestBuilder(injector, this);
	}

	protected void initializeTypeProvider(XtextResourceSet resourceSet) {
		JdtTypeProviderFactory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		resourceSet.setClasspathURIContext(getJavaProject(resourceSet));
	}

}
