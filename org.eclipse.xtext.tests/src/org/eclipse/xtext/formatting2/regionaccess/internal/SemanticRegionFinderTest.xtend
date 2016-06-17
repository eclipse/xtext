/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting2.regionaccess.internal

import com.google.common.collect.ImmutableList
import com.google.inject.Inject
import com.google.inject.Provider
import java.util.Collection
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Expression
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess
import org.eclipse.xtext.resource.XtextResource
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.junit.Test
import org.junit.runner.RunWith

import static org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage.Literals.*
import static org.junit.Assert.*

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(RegionAccessTestLanguageInjectorProvider)
class SemanticRegionFinderTest {
	@Inject extension ParseHelper<Root> parseHelper
	@Inject Provider<TextRegionAccessBuilder> textRegionAccessBuilder
	@Inject extension ValidationTestHelper validationTestHelper
	@Inject extension RegionAccessTestLanguageGrammarAccess

	@Test def void regionForFeatureAttribute() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.feature(MIXED__NAME)
		val actuals = finder.features(MIXED__NAME)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForFeatureCrossReference() {
		val mixed = '''6 (ref foo) action (foo) end'''.parseAs(AssignedAction)
		val finder = mixed.toAccess.regionForEObject(mixed.child)
		val actual = finder.regionFor.feature(MIXED__REF)
		val actuals = finder.regionFor.features(MIXED__REF)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForFeatureContainmentReference() {
		val mixed = '''6 (foo) action'''.parseAs(AssignedAction)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		try {
			finder.feature(ASSIGNED_ACTION__CHILD)
			fail()
		} catch (IllegalStateException e) {
		}
		try {
			finder.features(ASSIGNED_ACTION__CHILD)
			fail()
		} catch (IllegalStateException e) {
		}
	}

	@Test def void regionForRuleCallUnassignedTerminal() {
		val mixed = '''6 (unassigned foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.ruleCall(mixedAccess.IDTerminalRuleCall_1_1_0)
		val actuals = finder.ruleCalls(mixedAccess.IDTerminalRuleCall_1_1_0)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForRuleCallToUnassignedTerminal() {
		val mixed = '''6 (unassigned foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.ruleCallTo(IDRule)
		val actuals = finder.ruleCallsTo(IDRule)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForRuleCallUnassignedDataType() {
		val mixed = '''6 (unassigned datatype foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.ruleCall(mixedAccess.datatypeParserRuleCall_1_1_1)
		val actuals = finder.ruleCalls(mixedAccess.datatypeParserRuleCall_1_1_1)
		assertEquals("datatype foo", actual, actuals)
	}

	@Test def void regionForRuleCallToUnassignedDataType() {
		val mixed = '''6 (unassigned datatype foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.ruleCallTo(datatypeRule)
		val actuals = finder.ruleCallsTo(datatypeRule)
		assertEquals("datatype foo", actual, actuals)
	}

	@Test def void regionForRuleCallAssignedTerminal() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.ruleCall(mixedAccess.nameIDTerminalRuleCall_2_2_0_0)
		val actuals = finder.ruleCall(mixedAccess.nameIDTerminalRuleCall_2_2_0_0)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForRuleCallToAssignedTerminal() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.ruleCallTo(IDRule)
		val actuals = finder.ruleCallTo(IDRule)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForRuleCallAssignedDataType() {
		val mixed = '''6 (datatype foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.ruleCall(mixedAccess.datatypeDatatypeParserRuleCall_2_2_2_0)
		val actuals = finder.ruleCall(mixedAccess.datatypeDatatypeParserRuleCall_2_2_2_0)
		assertEquals("datatype foo", actual, actuals)
	}

	@Test def void regionForRuleCallToAssignedDataType() {
		val mixed = '''6 (datatype foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.ruleCallTo(datatypeRule)
		val actuals = finder.ruleCallTo(datatypeRule)
		assertEquals("datatype foo", actual, actuals)
	}

	@Test def void regionForRuleCallCrossReference() {
		val mixed = '''6 (ref foo) action (foo) end'''.parseAs(AssignedAction)
		val finder = mixed.toAccess.regionForEObject(mixed.child).regionFor
		val actual = finder.ruleCall(mixedAccess.refMixedIDTerminalRuleCall_2_2_3_1_0_1)
		val actuals = finder.ruleCalls(mixedAccess.refMixedIDTerminalRuleCall_2_2_3_1_0_1)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForRuleCallToCrossReference() {
		val mixed = '''6 (ref foo) action (foo) end'''.parseAs(AssignedAction)
		val finder = mixed.toAccess.regionForEObject(mixed.child).regionFor
		val actual = finder.ruleCallTo(IDRule)
		val actuals = finder.ruleCallsTo(IDRule)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForRuleCallEObjectParserRule() {
		val mixed = '''6 (child (foo))'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		try {
			finder.ruleCall(mixedAccess.eobjMixedParserRuleCall_2_2_1_1_0)
			fail()
		} catch (IllegalStateException e) {
		}
		try {
			finder.ruleCalls(mixedAccess.eobjMixedParserRuleCall_2_2_1_1_0)
			fail()
		} catch (IllegalStateException e) {
		}
	}

	@Test def void regionForRuleCallToEObjectParserRule() {
		val mixed = '''6 (child (foo))'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		try {
			finder.ruleCallTo(mixedRule)
			fail()
		} catch (IllegalStateException e) {
		}
		try {
			finder.ruleCallsTo(mixedRule)
			fail()
		} catch (IllegalStateException e) {
		}
	}

	@Test def void regionForKeywordString() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.keyword("(")
		val actuals = finder.keywords("(")
		assertEquals("(", actual, actuals)
	}

	@Test def void regionForKeyword() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.keyword(mixedAccess.leftParenthesisKeyword_0)
		val actuals = finder.keywords(mixedAccess.leftParenthesisKeyword_0)
		assertEquals("(", actual, actuals)
	}

	@Test def void regionForCrossReference() {
		val mixed = '''6 (ref foo) action (foo) end'''.parseAs(AssignedAction)
		val finder = mixed.toAccess.regionForEObject(mixed.child).regionFor
		val actual = finder.crossRef(mixedAccess.refMixedCrossReference_2_2_3_1_0)
		val actuals = finder.crossRefs(mixedAccess.refMixedCrossReference_2_2_3_1_0)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForAssignment() {
		val mixed = '''6 (foo)'''.parseAs(Mixed)
		val finder = mixed.toAccess.regionForEObject(mixed).regionFor
		val actual = finder.assignment(mixedAccess.nameAssignment_2_2_0)
		val actuals = finder.assignments(mixedAccess.nameAssignment_2_2_0)
		assertEquals("foo", actual, actuals)
	}

	@Test def void regionForKeywordPairs() {
		val extension rule = parenthesizedAccess
		val expr = '''5 (foo)'''.parseAs(Expression)
		val finder = expr.toAccess.regionForEObject(expr).regionFor
		val actual1 = finder.keywordPairs("(", ")").pairsToString
		val actual2 = finder.keywordPairs(leftParenthesisKeyword_0, rightParenthesisKeyword_2).pairsToString
		val expected = "(foo)"
		assertEquals(expected, actual1)
		assertEquals(expected, actual2)
	}

	@Test def void regionForKeywordPairs2() {
		val extension rule = parenthesizedAccess
		val expr = '''5 (a + ((b) + c) + d)'''.parseAs(Expression)
		val finder = expr.toAccess.regionForRootEObject.allRegionsFor
		val actual1 = finder.keywordPairs("(", ")").pairsToString
		val actual2 = finder.keywordPairs(leftParenthesisKeyword_0, rightParenthesisKeyword_2).pairsToString
		val expected = "(b); ((b) + c); (a + ((b) + c) + d)"
		assertEquals(expected, actual1)
		assertEquals(expected, actual2)
	}

	def private String pairsToString(Iterable<Pair<ISemanticRegion, ISemanticRegion>> pairs) {
		pairs.map[key.merge(value).text].join("; ")
	}

	def private <T extends EObject> parseAs(CharSequence seq, Class<T> cls) {
		val result = seq.parse
		result.assertNoErrors
		return cls.cast(result)
	}

	def private ITextRegionAccess toAccess(EObject obj) {
		return textRegionAccessBuilder.get.forNodeModel(obj.eResource as XtextResource).create
	}

	def private void assertEquals(String expected, ITextSegment single, Collection<? extends ITextSegment> regions) {
		assertEquals(expected, single.text)
		assertEquals(1, regions.size)
		assertEquals(expected, regions.head.text)
		assertTrue(regions instanceof ImmutableList<?>)
	}
}