/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import static org.eclipse.xtext.parsetree.NodeUtil.dumpCompositeNodes;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.parsetree.PartialParsingPointers;
import org.eclipse.xtext.parsetree.PartialParsingUtil;
import org.eclipse.xtext.testlanguages.LookaheadLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.SimpleExpressionsStandaloneSetup;
import org.eclipse.xtext.tests.AbstractGeneratorTest;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class PartialParsingPointerTest extends AbstractGeneratorTest {

	public static final boolean DEBUG = false;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.xtext.tests.AbstractGeneratorTest#setUp()
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testExpression() throws Exception {
		with(SimpleExpressionsStandaloneSetup.class);
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, 1, 1);
		checkParseRegionPointers(parsingPointers, "a+b+c", "ActionImpl", "Addition", "Op", "Op", "values");

		parsingPointers = calculatePartialParsingPointers(model, 3, 1);
		checkParseRegionPointers(parsingPointers, "b", "Multiplication", "Multiplication", "Atom", "Op", "values");

		parsingPointers = calculatePartialParsingPointers(model, 5, 2);
		checkParseRegionPointers(parsingPointers, model, "Addition", "Addition", "Op", null, null);

		parsingPointers = calculatePartialParsingPointers(model, 6, 1);
		checkParseRegionPointers(parsingPointers, model, "Addition", "Addition", "Op", null, null);

		parsingPointers = calculatePartialParsingPointers(model, 8, 2);
		checkParseRegionPointers(parsingPointers, "(c/d)", "Term", "Term", "Op", "Op", "values");

		parsingPointers = calculatePartialParsingPointers(model, 9, 2);
		checkParseRegionPointers(parsingPointers, "c/d", "Addition", "Addition", "Op", "Op", "values");

	}

	public void testLookahead() throws Exception {
		with(LookaheadLanguageStandaloneSetup.class);
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 0; i < model.length(); ++i) {
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			if (i < 29) {
				checkParseRegionPointers(parsingPointers, model, "Entry", "Entry", "Entry", null, null);
			}
			else {
				checkParseRegionPointers(parsingPointers, " c", "LookAhead4", "LookAhead4", "LookAhead4", "LookAhead3",
						"contents");
			}
		}
	}

	private PartialParsingPointers calculatePartialParsingPointers(String model, int changeRegionStart,
			int changeRegionSize) throws Exception {
		CompositeNode rootNode = getRootNode(model);
		if (DEBUG) {
			dumpCompositeNodes("", rootNode);
			System.out.println(model);
			for (int k = 0; k < changeRegionStart; ++k) {
				System.out.print('#');
			}
			System.out.print(model.substring(changeRegionStart, changeRegionStart + changeRegionSize));
			for (int k = changeRegionStart + changeRegionSize; k < model.length(); ++k) {
				System.out.print('#');
			}
			System.out.println();
		}
		PartialParsingPointers partialParsingPointers = PartialParsingUtil.calculatePartialParsingPointers(rootNode,
				changeRegionStart, changeRegionSize);
		return partialParsingPointers;
	}

	private void checkParseRegionPointers(PartialParsingPointers parsingPointers, String expectedRegion,
			String expectedGrammarElementClassName, String expectedEntryRuleName,
			String expectedAstReplaceElementClassName, String expectedAstParentElementClassName,
			String expectedAstParentFeatureName) {

		if (DEBUG) {
			parsingPointers.dump();
		}
		assertEquals(expectedRegion, parsingPointers.findReparseRegion());
		EObject grammarElement = parsingPointers.getDefaultReplaceRootNode().getGrammarElement();
		String grammarElementName;
		try {
			grammarElementName = grammarElement.getClass().getMethod("getName").invoke(grammarElement).toString();
		}
		catch (Exception exc) {
			grammarElementName = grammarElement.getClass().getSimpleName();
		}
		assertEquals(expectedGrammarElementClassName, grammarElementName);
		assertEquals(expectedEntryRuleName, parsingPointers.findEntryRuleName());
		assertEquals(expectedAstReplaceElementClassName, parsingPointers.findASTReplaceElement().eClass().getName());
		EObject astParentElement = parsingPointers.findASTParentElement();
		String astParentElementClassName = astParentElement != null ? astParentElement.eClass().getName() : null;
		assertEquals(expectedAstParentElementClassName, astParentElementClassName);
		assertEquals(expectedAstParentFeatureName, parsingPointers.findASTContainmentFeatureName());
	}

}
