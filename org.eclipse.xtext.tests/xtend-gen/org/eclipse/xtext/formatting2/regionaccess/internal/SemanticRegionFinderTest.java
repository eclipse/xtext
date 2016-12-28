/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.formatting2.regionaccess.internal;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.Collection;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
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
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class SemanticRegionFinderTest {
  @Inject
  @Extension
  private ParseHelper<Root> parseHelper;
  
  @Inject
  private Provider<TextRegionAccessBuilder> textRegionAccessBuilder;
  
  @Inject
  @Extension
  private ValidationTestHelper validationTestHelper;
  
  @Inject
  @Extension
  private RegionAccessTestLanguageGrammarAccess _regionAccessTestLanguageGrammarAccess;
  
  @Test
  public void regionForFeatureAttribute() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.feature(RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
    final List<ISemanticRegion> actuals = finder.features(RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForFeatureCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final IEObjectRegion finder = this.toAccess(mixed).regionForEObject(mixed.getChild());
    final ISemanticRegion actual = finder.getRegionFor().feature(RegionaccesstestlanguagePackage.Literals.MIXED__REF);
    final List<ISemanticRegion> actuals = finder.getRegionFor().features(RegionaccesstestlanguagePackage.Literals.MIXED__REF);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForFeatureContainmentReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo) action");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    try {
      finder.feature(RegionaccesstestlanguagePackage.Literals.ASSIGNED_ACTION__CHILD);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
        final IllegalStateException e = (IllegalStateException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      finder.features(RegionaccesstestlanguagePackage.Literals.ASSIGNED_ACTION__CHILD);
      Assert.fail();
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof IllegalStateException) {
        final IllegalStateException e_1 = (IllegalStateException)_t_1;
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
  }
  
  @Test
  public void regionForRuleCallUnassignedTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.ruleCall(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getIDTerminalRuleCall_1_1_0());
    final List<ISemanticRegion> actuals = finder.ruleCalls(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getIDTerminalRuleCall_1_1_0());
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToUnassignedTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.ruleCallTo(this._regionAccessTestLanguageGrammarAccess.getIDRule());
    final List<ISemanticRegion> actuals = finder.ruleCallsTo(this._regionAccessTestLanguageGrammarAccess.getIDRule());
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallUnassignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.ruleCall(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getDatatypeParserRuleCall_1_1_1());
    final List<ISemanticRegion> actuals = finder.ruleCalls(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getDatatypeParserRuleCall_1_1_1());
    this.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToUnassignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.ruleCallTo(this._regionAccessTestLanguageGrammarAccess.getDatatypeRule());
    final List<ISemanticRegion> actuals = finder.ruleCallsTo(this._regionAccessTestLanguageGrammarAccess.getDatatypeRule());
    this.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallAssignedTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.ruleCall(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getNameIDTerminalRuleCall_2_2_0_0());
    final ISemanticRegion actuals = finder.ruleCall(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getNameIDTerminalRuleCall_2_2_0_0());
    Assert.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToAssignedTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.ruleCallTo(this._regionAccessTestLanguageGrammarAccess.getIDRule());
    final ISemanticRegion actuals = finder.ruleCallTo(this._regionAccessTestLanguageGrammarAccess.getIDRule());
    Assert.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallAssignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.ruleCall(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getDatatypeDatatypeParserRuleCall_2_2_2_0());
    final ISemanticRegion actuals = finder.ruleCall(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getDatatypeDatatypeParserRuleCall_2_2_2_0());
    Assert.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToAssignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.ruleCallTo(this._regionAccessTestLanguageGrammarAccess.getDatatypeRule());
    final ISemanticRegion actuals = finder.ruleCallTo(this._regionAccessTestLanguageGrammarAccess.getDatatypeRule());
    Assert.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed.getChild()).getRegionFor();
    final ISemanticRegion actual = finder.ruleCall(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getRefMixedIDTerminalRuleCall_2_2_3_1_0_1());
    final List<ISemanticRegion> actuals = finder.ruleCalls(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getRefMixedIDTerminalRuleCall_2_2_3_1_0_1());
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed.getChild()).getRegionFor();
    final ISemanticRegion actual = finder.ruleCallTo(this._regionAccessTestLanguageGrammarAccess.getIDRule());
    final List<ISemanticRegion> actuals = finder.ruleCallsTo(this._regionAccessTestLanguageGrammarAccess.getIDRule());
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallEObjectParserRule() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (child (foo))");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    try {
      finder.ruleCall(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getEobjMixedParserRuleCall_2_2_1_1_0());
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
        final IllegalStateException e = (IllegalStateException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      finder.ruleCalls(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getEobjMixedParserRuleCall_2_2_1_1_0());
      Assert.fail();
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof IllegalStateException) {
        final IllegalStateException e_1 = (IllegalStateException)_t_1;
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
  }
  
  @Test
  public void regionForRuleCallToEObjectParserRule() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (child (foo))");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    try {
      finder.ruleCallTo(this._regionAccessTestLanguageGrammarAccess.getMixedRule());
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
        final IllegalStateException e = (IllegalStateException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      finder.ruleCallsTo(this._regionAccessTestLanguageGrammarAccess.getMixedRule());
      Assert.fail();
    } catch (final Throwable _t_1) {
      if (_t_1 instanceof IllegalStateException) {
        final IllegalStateException e_1 = (IllegalStateException)_t_1;
      } else {
        throw Exceptions.sneakyThrow(_t_1);
      }
    }
  }
  
  @Test
  public void regionForKeywordString() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.keyword("(");
    final List<ISemanticRegion> actuals = finder.keywords("(");
    this.assertEquals("(", actual, actuals);
  }
  
  @Test
  public void regionForKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.keyword(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getLeftParenthesisKeyword_0());
    final List<ISemanticRegion> actuals = finder.keywords(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getLeftParenthesisKeyword_0());
    this.assertEquals("(", actual, actuals);
  }
  
  @Test
  public void regionForCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed.getChild()).getRegionFor();
    final ISemanticRegion actual = finder.crossRef(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getRefMixedCrossReference_2_2_3_1_0());
    final List<ISemanticRegion> actuals = finder.crossRefs(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getRefMixedCrossReference_2_2_3_1_0());
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForAssignment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ISemanticRegionsFinder finder = this.toAccess(mixed).regionForEObject(mixed).getRegionFor();
    final ISemanticRegion actual = finder.assignment(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getNameAssignment_2_2_0());
    final List<ISemanticRegion> actuals = finder.assignments(this._regionAccessTestLanguageGrammarAccess.getMixedAccess().getNameAssignment_2_2_0());
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForKeywordPairs() {
    @Extension
    final RegionAccessTestLanguageGrammarAccess.ParenthesizedElements rule = this._regionAccessTestLanguageGrammarAccess.getParenthesizedAccess();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("5 (foo)");
    final Expression expr = this.<Expression>parseAs(_builder, Expression.class);
    final ISemanticRegionsFinder finder = this.toAccess(expr).regionForEObject(expr).getRegionFor();
    final String actual1 = this.pairsToString(finder.keywordPairs("(", ")"));
    final String actual2 = this.pairsToString(finder.keywordPairs(rule.getLeftParenthesisKeyword_0(), rule.getRightParenthesisKeyword_2()));
    final String expected = "(foo)";
    Assert.assertEquals(expected, actual1);
    Assert.assertEquals(expected, actual2);
  }
  
  @Test
  public void regionForKeywordPairs2() {
    @Extension
    final RegionAccessTestLanguageGrammarAccess.ParenthesizedElements rule = this._regionAccessTestLanguageGrammarAccess.getParenthesizedAccess();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("5 (a + ((b) + c) + d)");
    final Expression expr = this.<Expression>parseAs(_builder, Expression.class);
    final ISemanticRegionsFinder finder = this.toAccess(expr).regionForRootEObject().getAllRegionsFor();
    final String actual1 = this.pairsToString(finder.keywordPairs("(", ")"));
    final String actual2 = this.pairsToString(finder.keywordPairs(rule.getLeftParenthesisKeyword_0(), rule.getRightParenthesisKeyword_2()));
    final String expected = "(b); ((b) + c); (a + ((b) + c) + d)";
    Assert.assertEquals(expected, actual1);
    Assert.assertEquals(expected, actual2);
  }
  
  private String pairsToString(final Iterable<Pair<ISemanticRegion, ISemanticRegion>> pairs) {
    final Function1<Pair<ISemanticRegion, ISemanticRegion>, String> _function = (Pair<ISemanticRegion, ISemanticRegion> it) -> {
      return it.getKey().merge(it.getValue()).getText();
    };
    return IterableExtensions.join(IterableExtensions.<Pair<ISemanticRegion, ISemanticRegion>, String>map(pairs, _function), "; ");
  }
  
  private <T extends EObject> T parseAs(final CharSequence seq, final Class<T> cls) {
    try {
      final Root result = this.parseHelper.parse(seq);
      this.validationTestHelper.assertNoErrors(result);
      return cls.cast(result);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private ITextRegionAccess toAccess(final EObject obj) {
    Resource _eResource = obj.eResource();
    return this.textRegionAccessBuilder.get().forNodeModel(((XtextResource) _eResource)).create();
  }
  
  private void assertEquals(final String expected, final ITextSegment single, final Collection<? extends ITextSegment> regions) {
    Assert.assertEquals(expected, single.getText());
    Assert.assertEquals(1, regions.size());
    Assert.assertEquals(expected, IterableExtensions.head(regions).getText());
    Assert.assertTrue((regions instanceof ImmutableList<?>));
  }
}
