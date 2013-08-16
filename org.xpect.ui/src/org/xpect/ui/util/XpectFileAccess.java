/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.xpect.ui.util;

import java.io.IOException;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.common.types.access.ClasspathTypeProviderFactory;
import org.eclipse.xtext.resource.ClassloaderClasspathUriResolver;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceFactory;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;
import org.xpect.XpectFile;
import org.xpect.registry.ILanguageInfo;
import org.xpect.runner.XpectRunner;

import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@SuppressWarnings("restriction")
public class XpectFileAccess {

	private static class XpectResourceAdapter extends AdapterImpl {
		private final XtextResource resource;

		public XpectResourceAdapter(XtextResource resource) {
			super();
			this.resource = resource;
		}
	}

	protected static ResourceSet cloneResourceSet(ResourceSet rs) {
		XtextResourceSet result = new XtextResourceSet();
		result.setPackageRegistry(rs.getPackageRegistry());
		result.setResourceFactoryRegistry(rs.getResourceFactoryRegistry());
		result.setURIConverter(rs.getURIConverter());
		if (XpectRunner.testClassloader != null) {
			result.setClasspathURIContext(XpectRunner.testClassloader);
			result.setClasspathUriResolver(new ClassloaderClasspathUriResolver());
			new ClasspathTypeProviderFactory(XpectRunner.testClassloader).createTypeProvider(result);
		} else if (rs instanceof XtextResourceSet) {
			XtextResourceSet xrs = (XtextResourceSet) rs;
			result.setClasspathURIContext(xrs.getClasspathURIContext());
			result.setClasspathUriResolver(xrs.getClasspathUriResolver());
		}
		return result;
	}

	private static XpectFile findXpectFile(Resource xpectResource) {
		for (EObject contents : xpectResource.getContents())
			if (contents instanceof XpectFile)
				return (XpectFile) contents;
		return null;
	}

	public static XpectFile getXpectFile(Resource resource) {
		for (EObject contents : resource.getContents())
			if (contents instanceof XpectFile)
				return (XpectFile) contents;
		return findXpectFile(getXpectResource(resource));
	}

	public static XtextResource getXpectResource(Resource resource) {
		for (EObject contents : resource.getContents())
			if (contents instanceof XpectFile)
				return (XtextResource) resource;
		String document = ((XtextResource) resource).getParseResult().getRootNode().getText();
		for (Adapter a : resource.eAdapters())
			if (a instanceof XpectResourceAdapter) {
				XtextResource xpectResource = ((XpectResourceAdapter) a).resource;
				if (!xpectResource.getParseResult().getRootNode().getText().equals(document))
					load(xpectResource, document);
				return xpectResource;
			}
		ResourceSet rs = cloneResourceSet(resource.getResourceSet());
		Injector injector = ILanguageInfo.Registry.INSTANCE.getLanguageByFileExtension("xpect").getInjector();
		XtextResource xpectResource = (XtextResource) injector.getInstance(XtextResourceFactory.class).createResource(resource.getURI());
		rs.getResources().add(xpectResource);
		load(xpectResource, document);
		resource.eAdapters().add(new XpectResourceAdapter(xpectResource));
		return xpectResource;

	}

	private static void load(Resource xpectResource, String document) {
		try {
			xpectResource.unload();
			xpectResource.load(new StringInputStream(document), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
