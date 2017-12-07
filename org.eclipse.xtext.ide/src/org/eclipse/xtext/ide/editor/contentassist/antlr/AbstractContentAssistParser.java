/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.InfiniteRecursion;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.ide.editor.partialEditing.IPartialEditingContentAssistParser;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @since 2.9
 */
public abstract class AbstractContentAssistParser extends BaseContentAssistParser implements IContentAssistParser, IPartialEditingContentAssistParser {

	@Inject
	@Named(LexerIdeBindings.CONTENT_ASSIST)
	private Provider<Lexer> lexerProvider;
	
	@Inject
	private RuleNames ruleNames;
	
	private AbstractRule entryRule;
	
	@Inject
	private void initEntryRule(IGrammarAccess grammar) {
		initializeFor(grammar.getGrammar().getRules().get(0));
	}

	@Override
	public void initializeFor(AbstractRule rule) {
		this.entryRule = rule;
	}
	
	public AbstractRule getEntryRule() {
		return entryRule;
	}
	
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
					ObservableXtextTokenStream tokens = setTokensFromFollowElement(parser, element);
					tokens.setListener(parser);
					parser.getGrammarElements().addAll(element.getTrace());
					parser.getGrammarElements().add(elementToParse);
					parser.getLocalTrace().addAll(element.getLocalTrace());
					parser.getLocalTrace().add(elementToParse);
					parser.getParamStack().addAll(element.getParamStack());
					if (elementToParse instanceof UnorderedGroup && element.getGrammarElement() == elementToParse) {
						UnorderedGroup group = (UnorderedGroup) elementToParse;
						IUnorderedGroupHelper helper = getInitializedUnorderedGroupHelper(element, parser, group);
						parser.setUnorderedGroupHelper(ignoreFirstEntrance(helper));
					}
					Collection<FollowElement> elements = getFollowElements(parser, elementToParse, ruleNames, i);
					result.addAll(elements);
				}
			}
		}
		return result;
	}

	/**
	 * @since 2.14
	 */
	protected ObservableXtextTokenStream setTokensFromFollowElement(AbstractInternalContentAssistParser parser,
			FollowElement element) {
		final Iterator<LookAheadTerminal> iter = element.getLookAheadTerminals().iterator();
		ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(new LookAheadBasedTokenSource(iter), parser);
		parser.setTokenStream(tokens);
		return tokens;
	}

	/**
	 * @since 2.14
	 */
	protected IUnorderedGroupHelper getInitializedUnorderedGroupHelper(FollowElement element,
			AbstractInternalContentAssistParser parser, UnorderedGroup group) {
		final IUnorderedGroupHelper helper = parser.getUnorderedGroupHelper();
		helper.enter(group);
		for(AbstractElement consumed: element.getHandledUnorderedGroupElements()) {
			parser.before(consumed);
			helper.select(group, group.getElements().indexOf(consumed));
			helper.returnFromSelection(group);
			parser.after(consumed);
		}
		return helper;
	}

	/**
	 * @since 2.14
	 */
	protected Collection<FollowElement> getFollowElements(
			final AbstractInternalContentAssistParser parser,
			final AbstractElement elementToParse, 
			String[] ruleNames, 
			final int startIndex) {
		try {
			EofListener listener = createEofListener(parser, elementToParse);
			int i = startIndex;
			Collection<FollowElement> result = null;
			while(i < ruleNames.length && !listener.wasEof && listener.consumedSomething) {
				listener.reset();
				String ruleName = ruleNames[i];
				result = getFollowElements(parser, ruleName, true);
				if (i == ruleNames.length - 1 && !GrammarUtil.isMultipleCardinality(elementToParse)) {
					if (listener.consumedSomething || listener.announcedEofWithLA)
						return result;
					return Collections.emptyList();
				}
				if (!listener.wasEof && ruleNames.length != 1)
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

	/**
	 * @since 2.14
	 */
	protected EofListener createEofListener(final AbstractInternalContentAssistParser parser,
			final AbstractElement elementToParse) {
		return new EofListener(parser, elementToParse);
	}

	/**
	 * @since 2.14
	 */
	protected Set<FollowElement> getFollowElements(final AbstractInternalContentAssistParser parser, String ruleName, boolean swallowInfiniteRecursion)
			throws Exception {
		Method method = parser.getClass().getMethod(ruleName);
		method.setAccessible(true);
		try {
			method.invoke(parser);
		} catch(InvocationTargetException targetException) {
			Throwable cause = targetException.getCause();
			if (cause instanceof InfiniteRecursion) {
				if (swallowInfiniteRecursion) {
					return parser.getFollowElements();
				} else {
					throw (InfiniteRecursion) cause;
				}
			}
			throw targetException;
		}
		return parser.getFollowElements();
	}

	/**
	 * @since 2.14
	 */
	protected Collection<AbstractElement> getElementsToParse(FollowElement element) {
		return getElementsToParse(element.getGrammarElement(), element.getHandledUnorderedGroupElements());
	}

	protected abstract AbstractInternalContentAssistParser createParser();

	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		return getFollowElements(parser, entryRule);
	}

	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser,
			AbstractRule rule) {
		String ruleName = ruleNames.getAntlrRuleName(rule);
		return getFollowElements(parser, ruleName);
	}

	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser, String ruleName) {
		try {
			return getFollowElements(parser, ruleName, false);
		} catch (InfiniteRecursion e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
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

	/**
	 * @since 2.14
	 */
	protected RuleNames getRuleNames() {
		return ruleNames;
	}
}
