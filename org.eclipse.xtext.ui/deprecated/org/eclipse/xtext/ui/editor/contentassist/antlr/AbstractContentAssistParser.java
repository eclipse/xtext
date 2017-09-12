/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.BaseContentAssistParser;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ObservableXtextTokenStream.StreamListener;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.InfiniteRecursion;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * This class if effectively deprecated and clients should use the equivalent from
 * the ide package instead.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContentAssistParser extends BaseContentAssistParser implements IContentAssistParser {

	@Inject
	@Named(LexerIdeBindings.CONTENT_ASSIST)
	private Provider<Lexer> lexerProvider;
	
	@Override
	protected TokenSource createLexer(CharStream stream) {
		Lexer lexer = lexerProvider.get();
		lexer.setCharStream(stream);
		return lexer;
	}
	
	@Override
	public Collection<FollowElement> getFollowElements(FollowElement element) {
		if (element.getLookAhead() <= 1)
			throw new IllegalArgumentException("lookahead may not be less than or equal to 1");
		Collection<FollowElement> result = new ArrayList<FollowElement>();
		for(AbstractElement elementToParse: getElementsToParse(element)) {
			elementToParse = unwrapSingleElementGroups(elementToParse);
			String ruleName = getRuleName(elementToParse);
			String[][] allRuleNames = getRequiredRuleNames(ruleName, element.getParamStack(), elementToParse);
			for (String[] ruleNames: allRuleNames) {
				for(int i = 0; i < ruleNames.length; i++) {
					AbstractInternalContentAssistParser parser = createParser();
					parser.setUnorderedGroupHelper(createUnorderedGroupHelper());
					parser.getUnorderedGroupHelper().initializeWith(parser);
					final Iterator<LookAheadTerminal> iter = element.getLookAheadTerminals().iterator();
					ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(new TokenSource(){
						@Override
						public Token nextToken() {
							if (iter.hasNext()) {
								LookAheadTerminal lookAhead = iter.next();
								return lookAhead.getToken();
							}
							return Token.EOF_TOKEN;
						}
						@Override
						public String getSourceName() {
							return "LookAheadTerminalTokenSource";
						}
					}, parser);
					parser.setTokenStream(tokens);
					tokens.setListener(parser);
					parser.getGrammarElements().addAll(element.getTrace());
					parser.getGrammarElements().add(elementToParse);
					parser.getLocalTrace().addAll(element.getLocalTrace());
					parser.getLocalTrace().add(elementToParse);
					parser.getParamStack().addAll(element.getParamStack());
					if (elementToParse instanceof UnorderedGroup && element.getGrammarElement() == elementToParse) {
						UnorderedGroup group = (UnorderedGroup) elementToParse;
						final IUnorderedGroupHelper helper = parser.getUnorderedGroupHelper();
						helper.enter(group);
						for(AbstractElement consumed: element.getHandledUnorderedGroupElements()) {
							parser.before(consumed);
							helper.select(group, group.getElements().indexOf(consumed));
							helper.returnFromSelection(group);
							parser.after(consumed);
						}
						parser.setUnorderedGroupHelper(ignoreFirstEntrance(helper));
					}
					Collection<FollowElement> elements = getFollowElements(parser, elementToParse, ruleNames, i);
					result.addAll(elements);
				}
			}
		}
		return result;
	}
	
	protected Collection<AbstractElement> getElementsToParse(FollowElement element) {
		return getElementsToParse(element.getGrammarElement(), element.getHandledUnorderedGroupElements());
	}
	
	private RecognizerSharedState getParserState(AbstractInternalContentAssistParser parser) {
		return parser.getInternalRecognizerSharedState();
	}
	
	private Collection<FollowElement> getFollowElements(
			final AbstractInternalContentAssistParser parser,
			final AbstractElement elementToParse,
			String[] ruleNames, int startIndex) {
		try {
			final boolean[] wasEof = new boolean[] { false };
			final boolean[] announcedEofWithLA = new boolean[] { false };
			final boolean[] consumedSomething = new boolean[] { true };
			final boolean[] wasRecovering = new boolean[] { false };
			final RecognizerSharedState parserState = getParserState(parser);
			ObservableXtextTokenStream stream = (ObservableXtextTokenStream) parser.getTokenStream();
			stream.setListener(new StreamListener() {
				
				@Override
				public void announceEof(int lookAhead) {
					if (!wasRecovering[0]) {
						parser.announceEof(lookAhead);
						if (lookAhead > 1)
							announcedEofWithLA[0] = true;
					}
					if (parser.isDFAPrediction()) {
						int lastGrammarElement = parser.getGrammarElements().size() - 1;
						if (elementToParse instanceof UnorderedGroup && parser.getGrammarElements().get(lastGrammarElement) == elementToParse) {
							IUnorderedGroupHelper helper = parser.getUnorderedGroupHelper();
							if (!helper.canLeave((UnorderedGroup) elementToParse)) {
								wasEof[0] = true;		
							}
						}
					} else {
						wasEof[0] = true;
					}
				}
				
				@Override
				public void announceConsume() {
					parser.announceConsume();
					if (!wasRecovering[0])
						consumedSomething[0] = true;
				}

				@Override
				public void announceMark(int marker) {
					parser.announceMark(marker);
				}

				@Override
				public void announceRewind(int marker) {
					parser.announceRewind(marker);
				}
			});
			parser.setRecoveryListener(new AbstractInternalContentAssistParser.RecoveryListener() {
				
				private int startedErrorRecoveryAt;

				@Override
				public void endErrorRecovery() {
					if (!wasEof[0] && !parserState.failed && startedErrorRecoveryAt == parser.input.index()) {
						wasRecovering[0] = false;
					}
				}
				
				@Override
				public void beginErrorRecovery() {
					startedErrorRecoveryAt = parser.input.index();
					wasRecovering[0] = true;
				}
			});
			int i = startIndex;
			Collection<FollowElement> result = null;
			while(i < ruleNames.length && !wasEof[0] && consumedSomething[0]) {
				consumedSomething[0] = false;
				announcedEofWithLA[0] = false;
				wasRecovering[0] = false;
				Method method = parser.getClass().getMethod(ruleNames[i]);
				method.setAccessible(true);
				try {
					method.invoke(parser);
				} catch(InvocationTargetException targetException) {
					if (!(targetException.getCause() instanceof InfiniteRecursion))
						throw targetException;
				}
				result = parser.getFollowElements();
				if (i == ruleNames.length - 1 && !GrammarUtil.isMultipleCardinality(elementToParse)) {
					if (consumedSomething[0] || announcedEofWithLA[0])
						return result;
					return Collections.emptyList();
				}
				if (!wasEof[0] && ruleNames.length != 1)
					i++;
				if (ruleNames.length > 2)
					throw new IllegalArgumentException("The following lines assume that we have at most two rules to call.");
			}
			return result;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	protected abstract AbstractInternalContentAssistParser createParser();
	
	protected abstract Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser);
	
	protected abstract String[] getInitialHiddenTokens();
	
	@Override
	public Collection<FollowElement> getFollowElements(String input, boolean strict) {
		TokenSource tokenSource = createTokenSource(input);
		AbstractInternalContentAssistParser parser = createParser();
		parser.setStrict(strict);
		ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(tokenSource, parser);
		tokens.setInitialHiddenTokens(getInitialHiddenTokens());
		parser.setTokenStream(tokens);
		IUnorderedGroupHelper helper = createUnorderedGroupHelper();
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
