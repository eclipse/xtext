/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.enumrules;

import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.junit.Test;

import com.google.common.collect.Iterables;

public class EnumAndReferenceTest extends AbstractXtextTests {

	private ParserTestHelper helper;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(EnumAndReferenceTestLanguageStandaloneSetup.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
	}
	
	@Override
	public void tearDown() throws Exception {
		helper = null;
		super.tearDown();
	}
	
	@Test public void testSemantic() throws Exception {
		String modelAsString = "kindOfKeyword Hoo reference Hoo";
		EntityWithEnumAndReference model = (EntityWithEnumAndReference) helper.getModel(modelAsString);
		assertNotNull(model);
		assertEquals("Hoo", model.getName());
		assertNotNull(model.getRef());
		assertEquals(model, model.getRef());
	}
	
	@Test public void testNodes() throws Exception {
		String modelAsString = "kindOfKeyword Hoo reference Hoo";
		EntityWithEnumAndReference model = (EntityWithEnumAndReference) helper.getModel(modelAsString);
		ICompositeNode node = NodeModelUtils.getNode(model);
		assertNotNull(node);
		assertTrue(Iterables.size(node.getChildren()) == 7); // 3 hidden WS + 4 visible LeafNodes
	}
	
}
