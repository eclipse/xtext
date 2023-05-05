/**
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.homeautomation.validation;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.common.types.JvmOperation;
import org.eclipse.xtext.example.homeautomation.jvmmodel.RuleEngineJvmModelInferrer;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Declaration;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Device;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Model;
import org.eclipse.xtext.example.homeautomation.ruleEngine.Rule;
import org.eclipse.xtext.example.homeautomation.ruleEngine.RuleEnginePackage;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.jvmmodel.IJvmModelAssociations;
import org.eclipse.xtext.xbase.lib.StringExtensions;

import com.google.inject.Inject;

/**
 * This class contains custom validation rules.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class RuleEngineValidator extends AbstractRuleEngineValidator {
	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Check
	public void checkUniqueDeclarations(Model model) {
		Set<String> deviceNames = new HashSet<>();
		Set<String> ruleDescriptions = new HashSet<>();
		for (Declaration decl : model.getDeclarations()) {
			if (decl instanceof Device) {
				String name = ((Device) decl).getName();
				if (!deviceNames.add(name)) {
					error("Device names must be unique.", decl, RuleEnginePackage.Literals.DEVICE__NAME);
				}
			} else {
				String methodName = RuleEngineJvmModelInferrer.getRuleMethodName((Rule) decl);
				if (!ruleDescriptions.add(methodName)) {
					error("Rule descriptions must be unique.", decl, RuleEnginePackage.Literals.RULE__DESCRIPTION);
				}
			}
		}
	}

	@Check
	public void checkStatesNotEmpty(Device device) {
		if (device.getStates().isEmpty()) {
			error("The device \"" + device.getName() + "\" must have at least one state.", device,
					RuleEnginePackage.Literals.DEVICE__NAME);
		}
	}

	@Check
	public void checkUniqueStates(Device device) {
		Set<String> stateNames = new HashSet<>();
		for (org.eclipse.xtext.example.homeautomation.ruleEngine.State state : device.getStates()) {
			if (!stateNames.add(state.getName())) {
				error("State names must be unique.", state, RuleEnginePackage.Literals.STATE__NAME);
			}
		}
	}

	@Check
	public void checkRuleDescriptionNotEmpty(Rule rule) {
		if (StringExtensions.isNullOrEmpty(rule.getDescription())) {
			error("A rule description must not be empty.", rule, RuleEnginePackage.Literals.RULE__DESCRIPTION);
		}
	}

	@Check
	public void checkRuleRecursion(XFeatureCall featureCall) {
		Rule containingRule = EcoreUtil2.<Rule>getContainerOfType(featureCall, Rule.class);
		if (containingRule != null) {
			if (featureCall.getFeature() instanceof JvmOperation
				&& "fire".equals(featureCall.getConcreteSyntaxFeatureName())
				&& featureCall.getFeatureCallArguments().size() == 1) {
					XExpression argument = featureCall.getFeatureCallArguments().get(0);
					if (argument instanceof XAbstractFeatureCall) {
						EObject sourceElem = jvmModelAssociations
								.getPrimarySourceElement(((XAbstractFeatureCall) argument).getFeature());
						if (sourceElem == containingRule
								.getDeviceState()) {
							warning("Firing the same device state that triggers the rule \"" + containingRule.getDescription()
							+ "\" may lead to endless recursion.", featureCall,
							XbasePackage.Literals.XFEATURE_CALL__FEATURE_CALL_ARGUMENTS, 0);
						}
					}
				}
		}
	}
}
