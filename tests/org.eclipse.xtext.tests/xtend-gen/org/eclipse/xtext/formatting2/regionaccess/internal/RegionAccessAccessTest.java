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
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.formatting2.regionaccess.ITextRegionAccess;
import org.eclipse.xtext.formatting2.regionaccess.ITextSegment;
import org.eclipse.xtext.formatting2.regionaccess.TextRegionAccessBuilder;
import org.eclipse.xtext.formatting2.regionaccess.internal.RegionAccessTestLanguageInjectorProvider;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.AssignedAction;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Mixed;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.RegionaccesstestlanguagePackage;
import org.eclipse.xtext.formatting2.regionaccess.internal.regionaccesstestlanguage.Root;
import org.eclipse.xtext.formatting2.regionaccess.internal.services.RegionAccessTestLanguageGrammarAccess;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.util.ParseHelper;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(RegionAccessTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class RegionAccessAccessTest {
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
    final ITextRegionAccess access = this.toAccess(mixed);
    final ISemanticRegion actual = access.regionForFeature(mixed, RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
    final List<ISemanticRegion> actuals = access.regionsForFeatures(mixed, RegionaccesstestlanguagePackage.Literals.MIXED__NAME);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForFeatureCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    Mixed _child = mixed.getChild();
    final ISemanticRegion actual = access.regionForFeature(_child, RegionaccesstestlanguagePackage.Literals.MIXED__REF);
    Mixed _child_1 = mixed.getChild();
    final List<ISemanticRegion> actuals = access.regionsForFeatures(_child_1, RegionaccesstestlanguagePackage.Literals.MIXED__REF);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForFeatureContainmentReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo) action");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    try {
      access.regionForFeature(mixed, RegionaccesstestlanguagePackage.Literals.ASSIGNED_ACTION__CHILD);
      Assert.fail();
    } catch (final Throwable _t) {
      if (_t instanceof IllegalStateException) {
        final IllegalStateException e = (IllegalStateException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    try {
      access.regionsForFeatures(mixed, RegionaccesstestlanguagePackage.Literals.ASSIGNED_ACTION__CHILD);
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
    final ITextRegionAccess access = this.toAccess(mixed);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _iDTerminalRuleCall_1_1_0 = _mixedAccess.getIDTerminalRuleCall_1_1_0();
    final ISemanticRegion actual = access.regionForRuleCall(mixed, _iDTerminalRuleCall_1_1_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _iDTerminalRuleCall_1_1_0_1 = _mixedAccess_1.getIDTerminalRuleCall_1_1_0();
    final List<ISemanticRegion> actuals = access.regionsForRuleCalls(mixed, _iDTerminalRuleCall_1_1_0_1);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallUnassignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (unassigned datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _datatypeParserRuleCall_1_1_1 = _mixedAccess.getDatatypeParserRuleCall_1_1_1();
    final ISemanticRegion actual = access.regionForRuleCall(mixed, _datatypeParserRuleCall_1_1_1);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _datatypeParserRuleCall_1_1_1_1 = _mixedAccess_1.getDatatypeParserRuleCall_1_1_1();
    final List<ISemanticRegion> actuals = access.regionsForRuleCalls(mixed, _datatypeParserRuleCall_1_1_1_1);
    this.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallAssignedTerminal() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _nameIDTerminalRuleCall_2_2_0_0 = _mixedAccess.getNameIDTerminalRuleCall_2_2_0_0();
    final ISemanticRegion actual = access.regionForRuleCall(mixed, _nameIDTerminalRuleCall_2_2_0_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _nameIDTerminalRuleCall_2_2_0_0_1 = _mixedAccess_1.getNameIDTerminalRuleCall_2_2_0_0();
    final ISemanticRegion actuals = access.regionForRuleCall(mixed, _nameIDTerminalRuleCall_2_2_0_0_1);
    Assert.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallAssignedDataType() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (datatype foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _datatypeDatatypeParserRuleCall_2_2_2_0 = _mixedAccess.getDatatypeDatatypeParserRuleCall_2_2_2_0();
    final ISemanticRegion actual = access.regionForRuleCall(mixed, _datatypeDatatypeParserRuleCall_2_2_2_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _datatypeDatatypeParserRuleCall_2_2_2_0_1 = _mixedAccess_1.getDatatypeDatatypeParserRuleCall_2_2_2_0();
    final ISemanticRegion actuals = access.regionForRuleCall(mixed, _datatypeDatatypeParserRuleCall_2_2_2_0_1);
    Assert.assertEquals("datatype foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    Mixed _child = mixed.getChild();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _refMixedIDTerminalRuleCall_2_2_3_1_0_1 = _mixedAccess.getRefMixedIDTerminalRuleCall_2_2_3_1_0_1();
    final ISemanticRegion actual = access.regionForRuleCall(_child, _refMixedIDTerminalRuleCall_2_2_3_1_0_1);
    Mixed _child_1 = mixed.getChild();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    RuleCall _refMixedIDTerminalRuleCall_2_2_3_1_0_1_1 = _mixedAccess_1.getRefMixedIDTerminalRuleCall_2_2_3_1_0_1();
    final List<ISemanticRegion> actuals = access.regionsForRuleCalls(_child_1, _refMixedIDTerminalRuleCall_2_2_3_1_0_1_1);
    this.assertEquals("foo", actual, actuals);
  }
  
  @Test
  public void regionForRuleCallEObjectParserRule() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (child (foo))");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    try {
      RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
      RuleCall _eobjMixedParserRuleCall_2_2_1_1_0 = _mixedAccess.getEobjMixedParserRuleCall_2_2_1_1_0();
      access.regionForRuleCall(mixed, _eobjMixedParserRuleCall_2_2_1_1_0);
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
      access.regionsForRuleCalls(mixed, _eobjMixedParserRuleCall_2_2_1_1_0_1);
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
    final ITextRegionAccess access = this.toAccess(mixed);
    final ISemanticRegion actual = access.regionForKeyword(mixed, "(");
    final List<ISemanticRegion> actuals = access.regionsForKeywords(mixed, "(");
    this.assertEquals("(", actual, actuals);
  }
  
  @Test
  public void regionForKeyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (foo)");
    final Mixed mixed = this.<Mixed>parseAs(_builder, Mixed.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    Keyword _leftParenthesisKeyword_0 = _mixedAccess.getLeftParenthesisKeyword_0();
    final ISemanticRegion actual = access.regionForKeyword(mixed, _leftParenthesisKeyword_0);
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    Keyword _leftParenthesisKeyword_0_1 = _mixedAccess_1.getLeftParenthesisKeyword_0();
    final List<ISemanticRegion> actuals = access.regionsForKeywords(mixed, _leftParenthesisKeyword_0_1);
    this.assertEquals("(", actual, actuals);
  }
  
  @Test
  public void regionForCrossReference() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("6 (ref foo) action (foo) end");
    final AssignedAction mixed = this.<AssignedAction>parseAs(_builder, AssignedAction.class);
    final ITextRegionAccess access = this.toAccess(mixed);
    Mixed _child = mixed.getChild();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    CrossReference _refMixedCrossReference_2_2_3_1_0 = _mixedAccess.getRefMixedCrossReference_2_2_3_1_0();
    final ISemanticRegion actual = access.regionForCrossRef(_child, _refMixedCrossReference_2_2_3_1_0);
    Mixed _child_1 = mixed.getChild();
    RegionAccessTestLanguageGrammarAccess.MixedElements _mixedAccess_1 = this._regionAccessTestLanguageGrammarAccess.getMixedAccess();
    CrossReference _refMixedCrossReference_2_2_3_1_0_1 = _mixedAccess_1.getRefMixedCrossReference_2_2_3_1_0();
    final List<ISemanticRegion> actuals = access.regionsForCrossRefs(_child_1, _refMixedCrossReference_2_2_3_1_0_1);
    this.assertEquals("foo", actual, actuals);
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
