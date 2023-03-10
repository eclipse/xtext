/**
 * Copyright (c) 2013, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.junit.ui;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.junit4.util.ResourceLoadHelper;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @deprecated Use org.eclipse.xtext.ui.testing.AbstractContentAssistTest instead
 */
@Deprecated(forRemoval = true)
public abstract class AbstractContentAssistTest implements ResourceLoadHelper, IJavaProjectProvider {
	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	@Inject
	private FileExtensionProvider fileExtensionProvider;

	@Inject
	private Injector injector;

	private static IJavaProject javaProject;

	@BeforeClass
	public static void setUp() {
		try {
			AbstractContentAssistTest.javaProject = JavaProjectSetupUtil.createJavaProject("contentAssistTest");
		} catch (CoreException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	@AfterClass
	public static void tearDown() {
		try {
			AbstractContentAssistTest.javaProject.getProject().delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected ArrayList<String> expect(String[]... arrays) {
		ArrayList<String> expectation = Lists.newArrayList();
		for (String[] array : arrays) {
			for (String element : array) {
				expectation.add(element);
			}
		}
		return expectation;
	}

	protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		return new ContentAssistProcessorTestBuilder(injector, this);
	}

	@Override
	public XtextResource getResourceFor(InputStream stream) {
		try {
			XtextResourceSet set = resourceSetProvider.get();
			initializeTypeProvider(set);
			Resource result = set.createResource(URI.createURI("Test." + fileExtensionProvider.getPrimaryFileExtension()));
			result.load(stream, null);
			return (XtextResource) result;
		} catch (IOException e) {
			throw Exceptions.sneakyThrow(e);
		}
	}

	protected void initializeTypeProvider(final XtextResourceSet set) {
		final JdtTypeProviderFactory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(set);
		set.setClasspathURIContext(getJavaProject(set));
	}

	@Override
	public IJavaProject getJavaProject(final ResourceSet resourceSet) {
		return AbstractContentAssistTest.javaProject;
	}
}
