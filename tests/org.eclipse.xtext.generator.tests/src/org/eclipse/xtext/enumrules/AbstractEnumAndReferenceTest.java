/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.enumrules;

import org.eclipse.xtext.enumrules.enumAndReferenceTestLanguage.EntityWithEnumAndReference;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.NodeAdapter;
import org.eclipse.xtext.parsetree.NodeUtil;

public abstract class AbstractEnumAndReferenceTest extends AbstractXtextTests {

	private ParserTestHelper helper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(EnumAndReferenceTestLanguageStandaloneSetup.class);
		helper = new ParserTestHelper(getResourceFactory(), getParser(), get(Keys.RESOURCE_SET_KEY));
	}
	
	@Override
	protected void tearDown() throws Exception {
		helper = null;
		super.tearDown();
	}
	
	public void testSemantic() throws Exception {
		String modelAsString = "kindOfKeyword Hoo reference Hoo";
		EntityWithEnumAndReference model = (EntityWithEnumAndReference) helper.getModel(modelAsString);
		assertNotNull(model);
		assertEquals("Hoo", model.getName());
		assertNotNull(model.getRef());
		assertEquals(model, model.getRef());
	}
	
	public void testNodes() throws Exception {
		String modelAsString = "kindOfKeyword Hoo reference Hoo";
		EntityWithEnumAndReference model = (EntityWithEnumAndReference) helper.getModel(modelAsString);
		NodeAdapter nodeAdapter = NodeUtil.getNodeAdapter(model);
		
		CompositeNode node = nodeAdapter.getParserNode();
		assertNotNull(node);
		assertTrue(node.getChildren().size() == 7); // 3 hidden WS + 4 visible LeafNodes
	}
	
	public static class Antlr extends AbstractEnumAndReferenceTest {
		
		@Override
		protected IParser getParser() {
			return getAntlrParser();
		}
	}
	
	public static class Packrat extends AbstractEnumAndReferenceTest {
		
		@Override
		protected IParser getParser() {
			return getPackratParser();
		}
	}
	
}
