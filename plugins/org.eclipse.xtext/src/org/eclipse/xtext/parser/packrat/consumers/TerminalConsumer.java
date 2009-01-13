/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IParserConfiguration;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminal;
import org.eclipse.xtext.util.Strings;

public abstract class TerminalConsumer implements ITerminalConsumer {
	
	private final ICharSequenceWithOffset input;
	
	private final IMarkerFactory markerFactory;
	
	private final IParsedTokenAcceptor acceptor;

	private boolean hidden;
	
	protected TerminalConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory, IParsedTokenAcceptor tokenAcceptor) {
		this.input = input;
		this.markerFactory = markerFactory;
		this.acceptor = tokenAcceptor;
	}

	public final boolean consume(String feature, boolean isMany, boolean isBoolean, AbstractElement element, ISequenceMatcher notMatching) {
		int prevOffset = input.getOffset();
		boolean result = doConsume();
		if (notMatching.matches(input, prevOffset, input.getOffset()- prevOffset))
			return false;
		if (result) {
			acceptor.accept(new ParsedTerminal(input, prevOffset, input.getOffset()-prevOffset, 
					element != null ? element : getGrammarElement(), feature, isHidden(), isMany, isBoolean, getLexerRuleName()));
		}
		return result;
	}
	
	public final boolean consume(ISequenceMatcher notMatching) {
		int prevOffset = input.getOffset();
		boolean result = doConsume();
		if (!result) {
			input.setOffset(prevOffset);
		}
		return result;
	}
	
	protected boolean readAnyChar(char... candidates) {
		if (eof()) return false;
		char c = input.charAt(input.getOffset());
		if (candidates.length == 0) {
			input.incOffset();
			return true;
		}
		for (char candidate: candidates) {
			if (c == candidate) {
				input.incOffset();
				return true;
			}
		}
		return false;
	}
	
	protected boolean readChar(char candidate) {
		if (eof()) return false;
		if (input.charAt(input.getOffset()) == candidate) {
			input.incOffset();
			return true;
		}
		return false;
	}
	
	protected boolean readChar(ICharacterClass characterClass) {
		if (eof()) return false;
		if (characterClass.matches(input.charAt(input.getOffset()))) {
			input.incOffset();
			return true;
		}
		return false;
	}
	
	protected boolean peekChar(ICharacterClass characterClass) {
		if (eof()) return false;
		return characterClass.matches(input.charAt(input.getOffset()));
	}
	
	protected boolean readCharBetween(char min, char max) {
		if (eof()) return false;
		char c = input.charAt(input.getOffset());
		if (c >= min && c <= max) {
			input.incOffset();
			return true;
		}
		return false;
	}
	
	protected boolean readAnyChars(char... candidates) {
		while(readAnyChar(candidates));
		return true;
	}
	
	protected boolean readChars(char candidate) {
		while(readChar(candidate));
		return true;
	}
	
	protected boolean readChars(ICharacterClass characterClass) {
		while(readChar(characterClass));
		return true;
	}
	
	protected boolean readCharsBetween(char min, char max) {
		while(readCharBetween(min, max));
		return true;
	}
	
	protected boolean readString(CharSequence seq) {
		if (input.getOffset() + seq.length() - 1 >= input.length()) return false;
		if (input.subSequence(input.getOffset(), input.getOffset() + seq.length()).equals(seq)) {
			input.incOffset(seq.length());
			return true;
		}
		return false;
	}
	
	protected boolean readUntil(CharSequence seq) {
		char first = seq.charAt(0);
		for(int i = input.getOffset(); i <= input.length() - seq.length(); i++) {
			char next = input.charAt(i);
			if (next == first && input.subSequence(i, i + seq.length()).equals(seq)) {
				input.setOffset(i + seq.length());
				return true;
			}
		}
		return false;
	}
	
	protected abstract boolean doConsume();
	
	public abstract EObject getGrammarElement();
	
	protected abstract String getLexerRuleName();
	
	@Override
	public String toString() {
		String result = this.getClass().getSimpleName(); 
		return Strings.isEmpty(result) ? this.getClass().getName() : result;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isHidden() {
		return hidden;
	}
	
	protected boolean eof() {
		return input.getOffset() >= input.length();
	}

	protected IMarker mark() {
		return markerFactory.mark();
	}
	
	// TODO temporary HACK so AbstractREALConsumer can do whatever it wants to ...
	public void initFields(IParserConfiguration configuration) {
		// nothing to do
	}

}