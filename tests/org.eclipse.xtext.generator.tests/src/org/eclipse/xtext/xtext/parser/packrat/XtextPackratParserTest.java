/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser.packrat;

import org.eclipse.xtext.XtextGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.packrat.ParseResultFactory;
import org.eclipse.xtext.parser.packrat.XtextGrammarTestLanguagePackratParser;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.EmfFormater;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XtextPackratParserTest extends AbstractGeneratorTest {
	
//	private XtextPackratParser parser;
	private XtextGrammarTestLanguagePackratParser parser;

	@Override
	protected void setUp() throws Exception {
		with(XtextGrammarTestLanguageStandaloneSetup.class);
		this.parser = new XtextGrammarTestLanguagePackratParser();
		ParseResultFactory factory = new ParseResultFactory();
		factory.setFactory(getASTFactory());
		this.parser.setParseResultFactory(factory);
	}

	public void testParse_01() {
		IParseResult parseResult = parser.parse("/* comment */ language a.bc.def extends c.ef.ghi lexer a: 'b';");
		assertNotNull(parseResult);
		assertNotNull(parseResult.getRootNode());
		assertNotNull(parseResult.getRootASTElement());
		printParseResult(parseResult);
	}

	private void printParseResult(IParseResult parseResult) {
		System.out.println("==== " + getName() + " ====");
		System.out.println(EmfFormater.objToStr(parseResult.getRootNode(), "  "));
		System.out.println(EmfFormater.objToStr(parseResult.getRootASTElement(), "  "));
	}
	
	public void testParse_02() {
		IParseResult parseResult = parser.parse("/* comment */ abstract language a native c returns d: \"xy\";");
		assertNotNull(parseResult);
		assertNotNull(parseResult.getRootNode());
		assertNotNull(parseResult.getRootASTElement());
		printParseResult(parseResult);
	}
	
	public void testParse_03() {
		IParseResult parseResult = parser.parse("language test generate test 'test' as test lexer a: 'b'; lexer c: 'd';");
		assertNotNull(parseResult);
		assertNotNull(parseResult.getRootNode());
		assertNotNull(parseResult.getRootASTElement());
		printParseResult(parseResult);
	}
	
	public void testParse_04() {
		IParseResult parseResult = parser.parse("language test generate test 'test' as test generate test2 'test2' " +
				"lexer asdbdferdsfae00011 returns asdfaefadfaefdasefasdfasf: 'asdfkja akljsdfl kajlsjdf lajsdlfjlakjdfkl ';");
		assertNotNull(parseResult);
		assertNotNull(parseResult.getRootNode());
		assertNotNull(parseResult.getRootASTElement());
		printParseResult(parseResult);
	}
	
	public void testParse_05() {
		IParseResult parseResult = parser.parse("language a1 lexer a1: 'b1';");
		assertNotNull(parseResult);
		assertNotNull(parseResult.getRootNode());
		assertNotNull(parseResult.getRootASTElement());
		printParseResult(parseResult);
	}
	
	public void testParse_06() {
		IParseResult parseResult = parser.parse("language a lexer a: 'b';");
		assertNotNull(parseResult);
		assertNotNull(parseResult.getRootNode());
		assertNotNull(parseResult.getRootASTElement());
		printParseResult(parseResult);
	}

}
