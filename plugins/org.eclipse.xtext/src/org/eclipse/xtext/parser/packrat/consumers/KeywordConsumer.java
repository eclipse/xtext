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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class KeywordConsumer extends TerminalConsumer {

	private Keyword keyword;

	private ICharacterClass notFollowedBy;
	
	public KeywordConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
		setHidden(false);
	}

	public void configure(Keyword keyword, ICharacterClass notFollowedBy) {
		this.keyword = keyword;
		this.notFollowedBy = notFollowedBy != null ? notFollowedBy : ICharacterClass.Factory.nullClass();
	}
	
	@Override
	protected boolean doConsume() {
		if (readString(keyword.getValue()))
			return !peekChar(notFollowedBy);
		return false;
	}

	@Override
	public EObject getGrammarElement() {
		return keyword;
	}

	@Override
	protected String getRuleName() {
		return keyword.getValue();
	}
}