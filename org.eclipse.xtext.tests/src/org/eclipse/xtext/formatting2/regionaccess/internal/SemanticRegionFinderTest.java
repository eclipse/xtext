/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Expression;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess;
import org.eclipse.xtext.formatting2.regionaccess.internal.tests.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
public class SemanticRegionFinderTest {
	@Inject
	private ParseHelper<Root> parseHelper;

	@Inject
	private Provider<TextRegionAccessBuilder> textRegionAccessBuilder;

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Inject
	private RegionAccessTestLanguageGrammarAccess grammarAccess;

	@Test
	public void regionForFeatureAttribute() throws Exception {
		Mixed mixed = parseAs("6 (foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder.feature(RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
		List<ISemanticRegion> actuals = finder.features(RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
		assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForFeatureCrossReference() throws Exception {
		AssignedAction mixed = parseAs("6 (ref foo) action (foo) end", AssignedAction.class);
		IEObjectRegion finder = toAccess(mixed).regionForEObject(mixed.getChild());
		ISemanticRegion actual = finder.getRegionFor().feature(RegionaccesstestlanguagePackage.Literals.MIXED__REF);
		List<ISemanticRegion> actuals = finder.getRegionFor()
				.features(RegionaccesstestlanguagePackage.Literals.MIXED__REF);
		assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForFeatureContainmentReference() throws Exception {
		AssignedAction mixed = parseAs("6 (foo) action", AssignedAction.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		try {
			finder.feature(RegionaccesstestlanguagePackage.Literals.ASSIGNED_ACTION__CHILD);
			Assert.fail();
		} catch (IllegalStateException e) {
			// ok
		}
		try {
			finder.features(RegionaccesstestlanguagePackage.Literals.ASSIGNED_ACTION__CHILD);
			Assert.fail();
		} catch (IllegalStateException e) {
			// ok
		}
	}

	@Test
	public void regionForRuleCallUnassignedTerminal() throws Exception {
		Mixed mixed = parseAs("6 (unassigned foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder
				.ruleCall(grammarAccess.getMixedAccess().getIDTerminalRuleCall_1_1_0());
		List<ISemanticRegion> actuals = finder
				.ruleCalls(grammarAccess.getMixedAccess().getIDTerminalRuleCall_1_1_0());
		assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallToUnassignedTerminal() throws Exception {
		Mixed mixed = parseAs("6 (unassigned foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder.ruleCallTo(grammarAccess.getIDRule());
		List<ISemanticRegion> actuals = finder.ruleCallsTo(grammarAccess.getIDRule());
		assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallUnassignedDataType() throws Exception {
		Mixed mixed = parseAs("6 (unassigned datatype foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder.ruleCall(
				grammarAccess.getMixedAccess().getDatatypeParserRuleCall_1_1_1());
		List<ISemanticRegion> actuals = finder.ruleCalls(
				grammarAccess.getMixedAccess().getDatatypeParserRuleCall_1_1_1());
		assertEquals("datatype foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallToUnassignedDataType() throws Exception {
		Mixed mixed = parseAs("6 (unassigned datatype foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder.ruleCallTo(grammarAccess.getDatatypeRule());
		List<ISemanticRegion> actuals = finder
				.ruleCallsTo(grammarAccess.getDatatypeRule());
		assertEquals("datatype foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallAssignedTerminal() throws Exception {
		Mixed mixed = parseAs("6 (foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder.ruleCall(
				grammarAccess.getMixedAccess().getNameIDTerminalRuleCall_2_2_0_0());
		ISemanticRegion actuals = finder.ruleCall(
				grammarAccess.getMixedAccess().getNameIDTerminalRuleCall_2_2_0_0());
		Assert.assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallToAssignedTerminal() throws Exception {
		Mixed mixed = parseAs("6 (foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder.ruleCallTo(grammarAccess.getIDRule());
		ISemanticRegion actuals = finder.ruleCallTo(grammarAccess.getIDRule());
		Assert.assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallAssignedDataType() throws Exception {
		Mixed mixed = parseAs("6 (datatype foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder.ruleCall(grammarAccess.getMixedAccess()
				.getDatatypeDatatypeParserRuleCall_2_2_2_0());
		ISemanticRegion actuals = finder.ruleCall(grammarAccess.getMixedAccess()
				.getDatatypeDatatypeParserRuleCall_2_2_2_0());
		Assert.assertEquals("datatype foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallToAssignedDataType() throws Exception {
		Mixed mixed = parseAs("6 (datatype foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder.ruleCallTo(grammarAccess.getDatatypeRule());
		ISemanticRegion actuals = finder.ruleCallTo(grammarAccess.getDatatypeRule());
		Assert.assertEquals("datatype foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallCrossReference() throws Exception {
		AssignedAction mixed = parseAs("6 (ref foo) action (foo) end", AssignedAction.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed.getChild()).getRegionFor();
		ISemanticRegion actual = finder.ruleCall(grammarAccess.getMixedAccess()
				.getRefMixedIDTerminalRuleCall_2_2_3_1_0_1());
		List<ISemanticRegion> actuals = finder.ruleCalls(grammarAccess.getMixedAccess()
				.getRefMixedIDTerminalRuleCall_2_2_3_1_0_1());
		assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallToCrossReference() throws Exception {
		AssignedAction mixed = parseAs("6 (ref foo) action (foo) end", AssignedAction.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed.getChild()).getRegionFor();
		ISemanticRegion actual = finder.ruleCallTo(grammarAccess.getIDRule());
		List<ISemanticRegion> actuals = finder.ruleCallsTo(grammarAccess.getIDRule());
		assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForRuleCallEObjectParserRule() throws Exception {
		Mixed mixed = parseAs("6 (child (foo))", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		try {
			finder.ruleCall(grammarAccess.getMixedAccess()
					.getEobjMixedParserRuleCall_2_2_1_1_0());
			Assert.fail();
		} catch (IllegalStateException e) {
			// ok
		}
		try {
			finder.ruleCalls(grammarAccess.getMixedAccess()
					.getEobjMixedParserRuleCall_2_2_1_1_0());
			Assert.fail();
		} catch (IllegalStateException e) {
			// ok
		}
	}

	@Test
	public void regionForRuleCallToEObjectParserRule() throws Exception {
		Mixed mixed = parseAs("6 (child (foo))", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		try {
			finder.ruleCallTo(grammarAccess.getMixedRule());
			Assert.fail();
		} catch (IllegalStateException e) {
			// ok
		}
		try {
			finder.ruleCallsTo(grammarAccess.getMixedRule());
			Assert.fail();
		} catch (IllegalStateException e) {
			// ok
		}
	}

	@Test
	public void regionForKeywordString() throws Exception {
		Mixed mixed = parseAs("6 (foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder.keyword("(");
		List<ISemanticRegion> actuals = finder.keywords("(");
		assertEquals("(", actual, actuals);
	}

	@Test
	public void regionForKeyword() throws Exception {
		Mixed mixed = parseAs("6 (foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder
				.keyword(grammarAccess.getMixedAccess().getLeftParenthesisKeyword_0());
		List<ISemanticRegion> actuals = finder
				.keywords(grammarAccess.getMixedAccess().getLeftParenthesisKeyword_0());
		assertEquals("(", actual, actuals);
	}

	@Test
	public void regionForCrossReference() throws Exception {
		AssignedAction mixed = parseAs("6 (ref foo) action (foo) end", AssignedAction.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed.getChild()).getRegionFor();
		ISemanticRegion actual = finder.crossRef(
				grammarAccess.getMixedAccess().getRefMixedCrossReference_2_2_3_1_0());
		List<ISemanticRegion> actuals = finder.crossRefs(
				grammarAccess.getMixedAccess().getRefMixedCrossReference_2_2_3_1_0());
		assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForAssignment() throws Exception {
		Mixed mixed = parseAs("6 (foo)", Mixed.class);
		ISemanticRegionsFinder finder = toAccess(mixed).regionForEObject(mixed).getRegionFor();
		ISemanticRegion actual = finder
				.assignment(grammarAccess.getMixedAccess().getNameAssignment_2_2_0());
		List<ISemanticRegion> actuals = finder
				.assignments(grammarAccess.getMixedAccess().getNameAssignment_2_2_0());
		assertEquals("foo", actual, actuals);
	}

	@Test
	public void regionForKeywordPairs() throws Exception {
		@Extension
		RegionAccessTestLanguageGrammarAccess.ParenthesizedElements rule = grammarAccess
				.getParenthesizedAccess();
		Expression expr = parseAs("5 (foo)", Expression.class);
		ISemanticRegionsFinder finder = toAccess(expr).regionForEObject(expr).getRegionFor();
		String actual1 = pairsToString(finder.keywordPairs("(", ")"));
		String actual2 = pairsToString(
				finder.keywordPairs(rule.getLeftParenthesisKeyword_0(), rule.getRightParenthesisKeyword_2()));
		String expected = "(foo)";
		Assert.assertEquals(expected, actual1);
		Assert.assertEquals(expected, actual2);
	}

	@Test
	public void regionForKeywordPairs2() throws Exception {
		@Extension
		RegionAccessTestLanguageGrammarAccess.ParenthesizedElements rule = grammarAccess
				.getParenthesizedAccess();
		Expression expr = parseAs("5 (a + ((b) + c) + d)", Expression.class);
		ISemanticRegionsFinder finder = toAccess(expr).regionForRootEObject().getAllRegionsFor();
		String actual1 = pairsToString(finder.keywordPairs("(", ")"));
		String actual2 = pairsToString(
				finder.keywordPairs(rule.getLeftParenthesisKeyword_0(), rule.getRightParenthesisKeyword_2()));
		String expected = "(b); ((b) + c); (a + ((b) + c) + d)";
		Assert.assertEquals(expected, actual1);
		Assert.assertEquals(expected, actual2);
	}

	private String pairsToString(Iterable<Pair<ISemanticRegion, ISemanticRegion>> pairs) {
		return Joiner.on("; ")
				.join(Iterables.transform(pairs, it -> it.getKey().merge(it.getValue()).getText()));
	}

	private <T extends EObject> T parseAs(CharSequence seq, Class<T> cls) throws Exception {
		Root result = parseHelper.parse(seq);
		validationTestHelper.assertNoErrors(result);
		return cls.cast(result);
	}

	private ITextRegionAccess toAccess(EObject obj) {
		return textRegionAccessBuilder.get().forNodeModel((XtextResource) obj.eResource()).create();
	}

	private void assertEquals(String expected, ITextSegment single, Collection<? extends ITextSegment> regions) {
		Assert.assertEquals(expected, single.getText());
		Assert.assertEquals(1, regions.size());
		Assert.assertEquals(expected, Iterables.getFirst(regions, null).getText());
		Assert.assertTrue(regions instanceof ImmutableList<?>);
	}
}
