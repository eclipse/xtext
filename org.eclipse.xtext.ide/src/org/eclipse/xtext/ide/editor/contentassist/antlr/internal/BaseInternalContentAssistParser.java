/*******************************************************************************
 * Copyright (c) 2017 itemis AG (http://www.itemis.de) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.DFA;
import org.antlr.runtime.FailedPredicateException;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.UnorderedGroup;
import org.eclipse.xtext.ide.editor.contentassist.antlr.BaseFollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ILookAheadTerminal;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ObservableXtextTokenStream;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper;

import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.14
 */
public abstract class BaseInternalContentAssistParser<FollowElement extends BaseFollowElement<LookAheadTerminal>, LookAheadTerminal extends ILookAheadTerminal>
		extends Parser implements ObservableXtextTokenStream.StreamListener, ITokenDefProvider {

	public interface RecoveryListener {
		void beginErrorRecovery();

		void endErrorRecovery();
	}

	public interface IFollowElementFactory<FollowElement extends BaseFollowElement<LookAheadTerminal>, LookAheadTerminal extends ILookAheadTerminal> {
		FollowElement createFollowElement(AbstractElement current, int lookAhead);
	}

	protected final List<EObject> grammarElements;
	protected final List<EObject> localTrace;
	protected final List<Integer> paramStack;
	protected final List<Integer> grammarElementsWithParams;
	protected int stackSize;
	protected final Set<FollowElement> followElements;
	protected ObservableXtextTokenStream.StreamListener delegate;
	protected List<TerminalRule> terminalRules;
	protected boolean mismatch;
	protected RecoveryListener recoveryListener;
	protected int lookAheadAddOn;
	protected int marked = 0;
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
	protected IFollowElementFactory<FollowElement, LookAheadTerminal> followElementFactory = newFollowElementFactory();

	public BaseInternalContentAssistParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
		this.grammarElements = new ArrayList<EObject>();
		this.localTrace = new ArrayList<EObject>();
		this.paramStack = new ArrayList<Integer>();
		this.grammarElementsWithParams = new ArrayList<Integer>();
		this.followElements = new LinkedHashSetWithoutNull<FollowElement>();
	}

	public BaseInternalContentAssistParser(TokenStream input) {
		super(input);
		this.grammarElements = new ArrayList<EObject>();
		this.localTrace = new ArrayList<EObject>();
		this.followElements = new LinkedHashSetWithoutNull<FollowElement>();
		this.paramStack = new ArrayList<Integer>();
		this.grammarElementsWithParams = new ArrayList<Integer>();
	}
	
	protected abstract IFollowElementFactory<FollowElement, LookAheadTerminal> newFollowElementFactory();

	/**
	 * When experiencing slow content assist, try to reduce the threshold.
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
					List<EObject> secondRun = traceAfterFirstOccurrence.subList(secondIdx,
							traceAfterFirstOccurrence.size());
					if (firstRun.equals(secondRun)) {
						throw infiniteRecursion();
					}
				}
			}
		}
		grammarElements.add(grammarElement);
		localTrace.add(grammarElement);
	}

	protected InfiniteRecursion infiniteRecursion() {
		return new InfiniteRecursion();
	}

	public void before(EObject grammarElement, int paramConfig) {
		before(grammarElement);
		paramStack.add(paramConfig);
		grammarElementsWithParams.add(stackSize);
	}

	public void after(EObject grammarElement, int paramConfig) {
		int old = removeLast(paramStack);
		if (old != paramConfig) {
			throw new IllegalStateException(paramConfig + "!=" + old);
		}
		removeLast(grammarElementsWithParams);
		after(grammarElement);
	}

	public void after(EObject grammarElement) {
		EObject foundGrammarElement = removeLast(grammarElements);
		if (grammarElement != foundGrammarElement)
			throw new IllegalStateException(
					"expected element: '" + grammarElement + "', but was: '" + foundGrammarElement + "'");
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
		int dropParamAt = -1;
		if (!grammarElementsWithParams.isEmpty()) {
			dropParamAt = getLast(grammarElementsWithParams);
		}
		while (stackSize < grammarElements.size()) {
			removeLast(grammarElements);
			if (dropParamAt == grammarElements.size()) {
				removeLast(paramStack);
				removeLast(grammarElementsWithParams);
				if (!grammarElementsWithParams.isEmpty()) {
					dropParamAt = getLast(grammarElementsWithParams);
				}
			}
		}
	}

	private <T> T getLast(List<T> list) {
		return list.get(list.size() - 1);
	}

	private <T> T removeLast(List<T> list) {
		return list.remove(list.size() - 1);
	}

	@Override
	public void emitErrorMessage(String msg) {
		// don't call super, since it would do a plain vanilla
		// System.err.println(msg);
	}

	/**
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

	protected boolean isBacktracking() {
		return state.backtracking != 0;
	}

	protected abstract class StreamAdapter implements ObservableXtextTokenStream.StreamListener {
		@Override
		public void announceConsume() {
			BaseInternalContentAssistParser.this.announceConsume();
		}

		@Override
		public void announceMark(int marker) {
			BaseInternalContentAssistParser.this.announceMark(marker);
		}

		@Override
		public void announceRewind(int marker) {
			BaseInternalContentAssistParser.this.announceRewind(marker);
		}
	}

	protected void selectEofStrategy(int lookAhead) {
		if (mismatch || !state.errorRecovery) {
			selectEofStrategy();
		} else if (strict && lookAhead == 1) {
			delegate = createNoOpStrategy();
			if (predictionLevel > 0) {
				delegate = createPredictionStrategy();
			}
		} else {
			selectEofStrategy();
		}
	}

	protected void selectEofStrategy() throws UnsupportedOperationException {
		if (mismatch) {
			delegate = createMismatchStrategy();
		} else if (!state.errorRecovery) {
			if (marked > 0 && state.syntaxErrors > 0 && state.lastErrorIndex >= firstMarker) {
				delegate = createNoOpStrategy();
				return;
			} else {
				delegate = createNotErrorRecoveryStrategy();
			}
		} else {
			delegate = createErrorRecoveryStrategy();
		}
		if (predictionLevel > 0) {
			delegate = createPredictionStrategy();
		}
	}

	protected StreamAdapter createNoOpStrategy() {
		return new StreamAdapter() {
			@Override
			public void announceEof(int lookAhead) {
			}
		};
	}

	protected StreamAdapter createPredictionStrategy() {
		return new StreamAdapter() {

			private AbstractElement lastAddedElement;
			private AbstractElement globalLastAddedElement;
			private int lastKnownSyntaxErrors = Integer.MAX_VALUE;
			private boolean wasMismatch = false;
			private ObservableXtextTokenStream.StreamListener privateDelegate = delegate;
			private IFollowElementFactory<FollowElement, LookAheadTerminal> followElementFactory;
			private AbstractElement recovered;
			{
				followElementFactory = BaseInternalContentAssistParser.this.followElementFactory;
				BaseInternalContentAssistParser.this.followElementFactory = new IFollowElementFactory<FollowElement, LookAheadTerminal>() {

					@Override
					public FollowElement createFollowElement(AbstractElement current, int lookAhead) {
						if (lastKnownSyntaxErrors == Integer.MAX_VALUE || state.lastErrorIndex < 0) {
							FollowElement result = followElementFactory.createFollowElement(current, lookAhead);
							if (result != null) {
								globalLastAddedElement = result.getGrammarElement();
								if (lookAhead > 1 && isBacktracking() && lastKnownSyntaxErrors == Integer.MAX_VALUE) {
									lastKnownSyntaxErrors = state.syntaxErrors;
								}
							}
							return result;
						}
						return null;
					}
				};
			}

			@Override
			public void announceEof(int lookAhead) {
				try {
					if (predictionLevel == 0) {
						if (!wasMismatch && (!state.errorRecovery || !resyncing)) {
							AbstractElement current = getCurrentGrammarElement();
							if (current != null
									&& (lastAddedElement == null || !EcoreUtil.isAncestor(current, lastAddedElement))) {
								if (state.errorRecovery) {
									if (!failedPredicateAtEOF
											&& (globalLastAddedElement != current && (globalLastAddedElement == null
													|| GrammarUtil.isOptionalCardinality(globalLastAddedElement)
													|| GrammarUtil.isOneOrMoreCardinality(globalLastAddedElement)))) {
										createAndAddFollowElement(current, lookAhead);
									}
								} else {
									if (globalLastAddedElement != current
											&& state.syntaxErrors <= lastKnownSyntaxErrors)
										createAndAddFollowElement(current, lookAhead);
								}
							}
						}
						if (mismatch && !wasMismatch && !failedPredicateAtEOF) {
							AbstractElement current = getCurrentGrammarElement();
							if (recovered == null || recovered == current) {
								if (current != null && (lastAddedElement == null
										|| !EcoreUtil.isAncestor(current, lastAddedElement))) {
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
				if (marked > 0)
					lookAhead += lookAheadAddOn;
				FollowElement followElement = followElementFactory.createFollowElement(current, lookAhead);
				if (followElement != null) {
					followElements.add(followElement);
					lastAddedElement = current;
					globalLastAddedElement = current;
				}
			}

		};
	}

	protected StreamAdapter createErrorRecoveryStrategy() {
		return new StreamAdapter() {

			private AbstractElement lastAddedElement;

			@Override
			public void announceEof(int lookAhead) {
				AbstractElement current = getCurrentGrammarElement();
				if (current != null && (lastAddedElement == null || !EcoreUtil.isAncestor(current, lastAddedElement))) {
					if (marked > 0)
						lookAhead += lookAheadAddOn;
					followElements.add(createFollowElement(current, lookAhead));
					lastAddedElement = current;
				}
			}

		};
	}

	protected StreamAdapter createNotErrorRecoveryStrategy() {
		return new StreamAdapter() {

			@Override
			public void announceEof(int lookAhead) {
				if (!state.errorRecovery && !mismatch && ((!isBacktracking() || marked > 0) || wasErrorCount <= 0)) {
					AbstractElement current = getCurrentGrammarElement();
					if (current != null) {
						if (marked > 0)
							lookAhead += lookAheadAddOn;
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

			@Override
			public void announceEof(int lookAhead) {
				wasErrorRecovery = wasErrorRecovery || state.errorRecovery;
				if (!wasErrorRecovery && !mismatch) {
					AbstractElement current = getCurrentGrammarElement();
					if (current != null) {
						if (marked > 0)
							lookAhead += lookAheadAddOn;
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
		} finally {
			mismatch = false;
		}
	}

	@Override
	public boolean mismatchIsMissingToken(IntStream input, BitSet follow) {
		return false;
	}

	protected AbstractElement getCurrentGrammarElement() {
		for (int i = grammarElements.size() - 1; i >= 0; i--) {
			EObject result = grammarElements.get(i);
			if (result instanceof AbstractElement)
				return (AbstractElement) result;
		}
		return null;
	}

	protected FollowElement createFollowElement(AbstractElement current, int lookAhead) {
		return followElementFactory.createFollowElement(current, lookAhead);
	}

	public abstract LookAheadTerminal createLookAheadTerminal(Token token);

	@Override
	public void announceEof(int lookAhead) {
		if (delegate == null) {
			selectEofStrategy(lookAhead);
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

	@Override
	public void reportError(RecognitionException e) {
		if (strict) {
			if (state.errorRecovery) {
				return;
			}
			if (e.index != input.size()) {
				// don't count errors at EOF in strict mode
				state.syntaxErrors++;
			}
			state.errorRecovery = true;
		} else {
			super.reportError(e);
		}
	}

	@Override
	public void announceConsume() {
		if (marked <= 0)
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

	@Override
	public void announceRewind(int marker) {
		int useLookAhead = -1;
		if (marker != 0 && delegate == null && strict && predictionLevel != 0 && lookAheadAddOn > 0
				&& state.syntaxErrors == 0 && input.index() == input.size() && marker + lookAheadAddOn <= input.size()
				&& isBacktracking()) {
			useLookAhead = lookAheadAddOn;
			delegate = createNotErrorRecoveryStrategy();
			wasErrorCount = state.syntaxErrors;
		}
		currentMarker = marker;
		lookAheadAddOn = currentMarker - firstMarker;
		if (useLookAhead != -1 && useLookAhead + firstMarker >= input.index()) {
			announceEof(useLookAhead);
		}
		marked--;
	}

	@Override
	public void announceMark(int marker) {
		if (marked <= 0) {
			marked++;
			lookAheadAddOn = 0;
			currentMarker = marker;
			firstMarker = marker;
		} else {
			marked++;
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
		return followElements;
	}

	@Override
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

	public List<Integer> getParamStack() {
		return paramStack;
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

	protected static short[][] unpackEncodedStringArray(String[] arr) {
		int numStates = arr.length;
		short[][] result = new short[numStates][];
		for (int i = 0; i < numStates; i++) {
			result[i] = DFA.unpackEncodedString(arr[i]);
		}
		return result;
	}
	
	
}
