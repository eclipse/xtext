/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat;

import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.ErrorToken;
import org.eclipse.xtext.parser.packrat.tokens.FakedToken;
import org.eclipse.xtext.parser.packrat.tokens.ParsedAction;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;
import org.eclipse.xtext.parser.packrat.tokens.ParsedTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedToken;
import org.eclipse.xtext.util.Function;

/**
 * Interface for ParsedTokenVisitor. 
 * It is not intended to be implemented by clients. Use AbstractParsedTokenVisitor instead. 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IParsedTokenVisitor extends Function.WithoutResult<AbstractParsedToken> {

	void visitAbstractParsedToken(AbstractParsedToken token);

	void visitErrorToken(ErrorToken token);

	void visitParsedToken(ParsedToken token);

	void visitParsedTerminal(ParsedTerminal token);

	void visitParsedNonTerminal(ParsedNonTerminal token);

	void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token);

	void visitFakedToken(FakedToken fakedToken);

	void visitParsedAction(ParsedAction parsedAction);

}
