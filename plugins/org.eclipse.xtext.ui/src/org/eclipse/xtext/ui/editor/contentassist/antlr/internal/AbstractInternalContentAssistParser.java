/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.contentassist.antlr.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.LookAheadTerminal;
import org.eclipse.xtext.ui.editor.contentassist.antlr.LookAheadTerminalRuleCall;
import org.eclipse.xtext.ui.editor.contentassist.antlr.LookaheadKeyword;
import org.eclipse.xtext.ui.editor.contentassist.antlr.ObservableXtextTokenStream;

import com.google.common.collect.Iterators;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractInternalContentAssistParser extends Parser implements
		ObservableXtextTokenStream.StreamListener, ITokenDefProvider {

	private static final Logger logger = Logger.getLogger(AbstractInternalContentAssistParser.class);
	
	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	protected class DefaultFollowElementFactory implements IFollowElementFactory {
		public FollowElement createFollowElement(AbstractElement current, int lookAhead) {
			if (logger.isDebugEnabled())
				logger.debug("Creating FollowElement for: " + current);
			FollowElement result = new FollowElement();
			result.setLookAhead(lookAhead);
			if (lookAhead != 1) {
				int from = input.index();
				int to = input.size();
				if (marked) {
					from = firstMarker;
				}
				List<LookAheadTerminal> lookAheadTerminals = Lists.newArrayListWithExpectedSize(to - from);
				for (int tokenIndex = from; tokenIndex < to; tokenIndex++) {
					Token token = input.get(tokenIndex);
					
					if (token != null) {
						LookAheadTerminal lookAheadTerminal = createLookAheadTerminal(token);
						lookAheadTerminals.add(lookAheadTerminal);
					}
				}
				result.setLookAheadTerminals(lookAheadTerminals);
				result.setLookAhead(lookAheadTerminals.size() + 1);
			}
			result.setGrammarElement(current);
			result.setTrace(Lists.newArrayList(Iterators.filter(grammarElements.iterator(), AbstractElement.class)));
			result.setLocalTrace(Lists.newArrayList(Iterators.filter(localTrace.iterator(), AbstractElement.class)));
			if (current instanceof UnorderedGroup) {
				if (indexToHandledElements != null) {
					int index = grammarElements.lastIndexOf(current);
					List<AbstractElement> alreadyHandled = Lists.newArrayList(Iterators.filter(indexToHandledElements.get(index).iterator(), AbstractElement.class));
					result.setHandledUnorderedGroupElements(alreadyHandled);
				} else {
					result.setHandledUnorderedGroupElements(Collections.<AbstractElement>emptyList());
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug("FollowElement is: " + current);
				logger.debug("==================================");
			}
			return result;
		}
	}

	public interface RecoveryListener {
		void beginErrorRecovery();
		void endErrorRecovery();
	}
	
	interface IFollowElementFactory {
		FollowElement createFollowElement(AbstractElement current, int lookAhead);
	}
	
	protected final List<EObject> grammarElements;
	protected final List<EObject> localTrace;
	protected int stackSize;
	protected final Set<FollowElement> followElements;
	protected ObservableXtextTokenStream.StreamListener delegate;
	protected List<TerminalRule> terminalRules;
	protected boolean mismatch;
	protected RecoveryListener recoveryListener;
	protected int lookAheadAddOn;
	protected boolean marked = false;
	protected boolean resyncing = false;
	protected boolean strict = false;
	protected int wasErrorCount = -1;
	protected int predictionLevel = 0;
	protected int currentMarker;
	protected int firstMarker;
	protected boolean inMismatchIsUnwantedToken = false;
	protected boolean failedPredicateAtEOF = false;
	protected Multimap<Integer, AbstractElement> indexToHandledElements;
	protected IUnorderedGroupHelper unorderedGroupHelper;
	protected IFollowElementFactory followElementFactory = new DefaultFollowElementFactory();

	public AbstractInternalContentAssistParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.grammarElements = new ArrayList<EObject>();
		this.localTrace = new ArrayList<EObject>();
		this.followElements = new LinkedHashSet<FollowElement>();
	}
	
	public AbstractInternalContentAssistParser(TokenStream input) {
		super(input);
		this.grammarElements = new ArrayList<EObject>();
		this.localTrace = new ArrayList<EObject>();
		this.followElements = new LinkedHashSet<FollowElement>();
	}
	
	/**
	 * When experiencing slow content assist, try to reduce the threshold.
	 * 
	 * @since 2.4
	 */
	protected int getLookaheadThreshold() {
		return Integer.MAX_VALUE;
	}

	public void before(EObject grammarElement) {
		if (input.size() == input.index()) {
			int idx = localTrace.indexOf(grammarElement);
			// due to error recovery inconveniences we have to add some grammarElements
			// twice immediately after each other
			if (idx >= 0 && idx != localTrace.size() - 1) {
				List<EObject> traceAfterFirstOccurrence = localTrace.subList(idx + 1, localTrace.size());
				int secondIdx = traceAfterFirstOccurrence.indexOf(grammarElement);
				if (secondIdx >= 0 && secondIdx != traceAfterFirstOccurrence.size() - 1) {
					List<EObject> firstRun = localTrace.subList(idx, idx + 1 + secondIdx);
					List<EObject> secondRun = traceAfterFirstOccurrence.subList(secondIdx, traceAfterFirstOccurrence.size());
					if (firstRun.equals(secondRun)) {
						throw new InfiniteRecursion();
					}
				}
			}
		}
		grammarElements.add(grammarElement);
		localTrace.add(grammarElement);
	}

	public void after(EObject grammarElement) {
		EObject foundGrammarElement = grammarElements.remove(grammarElements.size() - 1);
		if (grammarElement != foundGrammarElement)
			throw new IllegalStateException("expected element: '" + grammarElement + "', but was: '"
					+ foundGrammarElement + "'");
		if (grammarElement instanceof UnorderedGroup && indexToHandledElements != null) {
			indexToHandledElements.removeAll(grammarElements.size());
		} else if (!grammarElements.isEmpty()) {
			int index = grammarElements.size() - 1;
			if (grammarElements.get(index) instanceof UnorderedGroup) {
				if (indexToHandledElements == null) {
					indexToHandledElements = LinkedHashMultimap.create();
				}
				indexToHandledElements.put(index, (AbstractElement) grammarElement);
			}
		}
	}

	@Override
	public void recover(IntStream stream, RecognitionException ex) {
		if (recoveryListener != null)
			recoveryListener.beginErrorRecovery();
		removeUnexpectedElements();
		if (ex instanceof FailedPredicateException && ex.token.getType() == Token.EOF) {
			failedPredicateAtEOF = true;
		}
		super.recover(stream, ex);
		if (recoveryListener != null)
			recoveryListener.endErrorRecovery();
	}

	private void removeUnexpectedElements() {
		while (stackSize < grammarElements.size())
			grammarElements.remove(grammarElements.size() - 1);
	}

	@Override
	public void emitErrorMessage(String msg) {
		// don't call super, since it would do a plain vanilla
		// System.err.println(msg);
	}
	
	/**
	 * @since 2.3
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	public RecognizerSharedState getInternalRecognizerSharedState() {
		return state;
	}

	protected abstract Grammar getGrammar();

	protected int keepStackSize() {
		int result = stackSize;
		stackSize = grammarElements.size();
		return result;
	}

	protected void restoreStackSize(int stackSize) {
		if (!isBacktracking()) {
			removeUnexpectedElements();
			this.stackSize = stackSize;
		}
	}

	
	/**
	 * @since 2.4
	 */
	protected boolean isBacktracking() {
		return state.backtracking != 0;
	}
	
	protected abstract class StreamAdapter implements ObservableXtextTokenStream.StreamListener {
		public void announceConsume() {
			AbstractInternalContentAssistParser.this.announceConsume();
		}
		
		public void announceMark(int marker) {
			AbstractInternalContentAssistParser.this.announceMark(marker);
		}
		
		public void announceRewind(int marker) {
			AbstractInternalContentAssistParser.this.announceRewind(marker);
		}
	}

	protected void selectEofStrategy() {
		if (mismatch) {
			delegate = createMismatchStrategy();
		} else if (!state.errorRecovery) {
			delegate = createNotErrorRecoveryStrategy();
		} else {
			delegate = createErrorRecoveryStrategy();
		}
		if (predictionLevel > 0) {
			delegate = createPredictionStrategy();
		} 
	}
	
	

	protected StreamAdapter createPredictionStrategy() {
		return new StreamAdapter() {

			private AbstractElement lastAddedElement;
			private AbstractElement globalLastAddedElement;
			private boolean wasMismatch = false;
			private ObservableXtextTokenStream.StreamListener privateDelegate = delegate;
			private IFollowElementFactory followElementFactory;
			private AbstractElement recovered;
			{
				followElementFactory = AbstractInternalContentAssistParser.this.followElementFactory;
				AbstractInternalContentAssistParser.this.followElementFactory = new IFollowElementFactory() {
					
					public FollowElement createFollowElement(AbstractElement current, int lookAhead) {
						FollowElement result = followElementFactory.createFollowElement(current, lookAhead);
						if (result != null) {
							globalLastAddedElement = result.getGrammarElement();
						}
						return result;
					}
				};
			}

			public void announceEof(int lookAhead) {
				try {
					if (predictionLevel == 0) {
						if (!wasMismatch && (!state.errorRecovery || !resyncing)) {
							AbstractElement current = getCurrentGrammarElement();
							if (current != null
									&& (lastAddedElement == null || 
										!EcoreUtil.isAncestor(current, lastAddedElement))) {
								if (state.errorRecovery) {
									if (!failedPredicateAtEOF && (globalLastAddedElement != current && (globalLastAddedElement == null 
											|| GrammarUtil.isOptionalCardinality(globalLastAddedElement)
											|| GrammarUtil.isOneOrMoreCardinality(globalLastAddedElement)))) {
										createAndAddFollowElement(current, lookAhead);
									} 
								} else {
									if (globalLastAddedElement != current)
										createAndAddFollowElement(current, lookAhead);
								}
							}
						}
						if (mismatch && !wasMismatch && !failedPredicateAtEOF) {
							AbstractElement current = getCurrentGrammarElement();
							if (recovered == null || recovered == current) {
								if (current != null
										&& (lastAddedElement == null || 
											!EcoreUtil.isAncestor(current, lastAddedElement))) {
									createAndAddFollowElement(current, lookAhead);
								}
							}
						} 
					} else {
						if (globalLastAddedElement != getCurrentGrammarElement())
							privateDelegate.announceEof(lookAhead);
					}
				} finally {
					wasMismatch |= mismatch;
					if (getCurrentGrammarElement() != null && getCurrentGrammarElement() != globalLastAddedElement) {
						if (state.errorRecovery && recovered == null) {
							recovered = getCurrentGrammarElement();
						}
					}
				}
			}

			protected void createAndAddFollowElement(AbstractElement current, int lookAhead) {
				if (marked)
					lookAhead+=lookAheadAddOn;
				FollowElement followElement = followElementFactory.createFollowElement(current, lookAhead);
				followElements.add(followElement);
				lastAddedElement = current;
				globalLastAddedElement = current;
			}

		};
	}

	protected StreamAdapter createErrorRecoveryStrategy() {
		return new StreamAdapter() {

			private AbstractElement lastAddedElement;

			public void announceEof(int lookAhead) {
				AbstractElement current = getCurrentGrammarElement();
				if (current != null
						&& (lastAddedElement == null || 
							!EcoreUtil.isAncestor(current, lastAddedElement))) {
					if (marked)
						lookAhead+=lookAheadAddOn;
					followElements.add(createFollowElement(current, lookAhead));
					lastAddedElement = current;
				}
			}

		};
	}

	protected StreamAdapter createNotErrorRecoveryStrategy() {
		return new StreamAdapter() {

			public void announceEof(int lookAhead) {
				if (!state.errorRecovery && !mismatch && (!isBacktracking() || marked)) {
					AbstractElement current = getCurrentGrammarElement();
					if (current != null) {
						if (marked)
							lookAhead+=lookAheadAddOn;
						if (lookAhead <= getLookaheadThreshold())
							followElements.add(createFollowElement(current, lookAhead));
					}
				}
			}

		};
	}

	protected StreamAdapter createMismatchStrategy() {
		return new StreamAdapter() {

			private boolean wasErrorRecovery = false;
			
			public void announceEof(int lookAhead) {
				wasErrorRecovery = wasErrorRecovery || state.errorRecovery;
				if (!wasErrorRecovery && !mismatch) {
					AbstractElement current = getCurrentGrammarElement();
					if (current != null) {
						if (marked)
							lookAhead+=lookAheadAddOn;
						followElements.add(createFollowElement(current, lookAhead));
					}
				}
			}
		};
	}
	
	@Override
	public void beginResync() {
		resyncing = true;
	}

	@Override
	public void endResync() {
		resyncing = false;
	}
	
	@Override
	protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) throws RecognitionException {
		try {
			mismatch = true;
			return super.recoverFromMismatchedToken(input, ttype, follow);
		}
		finally {
			mismatch = false;
		}
	}
	
	@Override
	public boolean mismatchIsMissingToken(IntStream input, BitSet follow) {
		return false;
	}
	
	protected AbstractElement getCurrentGrammarElement() {
		for (int i = grammarElements.size() - 1; i >= 0; i--) {
			EObject result = grammarElements.get(grammarElements.size() - 1);
			if (result instanceof AbstractElement)
				return (AbstractElement) result;
		}
		return null;
	}

	protected FollowElement createFollowElement(AbstractElement current, int lookAhead) {
		return followElementFactory.createFollowElement(current, lookAhead);
	}

	public LookAheadTerminal createLookAheadTerminal(Token token) {
		Grammar grammar = getGrammar();
		String tokenName = getTokenNames()[token.getType()];
		tokenName = getValueForTokenName(tokenName);
		if (tokenName.charAt(0) == '\'') {
			LookaheadKeyword result = new LookaheadKeyword();
			result.setKeyword(tokenName.substring(1, tokenName.length() - 1));
			result.setToken(token);
			return result;
		}
		LookAheadTerminalRuleCall result = new LookAheadTerminalRuleCall();
		result.setToken(token);
		String ruleName = tokenName.substring(5);
		if (terminalRules == null)
			terminalRules = GrammarUtil.allTerminalRules(grammar);
		for (TerminalRule rule : terminalRules) {
			if (rule.getName().equalsIgnoreCase(ruleName)) {
				result.setRule(rule);
				return result;
			}
		}
		throw new IllegalArgumentException("tokenType " + token.getType() + " seems to be invalid.");
	}

	public void announceEof(int lookAhead) {
		if (logger.isDebugEnabled()) {
			logger.debug("Reached Eof with LA " + lookAhead);
			logger.debug("Internal parser state is: ");
			logger.debug("  current: " + getCurrentGrammarElement());
			logger.debug("  failed: " + state.failed);
			logger.debug("  errorRecovery: " + state.errorRecovery);
			logger.debug("  resyncing: " + resyncing);
			logger.debug("  marked: " + marked);
			logger.debug("  firstMarker: " + firstMarker);
			logger.debug("  currentMarker: " + currentMarker);
			logger.debug("  lookAheadAddOn: " + lookAheadAddOn);
			logger.debug("  predictionLevel: " + predictionLevel);
			logger.debug("  stackSize: " + stackSize);
			logger.debug("  backtracking: " + state.backtracking);
			logger.debug("  syntaxErrors: " + state.syntaxErrors);
			logger.debug("  token: " + state.token);
			logger.debug("==================================");
		}
		if (delegate == null) {
			selectEofStrategy();
			if (strict) {
				wasErrorCount = state.syntaxErrors;
			}
		}
		if (inMismatchIsUnwantedToken)
			return;
		if (grammarElements.isEmpty() || delegate == null)
			return;
		if (strict) {
			if (wasErrorCount != state.syntaxErrors)
				return;
		}
		delegate.announceEof(lookAhead);
	}
	
	public void announceConsume() {
		if (!marked)
			localTrace.clear();
		else
			lookAheadAddOn++;
	}
	
	@Override
	public boolean mismatchIsUnwantedToken(IntStream input, int ttype) {
		try {
			inMismatchIsUnwantedToken = true;
			boolean result = super.mismatchIsUnwantedToken(input, ttype);
			return result;
		} finally {
			inMismatchIsUnwantedToken = false;
		}
	}
	
	public void announceRewind(int marker) {
		currentMarker = marker;
		lookAheadAddOn = currentMarker - firstMarker;
		if (firstMarker == currentMarker)
			marked = false;
	}
	
	public void announceMark(int marker) {
		if (!marked) {
			marked = true;
			lookAheadAddOn = 0;
			currentMarker = marker;
			firstMarker = marker;
		} else {
			currentMarker = marker;
		}
	}
	
	public void beginDFAPrediction() {
		predictionLevel++;
	}
	
	public boolean isDFAPrediction() {
		return predictionLevel != 0;
	}
	
	public void endDFAPrediction() {
		predictionLevel--;
	}

	public Set<FollowElement> getFollowElements() {
		if (logger.isDebugEnabled()) {
			logger.debug("getFollowElements()");
		}
		return followElements;
	}
	
	public Map<Integer, String> getTokenDefMap() {
		String[] names = getTokenNames();
		Map<Integer, String> result = Maps.newHashMapWithExpectedSize(names.length - Token.MIN_TOKEN_TYPE);
		for (int i = Token.MIN_TOKEN_TYPE; i < names.length; i++) {
			result.put(i, getValueForTokenName(names[i]));
		}
		return result;
	}
	
	protected String getValueForTokenName(String tokenName) {
		return tokenName;
	}
		
	public List<EObject> getGrammarElements() {
		return grammarElements;
	}

	public List<EObject> getLocalTrace() {
		return localTrace;
	}
	
	public RecoveryListener getRecoveryListener() {
		return recoveryListener;
	}

	public void setRecoveryListener(RecoveryListener recoveryListener) {
		this.recoveryListener = recoveryListener;
	}

	public void setUnorderedGroupHelper(IUnorderedGroupHelper unorderedGroupHelper) {
		this.unorderedGroupHelper = unorderedGroupHelper;
	}

	public IUnorderedGroupHelper getUnorderedGroupHelper() {
		return unorderedGroupHelper;
	}
	
	public void setStrict(boolean strict) {
		this.strict = strict;
	}

}
