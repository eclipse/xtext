/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.junit4.parameterized;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parsetree.reconstr.impl.NodeIterator;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.util.Wrapper;
import org.eclipse.xtext.util.formallang.FollowerFunctionImpl;
import org.eclipse.xtext.util.formallang.Nfa;
import org.eclipse.xtext.util.formallang.NfaUtil;
import org.eclipse.xtext.util.formallang.NfaUtil.BacktrackHandler;
import org.eclipse.xtext.util.formallang.StringProduction;
import org.eclipse.xtext.util.formallang.StringProduction.ElementType;
import org.eclipse.xtext.util.formallang.StringProduction.ProdElement;
import org.junit.Test;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

/**
 * This class will be removed in the next release after 2.4.2
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 */
@Deprecated
public class XpectParameterProvider implements IParameterProvider {

	protected static class AssignedProduction extends StringProduction {

		public AssignedProduction(String production) {
			super(production);
		}

		@Override
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
					result2.setValue(current.getSecond());
					parseCardinality(tokens, result2);
					return result2;
				case ID:
					ProdElement result3 = createElement(ElementType.TOKEN);
					result3.setName(current.getSecond());
					Pair<Token, String> eq = tokens.pop();
					if (eq.getFirst() == Token.EQ) {
						Pair<Token, String> val = tokens.pop();
						switch (val.getFirst()) {
							case ID:
							case STRING:
								result3.setValue(val.getSecond());
								break;
							default:
								throw new RuntimeException("Unexpected token " + current.getFirst());
						}
					} else
						throw new RuntimeException("Unexpected token " + eq.getFirst() + ", expected '='");
					parseCardinality(tokens, result3);
					return result3;
				default:
					throw new RuntimeException("Unexpected token " + current.getFirst());
			}
		}
	}

	protected static class BacktrackItem {
		protected int offset;
		protected ProdElement token;
		protected String value;

		public BacktrackItem(int offset) {
			super();
			this.offset = offset;
		}

		public BacktrackItem(int offset, ProdElement token, String value) {
			super();
			this.offset = offset;
			this.token = token;
			this.value = value;
		}

		@Override
		public String toString() {
			return token + ":" + value;
		}
	}

	protected static class Expectation implements IExpectation {
		protected String expectation;
		protected String indentation = null;
		protected int lenght;
		protected int offset;

		public Expectation(int offset, int lenght, String expectation) {
			super();
			this.offset = offset;
			this.lenght = lenght;
			this.expectation = expectation;
		}

		public Expectation(int offset, int lenght, String expectation, String indentation) {
			super();
			this.offset = offset;
			this.lenght = lenght;
			this.expectation = expectation;
			this.indentation = indentation;
		}

		public String getExpectation() {
			return expectation;
		}

		public String getIndentation() {
			return indentation;
		}

		public int getLength() {
			return lenght;
		}

		public int getOffset() {
			return offset;
		}

	}

	protected enum Token {
		ID("[a-zA-Z][a-zA-Z0-9_]*"), //
		INT("[0-9]+"), //
		OFFSET("'([^']*)'|[^\\s]+"), //
		STRING("'([^']*)'"), //
		TEXT("[^\\s]+");

		public final Pattern pattern;

		private Token(String regex) {
			this.pattern = Pattern.compile("^" + regex);
		}
	}

	public final static String PARAM_OFFSET = "offset";
	public final static String PARAM_RESOURCE = "resource";

	protected static final Pattern WS = Pattern.compile("^[\\s]+");

	protected static Pattern XPECT_PATTERN = Pattern.compile("(\\S)?XPECT(_CLASS|_IMPORT)?\\s+([a-zA-Z0-9]*)");

	public void collectParameters(Class<?> testClass, XtextResource resource, IParameterAcceptor acceptor) {
		collectTestMethods(testClass, resource, acceptor);
		for (ILeafNode leaf : resource.getParseResult().getRootNode().getLeafNodes())
			if (leaf.isHidden() && leaf.getText().contains("XPECT"))
				parseLeaf(testClass, resource, leaf, acceptor);

	}

	protected void collectTestMethods(Class<?> testClass, XtextResource res, IParameterAcceptor acceptor) {
		for (Method meth : testClass.getMethods()) {
			if (Modifier.isPublic(meth.getModifiers()) && !Modifier.isStatic(meth.getModifiers())) {
				Test annotation = meth.getAnnotation(Test.class);
				if (annotation != null)
					acceptor.acceptTest(null, meth.getName(), getDefaultParams(res, 0), null, false);
			}
		}
	}

	protected Iterable<Object> convertValue(XtextResource res, INode ctx, int offset, Token token, String value) {
		switch (token) {
			case OFFSET:
				int add = value.indexOf('|');
				if (add >= 0)
					value = value.substring(0, add) + value.substring(add + 1);
				else
					add = 0;
				String text = ctx.getRootNode().getText();
				int result = text.indexOf(value, offset);
				if (result >= 0) {
					int off = result + add;
					return Lists.newArrayList(off, new Offset(res, off));
				} else
					throw new RuntimeException("OFFSET '" + value + "' not found");
			case INT:
				List<Object> r = Lists.newArrayList();
				try {
					r.add(Integer.valueOf(value));
				} catch (NumberFormatException e) {
				}
				try {
					r.add(new BigInteger(value));
				} catch (NumberFormatException e) {
				}
				r.add(value);
				return r;
			case ID:
			case STRING:
			case TEXT:
				return Collections.<Object> singleton(value);
		}
		return Collections.<Object> singleton(value);
	}

	protected Multimap<String, Object> getDefaultParams(XtextResource res, int offset) {
		Multimap<String, Object> result = HashMultimap.create();
		result.put(PARAM_RESOURCE, res);
		result.put(PARAM_OFFSET, offset);
		result.put(PARAM_OFFSET, new Offset(res, offset));
		return result;
	}

	protected String getIndentation(INode ctx, int offset) {
		String text = ctx.getRootNode().getText();
		int nl = text.lastIndexOf("\n", offset);
		if (nl < 0)
			nl = 0;
		StringBuilder result = new StringBuilder();
		for (int i = nl + 1; i < text.length() && Character.isWhitespace(text.charAt(i)); i++)
			result.append(text.charAt(i));
		return result.toString();
	}

	protected int getOffsetOfNextSemanticNode(INode node) {
		Iterator<INode> it = new NodeIterator(node);
		while (it.hasNext()) {
			INode n = it.next();
			if (n instanceof ILeafNode && !((ILeafNode) n).isHidden())
				return n.getOffset();
		}
		return node.getEndOffset();
	}

	protected Nfa<ProdElement> getParameterNfa(String syntax) {
		AssignedProduction prod = new AssignedProduction(syntax);
		FollowerFunctionImpl<ProdElement, String> ff = new FollowerFunctionImpl<ProdElement, String>(prod);
		ProdElement start = prod.new ProdElement(ElementType.TOKEN);
		ProdElement stop = prod.new ProdElement(ElementType.TOKEN);
		Nfa<ProdElement> result = new NfaUtil().create(prod, ff, start, stop);
		return result;
	}

	protected String getParameterSyntax(Class<?> testClass, String methodName) {
		try {
			Method method = testClass.getMethod(methodName);
			ParameterSyntax annotation = method.getAnnotation(ParameterSyntax.class);
			if (annotation != null)
				return annotation.value();
		} catch (SecurityException e) {
			Exceptions.throwUncheckedException(e);
		} catch (NoSuchMethodException e) {
			Exceptions.throwUncheckedException(e);
		}
		return null;
	}

	protected void parseLeaf(Class<?> testClass, XtextResource resource, ILeafNode leaf, IParameterAcceptor acceptor) {
		String text = leaf.getText();
		Matcher matcher = XPECT_PATTERN.matcher(text);
		int offset = 0;
		while (offset < text.length() && matcher.find(offset)) {
			if (matcher.group(2) == null) {
				int newOffset;
				if ((newOffset = parseXpect(testClass, resource, leaf, text, matcher.group(3), matcher.end(), acceptor,
						matcher.group(1) != null)) >= 0)
					offset = newOffset;
				else
					offset = matcher.end();
			} else if ("_IMPORT".equals(matcher.group(2))) {
				offset = parseXpectImport(resource, text, matcher.end(2), acceptor);
			}
			//			} else {
			//				int newOffset;
			//				if ((newOffset = parseXpectTest(testClass, text, matcher.end(), acceptor)) >= 0)
			//					offset = newOffset;
			//				else
			//					offset = matcher.end();
			//			}
		}
	}

	protected int parseString(String text, int offset, Wrapper<String> value) {
		if (offset < text.length() && text.charAt(offset) == '"') {
			int i = offset + 1;
			while (offset < text.length() && text.charAt(i - 1) == '\\' || text.charAt(i) != '"')
				i++;
			if (text.charAt(i) == '"') {
				value.set(text.substring(offset + 1, i - 1));
				return i;
			}
		}
		return -1;
	}

	protected int parseStringOrText(String text, int offset, Wrapper<String> value) {
		int newOffset = parseString(text, offset, value);
		if (newOffset < 0)
			newOffset = parseText(text, offset, value);
		return newOffset;
	}

	protected int parseText(String text, int offset, Wrapper<String> value) {
		int i = offset;
		while (i < text.length())
			switch (text.charAt(i)) {
				case ' ':
				case '\t':
				case '\r':
				case '\n':
					value.set(text.substring(offset, i));
					return i;
				default:
					i++;
			}
		value.set(text.substring(offset, i));
		return i;
	}

	protected int parseXpect(Class<?> testClass, XtextResource res, INode ctx, String text, String method, int offset,
			IParameterAcceptor acceptor, boolean ignore) {
		int newOffset;
		Multimap<String, Object> params = HashMultimap.create();
		Wrapper<Expectation> expectation = new Wrapper<Expectation>(null);
		offset = skipWhitespace(text, offset);
		if ((newOffset = parseXpectParams(testClass, res, ctx, method, text, offset, params)) >= 0)
			offset = newOffset;
		offset = skipWhitespace(text, offset);
		if ((newOffset = parseXpectSLExpectation(ctx, text, offset, expectation)) >= 0)
			offset = newOffset;
		else if ((newOffset = parseXpectMLExpectation(ctx, text, offset, expectation)) >= 0)
			offset = newOffset;
		acceptor.acceptTest(null, method, params, expectation.get(), ignore);
		return offset;
	}

	protected int parseXpectImport(XtextResource res, String text, int offset, IParameterAcceptor acceptor) {
		offset = skipWhitespace(text, offset);
		int end = text.indexOf("\n", offset);
		String fileName = text.substring(offset, end).trim();
		URI uri = URI.createURI(fileName);
		if (uri.isRelative() && !res.getURI().isRelative())
			uri = uri.resolve(res.getURI());
		acceptor.acceptImportURI(uri);
		return end;
	}

	protected int parseXpectMLExpectation(INode node, String text, int offset, Wrapper<Expectation> expectation) {
		if (offset + 3 < text.length() && text.substring(offset, offset + 3).equals("---")) {
			String indentation = getIndentation(node, node.getOffset() + offset);
			int start = text.indexOf('\n', offset + 3);
			int end = text.indexOf("---", offset + 3);
			if (start >= 0 && end >= 0) {
				String substring = text.substring(start + 1, end);
				end = substring.lastIndexOf('\n');
				if (end >= 0) {
					String exp = substring.substring(0, end);
					int len = exp.length();
					if (exp.startsWith(indentation))
						exp = exp.substring(indentation.length());
					exp = exp.replace("\n" + indentation, "\n");
					expectation.set(new Expectation(node.getOffset() + start + 1, len, exp, indentation));
					return end + start + 1;
				}
			}
		}
		return -1;
	}

	protected int parseXpectParams(Class<?> testClass, XtextResource res, INode node, String methodName,
			final String text, int offset, Multimap<String, Object> params) {
		int semanticOffset = getOffsetOfNextSemanticNode(node);
		params.putAll(getDefaultParams(res, semanticOffset));
		String paramSyntax = getParameterSyntax(testClass, methodName);
		if (Strings.isEmpty(paramSyntax))
			return -1;
		Nfa<ProdElement> nfa = getParameterNfa(paramSyntax);
		List<BacktrackItem> trace = new NfaUtil().backtrack(nfa, new BacktrackItem(offset),
				new BacktrackHandler<ProdElement, BacktrackItem>() {
					public BacktrackItem handle(ProdElement state, BacktrackItem previous) {
						if (Strings.isEmpty(state.getValue()))
							return previous;
						if (Strings.isEmpty(state.getName())) {
							if (text.regionMatches(previous.offset, state.getValue(), 0, state.getValue().length())) {
								int newOffset = previous.offset + state.getValue().length();
								Matcher ws = WS.matcher(text).region(newOffset, text.length());
								int childOffset = ws.find() ? ws.end() : newOffset;
								return new BacktrackItem(childOffset, state, state.getValue());
							}
						} else {
							Token t = Token.valueOf(state.getValue());
							Matcher matcher = t.pattern.matcher(text).region(previous.offset, text.length());
							if (matcher.find()) {
								Matcher ws = WS.matcher(text).region(matcher.end(), text.length());
								int childOffset = ws.find() ? ws.end() : matcher.end();
								String value = matcher.groupCount() > 0 && matcher.group(1) != null ? matcher.group(1)
										: matcher.group(0);
								return new BacktrackItem(childOffset, state, value);
							}
						}
						return null;
					}

					public boolean isSolution(BacktrackItem result) {
						return true;
					}

					public Iterable<ProdElement> sortFollowers(BacktrackItem result, Iterable<ProdElement> followers) {
						return followers;
					}
				});
		if (trace != null && !trace.isEmpty()) {
			for (BacktrackItem item : trace)
				if (item.token != null && item.token.getName() != null) {
					String key = item.token.getName();
					params.removeAll(key);
					params.putAll(key,
							convertValue(res, node, semanticOffset, Token.valueOf(item.token.getValue()), item.value));
				}
			return trace.get(trace.size() - 1).offset;
		}
		return -1;
	}

	protected int parseXpectSLExpectation(INode node, String text, int offset, Wrapper<Expectation> expectation) {
		if (offset + 3 < text.length() && text.substring(offset, offset + 3).equals("-->")) {
			int begin = offset + 3;
			if (text.charAt(begin) == '\r' || text.charAt(begin) == '\n') {
				expectation.set(new Expectation(node.getOffset() + begin, 0, ""));
				return begin;
			} else if (Character.isWhitespace(text.charAt(begin)))
				begin++;
			int end = text.indexOf('\n', begin);
			if (end < 0)
				end = text.length();
			String exp = text.substring(begin, end);
			expectation.set(new Expectation(node.getOffset() + begin, exp.length(), exp));
			return end;
		}
		return -1;
	}

	//	protected int parseXpectTest(Wrapper<Class<?>> test, String text, int offset, IParameterAcceptor acceptor) {
	//		int index = text.indexOf("\n", offset);
	//		if (index > offset) {
	//			String name = text.substring(offset, index).trim();
	//			try {
	//				Class<?> clazz = Class.forName(name);
	//				acceptor.acceptTestClass(clazz);
	//			} catch (ClassNotFoundException e) {
	//				Exceptions.throwUncheckedException(e);
	//			}
	//			return index;
	//		}
	//		return -1;
	//	}

	protected int skipWhitespace(String text, int offset) {
		int i = offset;
		while (i < text.length())
			if (Character.isWhitespace(text.charAt(i)))
				i++;
			else
				return i;
		return i;
	}

}
