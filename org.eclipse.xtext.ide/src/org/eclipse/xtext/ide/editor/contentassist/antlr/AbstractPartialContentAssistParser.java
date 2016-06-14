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
import java.util.Collection;
import java.util.Set;

import org.antlr.runtime.TokenSource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.InfiniteRecursion;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.xtext.RuleNames;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Base class for content assist parsers that can reduce the input preceding the cursor
 * position without any impact on the follow set.
 * @since 2.9
 */
public abstract class AbstractPartialContentAssistParser extends AbstractContentAssistParser implements IPartialContentAssistParser {
	
	@Inject
	private EntryPointFinder entryPointFinder;
	
	@Inject
	private RuleNames ruleNames;

	@Override
	public Collection<FollowElement> getFollowElements(IParseResult parseResult, int offset, boolean strict) {
		ICompositeNode entryPoint = entryPointFinder.findEntryPoint(parseResult, offset);
		if (entryPoint != null) {
			String parseMe = getTextToParse(parseResult, entryPoint, offset);
			TokenSource tokenSource = createTokenSource(parseMe);
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
				Collection<FollowElement> followElements = getFollowElements(parser, getEntryGrammarElement(entryPoint));
				return Lists.newArrayList(followElements);
			} catch (InfiniteRecursion infinite) {
				return Lists.newArrayList(parser.getFollowElements());
			}
		} else {
			String text = parseResult.getRootNode().getText();
			String parseMe = text.substring(0, offset);
			Collection<FollowElement> followElements = getFollowElements(parseMe, strict);
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
	 * @return the replacement or <code>null</code>
	 */
	protected String getReplacement(ICompositeNode node) {
		return null;
	}

	protected Collection<FollowElement> getFollowElements(
			AbstractInternalContentAssistParser parser,
			AbstractElement entryPoint) {
		String ruleName = getRuleName(entryPoint);
		if (ruleName == null) {
			if (entryPoint instanceof RuleCall) {
				RuleCall call = (RuleCall) entryPoint;
				AbstractRule rule = call.getRule();
				if (rule instanceof ParserRule) {
					ruleName = ruleNames.getAntlrRuleName(rule);
				}
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
			} catch (InvocationTargetException targetException) {
				if ((targetException.getCause() instanceof InfiniteRecursion)) {
					throw (InfiniteRecursion) targetException.getCause();
				}
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
}
