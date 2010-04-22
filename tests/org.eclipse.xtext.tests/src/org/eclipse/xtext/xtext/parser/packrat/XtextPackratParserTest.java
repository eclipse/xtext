/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser.packrat;

import java.io.StringReader;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.packrat.XtextPackratParser;
import org.eclipse.xtext.util.EmfFormatter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextPackratParserTest extends AbstractXtextTests {

	private XtextPackratParser parser;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextStandaloneSetup.class);
		this.parser = get(XtextPackratParser.class);
	}

	public void testParse_01() throws Exception {
		String model = "/* comment */ grammar a.bc.def with c.ef.ghi terminal a: 'b';";
		parseAndCompareToAntlr(model);
	}

	private void parseAndCompareToAntlr(String model) throws Exception {
		IParseResult parseResult = parser.parse(model);
		assertNotNull(parseResult);
		assertNotNull(parseResult.getRootNode());
		assertNotNull(parseResult.getRootASTElement());
		String rootNode = EmfFormatter.objToStr(parseResult.getRootASTElement());
//		printParseResult(parseResult);
		IParseResult orig = getParser().parse(new StringReader(model));
		String origRootNode = EmfFormatter.objToStr(orig.getRootASTElement());
		assertEquals("Model: '" + model + "'", origRootNode, rootNode);
	}

//	private void printParseResult(IParseResult parseResult) {
//		System.out.println("==== " + getName() + " ====");
//		System.out.println(EmfFormater.objToStr(parseResult.getRootNode(), "  "));
//		System.out.println(EmfFormater.objToStr(parseResult.getRootASTElement(), "  "));
//	}

	public void testParse_02() throws Exception {
		String model = "/* comment */ grammar a terminal c returns d: \"xy\";";
		parseAndCompareToAntlr(model);
	}

	public void testParse_03() throws Exception {
		String model = "grammar test generate test 'test' as test terminal a: 'b'; terminal c: 'd';";
		parseAndCompareToAntlr(model);
	}

	public void testParse_04() throws Exception {
		String model = "grammar test generate test 'test' as test generate test2 'test2' " +
				"terminal asdbdferdsfae00011 returns asdfaefadfaefdasefasdfasf: 'asdfkja akljsdfl kajlsjdf lajsdlfjlakjdfkl ';";
		parseAndCompareToAntlr(model);
	}

	public void testParse_05() throws Exception {
		String model = "grammar a1 terminal a1: 'b1';";
		parseAndCompareToAntlr(model);
	}

	public void testParse_06() throws Exception {
		String model = "grammar a terminal a: 'b';";
		parseAndCompareToAntlr(model);
	}

	public void testXtextGrammar() throws Exception {
		String filename = "org/eclipse/xtext/Xtext.xtext";
		String model = readFileIntoString(filename);
		parseAndCompareToAntlr(model);
	}

	public void _testXtextGrammarPerformance() throws Exception {
		String filename = "org/eclipse/xtext/Xtext.xtext";
		String model = readFileIntoString(filename);
		for (int i = 0; i < 1000; i++) {
			IParseResult parseResult = parser.parse(model);
			assertNotNull(parseResult);
			assertNotNull(parseResult.getRootNode());
			assertNotNull(parseResult.getRootASTElement());
		}
	}

	public void _testXtextGrammarPerformanceAntlr() throws Exception {
		String filename = "org/eclipse/xtext/Xtext.xtext";
		String model = readFileIntoString(filename);
		for (int i = 0; i < 1000; i++) {
			IParseResult parseResult = getParser().parse(new StringReader(model));
			assertNotNull(parseResult);
			assertNotNull(parseResult.getRootNode());
			assertNotNull(parseResult.getRootASTElement());
		}
	}

}
