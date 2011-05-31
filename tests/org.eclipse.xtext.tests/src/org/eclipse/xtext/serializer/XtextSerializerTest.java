/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.mwe.utils.StandaloneSetup;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.junit.serializer.SerializerTester;
import org.eclipse.xtext.resource.XtextResourceSet;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextSerializerTest extends AbstractXtextTests {
	@Inject
	private SerializerTester tester;

	private Grammar load(URI uri) {
		XtextResourceSet rs = new XtextResourceSet();
		//		rs.getURIConverter()
		//				.getURIMap()
		//				.put(rs.getURIConverter().normalize(URI.createURI("classpath:/org/eclipse/xtext/Xtext.ecore")),
		//						URI.createURI("http://www.eclipse.org/2008/Xtext"));
		//		URIConverter.URI_MAP.put(URI.createURI("http://www.eclipse.org/2008/Xtext"),
		//				URI.createURI("classpath:/org/eclipse/xtext/Xtext.ecore"));
		//		rs.getURIConverter()
		//		.getURIMap()
		//		.put(rs.getURIConverter().normalize(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext")),
		//				URI.createURI("http://www.eclipse.org/2008/Xtext"));
		return (Grammar) rs.getResource(uri, true).getContents().get(0);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		new StandaloneSetup().setPlatformUri("../..");
		with(new XtextStandaloneSetup() {
			@Override
			public Injector createInjector() {
				return Guice.createInjector(new org.eclipse.xtext.XtextRuntimeModule() {
					@Override
					public Class<? extends org.eclipse.xtext.serializer.ISerializer> bindISerializer() {
						return org.eclipse.xtext.serializer.impl.Serializer.class;
					}

				});
			}

		});
		getInjector().injectMembers(this);
	}

	public void testDummy() {
	}

	public void _testXtextXtextWithNM() throws Exception {
		Grammar grammar = load(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		tester.assertSerializeWithNodeModel(grammar);
	}

	public void _testXtextXtextWithoutNM() throws Exception {
		Grammar grammar = load(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		tester.assertSerializeWithoutNodeModel(grammar);
	}
}
