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
import org.eclipse.xtext.xtext.ConditionEvaluator;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Computes the Antlr method names that need to be invoked to continue the
 * follow element computation for content proposals. It is used if a previous
 * round produced follow elements with a lookahead bigger than 1. The result
 * of {@link #getRequiredRuleNames(Param)} is the list of methods that need
 * need to be invoked to force the parser in one or the other direction at the
 * current decision point.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
@Singleton
public class RequiredRuleNameComputer {

	private static final String[][] EMPTY_ARRAY = new String[0][];

	public static abstract class Param {
		public String ruleName;
		public List<Integer> paramStack;
		public AbstractElement elementToParse;

		private Set<Parameter> assignedParameters;
		
		protected Param(String ruleName, List<Integer> paramStack, AbstractElement elementToParse) {
			this.ruleName = ruleName;
			this.paramStack = paramStack;
			this.elementToParse = elementToParse;
		}
		
		public Set<Parameter> getAssignedParametes() {
			if (assignedParameters == null) {
				return assignedParameters = getAssignedParameters(elementToParse, paramStack);
			}
			return assignedParameters;
		}
		
		public abstract String getBaseRuleName(AbstractElement element);
	}
	
	@Inject
	private RuleNames ruleNames;
	
	public String[][] getRequiredRuleNames(Param param) {
		if (isFiltered(param)) {
			return EMPTY_ARRAY;
		}
		AbstractElement elementToParse = param.elementToParse;
		String ruleName = param.ruleName;
		if (ruleName == null) {
			if (elementToParse instanceof RuleCall) {
				RuleCall call = (RuleCall) elementToParse;
				if (call.getRule() instanceof ParserRule) {
					String antlrRuleName = ruleNames.getAntlrRuleName(call.getRule());
					if (!call.getArguments().isEmpty()) {
						Set<Parameter> context = param.getAssignedParametes();
						Set<Parameter> arguments = getAssignedArguments(call, context);
						int config = getParameterConfig(arguments);
						antlrRuleName = ruleNames.getAntlrRuleName(call.getRule(), config);
					}
					return new String[][] {{ antlrRuleName }};
				}
			}
			return EMPTY_ARRAY;
		}
		String adjustedRuleName = adjustRuleName(ruleName, param);
		if (!(GrammarUtil.isOptionalCardinality(elementToParse) || GrammarUtil.isOneOrMoreCardinality(elementToParse))) {
			return new String[][] {{ adjustedRuleName }};
		}
		if ((elementToParse.eContainer() instanceof Group)) {
			List<AbstractElement> tokens = getFilteredElements(((Group) elementToParse.eContainer()).getElements(), param);
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
	
	protected List<AbstractElement> getFilteredElements(List<AbstractElement> elements, Param param) {
		List<AbstractElement> result = Lists.newArrayListWithExpectedSize(elements.size());
		for(AbstractElement element: elements) {
			if (!isFiltered(element, param)) {
				result.add(element);
			}
		}
		return result;
	}

	protected boolean isFiltered(Param param) {
		return isFiltered(param.elementToParse, param);
	}
	
	protected boolean isFiltered(AbstractElement canddiate, Param param) {
		if (canddiate instanceof Group) {
			Group group = (Group) canddiate;
			if (group.getGuardCondition() != null) {
				Set<Parameter> context = param.getAssignedParametes();
				ConditionEvaluator evaluator = new ConditionEvaluator(context);
				if (!evaluator.evaluate(group.getGuardCondition())) {
					return true;
				}
			}
		}
		return false;
	}

	protected String adjustRuleName(String ruleName, Param param) {
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
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 */
	protected RuleNames getRuleNames() {
		return ruleNames;
	}
	
}
