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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class KeywordConsumer extends TerminalConsumer {

	private Keyword keyword;

	private ICharacterClass notFollowedBy;
	
	public KeywordConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
		setHidden(false);
	}

	public void configure(Keyword keyword, ICharacterClass notFollowedBy) {
		this.keyword = keyword;
		this.notFollowedBy = notFollowedBy != null ? notFollowedBy : ICharacterClass.Factory.nullClass();
	}
	
	@Override
	protected int doConsume() {
		if (readString(keyword.getValue()))
			return !peekChar(notFollowedBy) ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
		return ConsumeResult.EMPTY_MATCH;
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