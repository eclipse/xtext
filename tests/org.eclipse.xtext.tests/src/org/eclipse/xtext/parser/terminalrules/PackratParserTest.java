/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.terminalrules;

import java.io.InputStream;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.junit.AbstractXtextTests.Keys;
import org.eclipse.xtext.parser.ParserTestHelper;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.TerminalRulesTestLanguagePackratParser;
import org.eclipse.xtext.resource.XtextResource;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PackratParserTest extends ParserTest  {

	private TerminalRulesTestLanguagePackratParser parser;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		this.parser = get(TerminalRulesTestLanguagePackratParser.class);
	}

	@Override
	public XtextResource doGetResource(InputStream in, URI uri) throws Exception {
		ParserTestHelper helper = new ParserTestHelper(getResourceFactory(), parser, get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
		return helper.getResourceFromStream(in);
	}

}
