/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr;

import java.util.List;
import java.util.Map;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class FirstSetComputer {

	public static List<AbstractElement> getFirstSet(AbstractElement element) {
		Impl impl = new Impl();
		impl.doSwitch(element);
		List<AbstractElement> result = Lists.<AbstractElement>newArrayList(impl.keywords.values());
		result.addAll(impl.ruleCalls.values());
		return result;
	}
	
	private static class Impl extends XtextSwitch<Boolean> {
		
		Map<String, Keyword> keywords = Maps.newLinkedHashMap();
		Map<TerminalRule, RuleCall> ruleCalls = Maps.newLinkedHashMap();
		
		@Override
		public Boolean caseRuleCall(RuleCall object) {
			AbstractRule rule = object.getRule();
			if (rule instanceof TerminalRule) {
				ruleCalls.put((TerminalRule) rule, object);
			} else {
				boolean result = doSwitch(rule.getAlternatives());
				if (result) {
					return true;
				}
			}
			return GrammarUtil.isOptionalCardinality(object);
		}
		
		@Override
		public Boolean caseAction(Action object) {
			return true;
		}
		
		@Override
		public Boolean caseKeyword(Keyword object) {
			keywords.put(object.getValue(), object);
			return GrammarUtil.isOptionalCardinality(object);
		}
		
		@Override
		public Boolean caseAssignment(Assignment object) {
			doSwitch(object.getTerminal());
			return GrammarUtil.isOptionalCardinality(object);
		}
		
		@Override
		public Boolean caseCrossReference(CrossReference object) {
			return doSwitch(object.getTerminal());
		}
		
		@Override
		public Boolean caseEnumLiteralDeclaration(EnumLiteralDeclaration object) {
			return doSwitch(object.getLiteral());
		}
		
		@Override
		public Boolean caseGroup(Group object) {
			for(AbstractElement element: object.getElements()) {
				if (!doSwitch(element)) {
					return GrammarUtil.isOptionalCardinality(object);
				}
			}
			return GrammarUtil.isOptionalCardinality(object);
		}
		
		@Override
		public Boolean caseAlternatives(Alternatives object) {
			boolean result = false;
			for(AbstractElement element: object.getElements()) {
				if (doSwitch(element)) {
					result = true;
				}
			}
			return result || GrammarUtil.isOptionalCardinality(object);
		}
		
		@Override
		public Boolean caseUnorderedGroup(UnorderedGroup object) {
			boolean result = true;
			for(AbstractElement element: object.getElements()) {
				if (!doSwitch(element)) {
					result = false;
				}
			}
			return result || GrammarUtil.isOptionalCardinality(object);
		}
		
	}
	
}
