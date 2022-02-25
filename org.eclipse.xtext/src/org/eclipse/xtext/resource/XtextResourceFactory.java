/*******************************************************************************
 * Copyright (c) 2008, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class XtextResourceFactory implements IResourceFactory {

	private Provider<XtextResource> provider;

	@Inject
	public XtextResourceFactory(Provider<XtextResource> resourceProvider) {
		this.provider = resourceProvider;
	}
	
	@Override
	public Resource createResource(URI uri) {
		XtextResource xtextResource = provider.get();
		xtextResource.setURI(uri);
		return xtextResource;
	}

}
