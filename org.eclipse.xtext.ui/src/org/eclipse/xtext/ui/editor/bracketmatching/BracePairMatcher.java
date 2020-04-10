/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.bracketmatching;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.xbase.lib.Conversions;

import com.google.inject.Inject;

/**
 * @author kosyakov - Initial contribution and API
 * 
 * @since 2.8
 */
public class BracePairMatcher implements ICharacterPairMatcher {

	private DefaultCharacterPairMatcher characterPairMatcher;

	@Inject
	public void setBracePairProvider(IBracePairProvider bracePairProvider) {
		List<Character> chars = getChars(bracePairProvider);
		characterPairMatcher = new DefaultCharacterPairMatcher(((char[])Conversions.unwrapArray(chars, char.class)));
	}

	protected List<Character> getChars(IBracePairProvider bracePairProvider) {
		List<Character> chars = new ArrayList<>();
		for (BracePair pair : bracePairProvider.getPairs()) {
			if (pair.getLeftBrace().length() == 1 && pair.getRightBrace().length() == 1) {
				chars.add(pair.getLeftBrace().charAt(0));
				chars.add(pair.getRightBrace().charAt(0));
			} else {
				throw new IllegalStateException(
						"Brace pair is invalid: " + pair + "; left and right braces should have length of one character.");
			}
		}
		return chars;
	}

	@Override
	public void dispose() {
		characterPairMatcher.dispose();
	}

	@Override
	public void clear() {
		characterPairMatcher.clear();
	}

	@Override
	public IRegion match(IDocument document, int offset) {
		return characterPairMatcher.match(document, offset);
	}

	@Override
	public int getAnchor() {
		return characterPairMatcher.getAnchor();
	}

}
