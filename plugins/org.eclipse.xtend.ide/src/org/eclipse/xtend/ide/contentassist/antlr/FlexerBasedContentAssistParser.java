/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.antlr;

import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Set;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtend.ide.contentassist.antlr.internal.ContentAssistFlexerFactory;
import org.eclipse.xtend.ide.contentassist.antlr.internal.InternalXtendParser;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ObservableXtextTokenStream;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.InfiniteRecursion;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FlexerBasedContentAssistParser extends XtendParser {

	@Inject
	private ITokenDefProvider tokenDefProvider;
	
	@Inject
	private ContentAssistFlexerFactory flexerFactory;
	
	@Inject
	private EntryPointFinder entryPointFinder;
	
	@Override
	protected InternalXtendParser createParser() {
		FlexerBasedInternalContentAssistParser result = new FlexerBasedInternalContentAssistParser(tokenDefProvider);
		result.setGrammarAccess(getGrammarAccess());
		return result;
	}
	
	@Override
	protected TokenSource createLexer(CharStream stream) {
		throw new UnsupportedOperationException();
	}
	
	/**
	 * @param node
	 *            the root node of the model to parse
	 * @param startOffset
	 *            the start offset to consider
	 * @param endOffset
	 *            the exclusive end offset
	 * @param strict
	 *            if true the parser will not use error recovery on the very last token of the input.
	 * @return a collection of follow elements.
	 */
	public Collection<FollowElement> getFollowElements(IParseResult parseResult, int offset, boolean strict) {
		ICompositeNode entryPoint = entryPointFinder.findEntryPoint(parseResult, offset);
		if (entryPoint != null) {
			String parseMe = getTextToParse(parseResult, entryPoint, offset);
//	System.out.println("Parsing: >>>" + parseMe + "<<<");
			TokenSource tokenSource = flexerFactory.createTokenSource(new StringReader(parseMe));
			AbstractInternalContentAssistParser parser = createParser();
			parser.setStrict(strict);
			ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(tokenSource, parser);
			tokens.setInitialHiddenTokens(getInitialHiddenTokens());
			parser.setTokenStream(tokens);
			IUnorderedGroupHelper helper = getUnorderedGroupHelper().get();
			parser.setUnorderedGroupHelper(helper);
			helper.initializeWith(parser);
			tokens.setListener(parser);
			try {
				Collection<FollowElement> followElements = getFollowElements(parser, (AbstractElement) entryPoint.getGrammarElement());
				return Lists.newArrayList(followElements);
			} catch(InfiniteRecursion infinite) {
				return Lists.newArrayList(parser.getFollowElements());
			}
		} else {
			String text = parseResult.getRootNode().getText();
			String parseMe = text.substring(0, offset);
			Collection<FollowElement> followElements = getFollowElements(parseMe, strict);
			return followElements;
		}
	}

	protected String getTextToParse(IParseResult parseResult, ICompositeNode entryPoint, int offset) {
		int entryPointOffset = entryPoint.getTotalOffset();
		String text = parseResult.getRootNode().getText();
		String parseMe = text.substring(entryPointOffset, offset);
		return parseMe;
	}
	
	private Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser, AbstractElement entryPoint) {
		String ruleName = getRuleName(entryPoint);
		if (ruleName == null) {
			if (entryPoint instanceof RuleCall) {
				RuleCall call = (RuleCall) entryPoint;
				if (call.getRule() instanceof ParserRule)
					ruleName = "rule" + call.getRule().getName();
			}
		}
		if (ruleName == null) {
			throw new IllegalStateException("entryPoint: " + entryPoint);
		}
		try {
			Method method = parser.getClass().getMethod(ruleName);
			method.setAccessible(true);
			try {
				method.invoke(parser);
			} catch(InvocationTargetException targetException) {
				if ((targetException.getCause() instanceof InfiniteRecursion))
					throw (InfiniteRecursion) targetException.getCause();
				throw new RuntimeException(targetException);
			}
			Set<FollowElement> result = parser.getFollowElements();
			return result;
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (NoSuchMethodException e) {
			throw new RuntimeException(e);
		} catch (SecurityException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Collection<FollowElement> getFollowElements(String input, boolean strict) {
		TokenSource tokenSource = flexerFactory.createTokenSource(new StringReader(input));
		AbstractInternalContentAssistParser parser = createParser();
		parser.setStrict(strict);
		ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(tokenSource, parser);
		tokens.setInitialHiddenTokens(getInitialHiddenTokens());
		parser.setTokenStream(tokens);
		IUnorderedGroupHelper helper = getUnorderedGroupHelper().get();
		parser.setUnorderedGroupHelper(helper);
		helper.initializeWith(parser);
		tokens.setListener(parser);
		try {
			return Lists.newArrayList(getFollowElements(parser));
		} catch(InfiniteRecursion infinite) {
			return Lists.newArrayList(parser.getFollowElements());
		}
	}
}
