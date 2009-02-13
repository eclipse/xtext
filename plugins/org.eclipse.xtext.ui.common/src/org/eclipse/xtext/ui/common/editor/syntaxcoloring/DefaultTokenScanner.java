/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.syntaxcoloring;

import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.Token;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultTokenScanner extends AbstractTokenScanner {

	@Inject
	public DefaultTokenScanner(final @Named("languageName") String languageName,
			final Provider<SyntaxColoringPreferencePage> preferencePageProvider,
			final PreferenceStoreAccessor accessor) {
		super(languageName, preferencePageProvider, accessor);
	}

	private int length;
	private boolean tokenReturned;

	public int getTokenLength() {
		return length;
	}

	public int getTokenOffset() {
		return 0;
	}

	public IToken nextToken() {
		if (!tokenReturned) {
			tokenReturned = true;
			return new Token(createTextAttribute(BuiltinTokenStyles.DEFAULT));
		}
		return Token.EOF;
	}

	public void setRange(IDocument document, int offset, int length) {
		this.length = length;
		this.tokenReturned = false;
	}

}
