/*******************************************************************************
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import static org.eclipse.xtext.xtext.ParameterConfigHelper.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
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
 * Computes the Antlr method names that need to be invoked to continue the follow element computation for content
 * proposals. It is used if a previous round produced follow elements with a lookahead bigger than 1. The result of
 * {@link #getRequiredRuleNames(Param)} is the list of methods that need need to be invoked to force the parser in one
 * or the other direction at the current decision point.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
@Singleton
public class RequiredRuleNameComputer {

	private static final String[][] EMPTY_ARRAY = new String[0][];

	/**
	 * A parameter configuration for a parameterized rule in the current stack of the parser.
	 */
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

	/**
	 * Returns the names of parser rules that should be called in order to obtain the follow elements for the parser
	 * call stack described by the given param.
	 */
	public String[][] getRequiredRuleNames(Param param) {
		if (isFiltered(param)) {
			return EMPTY_ARRAY;
		}
		AbstractElement elementToParse = param.elementToParse;
		String ruleName = param.ruleName;
		if (ruleName == null) {
			return getRequiredRuleNames(param, elementToParse);
		}
		return getAdjustedRequiredRuleNames(param, elementToParse, ruleName);
	}

	/**
	 * @since 2.14
	 */
	protected String[][] getAdjustedRequiredRuleNames(Param param, AbstractElement elementToParse,
			String originalRuleName) {
		String adjustedRuleName = adjustRuleName(originalRuleName, param);
		if (!(GrammarUtil.isOptionalCardinality(elementToParse)
				|| GrammarUtil.isOneOrMoreCardinality(elementToParse))) {
			return new String[][] { { adjustedRuleName } };
		}
		EObject container = elementToParse.eContainer();
		if (container instanceof Group) {
			Group group = (Group) container;
			List<AbstractElement> filteredElements = getFilteredElements(group.getElements(), param);
			int idx = filteredElements.indexOf(elementToParse) + 1;
			if (idx != filteredElements.size()) {
				String adjustedSecondRule = getAdjustedSecondRule(param, group, idx);
				return getRuleNamesInGroup(param, elementToParse, adjustedRuleName, adjustedSecondRule);
			}
		}
		return new String[][] { { adjustedRuleName } };
	}

	/**
	 * @since 2.14
	 */
	protected String getAdjustedSecondRule(Param param, Group group, int idx) {
		String secondRule = param.getBaseRuleName(group);
		secondRule = secondRule.substring(0, secondRule.lastIndexOf('_') + 1) + idx;
		String adjustedSecondRule = adjustRuleName(secondRule, param);
		return adjustedSecondRule;
	}

	/**
	 * @since 2.14
	 */
	protected String[][] getRuleNamesInGroup(Param param, AbstractElement elementToParse, String adjustedFirstRule,
			String adjustedSecondRule) {
		if (GrammarUtil.isMultipleCardinality(elementToParse))
			return new String[][] { { adjustedFirstRule }, { adjustedFirstRule, adjustedSecondRule } };
		return new String[][] { { adjustedFirstRule, adjustedSecondRule } };
	}

	/**
	 * @since 2.14
	 */
	protected String[][] getRequiredRuleNames(Param param, AbstractElement elementToParse) {
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
				return new String[][] { { antlrRuleName } };
			}
		}
		return EMPTY_ARRAY;
	}

	protected List<AbstractElement> getFilteredElements(List<AbstractElement> elements, Param param) {
		List<AbstractElement> result = Lists.newArrayListWithExpectedSize(elements.size());
		for (AbstractElement element : elements) {
			if (!isFiltered(element, param)) {
				result.add(element);
			}
		}
		return result;
	}

	/**
	 * Returns true if the grammar element that is associated with the given param is filtered due to guard conditions
	 * of parameterized rules in the current call stack.
	 * 
	 * If the grammar element is the only element contained in a group, its container is checked, too.
	 * 
	 * @see #isFiltered(AbstractElement, Param)
	 */
	protected boolean isFiltered(Param param) {
		AbstractElement elementToParse = param.elementToParse;
		while (elementToParse != null) {
			if (isFiltered(elementToParse, param)) {
				return true;
			}
			elementToParse = getEnclosingSingleElementGroup(elementToParse);
		}
		return false;
	}

	/**
	 * Return the containing group if it contains exactly one element.
	 * 
	 * @since 2.14
	 */
	protected AbstractElement getEnclosingSingleElementGroup(AbstractElement elementToParse) {
		EObject container = elementToParse.eContainer();
		if (container instanceof Group) {
			if (((Group) container).getElements().size() == 1) {
				return (AbstractElement) container;
			}
		}
		return null;
	}

	/**
	 * Returns true if the given candidate is a group that is filtered due to rule parameters in the current call graph.
	 */
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
				len += 2; // rule__XYZ instead of ruleXYZ
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
