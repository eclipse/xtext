/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class GrammarFormatter<ELEMENT, TOKEN> {

	protected static class ObjToStrFunction<TOKEN> implements Function<TOKEN, String> {
		public String apply(TOKEN from) {
			return from == null ? "null" : from.toString();
		}
	}

	protected final static int AUTO_WRAP_CHARS = 140;

	protected final static String INDENT = "    ";

	public static <ELEMENT, TOKEN> GrammarFormatter<ELEMENT, TOKEN> newFormatter(IGrammarAdapter<ELEMENT, TOKEN> adapter) {
		return new GrammarFormatter<ELEMENT, TOKEN>(adapter);
	}

	public static <ELEMENT, TOKEN> GrammarFormatter<ELEMENT, TOKEN> newFormatter(
			IGrammarAdapter<ELEMENT, TOKEN> adapter, Function<TOKEN, String> tokenToString) {
		return new GrammarFormatter<ELEMENT, TOKEN>(adapter, tokenToString);
	}

	protected IGrammarAdapter<ELEMENT, TOKEN> adapter;

	protected Function<TOKEN, String> tokenToString;

	public GrammarFormatter(IGrammarAdapter<ELEMENT, TOKEN> adapter) {
		super();
		this.adapter = adapter;
		this.tokenToString = new ObjToStrFunction<TOKEN>();
	}

	public GrammarFormatter(IGrammarAdapter<ELEMENT, TOKEN> adapter, Function<TOKEN, String> tokenToString) {
		super();
		this.adapter = adapter;
		this.tokenToString = tokenToString;
	}

	public String format(ELEMENT grammarElement) {
		return format(grammarElement, false);
	}

	public String format(ELEMENT grammarElement, boolean needParenthesis) {
		TOKEN token = adapter.getToken(grammarElement);
		if (token != null) {
			String cardinality = getCardinality(grammarElement);
			if (cardinality == null)
				return tokenToString.apply(token);
			return tokenToString.apply(token) + cardinality;
		}
		Iterable<ELEMENT> alternative = adapter.getAlternativeChildren(grammarElement);
		if (alternative != null)
			return format(grammarElement, alternative, " | ", false, needParenthesis, 5);
		Iterable<ELEMENT> group = adapter.getSequentialChildren(grammarElement);
		if (group != null)
			return format(grammarElement, group, " ", false, needParenthesis, 5);
		Iterable<ELEMENT> ungroup = adapter.getUnorderedChildren(grammarElement);
		if (ungroup != null)
			return format(grammarElement, ungroup, " & ", false, needParenthesis, 5);
		return "<unknown>";
	}

	protected String format(ELEMENT element, Iterable<ELEMENT> children, String separator, boolean needWrap,
			boolean needParenthesis, int maxChildren) {
		List<String> childStrs2 = Lists.newArrayList();
		int width2 = 0;
		for (ELEMENT child : children) {
			String childStr = format(child, true);
			childStrs2.add(childStr);
			width2 += childStr.length();
			if (childStr.contains("\n"))
				needWrap = true;
		}
		if (childStrs2.size() > maxChildren)
			needWrap = true;
		if (width2 > AUTO_WRAP_CHARS)
			needWrap = true;
		String cardinality = getCardinality(element);
		if (needWrap) {
			for (int i = 0; i < childStrs2.size(); i++)
				childStrs2.set(i, childStrs2.get(i).replaceAll("\\n", "\n" + INDENT));
			String body = Joiner.on(separator + "\n" + INDENT).join(childStrs2);
			return "(\n" + INDENT + body + "\n)" + (cardinality == null ? "" : cardinality);
		} else {
			if (cardinality != null && childStrs2.size() > 1)
				needParenthesis = true;
			String body = Joiner.on(separator).join(childStrs2);
			if (needParenthesis)
				return "(" + body + ")" + (cardinality == null ? "" : cardinality);
			return body;
		}
	}

	protected String getCardinality(ELEMENT ele) {
		return adapter.isMany(ele) ? adapter.isOptional(ele) ? "*" : "+" : adapter.isOptional(ele) ? "?" : null;
	}

}
