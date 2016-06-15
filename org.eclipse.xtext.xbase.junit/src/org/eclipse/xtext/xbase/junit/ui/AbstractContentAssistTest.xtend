/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.junit.ui

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Provider
import java.io.InputStream
import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jdt.core.IJavaProject
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory
import org.eclipse.xtext.junit4.ui.ContentAssistProcessorTestBuilder
import org.eclipse.xtext.junit4.util.ResourceLoadHelper
import org.eclipse.xtext.resource.FileExtensionProvider
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.junit.AfterClass
import org.junit.BeforeClass

import static org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil.*

class AbstractContentAssistTest implements ResourceLoadHelper, IJavaProjectProvider {
	
	@Inject Provider<XtextResourceSet> resourceSetProvider
	
	@Inject FileExtensionProvider fileExtensionProvider

	@Inject Injector injector
	
	static IJavaProject javaProject
	
	@BeforeClass
	def static void setUp() {
		javaProject = createJavaProject("contentAssistTest")
	}	
	
	@AfterClass
	def static void tearDown() {
		javaProject.project.delete(true, new NullProgressMonitor)
	}
	
	@SuppressWarnings("unchecked")
	def protected expect(String[]... arrays) {
		val expectation = newArrayList()
		for(array: arrays) {
			expectation.addAll(array)
		}
		return expectation
	}
	
	def protected ContentAssistProcessorTestBuilder newBuilder() throws Exception {
		new ContentAssistProcessorTestBuilder(injector, this)
	}
	
	override getResourceFor(InputStream stream) {
		val set = resourceSetProvider.get()
		initializeTypeProvider(set)
		val result = set.createResource(URI::createURI("Test." + fileExtensionProvider.primaryFileExtension))
		result.load(stream, null)
		result as XtextResource
	}
	
	def protected initializeTypeProvider(XtextResourceSet set) {
		val typeProviderFactory = new JdtTypeProviderFactory(this)
		typeProviderFactory.findOrCreateTypeProvider(set);
		set.setClasspathURIContext(getJavaProject(set));
	}

	override getJavaProject(ResourceSet resourceSet) {
		javaProject
	}
	
}