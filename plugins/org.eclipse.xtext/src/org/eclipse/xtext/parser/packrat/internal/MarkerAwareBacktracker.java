/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.internal;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.parser.packrat.IBacktracker;
import org.eclipse.xtext.parser.packrat.internal.Marker.IMarkerVisitor;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.tokens.CompoundParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminal;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class MarkerAwareBacktracker extends AbstractParsedTokenVisitor implements IBacktracker, IMarkerVisitor {

	/**
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	private final static class Skipper extends AbstractParsedTokenVisitor {
		private boolean continueSkip;
		private int skippedOffset;
		private int stackSize;

		private Skipper() {
			this.continueSkip = true;
			this.skippedOffset = 0;
		}

		@Override
		public void visitAbstractParsedToken(AbstractParsedToken token) {
			//
		}

		@Override
		public void visitCompoundParsedToken(CompoundParsedToken token) {
			if (!token.isSkipped()) {
				token.setSkipped(true);
				stackSize++;
			}
		}

		@Override
		public void visitCompoundParsedTokenEnd(CompoundParsedToken.End token) {
			if (!token.isSkipped()) {
				token.setSkipped(true);
				stackSize--;
				continueSkip = stackSize != 0;
			}
		}

		@Override
		public void visitParsedTerminal(ParsedTerminal token) {
			if (!token.isSkipped()) {
				token.setSkipped(true);
				skippedOffset += token.getLength();
				continueSkip = stackSize != 0;
			}
		}

		@Override
		public void visitParsedNonTerminal(ParsedNonTerminal token) {
			if (!token.isSkipped()) {
				token.setSkipped(true);
				stackSize++;
			}
		}

		@Override
		public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
			if (!token.isSkipped()) {
				token.setSkipped(true);
				stackSize--;
				continueSkip = stackSize != 0;
			}
		}


	}

	private final Marker marker;

	private boolean result;

	private boolean lookup;

	private final List<Marker> handledMarkers;

	private int stackSize;

	public MarkerAwareBacktracker(Marker marker) {
		this.marker = marker;
		this.result = false;
		this.handledMarkers = new ArrayList<Marker>(4);
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
				if (GrammarUtil.isOptionalCardinality(token.getGrammarElement())) {
					result = true;
				}
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
				EObject grammarElement = token.getGrammarElement();
				if (grammarElement instanceof AbstractElement) {
					if (GrammarUtil.isOptionalCardinality((AbstractElement) grammarElement)) {
						result = true;
					}
				} else {
					lookup = false;
				}
			}
		}
	}

	@Override
	public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
		if (lookup && !token.isSkipped())
			stackSize++;
	}

	@Override
	public void visitCompoundParsedTokenEnd(org.eclipse.xtext.parser.packrat.tokens.CompoundParsedToken.End token) {
		if (lookup && !token.isSkipped())
			stackSize++;
	}

	@Override
	public void visitParsedTerminal(ParsedTerminal token) {
		if (lookup && !token.isHidden() && !token.isSkipped() && (token.getGrammarElement() instanceof AbstractElement)) {
			if (GrammarUtil.isOptionalCardinality((AbstractElement) token.getGrammarElement())) {
				result = true;
				lookup = false;
			}
		}
	}

	public boolean skipPreviousToken() {
		result = false;
		lookup = true;
		handledMarkers.clear();
		stackSize = 0;
		Marker localMarker = this.marker;
		List<AbstractParsedToken> content = null;
		int idx = -1;
		while(localMarker != null && !result && lookup) {
			handledMarkers.add(localMarker);
			content = localMarker.getContent();
			idx = content.size() - 1;
			while(idx >= 0 && !result && lookup) {
				content.get(idx).accept(this);
				if (!result)
					idx--;
			}
			if (!result)
				localMarker = localMarker.getParent();
		}
		if (result) {
			Skipper skipper = new Skipper();
			while(!handledMarkers.isEmpty() && skipper.continueSkip) {
				Marker m = handledMarkers.remove(handledMarkers.size()-1);
				content = m.getContent();
				for (int i = idx; i < content.size() && skipper.continueSkip; i++)
					content.get(i).accept(skipper);
				if (skipper.continueSkip)
					idx = 0;
			}
			this.marker.getInput().setOffset(this.marker.getInput().getOffset() - skipper.skippedOffset);
		}
		handledMarkers.clear();
		return result;
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

}
