/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.scoping;

import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.XtextSwitch;

import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SyntaxFilteredScopes {

	public IScope create(IScope parent, AbstractElement syntaxElement) {
		if (syntaxElement instanceof CrossReference) {
			return create(parent, ((CrossReference) syntaxElement).getTerminal());
		}
		if (syntaxElement instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) syntaxElement).getRule();
			if (GrammarUtil.isDatatypeRule(rule)) {
				List<String> values = getEnumeratedValues((ParserRule) rule);
				if (values.isEmpty()) {
					return parent;
				}
				return new SyntaxFilteredScope(parent, values);
			}
		}
		return parent;
	}
	
	public List<String> getEnumeratedValues(ParserRule rule) {
		List<String> result = new XtextSwitch<List<String>>() {
			@Override
			public List<String> caseKeyword(Keyword object) {
				if (GrammarUtil.isMultipleCardinality(object)) {
					return Collections.emptyList();
				}
				if (GrammarUtil.isOptionalCardinality(object)) {
					return Lists.newArrayList("", object.getValue());
				}
				return Lists.newArrayList(object.getValue());
			}
			@Override
			public List<String> caseAssignment(Assignment object) {
				if (GrammarUtil.isMultipleCardinality(object)) {
					return Collections.emptyList();
				}
				List<String> nested = doSwitch(object.getTerminal());
				if (GrammarUtil.isOptionalCardinality(object)) {
					if (nested.isEmpty()) {
						return Collections.emptyList();
					}
					nested.add("");
				}
				return nested;
			}
			@Override
			public List<String> caseAlternatives(Alternatives object) {
				if (GrammarUtil.isMultipleCardinality(object)) {
					return Collections.emptyList();
				}
				List<String> result = Lists.newArrayList();
				if (GrammarUtil.isOptionalCardinality(object)) {
					result.add("");
				}
				for(AbstractElement element: object.getElements()) {
					List<String> nested = doSwitch(element);
					if (nested.isEmpty()) {
						return Collections.emptyList();
					}
					result.addAll(nested);
				}
				return result;
			}
			@Override
			public List<String> caseGroup(Group object) {
				if (GrammarUtil.isMultipleCardinality(object)) {
					return Collections.emptyList();
				}
				List<String> result = Lists.newArrayList();
				for(AbstractElement element: object.getElements()) {
					List<String> nested = doSwitch(element);
					if (nested.isEmpty()) {
						return Collections.emptyList();
					}
					if (result.isEmpty()) {
						result.addAll(nested);
					} else if (nested.size() == 1) {
						String addMe = nested.get(0);
						for(int i = 0; i < result.size(); i++) {
							result.set(i, result.get(i) + addMe);
						}
					} else {
						List<String> wasResult = result;
						result = Lists.newArrayListWithExpectedSize(result.size() * nested.size());
						for(String prefix: wasResult) {
							for(String suffix: nested) {
								result.add(prefix + suffix);
							}
						}
					}
				}
				if (GrammarUtil.isOptionalCardinality(object)) {
					result.add("");
				}
				return result;
			}
			@Override
			public List<String> caseAbstractElement(AbstractElement object) {
				return Collections.emptyList();
			}
		}.doSwitch(rule.getAlternatives());
		return result;
	}
	
}
