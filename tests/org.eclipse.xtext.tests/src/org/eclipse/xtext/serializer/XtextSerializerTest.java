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
import org.eclipse.xtext.junit4.AbstractXtextTests;
import org.eclipse.xtext.junit4.serializer.SerializerTester;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Ignore;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XtextSerializerTest extends AbstractXtextTests {
	@Inject
	private SerializerTester tester;

	private Grammar load(URI uri) {
		XtextResourceSet rs = new XtextResourceSet();
		return (Grammar) rs.getResource(uri, true).getContents().get(0);
	}

	@Override
	public void setUp() throws Exception {
		super.setUp();
		StandaloneSetup standaloneSetup = new StandaloneSetup();
		standaloneSetup.setIgnoreBrokenProjectFiles(true);
		standaloneSetup.setPlatformUri("../..");
		with(new XtextStandaloneSetup());
		getInjector().injectMembers(this);
	}

	@Test
	public void testXtextXtextWithNM() throws Exception {
		Grammar grammar = load(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		tester.assertSerializeWithNodeModel(grammar);
	}

	@Test
	@Ignore("To be done")
	public void testXtextXtextWithoutNM() throws Exception {
		Grammar grammar = load(URI.createURI("classpath:/org/eclipse/xtext/Xtext.xtext"));
		tester.assertSerializeWithoutNodeModel(grammar);
	}
}
