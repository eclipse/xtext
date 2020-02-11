/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.CompoundElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.BaseInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.InfiniteRecursion;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Abstract base type for the {@link AbstractContentAssistParser} and the deprecated equivalent in the xtext.ui bundle.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.14
 */
public abstract class BaseContentAssistParser<FE extends BaseFollowElement<LATerminal>, LATerminal extends ILookAheadTerminal, InternalParser extends BaseInternalContentAssistParser<FE, LATerminal>> {

	@Inject
	private Provider<IUnorderedGroupHelper> unorderedGroupHelper;

	@Inject
	private RequiredRuleNameComputer requiredRuleNameComputer;

	@Inject
	private RuleNames ruleNames;

	private AbstractRule entryRule;

	/**
	 * Create a token source for the given input based on the bound lexer.
	 */
	protected TokenSource createTokenSource(String input) {
		return createLexer(new ANTLRStringStream(input));
	}

	/**
	 * Create a token source for the given input based on the bound lexer.
	 */
	protected abstract TokenSource createLexer(CharStream stream);

	public Collection<FE> getFollowElements(FE element) {
		if (element.getLookAhead() <= 1)
			throw new IllegalArgumentException("lookahead may not be less than or equal to 1");
		Collection<FE> result = new ArrayList<FE>();
		for (AbstractElement elementToParse : getElementsToParse(element)) {
			elementToParse = unwrapSingleElementGroups(elementToParse);
			String ruleName = getRuleName(elementToParse);
			String[][] allRuleNames = getRequiredRuleNames(ruleName, element.getParamStack(), elementToParse);
			for (String[] ruleNames : allRuleNames) {
				for (int i = 0; i < ruleNames.length; i++) {
					InternalParser parser = createParser();
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
					Collection<FE> elements = getFollowElements(parser, elementToParse, ruleNames, i);
					result.addAll(elements);
				}
			}
		}
		return result;
	}

	protected abstract InternalParser createParser();

	/**
	 * @since 2.14
	 */
	protected ObservableXtextTokenStream setTokensFromFollowElement(InternalParser parser, FE element) {
		final Iterator<LATerminal> iter = element.getLookAheadTerminals().iterator();
		LookAheadBasedTokenSource tokenSource = new LookAheadBasedTokenSource(iter);
		ObservableXtextTokenStream tokens = createObservableTokenStream(tokenSource, parser);
		parser.setTokenStream(tokens);
		return tokens;
	}

	/**
	 * @since 2.14
	 */
	protected Collection<FE> getFollowElements(final InternalParser parser, final AbstractElement elementToParse,
			String[] ruleNames, final int startIndex) {
		try {
			EofListener listener = createEofListener(parser, elementToParse);
			int i = startIndex;
			Collection<FE> result = null;
			while (i < ruleNames.length && !listener.wasEof && listener.consumedSomething) {
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
					throw new IllegalArgumentException(
							"The following lines assume that we have at most two rules to call.");
			}
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * @since 2.14
	 */
	protected EofListener createEofListener(final InternalParser parser, final AbstractElement elementToParse) {
		return new EofListener(parser, elementToParse);
	}

	/**
	 * @since 2.14
	 */
	protected Set<FE> getFollowElements(final InternalParser parser, String ruleName, boolean swallowInfiniteRecursion)
			throws Exception {
		Method method = parser.getClass().getMethod(ruleName);
		method.setAccessible(true);
		try {
			method.invoke(parser);
		} catch (InvocationTargetException targetException) {
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
	protected Collection<AbstractElement> getElementsToParse(FE element) {
		return getElementsToParse(element.getGrammarElement(), element.getHandledUnorderedGroupElements());
	}

	/**
	 * @since 2.14
	 */
	protected ObservableXtextTokenStream createObservableTokenStream(LookAheadBasedTokenSource tokenSource,
			InternalParser parser) {
		return new ObservableXtextTokenStream(tokenSource, parser);
	}

	/**
	 * @since 2.14
	 */
	protected IUnorderedGroupHelper getInitializedUnorderedGroupHelper(FE element, InternalParser parser,
			UnorderedGroup group) {
		final IUnorderedGroupHelper helper = parser.getUnorderedGroupHelper();
		helper.enter(group);
		for (AbstractElement consumed : element.getHandledUnorderedGroupElements()) {
			parser.before(consumed);
			helper.select(group, group.getElements().indexOf(consumed));
			helper.returnFromSelection(group);
			parser.after(consumed);
		}
		return helper;
	}

	@Inject
	private void initEntryRule(IGrammarAccess grammar) {
		initializeFor(grammar.getGrammar().getRules().get(0));
	}

	public void initializeFor(AbstractRule rule) {
		this.entryRule = rule;
	}

	public AbstractRule getEntryRule() {
		return entryRule;
	}

	protected Collection<FE> getFollowElements(InternalParser parser) {
		return getFollowElements(parser, entryRule);
	}

	protected Collection<FE> getFollowElements(InternalParser parser, AbstractRule rule) {
		String ruleName = ruleNames.getAntlrRuleName(rule);
		return getFollowElements(parser, ruleName);
	}

	protected Collection<FE> getFollowElements(InternalParser parser, String ruleName) {
		try {
			return getFollowElements(parser, ruleName, false);
		} catch (InfiniteRecursion e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected abstract String[] getInitialHiddenTokens();

	public Collection<FE> getFollowElements(String input, boolean strict) {
		TokenSource tokenSource = createTokenSource(input);
		InternalParser parser = createParser();
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
		} catch (InfiniteRecursion infinite) {
			return Lists.newArrayList(parser.getFollowElements());
		}
	}

	/**
	 * Returns the elementToParse or the innermost element if the elementToParse is a (parameterized) group that
	 * contains only a single element.
	 */
	protected AbstractElement unwrapSingleElementGroups(AbstractElement elementToParse) {
		if (elementToParse instanceof Group) {
			List<AbstractElement> elements = ((Group) elementToParse).getElements();
			if (elements.size() == 1) {
				return unwrapSingleElementGroups(elements.get(0));
			}
		}
		return elementToParse;
	}

	/**
	 * Returns the root element or its alternative branches if it is an {@link Alternatives} or an
	 * {@link UnorderedGroup}. In case of an {@link UnorderedGroup} the result contains only the elements that are not
	 * yet processed up to the relevant cursor position.
	 */
	protected Collection<AbstractElement> getElementsToParse(AbstractElement root,
			List<AbstractElement> handledUnorderedGroupElements) {
		if (root instanceof UnorderedGroup) {
			if (handledUnorderedGroupElements.isEmpty())
				return ((CompoundElement) root).getElements();
			List<AbstractElement> result = Lists.newArrayList(root);
			for (AbstractElement child : ((UnorderedGroup) root).getElements()) {
				if (!handledUnorderedGroupElements.contains(child)) {
					result.add(child);
				}
			}
			return result;
		}
		return getElementsToParse(root);
	}

	/**
	 * Factory method for the {@link IgnoreFirstEntranceUnorderedGroupHelper}.
	 */
	protected IUnorderedGroupHelper ignoreFirstEntrance(final IUnorderedGroupHelper helper) {
		return new IgnoreFirstEntranceUnorderedGroupHelper(helper);
	}

	/**
	 * Return the element itself or its components if it is an {@link Alternatives}.
	 */
	protected Collection<AbstractElement> getElementsToParse(AbstractElement root) {
		if (root instanceof Alternatives)
			return ((CompoundElement) root).getElements();
		return Collections.singleton(root);
	}

	protected String[][] getRequiredRuleNames(String ruleName, List<Integer> paramStack,
			AbstractElement elementToParse) {
		return requiredRuleNameComputer
				.getRequiredRuleNames(new RequiredRuleNameComputer.Param(ruleName, paramStack, elementToParse) {
					@Override
					public String getBaseRuleName(AbstractElement element) {
						return getRuleName(element);
					}
				});
	}

	protected abstract String getRuleName(AbstractElement element);

	/**
	 * Creates a new {@link IUnorderedGroupHelper} that is not yet initialized.
	 */
	protected IUnorderedGroupHelper createUnorderedGroupHelper() {
		return getUnorderedGroupHelper().get();
	}

	/**
	 * Public for testing purpose.
	 */
	public void setUnorderedGroupHelper(Provider<IUnorderedGroupHelper> unorderedGroupHelper) {
		this.unorderedGroupHelper = unorderedGroupHelper;
	}

	/**
	 * Public for testing purpose.
	 */
	public Provider<IUnorderedGroupHelper> getUnorderedGroupHelper() {
		return unorderedGroupHelper;
	}

	/**
	 * Public for testing purpose.
	 */
	public void setRequiredRuleNameComputer(RequiredRuleNameComputer requiredRuleNameComputer) {
		this.requiredRuleNameComputer = requiredRuleNameComputer;
	}

	/**
	 * Public for testing purpose.
	 */
	public RequiredRuleNameComputer getRequiredRuleNameComputer() {
		return requiredRuleNameComputer;
	}

	/**
	 * @since 2.14
	 */
	protected RuleNames getRuleNames() {
		return ruleNames;
	}

	public Collection<FE> getFollowElements(IParseResult parseResult, EntryPointFinder entryPointFinder, int offset,
			boolean strict) {
		ICompositeNode entryPoint = entryPointFinder.findEntryPoint(parseResult, offset);
		if (entryPoint != null) {
			String parseMe = getTextToParse(parseResult, entryPoint, offset);
			TokenSource tokenSource = createTokenSource(parseMe);
			InternalParser parser = createParser();
			parser.setStrict(strict);
			ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(tokenSource, parser);
			tokens.setInitialHiddenTokens(getInitialHiddenTokens());
			parser.setTokenStream(tokens);
			IUnorderedGroupHelper helper = createUnorderedGroupHelper();
			parser.setUnorderedGroupHelper(helper);
			helper.initializeWith(parser);
			tokens.setListener(parser);
			try {
				Collection<FE> followElements = getFollowElements(parser, getEntryGrammarElement(entryPoint));
				return Lists.newArrayList(followElements);
			} catch (InfiniteRecursion infinite) {
				return Lists.newArrayList(parser.getFollowElements());
			}
		} else {
			String text = parseResult.getRootNode().getText();
			String parseMe = text.substring(0, offset);
			initializeFor(NodeModelUtils.getEntryParserRule(parseResult.getRootNode()));
			Collection<FE> followElements = getFollowElements(parseMe, strict);
			return followElements;
		}
	}

	protected AbstractElement getEntryGrammarElement(ICompositeNode entryPoint) {
		EObject grammarElement = entryPoint.getGrammarElement();
		if (grammarElement instanceof RuleCall) {
			AbstractRule rule = ((RuleCall) grammarElement).getRule();
			if (rule instanceof ParserRule) {
				if (!GrammarUtil.isMultipleCardinality(rule.getAlternatives())) {
					grammarElement = rule.getAlternatives();
				}
			}
		} else if (grammarElement instanceof ParserRule) {
			grammarElement = ((ParserRule) grammarElement).getAlternatives();
		} else if (grammarElement instanceof CrossReference) {
			grammarElement = GrammarUtil.containingAssignment(grammarElement);
		}
		AbstractElement result = (AbstractElement) grammarElement;
		if (result instanceof Action) {
			return getEntryGrammarElement((ICompositeNode) entryPoint.getFirstChild());
		}
		return result;
	}

	protected String getTextToParse(IParseResult parseResult, ICompositeNode entryPoint, int offset) {
		StringBuilder result = new StringBuilder(offset - entryPoint.getTotalOffset());
		appendTextToParse(entryPoint, offset, false, result);
		return result.toString();
	}

	protected boolean appendTextToParse(ICompositeNode node, int offset, boolean skipOptional, StringBuilder result) {
		for (INode child : node.getChildren()) {
			if (child instanceof ILeafNode) {
				String text = child.getText();
				if (child.getTotalEndOffset() >= offset) {
					String sub = text.substring(0, offset - child.getTotalOffset());
					result.append(sub);
					return true;
				} else {
					result.append(text);
				}
			} else {
				if (!skipOptional) {
					if (appendTextToParse((ICompositeNode) child, offset, child.getTotalEndOffset() < offset, result)) {
						return true;
					}
				} else {
					String skippedAs = getReplacement((ICompositeNode) child);
					if (skippedAs != null) {
						result.append(skippedAs);
					} else {
						if (appendTextToParse((ICompositeNode) child, offset, true, result)) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/**
	 * Returns a syntactically correct replacement for nodes whose real content does not need to be parsed.
	 * 
	 * @return the replacement or <code>null</code>
	 */
	protected String getReplacement(ICompositeNode node) {
		return null;
	}

	protected Collection<FE> getFollowElements(InternalParser parser, AbstractElement entryPoint) {
		String ruleName = getRuleName(entryPoint);
		if (ruleName == null) {
			if (entryPoint instanceof RuleCall) {
				RuleCall call = (RuleCall) entryPoint;
				AbstractRule rule = call.getRule();
				if (rule instanceof ParserRule) {
					ruleName = getRuleNames().getAntlrRuleName(rule);
				}
			}
		}
		if (ruleName == null) {
			throw new IllegalStateException("entryPoint: " + entryPoint);
		}
		return getFollowElements(parser, ruleName);
	}
}
