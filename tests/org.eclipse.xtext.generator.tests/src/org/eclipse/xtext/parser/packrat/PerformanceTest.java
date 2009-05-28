/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.terminalrules.XtextTerminalsTestLanguageStandaloneSetup;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.XtextTerminalsTestLanguagePackratParser;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PerformanceTest extends AbstractGeneratorTest {

	private XtextTerminalsTestLanguagePackratParser generatedWithTerminals;

	private String model;

	private static int metamodelCount = 200;

	private static int lexerRuleCount = metamodelCount;

	private long startTime;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(XtextTerminalsTestLanguageStandaloneSetup.class);
		this.generatedWithTerminals = get(XtextTerminalsTestLanguagePackratParser.class);
		StringBuilder modelBuilder = new StringBuilder("grammar a.bc.def.ghi with e.fh.ijk\n");
		for(int i = 0; i < metamodelCount; i++) {
			if (i % 2 == 0)
				modelBuilder.append("import 'http://test' as mm" + i + "\n");
			else
				modelBuilder.append("generate test" + i + " 'http://test' as mm" + i + "\n");
		}
		for(int i = 0; i < lexerRuleCount; i++) {
			modelBuilder.append("terminal lexer" + i + ": 'content';\n");
		}
		this.model = modelBuilder.toString();
		System.gc();
		if (metamodelCount >= 1000)
			Thread.sleep(2000); // increase chance for the gc to collect unused objects
		System.out.println("===== " + getName() + " =====");
		System.out.println("model.length(): " + model.length() + " chars (ca. " + (metamodelCount * 2)+ " lines)" );
		System.out.println("usage before:   " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
		startTime = System.currentTimeMillis();
	}

	@Override
	protected void tearDown() throws Exception {
		long endTime = System.currentTimeMillis();
		System.out.println("usage after:    " + (java.lang.Runtime.getRuntime().totalMemory() - java.lang.Runtime.getRuntime().freeMemory()));
		System.out.println("duration:               " + (endTime - startTime) + " ms");
		this.model = null;
		super.tearDown();
	}

	private void doTest(AbstractPackratParser parser) {
		IParseResult result = parser.parse(model);
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
	}

//	public void testProfile() {
//		testFirstGeneratedWithTerminalsPackrat();
//		for (int i = 0; i < 10; i++)
//			testGeneratedWithTerminalsPackratTwice();
//	}

	public void testFirstGeneratedWithTerminalsPackrat() {
		doTest(generatedWithTerminals);
	}

	public void testSecondGeneratedWithTerminalsPackrat() {
		doTest(generatedWithTerminals);
	}

	public void testGeneratedWithTerminalsPackratTwice() {
		for (int i = 0; i < 2; i++) {
			doTest(generatedWithTerminals);
		}
	}

	public void testFirstAntlr() {
		IParseResult result = getParser().parse(new StringInputStream(model));
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
	}

	public void testSecondAntlr() {
		IParseResult result = getParser().parse(new StringInputStream(model));
		assertNotNull(result);
		assertNotNull(result.getRootASTElement());
		assertNotNull(result.getRootNode());
	}

	public void testAntlrTwice() {
		for (int i = 0; i < 2; i++) {
			IParseResult result = getParser().parse(new StringInputStream(model));
			assertNotNull(result);
			assertNotNull(result.getRootASTElement());
			assertNotNull(result.getRootNode());
			result = null;
		}
	}
}
