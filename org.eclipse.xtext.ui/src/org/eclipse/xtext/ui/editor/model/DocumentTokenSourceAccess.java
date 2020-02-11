/*******************************************************************************
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.model;

import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * Provides access to the tokens of an IDocument.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.19
 */
public class DocumentTokenSourceAccess {

	@Inject
	private Provider<DocumentTokenSource> tokenSourceProvider;
	
	public IRegion getLastDamage(IDocument document) {
		if (document instanceof XtextDocument) {
			return ((XtextDocument) document).getLastDamage();
		}
		return new Region(0, document.getLength());
	}
	
	public Iterable<ILexerTokenRegion> getTokens(IDocument document, boolean nullIfNotCached) {
		if (document instanceof XtextDocument) {
			return ((XtextDocument) document).getTokens();
		}
		if (nullIfNotCached) {
			return null;
		}
		DocumentTokenSource tokenSource = tokenSourceProvider.get();
		tokenSource.computeDamageRegion(new DocumentEvent(document, 0, document.getLength(), document.get()));
		return tokenSource.getTokenInfos();
	}
	
}
