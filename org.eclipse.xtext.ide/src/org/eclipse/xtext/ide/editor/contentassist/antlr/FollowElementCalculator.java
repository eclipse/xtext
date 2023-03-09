/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.ide.editor.contentassist.IFollowElementAcceptor;
import org.eclipse.xtext.util.XtextSwitch;
import org.eclipse.xtext.xtext.ConditionEvaluator;
import org.eclipse.xtext.xtext.ParameterConfigHelper;

import com.google.common.collect.Sets;

/**
 * @since 2.9
 */
public class FollowElementCalculator extends XtextSwitch<Boolean> {
	
	protected IFollowElementAcceptor acceptor;
	
	private List<AbstractElement> handledAlternatives;

	private UnorderedGroup group;
	
	private Collection<RuleCall> visitedRuleCalls = Sets.newHashSet();
	
	private int parameterConfig = 0;
	
	private Set<Parameter> currentConfig = null;
	
	/**
	 * @since 2.9
	 */
	public void setAcceptor(IFollowElementAcceptor acceptor) {
		this.acceptor = acceptor;
	}
	
	public void setParameterConfig(int parameterConfig) {
		this.parameterConfig = parameterConfig;
	}
	
	public void doSwitch(UnorderedGroup group, List<AbstractElement> handledAlternatives) {
		this.group = group;
		this.handledAlternatives = handledAlternatives;
		try {
			doSwitch(group);
		} finally {
			this.handledAlternatives = null;
			this.group = null;
		}
	}
	
	@Override
	public Boolean caseAlternatives(Alternatives object) {
		boolean more = false;
		for(AbstractElement element: object.getElements()) {
			more = doSwitch(element) || more;
		}
		return more || isOptional(object);
	}
	
	@Override
	public Boolean caseUnorderedGroup(UnorderedGroup object) {
		if (object == this.group) {
			boolean more = true;
			for(AbstractElement element: object.getElements()) {
				if (handledAlternatives == null || !handledAlternatives.contains(element)) {
					this.group = null;
					more = doSwitch(element) && more;
					this.group = object;
				}
			}
			if (more && GrammarUtil.isMultipleCardinality(object)) {
				handledAlternatives = null;
				this.group = null;
				return caseUnorderedGroup(object);
			}
			return more || isOptional(object);
		} else {
			boolean more = true;
			for(AbstractElement element: object.getElements()) {
				more = doSwitch(element) && more;
			}
			return more || isOptional(object);
		}
	}
	
	@Override
	public Boolean caseGroup(Group object) {
		boolean more = true;
		if (object.getGuardCondition() != null) {
			Set<Parameter> parameterValues = getParameterValues(object);
			more = new ConditionEvaluator(parameterValues).evaluate(object.getGuardCondition());
		}
		if (more) {
			for(AbstractElement element: object.getElements()) {
				more = more && doSwitch(element);
			}
		}
		return more || isOptional(object);
	}
	
	private Set<Parameter> getParameterValues(AbstractElement object) {
		Set<Parameter> parameterValues = Collections.emptySet();
		if (currentConfig != null) {
			parameterValues = currentConfig;
		} else {
			parameterValues = ParameterConfigHelper.getAssignedParameters(object, parameterConfig);
		}
		return parameterValues;
	}
	
	@Override
	public Boolean caseAction(Action object) {
		return true;
	}
	
	@Override
	public Boolean caseAssignment(Assignment object) {
		acceptor.accept(object);
		return doSwitch(object.getTerminal()) || isOptional(object);
	}
	
	@Override
	public Boolean caseCrossReference(CrossReference object) {
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseParserRule(ParserRule object) {
		if (GrammarUtil.isDatatypeRule(object))
			return Boolean.FALSE;
		return doSwitch(object.getAlternatives());
	}
	
	@Override
	public Boolean caseEnumRule(EnumRule object) {
		return doSwitch(object.getAlternatives());
	}
	
	@Override
	public Boolean caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
		return doSwitch(object.getLiteral());
	}
	
	@Override
	public Boolean caseRuleCall(RuleCall object) {
		if (!visitedRuleCalls.add(object))
			return isOptional(object);
		acceptor.accept(object);
		Set<Parameter> oldConfig = currentConfig;
		try {
			if (!object.getArguments().isEmpty()) {
				currentConfig = ParameterConfigHelper.getAssignedArguments(object, getParameterValues(object));
			} else {
				currentConfig = Collections.emptySet();
			}
			Boolean result = doSwitch(object.getRule()) || isOptional(object);
			visitedRuleCalls.remove(object);
			return result;
		} finally {
			currentConfig = oldConfig;
		}
	}
	
	@Override
	public Boolean caseTerminalRule(TerminalRule object) {
		return Boolean.FALSE;
	}
	
	@Override
	public Boolean caseKeyword(Keyword object) {
		acceptor.accept(object);
		return isOptional(object);
	}
	
	public boolean isOptional(AbstractElement element) {
		return GrammarUtil.isOptionalCardinality(element);
	}
}