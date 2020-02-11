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

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class ProductionFormatter<ELEMENT, TOKEN> implements Function<Production<ELEMENT, TOKEN>, String> {

	protected static class ObjToStrFunction<TOKEN> implements Function<TOKEN, String> {
		@Override
		public String apply(TOKEN from) {
			return from == null ? "null" : from.toString();
		}
	}

	protected int autoWrapChars = 140;

	protected int autoWrapChildren = 5;

	protected String indent = "    ";

	protected Function<TOKEN, String> tokenToString = new ObjToStrFunction<TOKEN>();

	@Override
	public String apply(Production<ELEMENT, TOKEN> from) {
		return format(from);
	}

	public String format(Production<ELEMENT, TOKEN> adapter) {
		return format(adapter, adapter.getRoot());
	}

	public String format(Production<ELEMENT, TOKEN> adapter, ELEMENT grammarElement) {
		return format(adapter, grammarElement, false);
	}

	public String format(Production<ELEMENT, TOKEN> adapter, ELEMENT grammarElement, boolean needParenthesis) {
		TOKEN token = adapter.getToken(grammarElement);
		if (token != null) {
			String cardinality = getCardinality(adapter, grammarElement);
			if (cardinality == null)
				return tokenToString.apply(token);
			return tokenToString.apply(token) + cardinality;
		}
		Iterable<ELEMENT> alternative = adapter.getAlternativeChildren(grammarElement);
		if (alternative != null)
			return format(adapter, grammarElement, alternative, " | ", false, needParenthesis);
		Iterable<ELEMENT> group = adapter.getSequentialChildren(grammarElement);
		if (group != null)
			return format(adapter, grammarElement, group, " ", false, needParenthesis);
		Iterable<ELEMENT> ungroup = adapter.getUnorderedChildren(grammarElement);
		if (ungroup != null)
			return format(adapter, grammarElement, ungroup, " & ", false, needParenthesis);
		return "<unknown>";
	}

	protected String format(Production<ELEMENT, TOKEN> adapter, ELEMENT element, Iterable<ELEMENT> children,
			String separator, boolean needWrap, boolean needParenthesis) {
		List<String> childStrs2 = Lists.newArrayList();
		int width2 = 0;
		for (ELEMENT child : children) {
			String childStr = format(adapter, child, true);
			childStrs2.add(childStr);
			width2 += childStr.length();
			if (childStr.contains("\n"))
				needWrap = true;
		}
		if (childStrs2.size() > autoWrapChildren)
			needWrap = true;
		if (width2 > autoWrapChars)
			needWrap = true;
		String cardinality = getCardinality(adapter, element);
		if (needWrap) {
			for (int i = 0; i < childStrs2.size(); i++)
				childStrs2.set(i, childStrs2.get(i).replaceAll("\\n", "\n" + indent));
			String body = Joiner.on(separator + "\n" + indent).join(childStrs2);
			return "(\n" + indent + body + "\n)" + (cardinality == null ? "" : cardinality);
		} else {
			if (cardinality != null && childStrs2.size() > 1)
				needParenthesis = true;
			String body = Joiner.on(separator).join(childStrs2);
			if (needParenthesis)
				return "(" + body + ")" + (cardinality == null ? "" : cardinality);
			return body;
		}
	}

	protected String getCardinality(Production<ELEMENT, TOKEN> adapter, ELEMENT ele) {
		return adapter.isMany(ele) ? adapter.isOptional(ele) ? "*" : "+" : adapter.isOptional(ele) ? "?" : null;
	}

	public ProductionFormatter<ELEMENT, TOKEN> setAutoWrapChars(int autoWrapChars) {
		this.autoWrapChars = autoWrapChars;
		return this;
	}

	public ProductionFormatter<ELEMENT, TOKEN> setAutoWrapChildren(int autoWrapChildren) {
		this.autoWrapChildren = autoWrapChildren;
		return this;
	}

	public ProductionFormatter<ELEMENT, TOKEN> setIndent(String indent) {
		this.indent = indent;
		return this;
	}

	public ProductionFormatter<ELEMENT, TOKEN> setTokenToString(Function<TOKEN, String> tokenToString) {
		this.tokenToString = tokenToString;
		return this;
	}

}
