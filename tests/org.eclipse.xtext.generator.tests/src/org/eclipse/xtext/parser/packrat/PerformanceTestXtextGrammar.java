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
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.tests.EcoreModelComparator;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PerformanceTestXtextGrammar extends AbstractGeneratorTest {

	private int iterations = 10;
	
	private String model;

	private StringInputStream modelAsStream;
	
	private XtextPackratParser packratParser;
	
	protected void setUp() throws Exception {
		with(XtextStandaloneSetup.class);
		model = readFileIntoString("org/eclipse/xtext/Xtext.xtext");
		modelAsStream = new StringInputStream(model);
		packratParser = new XtextPackratParser();
		setAstFactory(packratParser);
	}
	
	public void testSetUp() throws InterruptedException {
		assertNotNull(model);
		IParseResult packratResult = packratParser.parse(model);
		assertNotNull(packratResult);
		assertNotNull(packratResult.getRootASTElement());
		assertNotNull(packratResult.getRootNode());
		IParseResult antlrResult = getParser().parse(modelAsStream);
		assertNotNull(antlrResult);
		assertNotNull(antlrResult.getRootASTElement());
		assertNotNull(antlrResult.getRootNode());
		EcoreModelComparator comparator = new EcoreModelComparator();
		assertFalse(comparator.modelsDiffer(antlrResult.getRootASTElement(), packratResult.getRootASTElement()));
	}
	
	public void testAntlr() {
		for(int i = 0 ; i < iterations ; i++ ) {
			modelAsStream.mark(0);
			IParseResult result = getParser().parse(modelAsStream);
			assertNotNull(result);
			modelAsStream.reset();
		}
	}
	
	public void testPackrat() {
		for(int i = 0 ; i < iterations ; i++ ) {
			IParseResult result = packratParser.parse(model);
			assertNotNull(result);
		}
	}
}
