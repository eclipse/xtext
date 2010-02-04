/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.StringInputStream;

import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTestHelper {

	private final IResourceFactory factory;
	private final IParser parser;
	private final Provider<XtextResourceSet> resourceSet;
	private String fileExtension;

	public ParserTestHelper(IResourceFactory factory, IParser parser, Provider<XtextResourceSet> resourceSet, String fileExtension) {
		this.factory = factory;
		this.parser = parser;
		this.resourceSet = resourceSet;
		this.fileExtension = fileExtension;
	}

	public XtextResource getResourceFromStream(InputStream in) throws IOException {
		XtextResourceSet rs = resourceSet.get();
		rs.setClasspathURIContext(getClass());
		URI uri = URI.createURI("mytestmodel."+fileExtension);
		XtextResource resource = createResource(uri);
		rs.getResources().add(resource);
		resource.load(in, null);
		return resource;
	}

	public XtextResource getResourceFromString(String in) throws IOException {
		return getResourceFromStream(new StringInputStream(in));
	}

	public XtextResource createResource(URI uri) {
		XtextResource result = (XtextResource) factory.createResource(uri);
		result.setParser(parser);
		return result;
	}

	public EObject getModel(String model) throws IOException {
		XtextResource res= getResourceFromString(model);
		if (res.getContents().isEmpty())
			return null;
		return res.getContents().get(0);
	}
}
