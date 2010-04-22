/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import java.io.StringReader;

import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.terminalrules.XtextTerminalsTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.XtextTerminalsTestLanguagePackratParser;
import org.eclipse.xtext.tests.EmfAssert;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PerformanceTestXtextGrammar extends AbstractXtextTests {

	private final int iterations = 20;

	private String model;


	private XtextTerminalsTestLanguagePackratParser packratParser;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextTerminalsTestLanguageStandaloneSetup.class);
		model = readFileIntoString("org/eclipse/xtext/Xtext.xtext");
		packratParser = get(XtextTerminalsTestLanguagePackratParser.class);
	}

	public void testSetUp() throws InterruptedException {
		assertNotNull(model);
		StringReader modelAsStream = new StringReader(model);
		IParseResult packratResult = packratParser.parse(model);
		assertNotNull(packratResult);
		assertNotNull(packratResult.getRootASTElement());
		assertNotNull(packratResult.getRootNode());
		IParseResult antlrResult = getParser().parse(modelAsStream);
		assertNotNull(antlrResult);
		assertNotNull(antlrResult.getRootASTElement());
		assertNotNull(antlrResult.getRootNode());
		EmfAssert.assertEObjectsEqual(antlrResult.getRootASTElement(), packratResult.getRootASTElement());
	}

	public void testAntlr() {
		for(int i = 0 ; i < iterations ; i++ ) {
			StringReader modelAsStream = new StringReader(model);
			IParseResult result = getParser().parse(modelAsStream);
			assertNotNull(result);
		}
	}

	public void testPackrat() {
		for(int i = 0 ; i < iterations ; i++ ) {
			IParseResult result = packratParser.parse(model);
			assertNotNull(result);
		}
	}
}
