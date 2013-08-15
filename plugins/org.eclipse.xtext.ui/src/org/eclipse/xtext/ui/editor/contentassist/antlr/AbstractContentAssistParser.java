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
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.BaseRecognizer;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ObservableXtextTokenStream.StreamListener;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.InfiniteRecursion;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContentAssistParser implements IContentAssistParser {

	@Inject
	@Named(LexerUIBindings.CONTENT_ASSIST)
	private Provider<Lexer> lexerProvider;
	
	@Inject
	private Provider<IUnorderedGroupHelper> unorderedGroupHelper;
	
	protected TokenSource createLexer(CharStream stream) {
		Lexer lexer = lexerProvider.get();
		lexer.setCharStream(stream);
		return lexer;
	}
	
	public Collection<FollowElement> getFollowElements(FollowElement element) {
		if (element.getLookAhead() <= 1)
			throw new IllegalArgumentException("lookahead may not be less than or equal to 1");
		Collection<FollowElement> result = new ArrayList<FollowElement>();
		for(AbstractElement elementToParse: getElementsToParse(element)) {
			String ruleName = getRuleName(elementToParse);
			String[][] allRuleNames = getRequiredRuleNames(ruleName, elementToParse);
			for (String[] ruleNames: allRuleNames) {
				for(int i = 0; i < ruleNames.length; i++) {
					AbstractInternalContentAssistParser parser = createParser();
					parser.setUnorderedGroupHelper(getUnorderedGroupHelper().get());
					parser.getUnorderedGroupHelper().initializeWith(parser);
					final Iterator<LookAheadTerminal> iter = element.getLookAheadTerminals().iterator();
					ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(new TokenSource(){
						public Token nextToken() {
							if (iter.hasNext()) {
								LookAheadTerminal lookAhead = iter.next();
								return lookAhead.getToken();
							}
							return Token.EOF_TOKEN;
						}
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
						parser.setUnorderedGroupHelper(new IUnorderedGroupHelper() {

							boolean first = true;
							public void initializeWith(BaseRecognizer recognizer) {
								helper.initializeWith(recognizer);
							}

							public void enter(UnorderedGroup group) {
								if (!first)
									helper.enter(group);
								first = false;
							}

							public void leave(UnorderedGroup group) {
								helper.leave(group);
							}

							public boolean canSelect(UnorderedGroup group, int index) {
								return helper.canSelect(group, index);
							}

							public void select(UnorderedGroup group, int index) {
								helper.select(group, index);
							}

							public void returnFromSelection(UnorderedGroup group) {
								helper.returnFromSelection(group);
							}

							public boolean canLeave(UnorderedGroup group) {
								return helper.canLeave(group);
							}

							public UnorderedGroupState snapShot(UnorderedGroup... groups) {
								return helper.snapShot(groups);
							}
							
						});
					}
					Collection<FollowElement> elements = getFollowElements(parser, elementToParse, ruleNames, i);
					result.addAll(elements);
				}
			}
		}
		return result;
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
				
				public void announceConsume() {
					parser.announceConsume();
					if (!wasRecovering[0])
						consumedSomething[0] = true;
				}

				public void announceMark(int marker) {
					parser.announceMark(marker);
				}

				public void announceRewind(int marker) {
					parser.announceRewind(marker);
				}
			});
			parser.setRecoveryListener(new AbstractInternalContentAssistParser.RecoveryListener() {
				
				private int startedErrorRecoveryAt;

				public void endErrorRecovery() {
					if (!wasEof[0] && !parserState.failed && startedErrorRecoveryAt == parser.input.index()) {
						wasRecovering[0] = false;
					}
				}
				
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

	private String[][] getRequiredRuleNames(String ruleName, AbstractElement elementToParse) {
		if (ruleName == null) {
			if (elementToParse instanceof RuleCall) {
				RuleCall call = (RuleCall) elementToParse;
				if (call.getRule() instanceof ParserRule)
					return new String[][] {{ "rule" + call.getRule().getName() }};
			}
			return new String[0][];
		}
		if (!(GrammarUtil.isOptionalCardinality(elementToParse) || GrammarUtil.isOneOrMoreCardinality(elementToParse)))
			return new String[][] {{ ruleName }};
		if ((elementToParse.eContainer() instanceof Group)) {
			List<AbstractElement> tokens = ((Group) elementToParse.eContainer()).getElements();
			int idx = tokens.indexOf(elementToParse) + 1;
			if (idx != tokens.size()) {
				String secondRule = getRuleName((AbstractElement) elementToParse.eContainer());
  				secondRule = secondRule.substring(0, secondRule.lastIndexOf('_') + 1) + idx;
				if (GrammarUtil.isMultipleCardinality(elementToParse))
					return new String[][] {{ ruleName }, {ruleName, secondRule}};
				return new String[][] { {ruleName, secondRule} };
			}
		}
		return new String[][] {{ ruleName }};
	}

	private Collection<AbstractElement> getElementsToParse(FollowElement element) {
		AbstractElement root = element.getGrammarElement();
		if (root instanceof UnorderedGroup) {
			List<AbstractElement> handled = element.getHandledUnorderedGroupElements();
			if (handled.isEmpty())
				return ((CompoundElement) root).getElements();
			List<AbstractElement> result = Lists.newArrayList(root);
			for(AbstractElement child: ((UnorderedGroup) root).getElements()) {
				if (!handled.contains(child)) {
					result.add(child);
				}
			}
			return result;
		}
		return getElementsToParse(root);
	}

	private Collection<AbstractElement> getElementsToParse(AbstractElement root) {
		if (root instanceof Alternatives/* || root instanceof UnorderedGroup*/)
			return ((CompoundElement) root).getElements();
		return Collections.singleton(root);
	}

	protected abstract String getRuleName(AbstractElement element);
		
	protected abstract AbstractInternalContentAssistParser createParser();
	
	protected abstract Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser);
	
	protected abstract String[] getInitialHiddenTokens();
	
	public Collection<FollowElement> getFollowElements(String input, boolean strict) {
		CharStream stream = new ANTLRStringStream(input);
		TokenSource tokenSource = createLexer(stream);
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

	public void setUnorderedGroupHelper(Provider<IUnorderedGroupHelper> unorderedGroupHelper) {
		this.unorderedGroupHelper = unorderedGroupHelper;
	}

	public Provider<IUnorderedGroupHelper> getUnorderedGroupHelper() {
		return unorderedGroupHelper;
	}
}
