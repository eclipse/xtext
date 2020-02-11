/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.formallang.StringProduction.ProdElement;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringCfg extends StringProduction implements Cfg<ProdElement, String> {

	public StringCfg() {
		super();
	}

	protected Map<String, ProdElement> rules = Maps.newLinkedHashMap();

	public ProdElement rule(String rule) {
		Stack<Pair<Token, String>> tokens = lex(rule);
		if (tokens.peek().getFirst() == Token.ID) {
			String ruleName = tokens.peek().getSecond();
			tokens.pop();
			if (tokens.peek().getFirst() == Token.COLON) {
				tokens.pop();
				ProdElement ele = parseAlt(tokens);
				if (root == null)
					root = ele;
				rules.put(ruleName, ele);
				return ele;
			} else
				throw new RuntimeException("Expected ':'");
		} else
			throw new RuntimeException("Expected ID");
	}

	@Override
	public ProdElement getCall(ProdElement ele) {
		if (ele.name != null)
			return rules.get(ele.name);
		return null;
	}

	@Override
	public String toString() {
		List<String> result = Lists.newArrayList();
		ProductionFormatter<ProdElement, String> fmt = new ProductionFormatter<ProdElement, String>();
		for (Entry<String, ProdElement> e : rules.entrySet())
			result.add(e.getKey() + ": " + fmt.format(this, e.getValue()));
		return Joiner.on('\n').join(result);
	}

}
