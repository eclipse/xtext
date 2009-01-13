/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.tokens;

import org.eclipse.xtext.parser.packrat.IParsedTokenVisitor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractParsedTokenVisitor implements IParsedTokenVisitor {

	public void visitAbstractParsedToken(AbstractParsedToken token) {
		throw new UnsupportedOperationException("visitAbstractParsedToken is not implemented.");
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
		visitAbstractParsedToken(token);
	}

	public void visitParsedTerminal(ParsedTerminal token) {
		visitParsedToken(token);
	}

	public void visitParsedToken(ParsedToken token) {
		visitAbstractParsedToken(token);
	}

	public void visitParsedAction(ParsedAction token) {
		visitAbstractParsedToken(token);
	}
	
	public void exec(AbstractParsedToken param) {
		param.accept(this);		
	}

}
