/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.packrat.ParseResultFactory;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.xtext.parser.handwritten.HandwrittenParser;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PerformanceTest extends AbstractGeneratorTest {

	private HandwrittenParser handwritten;
	
	private XtextGrammarTestLanguagePackratParser generated;

	private String model;
	
	private static int metamodelCount = 100;
	
	private static int lexerRuleCount = metamodelCount;

	@Override
	protected void setUp() throws Exception {
		with(XtextStandaloneSetup.class);
		this.handwritten = new HandwrittenParser();
		ParseResultFactory factory = new ParseResultFactory();
		factory.setFactory(getASTFactory());
		this.handwritten.setParseResultFactory(factory);
		this.generated = new XtextGrammarTestLanguagePackratParser();
		factory = new ParseResultFactory();
		factory.setFactory(getASTFactory());
		this.generated.setParseResultFactory(factory);
		StringBuilder modelBuilder = new StringBuilder("language a.bc.def.ghi extends e.fh.ijk\n");
		for(int i = 0; i < metamodelCount; i++) {
			if (i % 2 == 0)
				modelBuilder.append("import 'http://test' as mm" + i + "\n");
			else
				modelBuilder.append("generate test" + i + " 'http://test' as mm" + i + "\n");
		}
		for(int i = 0; i < lexerRuleCount; i++) {
			if (i % 2 == 0)
				modelBuilder.append("native lexer" + i + ": 'content';\n");
			else
				modelBuilder.append("lexer native" + i + " returns type" + i + ": \"otherContent\";");
		}
		this.model = modelBuilder.toString();
	}
	
	protected void tearDown() throws Exception {
		this.handwritten = null;
		this.model = null;
	}
	
	public void testFirstHandwrittenPackrat() {
		System.out.println("usage before: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
		IParseResult result = handwritten.parse(model);
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
		System.out.println("usage after: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
	}
	
	public void testSecondHandwrittenPackrat() {
		System.out.println("usage before: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
		IParseResult result = handwritten.parse(model);
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
		System.out.println("usage after: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
	}
	
	public void testFirstGeneratedPackrat() {
		System.out.println("usage before: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
		IParseResult result = handwritten.parse(model);
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
		System.out.println("usage after: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
	}
	
	public void testSecondGeneratedPackrat() {
		System.out.println("usage before: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
		IParseResult result = handwritten.parse(model);
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
		System.out.println("usage after: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
	}
	
	public void testFirstAntlr() {
		System.out.println("usage before: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
		IParseResult result = getParser().parse(new StringInputStream(model));
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
		System.out.println("usage after: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
	}
	
	public void testSecondAntlr() {
		System.out.println("usage before: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
		IParseResult result = getParser().parse(new StringInputStream(model));
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
		System.out.println("usage after: " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
	}
}
