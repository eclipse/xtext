/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.util.formallang;

import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;
import org.eclipse.xtext.util.formallang.StringProduction.Element;

import com.google.inject.internal.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class StringProduction implements Production<Element, String> {

	public class Element {
		protected List<Element> children;
		protected boolean many;
		protected boolean optional;
		protected Element parent;
		protected ElementType type;
		protected String value;

		protected Element(ElementType type) {
			super();
			this.type = type;
			if (type != ElementType.TOKEN)
				this.children = Lists.newArrayList();
		}

		protected Element(String value) {
			this(ElementType.TOKEN);
			this.value = value;
		}

		protected void addChild(Element ele) {
			children.add(ele);
			ele.parent = this;
		}

		@Override
		public String toString() {
			//			switch (type) {
			//				case TOKEN:
			//					return "'" + value + "'";
			//				default:
			ProductionFormatter<Element, String> pf = new ProductionFormatter<StringProduction.Element, String>();
			return pf.format(StringProduction.this, this);
			//			}
		}
	}

	public static enum ElementType {
		ALTERNATIVE, SEQUENCE, TOKEN, UNOREDERED
	}

	protected enum Token {
		AND("&"), // 
		COLON(":"), //
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

	protected Element root;

	public StringProduction() {
		super();
	}

	public StringProduction(String production) {
		root = parseAlt(lex(production));
	}

	public Iterable<Element> getAlternativeChildren(Element ele) {
		return ele.type == ElementType.ALTERNATIVE ? ele.children : null;
	}

	public Element getParent(Element ele) {
		return ele.parent;
	}

	public Element getRoot() {
		return root;
	}

	public Iterable<Element> getSequentialChildren(Element ele) {
		return ele.type == ElementType.SEQUENCE ? ele.children : null;
	}

	public String getToken(Element ele) {
		return ele.type == ElementType.TOKEN ? ele.value : null;
	}

	public Iterable<Element> getUnorderedChildren(Element ele) {
		return ele.type == ElementType.UNOREDERED ? ele.children : null;
	}

	public boolean isMany(Element ele) {
		return ele.many;
	}

	public boolean isOptional(Element ele) {
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

	protected Element parseAlt(Stack<Pair<Token, String>> tokens) {
		Element first = parseUnordered(tokens);
		if (!tokens.isEmpty() && tokens.peek().getFirst() == Token.PIPE) {
			Element uno = new Element(ElementType.ALTERNATIVE);
			uno.addChild(first);
			do {
				tokens.pop();
				Element next = parseUnordered(tokens);
				uno.addChild(next);
			} while (!tokens.isEmpty() && tokens.peek().getFirst() == Token.PIPE);
			return uno;
		}
		return first;
	}

	protected void parseCardinality(Stack<Pair<Token, String>> tokens, Element ele) {
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

	protected Element parsePrim(Stack<Pair<Token, String>> tokens) {
		Pair<Token, String> current = tokens.pop();
		switch (current.getFirst()) {
			case PL:
				Element result1 = parseAlt(tokens);
				if (tokens.peek().getFirst().equals(Token.PR))
					tokens.pop();
				else
					throw new RuntimeException("')' expected, but " + tokens.peek().getFirst() + " found");
				parseCardinality(tokens, result1);
				return result1;
			case STRING:
				Element result2 = new Element(current.getSecond());
				parseCardinality(tokens, result2);
				return result2;
			default:
				throw new RuntimeException("Unexpected token " + current.getFirst());
		}
	}

	protected Element parseSeq(Stack<Pair<Token, String>> tokens) {
		Element first = parsePrim(tokens);
		if (!tokens.isEmpty() && (tokens.peek().getFirst() == Token.STRING || tokens.peek().getFirst() == Token.PL)) {
			Element seq = new Element(ElementType.SEQUENCE);
			seq.addChild(first);
			do {
				Element next = parsePrim(tokens);
				seq.addChild(next);
			} while (!tokens.isEmpty()
					&& (tokens.peek().getFirst() == Token.STRING || tokens.peek().getFirst() == Token.PL));
			return seq;
		}
		return first;
	}

	protected Element parseUnordered(Stack<Pair<Token, String>> tokens) {
		Element first = parseSeq(tokens);
		if (!tokens.isEmpty() && tokens.peek().getFirst() == Token.AND) {
			Element uno = new Element(ElementType.UNOREDERED);
			uno.addChild(first);
			do {
				tokens.pop();
				Element next = parseSeq(tokens);
				uno.addChild(next);
			} while (!tokens.isEmpty() && tokens.peek().getFirst() == Token.AND);
			return uno;
		}
		return first;
	}

	@Override
	public String toString() {
		return root == null ? "null" : root.toString();
	}

}
