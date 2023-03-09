/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.NamedArgument;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParameterConfigHelper {

	public static Set<Parameter> getAssignedParameters(AbstractElement element, int parameterConfig) {
		if (parameterConfig != 0) {
			ParserRule parserRule = GrammarUtil.containingParserRule(element);
			Set<Parameter> allParameters = ImmutableSet.copyOf(parserRule.getParameters());
			int seen = 0;
			for(Set<Parameter> candidate: Sets.powerSet(allParameters)) {
				if (seen == parameterConfig) {
					return candidate;
				}
				seen++;
			}
		}
		return Collections.emptySet();
	}
	
	public static int getParameterConfig(Set<Parameter> params) {
		if (params.isEmpty()) {
			return 0;
		}
		Parameter firstParam = params.iterator().next();
		ParserRule parserRule = GrammarUtil.containingParserRule(firstParam);
		return getParameterConfig(params, parserRule);
	}
	
	public static int getParameterConfig(Set<Parameter> params, ParserRule context) {
		if (params.isEmpty()) {
			return 0;
		}
		Set<Parameter> allParameters = ImmutableSet.copyOf(context.getParameters());
		int result = 0;
		for(Set<Parameter> candidate: Sets.powerSet(allParameters)) {
			if (params.equals(candidate)) {
				return result;
			}
			result++;
		}
		throw new IllegalStateException();
	}
	
	public static Set<Parameter> getAssignedParameters(AbstractElement element, List<Integer> paramStack) {
		if (!paramStack.isEmpty()) {
			return getAssignedParameters(element, paramStack.get(paramStack.size() - 1));
		}
		return Collections.emptySet();
	}
	
	public static Set<Parameter> getAssignedArguments(RuleCall ruleCall, Set<Parameter> contextParameters) {
		if (!ruleCall.getArguments().isEmpty()) {
			ConditionEvaluator evaluator = new ConditionEvaluator(contextParameters);
			ImmutableSet.Builder<Parameter> result = ImmutableSet.builder();
			for(NamedArgument argument: ruleCall.getArguments()) {
				if (evaluator.evaluate(argument.getValue())) {
					result.add(argument.getParameter());
				}
			}
			return result.build();
		} else {
			return Collections.emptySet();
		}
	}
	
}
