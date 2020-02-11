/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.parser;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.parser.impl.PartialParsingPointers;

/**
 * @author Jan Köhnlein - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public abstract class AbstractPartialParsingPointerTest extends AbstractPartialParserTest {
	
	protected PartialParsingPointers calculatePartialParsingPointers(String model, int changeRegionStart,
			int changeRegionSize) throws Exception {
		IParseResult parseResult = getParseResult(model);
		PartialParsingPointers partialParsingPointers = getPartialParser().calculatePartialParsingPointers(parseResult,
				changeRegionStart, changeRegionSize);
		return partialParsingPointers;
	}

	protected void checkParseRegionPointers(
			PartialParsingPointers parsingPointers, 
			String expectedRegion,
			String expectedGrammarElementClassName, 
			String expectedEntryRuleName) {

		assertEquals(expectedRegion, getReparseRegion(parsingPointers));
		EObject grammarElement = parsingPointers.getDefaultReplaceRootNode().getGrammarElement();
		String grammarElementName = grammarElement.eClass().getName();
		assertEquals(expectedGrammarElementClassName, grammarElementName);
		EObject ruleOrRuleCall = parsingPointers.findEntryRuleOrRuleCall(parsingPointers.getDefaultReplaceRootNode());
		if (ruleOrRuleCall instanceof RuleCall) {
			ruleOrRuleCall = ((RuleCall) ruleOrRuleCall).getRule();
		}
		assertEquals(expectedEntryRuleName, ((AbstractRule) ruleOrRuleCall).getName());
	}

}
