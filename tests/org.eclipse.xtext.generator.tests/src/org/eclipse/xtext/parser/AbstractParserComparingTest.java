/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.xtext.GenerateAllTestGrammars;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.tests.AbstractGeneratorTest;
import org.eclipse.xtext.util.EmfStructureComparator;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.StringInputStream;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParserComparingTest extends AbstractGeneratorTest {

	private IParser firstParser;
	private IParser secondParser;
	private ParserTestHelper firstHelper;
	private ParserTestHelper secondHelper;

	@Override
	protected void setUp() throws Exception {
		with(getStandaloneSetupClass());
		firstParser = createFirstParser();
		secondParser = createSecondParser();
		firstHelper = new ParserTestHelper(getResourceFactory(), firstParser);
		secondHelper = new ParserTestHelper(getResourceFactory(), secondParser);
	}

	protected abstract Class<?> getStandaloneSetupClass();

	protected abstract IParser createFirstParser();
	protected abstract IParser createSecondParser();
	
	protected abstract Iterable<Pair<String, String>> getAllModels();
	
	public void testCompareAllModels() throws Exception {
		EmfStructureComparator comparator = new EmfStructureComparator();
		for(Pair<String, String> pair: getAllModels()) {
			String model = pair.getSecond();
			XtextResource firstResult = firstHelper.getResourceFromStream(new StringInputStream(model));
			XtextResource secondResult = secondHelper.getResourceFromStream(new StringInputStream(model));
			checkResource(pair.getFirst() + " - " + getFirstParserName(), firstResult);
			checkResource(pair.getFirst() + " - " + getSecondParserName(), secondResult);
			comparator.assertSameStructure(firstResult.getParseResult().getRootASTElement(), firstResult.getParseResult().getRootASTElement());
		}
	}
	
	protected String getFirstParserName() {
		return firstParser.getClass().getSimpleName();
	}
	
	protected String getSecondParserName() {
		return secondParser.getClass().getSimpleName();
	}

	private void checkResource(String parserName, XtextResource resource) {
		assertTrue(parserName, resource.getErrors().isEmpty());
		assertNotNull(parserName, resource.getParseResult().getRootASTElement());
		assertNotNull(parserName, resource.getParseResult().getRootNode());
	}
}
