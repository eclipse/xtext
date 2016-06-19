/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractXtextTests;
import org.eclipse.xtext.tests.EmfAssert;
import org.eclipse.xtext.util.ReplaceRegion;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PartialParserTest extends AbstractXtextTests {
	
	private String model;
	private XtextResource resource;
	private IParseResult parseResult;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(DatatypeRulesTestLanguageStandaloneSetup.class);
		model = "a.b.c.d: 123;\n" +
				"e.f.g.h: 456;";
		resource = getResourceFromString(model);
		parseResult = resource.getParseResult();
	}
	
	@Test public void testSetUp() {
		assertTrue(resource.getErrors().isEmpty());
	}
	
	@Test public void testInsertSlashInFirstNode() throws Exception {
		IParseResult parseResult = resource.getParser().reparse(this.parseResult, new ReplaceRegion(model.indexOf('3'), 0, "/"));
		assertFalse(parseResult.hasSyntaxErrors());
		assertEquals(0, parseResult.getRootNode().getTotalOffset());
		assertSame(resource.getParseResult().getRootNode(), parseResult.getRootNode());
		String newModel = 
			"a.b.c.d: 12/3;\n" +
			"e.f.g.h: 456;";
		EmfAssert.assertEObjectsEqual(getModel(newModel), resource.getParseResult().getRootASTElement());
	}
	
	@Test public void testInsertSlashInSecondNode() throws Exception {
		IParseResult parseResult = resource.getParser().reparse(this.parseResult, new ReplaceRegion(model.indexOf('6'), 0, "/"));
		assertFalse(parseResult.hasSyntaxErrors());
		assertEquals(0, parseResult.getRootNode().getTotalOffset());
		assertSame(resource.getParseResult().getRootNode(), parseResult.getRootNode());
		String newModel = 
			"a.b.c.d: 123;\n" +
			"e.f.g.h: 45/6;";
		EmfAssert.assertEObjectsEqual(getModel(newModel), resource.getParseResult().getRootASTElement());
	}

}
