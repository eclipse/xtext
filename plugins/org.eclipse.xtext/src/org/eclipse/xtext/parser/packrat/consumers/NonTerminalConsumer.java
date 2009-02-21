/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parser.packrat.IBacktracker;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler.IHiddenTokenState;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.AlternativesToken;
import org.eclipse.xtext.parser.packrat.tokens.AssignmentToken;
import org.eclipse.xtext.parser.packrat.tokens.ErrorToken;
import org.eclipse.xtext.parser.packrat.tokens.GroupToken;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;
import org.eclipse.xtext.parser.packrat.tokens.PlaceholderToken;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class NonTerminalConsumer extends AbstractConsumer implements INonTerminalConsumer, INonTerminalConsumerConfiguration {

	private final IHiddenTokenHandler hiddenTokenHandler;

	private final IMarkerFactory markerFactory;

	private final IBacktracker backtracker;

	private final ITerminalConsumer[] hiddenTokens;

	private final IConsumerUtility consumerUtil;

	protected class AlternativesResult {
		private int bestResult;
		private IMarker bestMarker;
		private IMarker currentMarker;

		protected AlternativesResult() {
			bestResult = ConsumeResult.SUCCESS;
			bestMarker = mark();
		}

		public void nextAlternative() {
			announceNextPath();
			currentMarker = bestMarker.fork();
		}

		public void reset() {
			bestResult = ConsumeResult.EMPTY_MATCH;
		}

		public int getResult() {
			bestMarker.commit();
			announceLevelFinished();
			getTokenAcceptor().accept(new AlternativesToken.End(getOffset()));
			return bestResult;
		}

		public boolean isAlternativeDone(int result) {
			if (result == ConsumeResult.SUCCESS || result > bestResult) {
				bestMarker = currentMarker.join(bestMarker);
				bestResult = result;
			} else {
				bestMarker = bestMarker.join(currentMarker);
			}
			currentMarker = null;
			return result == ConsumeResult.SUCCESS;
		}
	}

	protected class GroupResult {
		private int result;
		private final IMarker marker;

		protected GroupResult() {
			result = ConsumeResult.SUCCESS;
			marker = mark();
		}

		public void nextStep() {
			announceNextStep();
		}

		public void reset() {
			result = ConsumeResult.EMPTY_MATCH;
		}

		public int getResult() {
			marker.commit();
			announceLevelFinished();
			getTokenAcceptor().accept(new GroupToken.End(getOffset()));
			return result;
		}

		public boolean didGroupFail(int result) {
			this.result = result;
			return result != ConsumeResult.SUCCESS;
		}
	}

	protected class AssignmentResult {
		public int getResult(int result) {
			getTokenAcceptor().accept(new AssignmentToken.End(getOffset()));
			return result;
		}
	}

	protected NonTerminalConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration.getInput(), configuration.getTokenAcceptor(), configuration.getRecoveryStateHolder());
		this.markerFactory = configuration.getMarkerFactory();
		this.hiddenTokenHandler = configuration.getHiddenTokenHandler();
		this.consumerUtil = configuration.getConsumerUtil();
		this.hiddenTokens = hiddenTokens;
		this.backtracker = configuration.getBacktracker();
	}

	public int consume(String feature, boolean isMany, boolean isDatatype, boolean isBoolean, AbstractElement grammarElement) throws Exception {
		IHiddenTokenState prevState = hiddenTokenHandler.replaceHiddenTokens(hiddenTokens);
		IMarker marker = mark();
		int prevOffset = getOffset();
		getTokenAcceptor().accept(new ParsedNonTerminal(getInput().getOffset(), grammarElement != null ? grammarElement : getGrammarElement(), getDefaultType()));
		int result = doConsume(-1);
		if (result != ConsumeResult.SUCCESS) {
			getTokenAcceptor().accept(new ErrorToken(prevOffset, 0, null, "Expected " + getDefaultType() + ", but could not find."));
		}
		getTokenAcceptor().accept(new ParsedNonTerminalEnd(getInput().getOffset(), feature, isMany, isDatatype, isBoolean));
		marker.commit();
		prevState.restore();
		return result;
	}

	public AlternativesResult createAlternativesResult() {
		announceNextLevel();
		return new AlternativesResult();
	}

	public AlternativesResult createAlternativesResult(Alternatives alternatives) {
		announceNextLevel();
		getTokenAcceptor().accept(new AlternativesToken(getOffset(), alternatives));
		return new AlternativesResult();
	}

	public GroupResult createGroupResult(Group group) {
		announceNextLevel();
		getTokenAcceptor().accept(new GroupToken(getOffset(), group));
		return new GroupResult();
	}

	public AssignmentResult createAssignmentResult(Assignment assignment) {
		getTokenAcceptor().accept(new AssignmentToken(getOffset(), assignment));
		return new AssignmentResult();
	}

	public boolean skipPreviousToken() {
		return backtracker.skipPreviousToken();
	}

	public void skipped(EObject grammarElement) {
		getTokenAcceptor().accept(new PlaceholderToken(getOffset(), grammarElement));
	}

	public boolean isDefiningHiddens() {
		return hiddenTokens != null;
	}

	public void consumeAsRoot(IRootConsumerListener listener) {
		IHiddenTokenState prevState = hiddenTokenHandler.replaceHiddenTokens(hiddenTokens);
		IMarker marker = mark();
		getTokenAcceptor().accept(new ParsedNonTerminal(getInput().getOffset(), getGrammarElement(), getDefaultType()));
		listener.afterNonTerminalBegin(this, this);
		int result;
		try {
			result = doConsume(-1);
		} catch(Exception e) {
			e.printStackTrace();
			result = ConsumeResult.EXCEPTION;
			listener.handleException(this, e, this);
		}
		listener.beforeNonTerminalEnd(this, result, this);
		getTokenAcceptor().accept(new ParsedNonTerminalEnd(getInput().getOffset(), null, false, false, false));
		marker.commit();
		prevState.restore();
	}

	protected final IMarker mark() {
		return markerFactory.mark();
	}

	protected final void error(String message, AbstractElement grammarElement) {
		getTokenAcceptor().accept(new ErrorToken(getOffset(), 0, grammarElement, message));
	}

	protected final int consumeKeyword(Keyword keyword, String feature, boolean isMany, boolean isBoolean, ICharacterClass notFollowedBy) {
		return consumerUtil.consumeKeyword(keyword, feature, isMany, isBoolean, notFollowedBy);
	}

	protected final int consumeTerminal(ITerminalConsumer consumer, String feature, boolean isMany, boolean isBoolean, AbstractElement grammarElement, ISequenceMatcher notMatching) {
		return consumerUtil.consumeTerminal(consumer, feature, isMany, isBoolean, grammarElement, notMatching);
	}

	protected final int consumeNonTerminal(INonTerminalConsumer consumer, String feature, boolean isMany, boolean isDatatype, boolean isBoolean, AbstractElement grammarElement) throws Exception {
		return consumerUtil.consumeNonTerminal(consumer, feature, isMany, isDatatype, isBoolean, grammarElement);
	}

	protected final void consumeAction(Action action, boolean isMany) {
		consumerUtil.consumeAction(action, isMany);
	}

	protected abstract int doConsume(int entryPoint) throws Exception;

	// TODO: replace by getDefaultType: EClassifier
	protected abstract EClassifier getDefaultType();

	protected abstract EObject getGrammarElement();

	public IConsumerUtility getConsumerUtil() {
		return consumerUtil;
	}

	public IHiddenTokenHandler getHiddenTokenHandler() {
		return hiddenTokenHandler;
	}

	public IMarkerFactory getMarkerFactory() {
		return markerFactory;
	}

	public IBacktracker getBacktracker() {
		return backtracker;
	}

	@Override
	public String toString() {
		return "NonTerminalConsumer " + getClass().getSimpleName() + " for type '" + getDefaultType()  + "'";
	}
}