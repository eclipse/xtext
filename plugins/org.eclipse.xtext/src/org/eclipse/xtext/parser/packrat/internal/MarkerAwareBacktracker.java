/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.internal;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.parser.packrat.IBacktracker;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.internal.Marker.IMarkerVisitor;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.tokens.AlternativesToken;
import org.eclipse.xtext.parser.packrat.tokens.AssignmentToken;
import org.eclipse.xtext.parser.packrat.tokens.CompoundParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.ErrorToken;
import org.eclipse.xtext.parser.packrat.tokens.GroupToken;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedToken;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MarkerAwareBacktracker implements IBacktracker {

	private final Marker marker;

	public MarkerAwareBacktracker(Marker marker) {
		this.marker = marker;
	}

	protected class NestedBacktrackingResult extends AbstractParsedTokenVisitor implements IBacktrackingResult, IMarkerVisitor {

		private Marker workingMarker;

		private boolean result;

		private boolean lookup;

		private int stackSize;

		private int skippedOffset;

		private final Set<AbstractParsedToken> markedTokens;

		protected NestedBacktrackingResult() {
			this.result = false;
			this.markedTokens = new HashSet<AbstractParsedToken>(8);
			this.skippedOffset = 0;
		}

		public void commit() {
			if (workingMarker == null)
				throw new IllegalStateException("Working marker may not be null");
			marker.replaceContent(workingMarker.getContent());
			marker.discardLastOffset();
			marker.join(workingMarker);
		}

		public void discard() {
			for(AbstractParsedToken token: markedTokens) {
				token.setSkipped(false);
			}
			if (workingMarker != null) {
				marker.join(workingMarker);
				workingMarker = null;
			}
			markedTokens.clear();
		}

		public boolean isSuccessful() {
			return result;
		}

		public IBacktrackingResult skipPreviousToken() {
			if (workingMarker != null) {
				marker.join(workingMarker);
				workingMarker = null;
			}
			result = false;
			lookup = true;
			stackSize = 0;
			int idx = -1;
			List<AbstractParsedToken> content = marker.getContent();
			idx = content.size() - 1;
			while(idx >= 0 && !result && lookup) {
				content.get(idx).accept(this);
				if (!result)
					idx--;
			}
			if (result) {
				Skipper skipper = new Skipper();
				while(idx < content.size() && skipper.continueSkip) {
					content.get(idx).accept(skipper);
					idx++;
				}
				skippedOffset += skipper.skippedOffset;
				if (idx < content.size()) {
					workingMarker = marker.fork(idx, marker.getInput().getOffset() - skipper.skippedOffset);
					final Replayer replayer = new Replayer(idx);
					boolean replaySuccessful = true;
					while (replaySuccessful && replayer.replay()) {
						ParsedToken replayMe = replayer.currentReplayToken;
						try {
							replaySuccessful = replayMe.getSource().parseAgain(replayMe) == ConsumeResult.SUCCESS;
						} catch(Exception e) {
							throw new WrappedException(e);
						}
					}
					if (!replaySuccessful) {
						marker.join(workingMarker);
						workingMarker = null;
						return skipPreviousToken();
					}
				}
			}
			return this;
		}

		@Override
		public void visitAbstractParsedToken(AbstractParsedToken token) {
			//
		}

		@Override
		public void visitCompoundParsedToken(CompoundParsedToken token) {
			if (lookup && !token.isSkipped()) {
				if (stackSize == 0)
					lookup = false;
				else {
					stackSize--;
					result = token.isOptional();
				}
			}
		}

		@Override
		public void visitParsedNonTerminal(ParsedNonTerminal token) {
			if (lookup && !token.isSkipped()) {
				if (stackSize == 0)
					lookup = false;
				else {
					stackSize--;
					result = token.isOptional();
				}
			}
		}

		@Override
		public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
			if (lookup && !token.isSkipped()) {
				stackSize++;
			}
		}

		@Override
		public void visitCompoundParsedTokenEnd(org.eclipse.xtext.parser.packrat.tokens.CompoundParsedToken.End token) {
			if (lookup && !token.isSkipped()) {
				stackSize++;
			}
		}

		@Override
		public void visitParsedTerminal(ParsedTerminal token) {
			if (lookup && !token.isHidden() && !token.isSkipped() && (token.getGrammarElement() instanceof AbstractElement)) {
				result = token.isOptional();
			}
		}

		@Override
		public void visitErrorToken(ErrorToken token) {
			token.setSkipped(true);
			markedTokens.add(token);
		}

		public void visitMarker(Marker marker) {
			final List<AbstractParsedToken> content = marker.getContent();
			if (!lookup) {
				for(int i = 0; i < content.size(); i++) {
					content.get(i).accept(this);
				}
			} else {
				for(int i = content.size() - 1; i >= 0; i--) {
					content.get(i).accept(this);
				}
			}
		}

		private final class Skipper extends AbstractParsedTokenVisitor {
			private boolean continueSkip;
			private int skippedOffset;
			private int stackSize;

			private Skipper() {
				this.continueSkip = true;
				this.skippedOffset = 0;
				this.stackSize = 0;
			}

			@Override
			public void visitAbstractParsedToken(AbstractParsedToken token) {
				//
			}

			@Override
			public void visitCompoundParsedToken(CompoundParsedToken token) {
				if (!token.isSkipped()) {
					if (continueSkip) {
						markedTokens.add(token);
						token.setSkipped(true);
						stackSize++;
					}
				}
			}

			@Override
			public void visitCompoundParsedTokenEnd(CompoundParsedToken.End token) {
				if (!token.isSkipped()) {
					if (continueSkip) {
						markedTokens.add(token);
						token.setSkipped(true);
						stackSize--;
						continueSkip = stackSize != 0;
					}
				}
			}

			@Override
			public void visitParsedTerminal(ParsedTerminal token) {
				if (!token.isSkipped()) {
					if (continueSkip) {
						markedTokens.add(token);
						token.setSkipped(true);
						skippedOffset += token.getLength();
						continueSkip = stackSize != 0;
					}
				}
			}

			@Override
			public void visitParsedNonTerminal(ParsedNonTerminal token) {
				if (!token.isSkipped()) {
					if (continueSkip) {
						markedTokens.add(token);
						token.setSkipped(true);
						stackSize++;
					}
				}
			}

			@Override
			public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
				if (!token.isSkipped()) {
					if (continueSkip) {
						markedTokens.add(token);
						token.setSkipped(true);
						stackSize--;
						continueSkip = stackSize != 0;
					}
				}
			}

			@Override
			public void visitErrorToken(ErrorToken token) {
				if (!token.isSkipped()) {
					markedTokens.add(token);
					token.setSkipped(true);
				}
			}
		}

		private final class Replayer extends AbstractParsedTokenVisitor {

			private ParsedToken nextReplayToken;
			private ParsedToken currentReplayToken;

			private int idx;

			private int stackSize;

			private final List<AbstractParsedToken> contents;

			private Replayer(int idx) {
				this.idx = idx;
				this.stackSize = 0;
				this.contents = marker.getContent();
			}

			public boolean replay() {
				if (currentReplayToken == null)
					prepare();
				if (idx >= contents.size())
					return false;
				next();
				return currentReplayToken != null && nextReplayToken != null;
			}

			private void prepare() {
				if (idx >= contents.size())
					next();
			}

			private void next() {
				currentReplayToken = nextReplayToken;
				nextReplayToken = null;
				while(idx < contents.size() && (nextReplayToken == null || stackSize != 0)) {
					contents.get(idx).accept(this);
					idx++;
				}
			}

			@Override
			public void visitCompoundParsedToken(CompoundParsedToken token) {
				if (!token.isSkipped()) {
					if (stackSize == 0)
						nextReplayToken = token;
					stackSize++;
				}
			}

			@Override
			public void visitAlternativesTokenEnd(AlternativesToken.End token) {
				if (!token.isSkipped()) {
					if (stackSize == 0)
						workingMarker.accept(new AlternativesToken.End(workingMarker.getInput().getOffset(), token.getAlternative()));
					else
						stackSize--;
				}
			}

			@Override
			public void visitAssignmentTokenEnd(AssignmentToken.End token) {
				if (!token.isSkipped()) {
					if (stackSize == 0)
						workingMarker.accept(new AssignmentToken.End(workingMarker.getInput().getOffset()));
					else
						stackSize--;
				}
			}

			@Override
			public void visitGroupTokenEnd(GroupToken.End token) {
				if (!token.isSkipped()) {
					if (stackSize == 0)
						workingMarker.accept(new GroupToken.End(workingMarker.getInput().getOffset()));
					else
						stackSize--;
				}
			}

			@Override
			public void visitParsedNonTerminal(ParsedNonTerminal token) {
				if (!token.isSkipped()) {
					if (stackSize == 0)
						nextReplayToken = token;
					stackSize++;
				}
			}

			@Override
			public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
				if (!token.isSkipped()) {
					if (stackSize == 0)
						workingMarker.accept(new ParsedNonTerminalEnd(workingMarker.getInput().getOffset(),
								token.getFeature(), token.isMany(), token.isDatatype(), token.isBoolean()));
					else
						stackSize--;
				}
			}

			@Override
			public void visitParsedToken(ParsedToken token) {
				if (!token.isSkipped() && nextReplayToken == null)
					nextReplayToken = token;
			}

		}
	}

	public IBacktrackingResult skipPreviousToken() {
		return new NestedBacktrackingResult().skipPreviousToken();
	}

}
