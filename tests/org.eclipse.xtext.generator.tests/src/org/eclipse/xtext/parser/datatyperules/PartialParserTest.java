/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialParserTest extends AbstractGeneratorTest {
	
	private String model;
	private XtextResource resource;
	private CompositeNode rootNode;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(DatatypeRulesTestLanguageStandaloneSetup.class);
		model = "a.b.c.d: 123;\n" +
				"e.f.g.h: 456;";
		resource = getResourceFromString(model);
		rootNode = resource.getParseResult().getRootNode();
	}
	
	public void testSetUp() {
		assertTrue(resource.getErrors().isEmpty());
	}
	
	public void testInsertSlashInFirstNode() {
		IParseResult parseResult = resource.getParser().reparse(rootNode, model.indexOf('3'), 0, "/");
		assertTrue(parseResult.getParseErrors().isEmpty());
		assertEquals(0, parseResult.getRootNode().getOffset());
		assertNotSame(resource.getParseResult().getRootNode(), parseResult.getRootNode());
	}
	
	public void testInsertSlashInSecondNode() {
		IParseResult parseResult = resource.getParser().reparse(rootNode, model.indexOf('6'), 0, "/");
		assertTrue(parseResult.getParseErrors().isEmpty());
		assertEquals(0, parseResult.getRootNode().getOffset());
		assertNotSame(resource.getParseResult().getRootNode(), parseResult.getRootNode());
	}

}
