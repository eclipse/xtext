/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.xtext.parser.IAstFactory;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.DatatypeRulesTestLanguagePackratParser;
import org.eclipse.xtext.parser.packrat.ParseResultFactory;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PackratParserTest extends ParserTest implements IParser, IResourceFactory {

	private DatatypeRulesTestLanguagePackratParser parser;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.parser = new DatatypeRulesTestLanguagePackratParser();
		ParseResultFactory factory = new ParseResultFactory();
		factory.setFactory(getASTFactory());
		this.parser.setParseResultFactory(factory);
	}

//	@Override
//	protected XtextResource getResource(InputStream in) throws Exception {
//		ResourceSet rs = new XtextResourceSet();
//		URI uri = URI.createURI("mytestmodel." + getResourceFactory().getModelFileExtensions()[0]);
//		XtextResource resource = createResource(uri);
//		rs.getResources().add(resource);
//		resource.load(in, null);
//
//		for (Diagnostic d : resource.getErrors())
//			System.out.println("Resource Error: " + d);
//
//		for (Diagnostic d : resource.getWarnings())
//			System.out.println("Resource Warning: " + d);
//
//		return resource;
//	}

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
		XtextResource result = (XtextResource) getResourceFactory().createResource(uri);
		result.setParser(this);
		return result;
	}

}
