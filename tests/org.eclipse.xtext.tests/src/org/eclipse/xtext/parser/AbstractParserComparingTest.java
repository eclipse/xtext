/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser;

import java.util.Iterator;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.ISetup;
import org.eclipse.xtext.junit.AbstractXtextTests;
import org.eclipse.xtext.parsetree.ParsetreePackage;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.EmfFormatter;
import org.eclipse.xtext.util.EmfStructureComparator;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.StringInputStream;
import org.eclipse.xtext.util.Wrapper;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParserComparingTest extends AbstractXtextTests {

	private IParser firstParser;
	private IParser secondParser;
	private ParserTestHelper firstHelper;
	private ParserTestHelper secondHelper;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		with(getStandaloneSetupClass());
		firstParser = createFirstParser();
		secondParser = createSecondParser();
		firstHelper = new ParserTestHelper(getResourceFactory(), firstParser, get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
		secondHelper = new ParserTestHelper(getResourceFactory(), secondParser, get(Keys.RESOURCE_SET_KEY),getCurrentFileExtension());
	}

	protected abstract Class<? extends ISetup> getStandaloneSetupClass();

	protected abstract IParser createFirstParser();
	protected abstract IParser createSecondParser();

	protected abstract Iterator<Pair<String, String>> getAllModels();

	public void testCompareAllModels() throws Exception {
		final Wrapper<String> modelName = Wrapper.forType(String.class);
		EmfStructureComparator comparator = new EmfStructureComparator() {
			@Override
			protected String getErrorMessage() {
				return modelName.get() + " - " + super.getErrorMessage();
			}
		};
		Iterator<Pair<String, String>> iter = getAllModels();
		while(iter.hasNext()) {
			Pair<String, String> pair = iter.next();
			String model = pair.getSecond();
			modelName.set(pair.getFirst() + "(" + getFirstParserName() + " / " + getSecondParserName() + ")");
			try {
				XtextResource firstResult = firstHelper.getResourceFromStream(new StringInputStream(model));
				XtextResource secondResult = secondHelper.getResourceFromStream(new StringInputStream(model));
				checkResource(pair.getFirst() + " - " + getFirstParserName(), firstResult);
				checkResource(pair.getFirst() + " - " + getSecondParserName(), secondResult);

				String firstNodeResultAsString = EmfFormatter.objToStr(firstResult.getParseResult().getRootNode(), getIgnoredFeatures());
				String secondNodeResultAsString = EmfFormatter.objToStr(secondResult.getParseResult().getRootNode(), getIgnoredFeatures());
				assertEquals(modelName.get(), firstNodeResultAsString, secondNodeResultAsString);

				String firstResultAsString = EmfFormatter.objToStr(firstResult.getParseResult().getRootASTElement());
				String secondResultAsString = EmfFormatter.objToStr(secondResult.getParseResult().getRootASTElement());
				assertEquals(modelName.get(), firstResultAsString, secondResultAsString);

				comparator.assertSameStructure(firstResult.getParseResult().getRootASTElement(), secondResult.getParseResult().getRootASTElement());
				comparator.assertSameStructure(firstResult.getParseResult().getRootNode(), secondResult.getParseResult().getRootNode());
			} catch (Exception e) {
				throw new RuntimeException(modelName.get(), e);
			}
		}
	}

	protected EStructuralFeature[] getIgnoredFeatures() {
		return new EStructuralFeature[]{ ParsetreePackage.eINSTANCE.getCompositeNode_LookaheadLeafNodes() };
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
