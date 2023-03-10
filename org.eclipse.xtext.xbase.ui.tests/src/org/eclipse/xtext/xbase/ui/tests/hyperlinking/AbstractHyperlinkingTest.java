/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ui.tests.hyperlinking;

import java.io.InputStream;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.access.jdt.JdtTypeProviderFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.testing.util.JavaProjectSetupUtil;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xbase.ui.tests.AbstractXbaseUITestCase;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public abstract class AbstractHyperlinkingTest extends AbstractXbaseUITestCase implements IJavaProjectProvider {
	@Inject
	private IHyperlinkHelper hyperlinkHelper;

	private static IProject staticProject;

	@BeforeClass
	public static void createTestProject() throws Exception {
		staticProject = AbstractXbaseUITestCase.createPluginProject(AbstractHyperlinkingTest.class.getName());
	}

	@AfterClass
	public static void deleteTestProject() throws Exception {
		JavaProjectSetupUtil.deleteProject(staticProject);
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
		XtextResourceSet rs = get(XtextResourceSet.class);
		initializeTypeProvider(rs);
		return rs;
	}

	protected void initializeTypeProvider(XtextResourceSet set) {
		JdtTypeProviderFactory typeProviderFactory = new JdtTypeProviderFactory(this);
		typeProviderFactory.findOrCreateTypeProvider(set);
		set.setClasspathURIContext(getJavaProject(set));
	}

	@Override
	public IJavaProject getJavaProject(ResourceSet set) {
		return JavaCore.create(staticProject);
	}

	public IHyperlink[] getHyperLinks(String modelAsString) {
		XtextResource resource = getResourceFor(new StringInputStream(modelAsString.replace("|", "")));
		int index = modelAsString.indexOf("|");
		return hyperlinkHelper.createHyperlinksByOffset(resource, index, true);
	}
}
