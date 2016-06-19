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
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting2.regionaccess.IEObjectRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegionsFinder;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Expression;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess;
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
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    final ISemanticRegion actual = finder.feature(RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
    final List<ISemanticRegion> actuals = finder.features(RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForFeatureCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    Mixed _child = mixed.getChild();
    final IEObjectRegion finder = _access.regionForEObject(_child);
    ISemanticRegionsFinder _regionFor = finder.getRegionFor();
    final ISemanticRegion actual = _regionFor.feature(RegionaccesstestlanguagePackage.Literals.MIXED__REF);
    ISemanticRegionsFinder _regionFor_1 = finder.getRegionFor();
    final List<ISemanticRegion> actuals = _regionFor_1.features(RegionaccesstestlanguagePackage.Literals.MIXED__REF);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForFeatureContainmentReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo) action");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
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
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _iDTerminalRuleCall_1_1_0 = _mixedAccess.getIDTerminalRuleCall_1_1_0();
    final ISemanticRegion actual = finder.ruleCall(_iDTerminalRuleCall_1_1_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _iDTerminalRuleCall_1_1_0_1 = _mixedAccess_1.getIDTerminalRuleCall_1_1_0();
    final List<ISemanticRegion> actuals = finder.ruleCalls(_iDTerminalRuleCall_1_1_0_1);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToUnassignedTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    TerminalRule _iDRule = this._regionAccessTestLanguageGrammarAccess.getIDRule();
    final ISemanticRegion actual = finder.ruleCallTo(_iDRule);
    TerminalRule _iDRule_1 = this._regionAccessTestLanguageGrammarAccess.getIDRule();
    final List<ISemanticRegion> actuals = finder.ruleCallsTo(_iDRule_1);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallUnassignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _datatypeParserRuleCall_1_1_1 = _mixedAccess.getDatatypeParserRuleCall_1_1_1();
    final ISemanticRegion actual = finder.ruleCall(_datatypeParserRuleCall_1_1_1);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _datatypeParserRuleCall_1_1_1_1 = _mixedAccess_1.getDatatypeParserRuleCall_1_1_1();
    final List<ISemanticRegion> actuals = finder.ruleCalls(_datatypeParserRuleCall_1_1_1_1);
    this.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToUnassignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    ParserRule _datatypeRule = this._regionAccessTestLanguageGrammarAccess.getDatatypeRule();
    final ISemanticRegion actual = finder.ruleCallTo(_datatypeRule);
    ParserRule _datatypeRule_1 = this._regionAccessTestLanguageGrammarAccess.getDatatypeRule();
    final List<ISemanticRegion> actuals = finder.ruleCallsTo(_datatypeRule_1);
    this.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallAssignedTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _nameIDTerminalRuleCall_2_2_0_0 = _mixedAccess.getNameIDTerminalRuleCall_2_2_0_0();
    final ISemanticRegion actual = finder.ruleCall(_nameIDTerminalRuleCall_2_2_0_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _nameIDTerminalRuleCall_2_2_0_0_1 = _mixedAccess_1.getNameIDTerminalRuleCall_2_2_0_0();
    final ISemanticRegion actuals = finder.ruleCall(_nameIDTerminalRuleCall_2_2_0_0_1);
    Assert.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToAssignedTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    TerminalRule _iDRule = this._regionAccessTestLanguageGrammarAccess.getIDRule();
    final ISemanticRegion actual = finder.ruleCallTo(_iDRule);
    TerminalRule _iDRule_1 = this._regionAccessTestLanguageGrammarAccess.getIDRule();
    final ISemanticRegion actuals = finder.ruleCallTo(_iDRule_1);
    Assert.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallAssignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _datatypeDatatypeParserRuleCall_2_2_2_0 = _mixedAccess.getDatatypeDatatypeParserRuleCall_2_2_2_0();
    final ISemanticRegion actual = finder.ruleCall(_datatypeDatatypeParserRuleCall_2_2_2_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _datatypeDatatypeParserRuleCall_2_2_2_0_1 = _mixedAccess_1.getDatatypeDatatypeParserRuleCall_2_2_2_0();
    final ISemanticRegion actuals = finder.ruleCall(_datatypeDatatypeParserRuleCall_2_2_2_0_1);
    Assert.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToAssignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    ParserRule _datatypeRule = this._regionAccessTestLanguageGrammarAccess.getDatatypeRule();
    final ISemanticRegion actual = finder.ruleCallTo(_datatypeRule);
    ParserRule _datatypeRule_1 = this._regionAccessTestLanguageGrammarAccess.getDatatypeRule();
    final ISemanticRegion actuals = finder.ruleCallTo(_datatypeRule_1);
    Assert.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    Mixed _child = mixed.getChild();
    IEObjectRegion _regionForEObject = _access.regionForEObject(_child);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _refMixedIDTerminalRuleCall_2_2_3_1_0_1 = _mixedAccess.getRefMixedIDTerminalRuleCall_2_2_3_1_0_1();
    final ISemanticRegion actual = finder.ruleCall(_refMixedIDTerminalRuleCall_2_2_3_1_0_1);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _refMixedIDTerminalRuleCall_2_2_3_1_0_1_1 = _mixedAccess_1.getRefMixedIDTerminalRuleCall_2_2_3_1_0_1();
    final List<ISemanticRegion> actuals = finder.ruleCalls(_refMixedIDTerminalRuleCall_2_2_3_1_0_1_1);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallToCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    Mixed _child = mixed.getChild();
    IEObjectRegion _regionForEObject = _access.regionForEObject(_child);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    TerminalRule _iDRule = this._regionAccessTestLanguageGrammarAccess.getIDRule();
    final ISemanticRegion actual = finder.ruleCallTo(_iDRule);
    TerminalRule _iDRule_1 = this._regionAccessTestLanguageGrammarAccess.getIDRule();
    final List<ISemanticRegion> actuals = finder.ruleCallsTo(_iDRule_1);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallEObjectParserRule() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (child (foo))");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    try {
      RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
      RuleCall _eobjMixedParserRuleCall_2_2_1_1_0 = _mixedAccess.getEobjMixedParserRuleCall_2_2_1_1_0();
      finder.ruleCall(_eobjMixedParserRuleCall_2_2_1_1_0);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
        final IllegalStateException e = (IllegalStateException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
      RuleCall _eobjMixedParserRuleCall_2_2_1_1_0_1 = _mixedAccess_1.getEobjMixedParserRuleCall_2_2_1_1_0();
      finder.ruleCalls(_eobjMixedParserRuleCall_2_2_1_1_0_1);
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
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    try {
      ParserRule _mixedRule = this._regionAccessTestLanguageGrammarAccess.getMixedRule();
      finder.ruleCallTo(_mixedRule);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
        final IllegalStateException e = (IllegalStateException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      ParserRule _mixedRule_1 = this._regionAccessTestLanguageGrammarAccess.getMixedRule();
      finder.ruleCallsTo(_mixedRule_1);
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
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    final ISemanticRegion actual = finder.keyword("(");
    final List<ISemanticRegion> actuals = finder.keywords("(");
    this.assertEquals("(", actual, actuals);
  }
  
  @Test
  public void regionForKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    Keyword _leftParenthesisKeyword_0 = _mixedAccess.getLeftParenthesisKeyword_0();
    final ISemanticRegion actual = finder.keyword(_leftParenthesisKeyword_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    Keyword _leftParenthesisKeyword_0_1 = _mixedAccess_1.getLeftParenthesisKeyword_0();
    final List<ISemanticRegion> actuals = finder.keywords(_leftParenthesisKeyword_0_1);
    this.assertEquals("(", actual, actuals);
  }
  
  @Test
  public void regionForCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    Mixed _child = mixed.getChild();
    IEObjectRegion _regionForEObject = _access.regionForEObject(_child);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    CrossReference _refMixedCrossReference_2_2_3_1_0 = _mixedAccess.getRefMixedCrossReference_2_2_3_1_0();
    final ISemanticRegion actual = finder.crossRef(_refMixedCrossReference_2_2_3_1_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    CrossReference _refMixedCrossReference_2_2_3_1_0_1 = _mixedAccess_1.getRefMixedCrossReference_2_2_3_1_0();
    final List<ISemanticRegion> actuals = finder.crossRefs(_refMixedCrossReference_2_2_3_1_0_1);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForAssignment() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    ITextRegionAccess _access = this.toAccess(mixed);
    IEObjectRegion _regionForEObject = _access.regionForEObject(mixed);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    Assignment _nameAssignment_2_2_0 = _mixedAccess.getNameAssignment_2_2_0();
    final ISemanticRegion actual = finder.assignment(_nameAssignment_2_2_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    Assignment _nameAssignment_2_2_0_1 = _mixedAccess_1.getNameAssignment_2_2_0();
    final List<ISemanticRegion> actuals = finder.assignments(_nameAssignment_2_2_0_1);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForKeywordPairs() {
    @Extension
    final RegionAccessTestLanguageGrammarAccess.ParenthesizedElements rule = this._regionAccessTestLanguageGrammarAccess.getParenthesizedAccess();
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("5 (foo)");
    final Expression expr = this.<Expression>parseAs(_builder, Expression.class);
    ITextRegionAccess _access = this.toAccess(expr);
    IEObjectRegion _regionForEObject = _access.regionForEObject(expr);
    final ISemanticRegionsFinder finder = _regionForEObject.getRegionFor();
    List<Pair<ISemanticRegion, ISemanticRegion>> _keywordPairs = finder.keywordPairs("(", ")");
    final String actual1 = this.pairsToString(_keywordPairs);
    Keyword _leftParenthesisKeyword_0 = rule.getLeftParenthesisKeyword_0();
    Keyword _rightParenthesisKeyword_2 = rule.getRightParenthesisKeyword_2();
    List<Pair<ISemanticRegion, ISemanticRegion>> _keywordPairs_1 = finder.keywordPairs(_leftParenthesisKeyword_0, _rightParenthesisKeyword_2);
    final String actual2 = this.pairsToString(_keywordPairs_1);
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
    ITextRegionAccess _access = this.toAccess(expr);
    IEObjectRegion _regionForRootEObject = _access.regionForRootEObject();
    final ISemanticRegionsFinder finder = _regionForRootEObject.getAllRegionsFor();
    List<Pair<ISemanticRegion, ISemanticRegion>> _keywordPairs = finder.keywordPairs("(", ")");
    final String actual1 = this.pairsToString(_keywordPairs);
    Keyword _leftParenthesisKeyword_0 = rule.getLeftParenthesisKeyword_0();
    Keyword _rightParenthesisKeyword_2 = rule.getRightParenthesisKeyword_2();
    List<Pair<ISemanticRegion, ISemanticRegion>> _keywordPairs_1 = finder.keywordPairs(_leftParenthesisKeyword_0, _rightParenthesisKeyword_2);
    final String actual2 = this.pairsToString(_keywordPairs_1);
    final String expected = "(b); ((b) + c); (a + ((b) + c) + d)";
    Assert.assertEquals(expected, actual1);
    Assert.assertEquals(expected, actual2);
  }
  
  private String pairsToString(final Iterable<Pair<ISemanticRegion, ISemanticRegion>> pairs) {
    final Function1<Pair<ISemanticRegion, ISemanticRegion>, String> _function = (Pair<ISemanticRegion, ISemanticRegion> it) -> {
      ISemanticRegion _key = it.getKey();
      ISemanticRegion _value = it.getValue();
      ITextSegment _merge = _key.merge(_value);
      return _merge.getText();
    };
    Iterable<String> _map = IterableExtensions.<Pair<ISemanticRegion, ISemanticRegion>, String>map(pairs, _function);
    return IterableExtensions.join(_map, "; ");
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
    TextRegionAccessBuilder _get = this.textRegionAccessBuilder.get();
    Resource _eResource = obj.eResource();
    TextRegionAccessBuilder _forNodeModel = _get.forNodeModel(((XtextResource) _eResource));
    return _forNodeModel.create();
  }
  
  private void assertEquals(final String expected, final ITextSegment single, final Collection<? extends ITextSegment> regions) {
    String _text = single.getText();
    Assert.assertEquals(expected, _text);
    int _size = regions.size();
    Assert.assertEquals(1, _size);
    ITextSegment _head = IterableExtensions.head(regions);
    String _text_1 = _head.getText();
    Assert.assertEquals(expected, _text_1);
    Assert.assertTrue((regions instanceof ImmutableList<?>));
  }
}
