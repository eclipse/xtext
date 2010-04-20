/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.datatyperules;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit.AbstractXtextTests.Keys;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.DatatypeRulesTestLanguagePackratParser;
import org.eclipse.xtext.parser.packrat.ParseResultFactory;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PackratParserTest extends ParserTest {

	private DatatypeRulesTestLanguagePackratParser parser;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.parser = get(DatatypeRulesTestLanguagePackratParser.class);
		ParseResultFactory factory = new ParseResultFactory();
		factory.setFactory(getASTFactory());
	}

	@Override
	public void testParseWithFractionErrorAndSyntaxError() {
		assertTrue("TODO SZ", true);
	}

	@Override
	public void testParseErrors_01() throws Exception {
		assertTrue("TODO SZ", true);
	}

	@Override
	public void testParseErrors_02() throws Exception {
		assertTrue("TODO SZ", true);
	}

	@Override
	public void testParseErrors_03() throws Exception {
		assertTrue("TODO SZ", true);
	}

	@Override
	public void testParseErrors_04() throws Exception {
		assertTrue("TODO SZ", true);
	}

	@Override
	public XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		ParserTestHelper helper = new ParserTestHelper(getResourceFactory(), parser, get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
		return helper.getResourceFromStream(in);
	}

}
