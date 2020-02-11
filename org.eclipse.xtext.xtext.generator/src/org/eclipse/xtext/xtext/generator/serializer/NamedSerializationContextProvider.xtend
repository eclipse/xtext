/*******************************************************************************
 * Copyright (c) 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.serializer

import java.util.List
import java.util.Map
import org.eclipse.emf.ecore.EClass
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.GrammarUtil
import org.eclipse.xtext.ParserRule
import org.eclipse.xtext.serializer.ISerializationContext
import org.eclipse.xtext.serializer.analysis.SerializationContextMap

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
class NamedSerializationContextProvider {
	val Map<ParserRule, Integer> rules

	new(Grammar grammar) {
		rules = newHashMap(GrammarUtil.allParserRules(grammar).indexed.map[value -> key])
	}

	def <T> List<NamedSerializationContexts<T>> getNamedContexts(SerializationContextMap<T> map) {
		val result = <NamedSerializationContexts<T>>newArrayList()
		val names = <String, Integer>newHashMap()
		for (e : map.values) {
			for (t : e.types) {
				val ctx = e.getContexts(t)
				val name = (if(t === null) "" else t.name) + "_" + getSignificantGrammarElement(ctx)
				val dup = names.get(name)
				val unique = if (dup === null) {
						names.put(name, 1)
						name
					} else {
						names.put(name, dup + 1)
						name + "_" + dup
					}
				result += new NamedSerializationContexts(unique, t, ctx, e.value)
			}
		}
		return result;
	}

	def String getSignificantGrammarElement(Iterable<ISerializationContext> contexts) {
		var ParserRule rule = null
		var index = Integer.MAX_VALUE;
		for (ISerializationContext ctx : contexts) {
			var pr = ctx.parserRule
			if (pr === null) {
				val action = ctx.assignedAction
				if (action !== null) {
					pr = GrammarUtil.containingParserRule(action)
				}
			}
			if (pr !== null) {
				val i = rules.get(pr)
				if (i < index) {
					index = i
					rule = pr
				}
			}
		}
		if (rule !== null) {
			return rule.name
		}
		return "unknown"
	}

}

@Accessors class NamedSerializationContexts<T> {
	val String name
	val EClass type
	val List<ISerializationContext> contexts
	val T value

}
