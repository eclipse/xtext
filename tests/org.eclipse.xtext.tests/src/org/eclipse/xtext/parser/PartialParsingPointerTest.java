/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import static org.eclipse.xtext.parsetree.NodeUtil.*;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;
import org.eclipse.xtext.parsetree.CompositeNode;
import org.eclipse.xtext.testlanguages.LookaheadTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.ReferenceGrammarTestLanguageStandaloneSetup;
import org.eclipse.xtext.testlanguages.SimpleExpressionsTestLanguageStandaloneSetup;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * 
 */
public class PartialParsingPointerTest extends AbstractPartialParserTest {
	
	private static final Logger logger = Logger.getLogger(PartialParsingPointerTest.class);

	public void testExpression() throws Exception {
		with(SimpleExpressionsTestLanguageStandaloneSetup.class);
		String model = "(a+b+c)*(c/d)";
		PartialParsingPointers parsingPointers;
		
		parsingPointers = calculatePartialParsingPointers(model, 1, 1);
		checkParseRegionPointers(parsingPointers, "(a+b+c)", "RuleCallImpl", "Parens", "Op", "Op", "values");

		parsingPointers = calculatePartialParsingPointers(model, 3, 1);
		checkParseRegionPointers(parsingPointers, "b", "RuleCallImpl", "Multiplication", "Atom", "Op", "values");

		parsingPointers = calculatePartialParsingPointers(model, 5, 2);
		checkParseRegionPointers(parsingPointers, "(a+b+c)", "RuleCallImpl", "Parens", "Op", "Op", "values");

		parsingPointers = calculatePartialParsingPointers(model, 6, 1);
		checkParseRegionPointers(parsingPointers, "(a+b+c)", "RuleCallImpl", "Parens", "Op", "Op", "values");

		parsingPointers = calculatePartialParsingPointers(model, 8, 2);
		checkParseRegionPointers(parsingPointers, "(c/d)", "RuleCallImpl", "Term", "Op", "Op", "values");

		parsingPointers = calculatePartialParsingPointers(model, 9, 2);
		checkParseRegionPointers(parsingPointers, "(c/d)", "RuleCallImpl", "Parens", "Op", "Op", "values");

		model = "a b";
		parsingPointers = calculatePartialParsingPointers(model, 1, 1);
		checkParseRegionPointers(parsingPointers, "a b", "ActionImpl", "Sequence", "Sequence", null, null);
	}

	public void testLookahead() throws Exception {
		with(LookaheadTestLanguageStandaloneSetup.class);
		String model = "bar a foo bar c b d foo bar b c";
		for (int i = 0; i < model.length(); ++i) {
			logger.debug(i);
			PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, i, 1);
			if (i < 3) {
				checkParseRegionPointers(parsingPointers, model, "Entry", "Entry", "Entry", null, null);
			}
			else if (i < 5) {
				checkParseRegionPointers(parsingPointers, "bar a", "RuleCallImpl", "LookAhead0", "LookAhead0", "Entry",
						"contents");
			}
			else if (i < 9) {
				checkParseRegionPointers(parsingPointers, model, "Entry", "Entry", "Entry", null, null);
			}
			else if (i < 15) {
				checkParseRegionPointers(parsingPointers, " foo bar c b d", "RuleCallImpl", "Alts", "LookAhead1", "Entry",
						"contents");
			}
			else if (i < 19) {
				checkParseRegionPointers(parsingPointers, " foo bar c b d", "RuleCallImpl", "LookAhead1", "LookAhead1",
						"Entry", "contents");
			}
			else if (i < 23) {
				checkParseRegionPointers(parsingPointers, model, "Entry", "Entry", "Entry", null, null);
			}
			else if (i < 29) {
				checkParseRegionPointers(parsingPointers, " foo bar b c", "RuleCallImpl", "Alts", "LookAhead3", "Entry",
						"contents");
			}
			else {
				checkParseRegionPointers(parsingPointers, " foo bar b c", "RuleCallImpl", "LookAhead3", "LookAhead3", "Entry",
				"contents");
			}
		}
	}

	public void testReference() throws Exception {
		with(ReferenceGrammarTestLanguageStandaloneSetup.class);
		String model = "spielplatz 17 { kind ( Dennis 6 ) kind ( Sven 7 ) }";
		PartialParsingPointers parsingPointers = calculatePartialParsingPointers(model, model.indexOf("Sven"), 4);
		checkParseRegionPointers(parsingPointers, " kind ( Sven 7 )", "RuleCallImpl", "Kind", "Kind", "Spielplatz", "kinder");
	}

	private PartialParsingPointers calculatePartialParsingPointers(String model, int changeRegionStart,
			int changeRegionSize) throws Exception {
		CompositeNode rootNode = getRootNode(model);
		if (DEBUG) {
			dumpCompositeNodes("", rootNode);
			logger.debug(model);
			String line = "";
			for (int k = 0; k < changeRegionStart; ++k) {
				line += "#";
			}
			line += model.substring(changeRegionStart, changeRegionStart + changeRegionSize);
			for (int k = changeRegionStart + changeRegionSize; k < model.length(); ++k) {
				line += "#";
			}
			logger.debug(line);
		}
		PartialParsingPointers partialParsingPointers = partialParser.calculatePartialParsingPointers(rootNode,
				changeRegionStart, changeRegionSize);
		return partialParsingPointers;
	}

	@SuppressWarnings("unchecked")
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
		String containmentFeatureName = parsingPointers.findASTContainmentFeatureName();
		assertEquals(expectedAstParentFeatureName, containmentFeatureName);
		if (astParentElement != null) {
			EStructuralFeature containmentFeature = astParentElement.eClass().getEStructuralFeature(
					containmentFeatureName);
			if (containmentFeature.isMany()) {
				assertTrue(((List<EObject>) astParentElement.eGet(containmentFeature)).contains(parsingPointers
						.findASTReplaceElement()));
			}
			else {
				assertTrue(astParentElement.eGet(containmentFeature).equals(parsingPointers.findASTReplaceElement()));
			}
		}
	}

}
