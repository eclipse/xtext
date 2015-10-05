/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import static org.eclipse.xtext.xtext.ParameterConfigHelper.*;

import java.util.List;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class RequiredRuleNameComputer {

	public static abstract class Param {
		private String ruleName;
		private List<Integer> paramStack;
		private AbstractElement elementToParse;

		protected Param(String ruleName, List<Integer> paramStack, AbstractElement elementToParse) {
			this.ruleName = ruleName;
			this.paramStack = paramStack;
			this.elementToParse = elementToParse;
		}
		
		protected abstract String getBaseRuleName(AbstractElement element);
	}
	
	@Inject
	private RuleNames ruleNames;
	
	public String[][] getRequiredRuleNames(Param param) {
		AbstractElement elementToParse = param.elementToParse;
		String ruleName = param.ruleName;
		if (ruleName == null) {
			if (elementToParse instanceof RuleCall) {
				RuleCall call = (RuleCall) elementToParse;
				if (call.getRule() instanceof ParserRule) {
					String antlrRuleName = ruleNames.getAntlrRuleName(call.getRule());
					if (!call.getArguments().isEmpty()) {
						Set<Parameter> context = getAssignedParameters(elementToParse, param.paramStack);
						Set<Parameter> arguments = getAssignedArguments(call, context);
						int config = getParameterConfig(arguments);
						antlrRuleName = ruleNames.getAntlrRuleName(call.getRule(), config);
					}
					return new String[][] {{ antlrRuleName }};
				}
			}
			return new String[0][];
		}
		String adjustedRuleName = adjustRuleName(ruleName, param);
		if (!(GrammarUtil.isOptionalCardinality(elementToParse) || GrammarUtil.isOneOrMoreCardinality(elementToParse))) {
			return new String[][] {{ adjustedRuleName }};
		}
		if ((elementToParse.eContainer() instanceof Group)) {
			List<AbstractElement> tokens = ((Group) elementToParse.eContainer()).getElements();
			int idx = tokens.indexOf(elementToParse) + 1;
			if (idx != tokens.size()) {
				String secondRule = param.getBaseRuleName((AbstractElement) elementToParse.eContainer());
  				secondRule = secondRule.substring(0, secondRule.lastIndexOf('_') + 1) + idx;
				String adjustedSecondRule = adjustRuleName(secondRule, param);
				if (GrammarUtil.isMultipleCardinality(elementToParse))
					return new String[][] {{ adjustedRuleName }, {adjustedRuleName, adjustedSecondRule }};
				return new String[][] { {adjustedRuleName, adjustedSecondRule} };
			}
		}
		return new String[][] {{ ruleName }};
	}
	
	private String adjustRuleName(String ruleName, Param param) {
		AbstractElement elementToParse = param.elementToParse;
		Set<Parameter> context = getAssignedParameters(elementToParse, param.paramStack);
		if (!context.isEmpty()) {
			ParserRule containingRule = GrammarUtil.containingParserRule(elementToParse);
			String antlrRuleName = ruleNames.getAntlrRuleName(containingRule);
			int len = antlrRuleName.length();
			if (antlrRuleName.startsWith("rule")) {
				len+=2; // rule__XYZ instead of ruleXYZ
			}
			int config = getParameterConfig(context);
			String result = ruleNames.getAntlrRuleName(containingRule, config) + ruleName.substring(len);
			return result;
		}
		return ruleName;
	}
	
}
