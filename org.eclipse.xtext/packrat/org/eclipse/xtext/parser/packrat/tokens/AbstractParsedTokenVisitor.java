/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.tokens.CompoundParsedToken.End;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParsedTokenVisitor implements IParsedTokenVisitor {

	@Override
	public void visitAbstractParsedToken(AbstractParsedToken token) {
		throw new UnsupportedOperationException("visitAbstractParsedToken is not implemented.");
	}

	@Override
	public void visitAbstractParsedTokenEnd(AbstractParsedToken.End token) {
		visitAbstractParsedToken(token);
	}

	@Override
	public void visitCompoundParsedToken(CompoundParsedToken token) {
		visitParsedToken(token);
	}

	@Override
	public void visitCompoundParsedTokenEnd(End token) {
		visitAbstractParsedTokenEnd(token);
	}

	@Override
	public void visitAssignmentToken(AssignmentToken token) {
		visitCompoundParsedToken(token);
	}

	@Override
	public void visitAssignmentTokenEnd(AssignmentToken.End token) {
		visitCompoundParsedTokenEnd(token);
	}

	@Override
	public void visitAlternativesToken(AlternativesToken token) {
		visitCompoundParsedToken(token);
	}

	@Override
	public void visitAlternativesTokenEnd(AlternativesToken.End token) {
		visitCompoundParsedTokenEnd(token);
	}

	@Override
	public void visitGroupToken(GroupToken token) {
		visitCompoundParsedToken(token);
	}

	@Override
	public void visitGroupTokenEnd(GroupToken.End token) {
		visitCompoundParsedTokenEnd(token);
	}
	
	@Override
	public void visitUnorderedGroupToken(UnorderedGroupToken token) {
		visitCompoundParsedToken(token);
	}

	@Override
	public void visitUnorderedGroupTokenEnd(UnorderedGroupToken.End token) {
		visitCompoundParsedTokenEnd(token);
	}

	@Override
	public void visitErrorToken(ErrorToken token) {
		visitParsedToken(token);
	}

	@Override
	public void visitFakedToken(FakedToken token) {
		visitAbstractParsedToken(token);
	}

	@Override
	public void visitParsedNonTerminal(ParsedNonTerminal token) {
		visitParsedToken(token);
	}

	@Override
	public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
		visitAbstractParsedTokenEnd(token);
	}

	@Override
	public void visitParsedTerminal(ParsedTerminal token) {
		visitParsedToken(token);
	}

	@Override
	public void visitParsedTerminalWithFeatureInfo(ParsedTerminalWithFeatureInfo token) {
		visitParsedTerminal(token);
	}

	@Override
	public void visitParsedTerminalWithFeature(ParsedTerminalWithFeature token) {
		visitParsedTerminalWithFeatureInfo(token);
	}

	@Override
	public void visitParsedToken(ParsedToken token) {
		visitAbstractParsedToken(token);
	}

	@Override
	public void visitParsedAction(ParsedAction token) {
		visitParsedToken(token);
	}

	@Override
	public void visitPlaceholder(PlaceholderToken token) {
		visitParsedToken(token);
	}

	@Override
	public Void apply(AbstractParsedToken param) {
		param.accept(this);
		return null;
	}

	@Override
	public void visitParsedEnumLiteral(ParsedEnumLiteral token) {
		visitParsedToken(token);
	}
}
