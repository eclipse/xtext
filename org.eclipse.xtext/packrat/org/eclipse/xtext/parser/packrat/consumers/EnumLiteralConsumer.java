/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenSource;
import org.eclipse.xtext.parser.packrat.tokens.ParsedEnumLiteral;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EnumLiteralConsumer extends TerminalConsumer {

	private EnumLiteralDeclaration literal;

	private ICharacterClass notFollowedBy;

	public EnumLiteralConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
		setHidden(false);
	}

	public void configure(EnumLiteralDeclaration literal, ICharacterClass notFollowedBy) {
		this.literal = literal;
		this.notFollowedBy = notFollowedBy != null ? notFollowedBy : ICharacterClass.Factory.nullClass();
	}

	@Override
	protected int doConsume() {
		if (readString(literal.getLiteral().getValue()))
			return !peekChar(notFollowedBy) ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
		return ConsumeResult.EMPTY_MATCH;
	}

	@Override
	protected AbstractParsedToken createParsedToken(String feature, boolean isMany, boolean isBoolean,
			AbstractElement element, ISequenceMatcher notMatching, boolean optional, int prevMarker, IParsedTokenSource source) {
		return new ParsedEnumLiteral(prevMarker, getInput().getOffset()-prevMarker, literal, source, false);
	}

	@Override
	public EObject getGrammarElement() {
		return literal;
	}

	@Override
	protected String getRuleName() {
		return literal.getEnumLiteral().getName();
	}
}