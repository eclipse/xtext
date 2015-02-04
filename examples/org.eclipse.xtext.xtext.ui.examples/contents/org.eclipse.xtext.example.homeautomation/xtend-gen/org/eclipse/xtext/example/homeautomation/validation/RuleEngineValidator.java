/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.homeautomation.validation;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmIdentifiableElement;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.example.homeautomation.ruleEngine.RuleEnginePackage;
import org.eclipse.xtext.example.homeautomation.validation.AbstractRuleEngineValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;

/**
 * Custom validation rules.
 * 
 * see http://www.eclipse.org/Xtext/documentation.html#validation
 */
@SuppressWarnings("all")
public class RuleEngineValidator extends AbstractRuleEngineValidator {
  @Inject
  @Extension
  private IJvmModelAssociations _iJvmModelAssociations;
  
  @Check
  public void checkStatesNotEmpty(final Device device) {
    EList<org.eclipse.xtext.example.homeautomation.ruleEngine.State> _states = device.getStates();
    boolean _isEmpty = _states.isEmpty();
    if (_isEmpty) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("The device \"");
      String _name = device.getName();
      _builder.append(_name, "");
      _builder.append("\" must have at least one state.");
      this.error(_builder.toString(), device, RuleEnginePackage.Literals.DEVICE__NAME);
    }
  }
  
  @Check
  public void checkRuleDescriptionNotEmpty(final Rule rule) {
    String _description = rule.getDescription();
    boolean _isNullOrEmpty = StringExtensions.isNullOrEmpty(_description);
    if (_isNullOrEmpty) {
      this.error("A rule description must not be empty.", rule, RuleEnginePackage.Literals.RULE__DESCRIPTION);
    }
  }
  
  @Check
  public void checkRuleRecursion(final XFeatureCall featureCall) {
    final Rule containingRule = EcoreUtil2.<Rule>getContainerOfType(featureCall, Rule.class);
    boolean _and = false;
    boolean _and_1 = false;
    boolean _and_2 = false;
    boolean _notEquals = (!Objects.equal(containingRule, null));
    if (!_notEquals) {
      _and_2 = false;
    } else {
      JvmIdentifiableElement _feature = featureCall.getFeature();
      _and_2 = (_feature instanceof JvmOperation);
    }
    if (!_and_2) {
      _and_1 = false;
    } else {
      String _concreteSyntaxFeatureName = featureCall.getConcreteSyntaxFeatureName();
      boolean _equals = Objects.equal(_concreteSyntaxFeatureName, "fire");
      _and_1 = _equals;
    }
    if (!_and_1) {
      _and = false;
    } else {
      EList<XExpression> _featureCallArguments = featureCall.getFeatureCallArguments();
      int _size = _featureCallArguments.size();
      boolean _equals_1 = (_size == 1);
      _and = _equals_1;
    }
    if (_and) {
      EList<XExpression> _featureCallArguments_1 = featureCall.getFeatureCallArguments();
      final XExpression argument = IterableExtensions.<XExpression>head(_featureCallArguments_1);
      if ((argument instanceof XAbstractFeatureCall)) {
        JvmIdentifiableElement _feature_1 = ((XAbstractFeatureCall)argument).getFeature();
        final EObject sourceElem = this._iJvmModelAssociations.getPrimarySourceElement(_feature_1);
        org.eclipse.xtext.example.homeautomation.ruleEngine.State _deviceState = containingRule.getDeviceState();
        boolean _equals_2 = Objects.equal(sourceElem, _deviceState);
        if (_equals_2) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Firing the same device state that triggers the rule \"");
          String _description = containingRule.getDescription();
          _builder.append(_description, "");
          _builder.append("\" may lead to endless recursion.");
          this.warning(_builder.toString(), featureCall, XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, 0);
        }
      }
    }
  }
}
