/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.debug;

import org.apache.log4j.Logger;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedToken;
import org.eclipse.xtext.parser.packrat.tokens.AbstractParsedTokenVisitor;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminal;
import org.eclipse.xtext.parser.packrat.tokens.ParsedNonTerminalEnd;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ParsedTokenPrinter extends AbstractParsedTokenVisitor {

	private static Logger logger = Logger.getLogger(ParsedTokenPrinter.class);
	
	private String indent;
	
	public ParsedTokenPrinter() {
		this.indent = "";
	}
	
	@Override
	public void visitAbstractParsedToken(AbstractParsedToken token) {
		logger.info(indent + token);
	}

	@Override
	public void visitParsedNonTerminal(ParsedNonTerminal token) {
		super.visitParsedNonTerminal(token);
		indent += "   ";
	}

	@Override
	public void visitParsedNonTerminalEnd(ParsedNonTerminalEnd token) {
		indent = indent.substring(0, indent.length() - 3);
		super.visitParsedNonTerminalEnd(token);
	}
	
}
