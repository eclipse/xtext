/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.internal;

import java.util.ArrayList;
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
import org.eclipse.xtext.parser.packrat.tokens.UnorderedGroupToken;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MarkerAwareBacktracker implements IBacktracker {

	private final Marker marker;

	public MarkerAwareBacktracker(Marker marker) {
		this.marker = marker;
	}

	protected class NestedBacktrackingResult extends AbstractParsedTokenVisitor implements IBacktrackingResult, IMarkerVisitor {

		private final List<Marker> visitedMarkers;

		private final List<Marker> workingMarkers;

		private boolean result;

		private boolean lookup;

		private int stackSize;

		private final Set<AbstractParsedToken> markedTokens;

		protected NestedBacktrackingResult() {
			this.result = false;
			this.markedTokens = new HashSet<AbstractParsedToken>(8);
			this.visitedMarkers = new ArrayList<Marker>(4);
			this.workingMarkers = new ArrayList<Marker>(4);
		}

		@Override
		public void commit() {
			if (workingMarkers.isEmpty())
				throw new IllegalStateException("Working marker may not be null");
			Marker localMarker = marker;
			for(int i = workingMarkers.size() - 1; i >= 0; i--) {
				Marker workingMarker = workingMarkers.get(i);
				localMarker.replaceContent(workingMarker.getContent());
				localMarker.discardLastOffset();
				workingMarker.forget();
				localMarker = localMarker.getParent();
			}
			workingMarkers.clear();
			markedTokens.clear();
		}

		@Override
		public void discard() {
			for(AbstractParsedToken token: markedTokens) {
				token.setSkipped(false);
			}
			discardImpl();
		}

		private void discardImpl() {
			for(int i = workingMarkers.size() - 1; i >= 0; i--) {
				Marker workingMarker = workingMarkers.get(i);
				workingMarker.forget();
			}
			workingMarkers.clear();
			markedTokens.clear();
		}

		@Override
		public boolean isSuccessful() {
			return result;
		}

		@Override
		public IBacktrackingResult skipPreviousToken() {
			discardImpl();
			init();
			Marker localMarker = marker;
			List<AbstractParsedToken> content = null;
			int idx = -1;
			while(localMarker != null && !result && lookup) {
				visitedMarkers.add(localMarker);
				content = localMarker.getContent();
				idx = content.size() - 1;
				while(idx >= 0 && !result && lookup) {
					content.get(idx).accept(this);
					if (!result)
						idx--;
				}
				if (!result && lookup)
					localMarker = localMarker.getParent();
			}
			if (result && content != null) {
				Skipper skipper = new Skipper();
				idx = skipper.skip(idx);
				if (!visitedMarkers.isEmpty()) {
					final Replayer replayer = new Replayer();
					if (!replayer.replay(idx))
						return skipPreviousToken();
				}
			}
			return this;
		}

		private void init() {
			visitedMarkers.clear();
			result = false;
			lookup = true;
			stackSize = 0;
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
		public void visitAlternativesToken(AlternativesToken token) {
			if (lookup && !token.isSkipped()) {
				if (stackSize == 0)
					lookup = false;
				else {
					if (token.canParseFurther())
						result = true;
					else
						super.visitAlternativesToken(token);
				}
			}
		}
		
		@Override
		public void visitUnorderedGroupToken(UnorderedGroupToken token) {
			if (lookup && !token.isSkipped()) {
				if (stackSize == 0)
					lookup = false;
				else {
					if (token.canParseFurther())
						result = true;
					else
						super.visitUnorderedGroupToken(token);
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
			if (!token.isSkipped()) {
				stackSize++;
			}
		}

		@Override
		public void visitParsedTerminal(ParsedTerminal token) {
			if (!token.isHidden() && !token.isSkipped() && (token.getGrammarElement() instanceof AbstractElement)) {
				result = token.isOptional();
			}
		}

		@Override
		public void visitMarker(Marker marker) {
			throw new IllegalStateException("Marker may not be content of other markers.");
		}

		private final class Skipper extends AbstractParsedTokenVisitor implements IMarkerVisitor {
			private boolean continueSkip;
			private int stackSize;
			private boolean first;

			private Skipper() {
				this.continueSkip = true;
				this.stackSize = 0;
			}

			public int skip(final int idx) {
				int i = idx;
				first = true;
				while(!visitedMarkers.isEmpty() && continueSkip) {
					Marker localMarker = visitedMarkers.get(visitedMarkers.size() - 1);
					List<AbstractParsedToken> content = localMarker.getContent();
					while(i < content.size() && continueSkip) {
						content.get(i).accept(this);
						first = false;
						if (continueSkip)
							i++;
					}
					if (continueSkip)
						visitedMarkers.remove(visitedMarkers.size() - 1);
				}
				return i;
			}

			@Override
			public void visitAbstractParsedToken(AbstractParsedToken token) {
				//
			}

			@Override
			public void visitCompoundParsedToken(CompoundParsedToken token) {
				if (!token.isSkipped()) {
					markedTokens.add(token);
					token.setSkipped(true);
					stackSize++;
				}
			}

			@Override
			public void visitAlternativesToken(AlternativesToken token) {
				if (!token.isSkipped()) {
					if (first && token.canParseFurther())
						continueSkip = false;
					else
						super.visitAlternativesToken(token);
				}
			}
			
			@Override
			public void visitUnorderedGroupToken(UnorderedGroupToken token) {
				if (!token.isSkipped()) {
					if (first && token.canParseFurther())
						continueSkip = false;
					else
						super.visitUnorderedGroupToken(token);
				}
			}

			@Override
			public void visitCompoundParsedTokenEnd(CompoundParsedToken.End token) {
				if (!token.isSkipped()) {
					markedTokens.add(token);
					token.setSkipped(true);
					stackSize--;
					continueSkip = stackSize != 0;
				}
			}

			@Override
			public void visitParsedTerminal(ParsedTerminal token) {
				if (!token.isSkipped()) {
					markedTokens.add(token);
					token.setSkipped(true);
					continueSkip = stackSize != 0;
				}
			}

			@Override
			public void visitParsedNonTerminal(ParsedNonTerminal token) {
				if (!token.isSkipped()) {
					markedTokens.add(token);
					token.setSkipped(true);
					stackSize++;
				}
			}

			@Override
			public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
				if (!token.isSkipped()) {
					markedTokens.add(token);
					token.setSkipped(true);
					stackSize--;
					continueSkip = stackSize != 0;
				}
			}

			@Override
			public void visitErrorToken(ErrorToken token) {
				if (!token.isSkipped()) {
					markedTokens.add(token);
					token.setSkipped(true);
				}
			}

			@Override
			public void visitMarker(Marker marker) {
				throw new IllegalStateException("Marker may not be content of other markers.");
			}
		}

		private final class Replayer extends AbstractParsedTokenVisitor implements IMarkerVisitor {

			private boolean first;

			private int idx;

			private int stackSize;

			private ParsedToken replayToken;

			private List<AbstractParsedToken> contents;

			private Marker workingMarker;

			private Replayer() {
				this.stackSize = 0;
			}

			@SuppressWarnings("unchecked")
			public boolean replay(int idx) {
				this.idx = idx;
				this.first = true;
				final Marker markerToFork = visitedMarkers.get(visitedMarkers.size() - 1);
				workingMarker = markerToFork.forkAfterSkipped(idx);
				workingMarkers.add(workingMarker);
				int offset = workingMarker.getOffset();
				for (int i = 0; i < workingMarker.getContent().size(); i++) {
					AbstractParsedToken token = workingMarker.getContent().get(i);
					if (!token.isSkipped())
						offset+=token.getLength();
				}
				workingMarker.getInput().setOffset(offset);

				boolean replaySuccessful = true;
				while(!visitedMarkers.isEmpty() && replaySuccessful) {
					contents = visitedMarkers.get(visitedMarkers.size() - 1).getContent();
					while(replaySuccessful && replay()) {
						if (replayToken != null) {
							Marker localMarker = (Marker) workingMarker.getClient().mark();
							try {
								if (first && (replayToken instanceof IFurtherParsable<?>)) {
									IFurtherParsable<ParsedToken> continuedParsable = (IFurtherParsable<ParsedToken>) replayToken;
									replaySuccessful = continuedParsable.getSource().parseFurther(continuedParsable) == ConsumeResult.SUCCESS;
								} else {
									replaySuccessful = replayToken.getSource().parseAgain(replayToken) == ConsumeResult.SUCCESS;
								}
								first = false;
							} catch(Exception e) {
								throw new WrappedException(e);
							}
							if (replaySuccessful)
								localMarker.commit();
							else
								localMarker.rollback();
							localMarker = null;
						}
					}
					if (replaySuccessful) {
						visitedMarkers.remove(visitedMarkers.size() - 1);
						if (!visitedMarkers.isEmpty()) {
							workingMarker = (Marker) workingMarker.getClient().mark();
							workingMarkers.add(workingMarker);
							this.idx = 0;
						}
					}
				}
				return replaySuccessful;
			}

			public boolean replay() {
				if (idx >= contents.size())
					return false;
				next();
				return replayToken != null;
			}

			private void next() {
				replayToken = null;
				while(idx < contents.size() && (replayToken == null || stackSize != 0)) {
					contents.get(idx).accept(this);
					idx++;
				}
			}

			@Override
			public void visitCompoundParsedToken(CompoundParsedToken token) {
				if (!token.isSkipped()) {
					if (stackSize == 0)
						replayToken = token;
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
			public void visitUnorderedGroupTokenEnd(UnorderedGroupToken.End token) {
				if (!token.isSkipped()) {
					if (stackSize == 0)
						workingMarker.accept(new UnorderedGroupToken.End(workingMarker.getInput().getOffset()));
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
						replayToken = token;
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
				if (!token.isSkipped() && replayToken == null)
					replayToken = token;
			}

			@Override
			public void visitMarker(Marker marker) {
				throw new IllegalStateException("Marker may not be content of other markers.");
			}

		}
	}

	@Override
	public IBacktrackingResult skipPreviousToken() {
		return new NestedBacktrackingResult().skipPreviousToken();
	}

}
