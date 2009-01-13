/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class KeywordConsumer extends TerminalConsumer {

	private Keyword keyword;
	
	public KeywordConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
		setHidden(false);
	}

	public void setKeyword(Keyword keyword) {
		this.keyword = keyword;
	}
	
	@Override
	protected boolean doConsume() {
		return readString(keyword.getValue());
	}

	@Override
	public EObject getGrammarElement() {
		return keyword;
	}

	@Override
	protected String getLexerRuleName() {
		return keyword.getValue();
	}
}