/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.tokens.CompoundParsedToken.End;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParsedTokenVisitor implements IParsedTokenVisitor {

	public void visitAbstractParsedToken(AbstractParsedToken token) {
		throw new UnsupportedOperationException("visitAbstractParsedToken is not implemented.");
	}

	public void visitAbstractParsedTokenEnd(AbstractParsedToken.End token) {
		visitAbstractParsedToken(token);
	}

	public void visitCompoundParsedToken(CompoundParsedToken token) {
		visitParsedToken(token);
	}

	public void visitCompoundParsedTokenEnd(End token) {
		visitAbstractParsedTokenEnd(token);
	}

	public void visitAssignmentToken(AssignmentToken token) {
		visitCompoundParsedToken(token);
	}

	public void visitAssignmentTokenEnd(AssignmentToken.End token) {
		visitCompoundParsedTokenEnd(token);
	}

	public void visitAlternativesToken(AlternativesToken token) {
		visitCompoundParsedToken(token);
	}

	public void visitAlternativesTokenEnd(AlternativesToken.End token) {
		visitCompoundParsedTokenEnd(token);
	}

	public void visitGroupToken(GroupToken token) {
		visitCompoundParsedToken(token);
	}

	public void visitGroupTokenEnd(GroupToken.End token) {
		visitCompoundParsedTokenEnd(token);
	}

	public void visitErrorToken(ErrorToken token) {
		visitParsedToken(token);
	}

	public void visitFakedToken(FakedToken token) {
		visitAbstractParsedToken(token);
	}

	public void visitParsedNonTerminal(ParsedNonTerminal token) {
		visitParsedToken(token);
	}

	public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
		visitAbstractParsedTokenEnd(token);
	}

	public void visitParsedTerminal(ParsedTerminal token) {
		visitParsedToken(token);
	}

	public void visitParsedTerminalWithFeatureInfo(ParsedTerminalWithFeatureInfo token) {
		visitParsedTerminal(token);
	}

	public void visitParsedTerminalWithFeature(ParsedTerminalWithFeature token) {
		visitParsedTerminalWithFeatureInfo(token);
	}

	public void visitParsedToken(ParsedToken token) {
		visitAbstractParsedToken(token);
	}

	public void visitParsedAction(ParsedAction token) {
		visitParsedToken(token);
	}

	public void visitPlaceholder(PlaceholderToken token) {
		visitParsedToken(token);
	}

	public Void apply(AbstractParsedToken param) {
		param.accept(this);
		return null;
	}

	public void visitParsedEnumLiteral(ParsedEnumLiteral token) {
		visitParsedToken(token);
	}
}
