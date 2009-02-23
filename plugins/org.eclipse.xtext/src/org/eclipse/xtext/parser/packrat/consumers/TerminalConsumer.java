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
		super(configuration.getInput(), configuration.getTokenAcceptor());
	}

	public final int consume(String feature, boolean isMany, boolean isBoolean, AbstractElement element, ISequenceMatcher notMatching) {
		int prevMarker = mark();
		final int result = doConsume();
		if (result == ConsumeResult.SUCCESS && notMatching.matches(getInput(), prevMarker, getInput().getOffset()- prevMarker)) {
			getInput().setOffset(prevMarker);
			return ConsumeResult.EMPTY_MATCH;
		}
		if (result == ConsumeResult.SUCCESS) {
			if (feature != null) {
				if (element instanceof CrossReference)
					getTokenAcceptor().accept(new ParsedTerminalWithFeatureInfo(prevMarker, getInput().getOffset()-prevMarker,
							element, isHidden(), feature));
				else
					getTokenAcceptor().accept(new ParsedTerminalWithFeature(prevMarker, getInput().getOffset()-prevMarker,
							element != null ? element : getGrammarElement(), isHidden(), feature, isMany, isBoolean, getRuleName()));
			} else
				getTokenAcceptor().accept(new ParsedTerminal(prevMarker, getInput().getOffset()-prevMarker, element != null ? element : getGrammarElement(), isHidden()));
		} else {
			getInput().setOffset(prevMarker);
		}
		return result;
	}

	public final int consume() {
		int prevOffset = getInput().getOffset();
		final int result = doConsume();
		if (result != ConsumeResult.SUCCESS) {
			getInput().setOffset(prevOffset);
		}
		return result;
	}

	public final int consume(ISequenceMatcher notMatching) {
		int prevOffset = getInput().getOffset();
		final int result = doConsume();
		if (result == ConsumeResult.SUCCESS && notMatching.matches(getInput(), prevOffset, getInput().getOffset() - prevOffset)) {
			getInput().setOffset(prevOffset);
			return ConsumeResult.EMPTY_MATCH;
		}
		if (result != ConsumeResult.SUCCESS) {
			getInput().setOffset(prevOffset);
		}
		return result;
	}

	protected void incOffset() {
		getInput().incOffset();
	}

	protected boolean readAnyChar(char... candidates) {
		if (eof()) return false;
		char c = getInput().charAt(getInput().getOffset());
		if (candidates.length == 0) {
			getInput().incOffset();
			return true;
		}
		for (char candidate: candidates) {
			if (c == candidate) {
				getInput().incOffset();
				return true;
			}
		}
		return false;
	}

	protected boolean readChar(char candidate) {
		if (eof()) return false;
		if (getInput().charAt(getInput().getOffset()) == candidate) {
			getInput().incOffset();
			return true;
		}
		return false;
	}

	protected boolean readChar(ICharacterClass characterClass) {
		if (eof()) return false;
		if (characterClass.matches(getInput().charAt(getInput().getOffset()))) {
			getInput().incOffset();
			return true;
		}
		return false;
	}

	protected char getChar() {
		return getInput().charAt(getInput().getOffset());
	}

	protected boolean peekChar(ICharacterClass characterClass) {
		if (eof()) return false;
		return characterClass.matches(getInput().charAt(getInput().getOffset()));
	}

	protected boolean readCharBetween(char min, char max) {
		if (eof()) return false;
		char c = getInput().charAt(getInput().getOffset());
		if (c >= min && c <= max) {
			getInput().incOffset();
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
		if (getInput().getOffset() + seq.length() - 1 >= getInput().length()) return false;
		final int offset = getInput().getOffset();
		for (int i = 0; i < seq.length(); i++) {
			if (getInput().charAt(offset + i) != seq.charAt(i))
				return false;
		}
		getInput().incOffset(seq.length());
		return true;
	}

	protected boolean readUntil(CharSequence seq) {
		char first = seq.charAt(0);
		OUTER: for(int i = getInput().getOffset(); i <= getInput().length() - seq.length(); i++) {
			if (getInput().charAt(i) == first) {
				for(int j = 1; j < seq.length(); j++) {
					if (getInput().charAt(i + j) != seq.charAt(j))
						continue OUTER;
				}
				getInput().setOffset(i + seq.length());
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
		return getInput().getOffset() >= getInput().length();
	}

	protected int mark() {
		return getInput().getOffset();
	}

	protected void rollbackTo(int marker) {
		getInput().setOffset(marker);
	}

	@Override
	public String toString() {
		String result = this.getClass().getSimpleName();
		return "TerminalConsumer " + (Strings.isEmpty(result) ? this.getClass().getName() : result) + " for rule '" + getRuleName() + "'";
	}

}