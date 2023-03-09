/**
 * Copyright (c) 2016, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator.serializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.analysis.SerializationContextMap;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class NamedSerializationContextProvider {
	private final Map<ParserRule, Integer> rules;

	public NamedSerializationContextProvider(Grammar grammar) {
		rules = new HashMap<>();
		int index = 0;
		for (ParserRule rule : GrammarUtil.allParserRules(grammar)) {
			rules.put(rule, index++);
		}
	}

	public <T extends Object> List<NamedSerializationContexts<T>> getNamedContexts(SerializationContextMap<T> map) {
		ArrayList<NamedSerializationContexts<T>> result = new ArrayList<>();
		HashMap<String, Integer> names = new LinkedHashMap<String, Integer>();
		for (SerializationContextMap.Entry<T> e : map.values()) {
			for (EClass t : e.getTypes()) {
				List<ISerializationContext> ctx = e.getContexts(t);
				String namePrefix = (t == null) ? "" : t.getName();
				String name = namePrefix + "_" + getSignificantGrammarElement(ctx);
				Integer dup = names.get(name);
				String unique = null;
				if (dup == null) {
					names.put(name, 1);
					unique = name;
				} else {
					names.put(name, dup.intValue() + 1);
					unique = name + "_" + dup;
				}
				result.add(new NamedSerializationContexts<T>(unique, t, ctx, e.getValue()));
			}
		}
		return result;
	}

	public String getSignificantGrammarElement(Iterable<ISerializationContext> contexts) {
		ParserRule rule = null;
		int index = Integer.MAX_VALUE;
		for (ISerializationContext ctx : contexts) {
			ParserRule pr = ctx.getParserRule();
			if (pr == null) {
				Action action = ctx.getAssignedAction();
				if (action != null) {
					pr = GrammarUtil.containingParserRule(action);
				}
			}
			if (pr != null) {
				Integer i = rules.get(pr);
				if (i.intValue() < index) {
					index = i.intValue();
					rule = pr;
				}
			}
		}
		if (rule != null) {
			return rule.getName();
		}
		return "unknown";
	}
}
