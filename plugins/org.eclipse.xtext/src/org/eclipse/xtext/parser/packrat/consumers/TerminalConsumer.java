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
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminalWithFeature;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminalWithFeatureInfo;
import org.eclipse.xtext.util.Strings;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class TerminalConsumer extends AbstractConsumer implements ITerminalConsumer {
	
	private boolean hidden;
	
	protected TerminalConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration.getInput(), configuration.getTokenAcceptor(), configuration.getRecoveryStateHolder());
	}

	public final int consume(String feature, boolean isMany, boolean isBoolean, AbstractElement element, ISequenceMatcher notMatching) {
		int prevMarker = mark();
		final int result = doConsume();
		if (result == ConsumeResult.SUCCESS && notMatching.matches(input, prevMarker, input.getOffset()- prevMarker)) {
			input.setOffset(prevMarker);
			return ConsumeResult.EMPTY_MATCH;
		}
		if (result == ConsumeResult.SUCCESS) {
			if (feature != null) {
				if (element instanceof CrossReference)
					acceptor.accept(new ParsedTerminalWithFeatureInfo(prevMarker, input.getOffset()-prevMarker, 
							element, isHidden(), feature));
				else
					acceptor.accept(new ParsedTerminalWithFeature(prevMarker, input.getOffset()-prevMarker, 
							element != null ? element : getGrammarElement(), isHidden(), feature, isMany, isBoolean, getRuleName()));
			} else
				acceptor.accept(new ParsedTerminal(prevMarker, input.getOffset()-prevMarker, element != null ? element : getGrammarElement(), isHidden()));
		} else {
			input.setOffset(prevMarker);
		}
		return result;
	}
	
	public final int consume() {
		int prevOffset = input.getOffset();
		final int result = doConsume();
		if (result != ConsumeResult.SUCCESS) {
			input.setOffset(prevOffset);
		}
		return result;
	}
	
	public final int consume(ISequenceMatcher notMatching) {
		int prevOffset = input.getOffset();
		final int result = doConsume();
		if (result == ConsumeResult.SUCCESS && notMatching.matches(input, prevOffset, input.getOffset() - prevOffset)) {
			input.setOffset(prevOffset);
			return ConsumeResult.EMPTY_MATCH;
		}
		if (result != ConsumeResult.SUCCESS) {
			input.setOffset(prevOffset);
		} 
		return result;
	}
	
	protected void incOffset() {
		input.incOffset();
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
	
	protected char getChar() {
		return input.charAt(input.getOffset());
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
		while(readAnyChar(candidates)) {
		}
		return true;
	}
	
	protected boolean readChars(char candidate) {
		while(readChar(candidate)) {
		}
		return true;
	}
	
	protected boolean readChars(ICharacterClass characterClass) {
		while(readChar(characterClass)) {
		}
		return true;
	}
	
	protected boolean readCharsBetween(char min, char max) {
		while(readCharBetween(min, max)) {
		}
		return true;
	}
	
	protected boolean readString(CharSequence seq) {
		if (input.getOffset() + seq.length() - 1 >= input.length()) return false;
		final int offset = input.getOffset();
		for (int i = 0; i < seq.length(); i++) {
			if (input.charAt(offset + i) != seq.charAt(i))
				return false;
		}
		input.incOffset(seq.length());
		return true;
	}
	
	protected boolean readUntil(CharSequence seq) {
		char first = seq.charAt(0);
		OUTER: for(int i = input.getOffset(); i <= input.length() - seq.length(); i++) {
			if (input.charAt(i) == first) {
				for(int j = 1; j < seq.length(); j++) {
					if (input.charAt(i + j) != seq.charAt(j))
						continue OUTER;
				}
				input.setOffset(i + seq.length());
				return true;
			}
		}
		return false;
	}
	
	protected abstract int doConsume();
	
	public abstract EObject getGrammarElement();
	
	protected abstract String getRuleName();
	
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	public boolean isHidden() {
		return hidden;
	}
	
	protected boolean eof() {
		return input.getOffset() >= input.length();
	}

	protected int mark() {
		return input.getOffset();
	}

	protected void rollbackTo(int marker) {
		input.setOffset(marker);
	}
	
	@Override
	public String toString() {
		String result = this.getClass().getSimpleName(); 
		return "TerminalConsumer " + (Strings.isEmpty(result) ? this.getClass().getName() : result) + " for rule '" + getRuleName() + "'";
	}

}