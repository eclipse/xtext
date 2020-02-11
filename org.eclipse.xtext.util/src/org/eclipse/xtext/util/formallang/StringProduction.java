/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.StringProduction.ProdElement;

import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringProduction implements Production<ProdElement, String> {

	public static enum ElementType {
		ALTERNATIVE, SEQUENCE, TOKEN, UNOREDERED
	}

	public class ProdElement {
		protected List<ProdElement> children;
		protected boolean many;
		protected String name;
		protected boolean optional;
		protected ProdElement parent;

		protected ElementType type;

		protected String value;

		public ProdElement(ElementType type) {
			super();
			this.type = type;
			if (type != ElementType.TOKEN)
				this.children = Lists.newArrayList();
		}

		public void setValue(String value) {
			this.value = value;
		}

		protected void addChild(ProdElement ele) {
			children.add(ele);
			ele.parent = this;
		}

		public List<ProdElement> getChildren() {
			return children;
		}

		public void setMany(boolean many) {
			this.many = many;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setOptional(boolean optional) {
			this.optional = optional;
		}

		public String getName() {
			return name;
		}

		public ProdElement getParent() {
			return parent;
		}

		public ElementType getType() {
			return type;
		}

		public String getValue() {
			return value;
		}

		public boolean isMany() {
			return many;
		}

		public boolean isOptional() {
			return optional;
		}

		@Override
		public String toString() {
			if (value != null)
				return "'" + value + "'";
			if (name != null)
				return name;
			return new ProductionFormatter<ProdElement, String>().format(StringProduction.this, this);
		}
	}

	protected enum Token {
		AND("&"), // 
		COLON(":"), //
		EQ("="), //
		ID("[a-zA-Z][a-zA-Z0-9]*"), //
		PIPE("\\|"), //
		PL("\\("), //
		PLUS("\\+"), //
		PR("\\)"), //
		QM("\\?"), //
		STAR("\\*"), //
		STRING("'([^']*)'");

		public final Pattern pattern;

		private Token(String regex) {
			this.pattern = Pattern.compile("^" + regex);
		}
	}

	protected static final Pattern WS = Pattern.compile("^[\\s]+");

	protected ProdElement root;

	public StringProduction() {
		super();
	}

	public StringProduction(String production) {
		root = parseAlt(lex(production));
	}

	protected ProdElement createElement(ElementType type) {
		return new ProdElement(type);
	}

	@Override
	public Iterable<ProdElement> getAlternativeChildren(ProdElement ele) {
		return ele.type == ElementType.ALTERNATIVE ? ele.children : null;
	}

	@Override
	public ProdElement getParent(ProdElement ele) {
		return ele.parent;
	}

	@Override
	public ProdElement getRoot() {
		return root;
	}

	@Override
	public Iterable<ProdElement> getSequentialChildren(ProdElement ele) {
		return ele.type == ElementType.SEQUENCE ? ele.children : null;
	}

	@Override
	public String getToken(ProdElement ele) {
		return ele.type == ElementType.TOKEN ? ele.value : null;
	}

	@Override
	public Iterable<ProdElement> getUnorderedChildren(ProdElement ele) {
		return ele.type == ElementType.UNOREDERED ? ele.children : null;
	}

	@Override
	public boolean isMany(ProdElement ele) {
		return ele.many;
	}

	@Override
	public boolean isOptional(ProdElement ele) {
		return ele.optional;
	}

	protected Stack<Pair<Token, String>> lex(String string) {
		int offset = 0;
		Matcher wsMatcher = WS.matcher(string);
		List<Pair<Token, Matcher>> matcher = Lists.newArrayList();
		for (Token t : Token.values())
			matcher.add(Tuples.create(t, t.pattern.matcher(string)));
		Stack<Pair<Token, String>> result = new Stack<Pair<Token, String>>();
		ROOT: while (offset < string.length()) {
			wsMatcher.region(offset, string.length());
			if (wsMatcher.find()) {
				offset = wsMatcher.end();
				continue ROOT;
			}
			for (Pair<Token, Matcher> m : matcher) {
				m.getSecond().region(offset, string.length());
				if (m.getSecond().find()) {
					result.add(Tuples.create(m.getFirst(), m.getSecond().group(m.getSecond().groupCount() == 1 ? 1 : 0)));
					offset = m.getSecond().end();
					continue ROOT;
				}
			}
			throw new RuntimeException("No valid token found at '" + string.substring(offset) + "'");
		}
		Collections.reverse(result);
		return result;
	}

	protected ProdElement parseAlt(Stack<Pair<Token, String>> tokens) {
		ProdElement first = parseUnordered(tokens);
		if (!tokens.isEmpty() && tokens.peek().getFirst() == Token.PIPE) {
			ProdElement uno = createElement(ElementType.ALTERNATIVE);
			uno.addChild(first);
			do {
				tokens.pop();
				ProdElement next = parseUnordered(tokens);
				uno.addChild(next);
			} while (!tokens.isEmpty() && tokens.peek().getFirst() == Token.PIPE);
			return uno;
		}
		return first;
	}

	protected void parseCardinality(Stack<Pair<Token, String>> tokens, ProdElement ele) {
		if (!tokens.isEmpty())
			switch (tokens.peek().getFirst()) {
				case QM:
					tokens.pop();
					ele.optional = true;
					break;
				case STAR:
					tokens.pop();
					ele.optional = true;
					ele.many = true;
					break;
				case PLUS:
					tokens.pop();
					ele.many = true;
					break;
				default:
			}
	}

	protected ProdElement parsePrim(Stack<Pair<Token, String>> tokens) {
		Pair<Token, String> current = tokens.pop();
		switch (current.getFirst()) {
			case PL:
				ProdElement result1 = parseAlt(tokens);
				if (tokens.peek().getFirst().equals(Token.PR))
					tokens.pop();
				else
					throw new RuntimeException("')' expected, but " + tokens.peek().getFirst() + " found");
				parseCardinality(tokens, result1);
				return result1;
			case STRING:
				ProdElement result2 = createElement(ElementType.TOKEN);
				result2.value = current.getSecond();
				parseCardinality(tokens, result2);
				return result2;
			case ID:
				ProdElement result3 = createElement(ElementType.TOKEN);
				result3.name = current.getSecond();
				parseCardinality(tokens, result3);
				return result3;
			default:
				throw new RuntimeException("Unexpected token " + current.getFirst());
		}
	}

	protected ProdElement parseSeq(Stack<Pair<Token, String>> tokens) {
		ProdElement first = parsePrim(tokens);
		EnumSet<Token> followers = EnumSet.of(Token.STRING, Token.PL, Token.ID);
		if (!tokens.isEmpty() && followers.contains(tokens.peek().getFirst())) {
			ProdElement seq = createElement(ElementType.SEQUENCE);
			seq.addChild(first);
			do {
				ProdElement next = parsePrim(tokens);
				seq.addChild(next);
			} while (!tokens.isEmpty() && followers.contains(tokens.peek().getFirst()));
			return seq;
		}
		return first;
	}

	protected ProdElement parseUnordered(Stack<Pair<Token, String>> tokens) {
		ProdElement first = parseSeq(tokens);
		if (!tokens.isEmpty() && tokens.peek().getFirst() == Token.AND) {
			ProdElement uno = createElement(ElementType.UNOREDERED);
			uno.addChild(first);
			do {
				tokens.pop();
				ProdElement next = parseSeq(tokens);
				uno.addChild(next);
			} while (!tokens.isEmpty() && tokens.peek().getFirst() == Token.AND);
			return uno;
		}
		return first;
	}

	@Override
	public String toString() {
		if (root == null)
			return "null";
		return new ProductionFormatter<ProdElement, String>().format(this);
	}

}
