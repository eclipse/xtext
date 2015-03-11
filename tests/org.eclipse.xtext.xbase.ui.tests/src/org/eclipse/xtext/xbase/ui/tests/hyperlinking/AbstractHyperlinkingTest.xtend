/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.ui.tests.hyperlinking

import com.google.inject.Inject
import java.io.InputStream
import org.eclipse.core.resources.IProject
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.jdt.core.JavaCore
import org.eclipse.jface.text.hyperlink.IHyperlink
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory
import org.eclipse.xtext.junit4.ui.util.JavaProjectSetupUtil
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper
import org.eclipse.xtext.util.StringInputStream
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase
import org.junit.AfterClass
import org.junit.BeforeClass

/**
 * @author Holger Schill - Initial contribution and API
 */
class AbstractHyperlinkingTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {


	@Inject
	private IHyperlinkHelper hyperlinkHelper;

	static IProject staticProject;

	@BeforeClass
	def static void createTestProject() throws Exception {
		staticProject = createPluginProject(typeof(AbstractHyperlinkingTest).name);
	}

	@AfterClass
	def static void deleteTestProject() throws Exception {
		JavaProjectSetupUtil.deleteProject(staticProject)
	}

	override getResourceFor (InputStream stream) {
		try {
			val result = getResourceSet().createResource(URI.createURI("Test." + fileExtension)) as XtextResource
			result.load(stream, null);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	def getResourceSet() {
		val rs = get(XtextResourceSet)
		initializeTypeProvider(rs)
		return rs
	}

	def protected initializeTypeProvider(XtextResourceSet set) {
		val typeProviderFactory = new JdtTypeProviderFactory(this)
		typeProviderFactory.findOrCreateTypeProvider(set);
		set.setClasspathURIContext(getJavaProject(set));
	}

	override getJavaProject(ResourceSet set) {
		JavaCore.create(staticProject)
	}

	def IHyperlink[] getHyperLinks(String modelAsString){
		val resource = getResourceFor(new StringInputStream(modelAsString.replace("|", "")))
		val index = modelAsString.indexOf("|")
		hyperlinkHelper.createHyperlinksByOffset(resource, index, true)
	}


}