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
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.parser.packrat.IPackratParser;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParserTestHelper implements IParser, IResourceFactory {

	private final IResourceFactory factory;
	private final IPackratParser parser;

	public ParserTestHelper(IResourceFactory factory, IPackratParser parser) {
		this.factory = factory;
		this.parser = parser;
	}
	
	public XtextResource getResourceFromStream(InputStream in) throws IOException {
		ResourceSet rs = new XtextResourceSet();
		URI uri = URI.createURI("mytestmodel." + factory.getModelFileExtensions()[0]);
		XtextResource resource = createResource(uri);
		rs.getResources().add(resource);
		resource.load(in, null);

		for (Diagnostic d : resource.getErrors())
			System.out.println("Resource Error: " + d);

		for (Diagnostic d : resource.getWarnings())
			System.out.println("Resource Warning: " + d);

		return resource;
	}

	public IParseResult parse(InputStream in, IAstFactory factory) {
		final Reader reader = new InputStreamReader(in);
		final StringBuilder builder = new StringBuilder();
		final char[] buffer = new char[256];
		int read = 0;
		try {
			while ((read = reader.read(buffer)) != -1) {
				builder.append(buffer, 0, read);
			}
		}
		catch (IOException ex) {
			throw new RuntimeException(ex);
		}
		return parser.parse(builder.toString());
	}

	public IParseResult parse(InputStream in) {
		throw new UnsupportedOperationException();
	}

	public IParseResult reparse(CompositeNode originalRootNode, int offset, int length, String change) {
		throw new UnsupportedOperationException();
	}

	public String[] getModelFileExtensions() {
		return null;
	}

	public XtextResource createResource(URI uri) {
		XtextResource result = (XtextResource) factory.createResource(uri);
		result.setParser(this);
		return result;
	}
}
