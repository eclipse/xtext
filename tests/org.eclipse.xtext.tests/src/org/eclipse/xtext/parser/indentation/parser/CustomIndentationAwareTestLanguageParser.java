/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.indentation.parser;

import org.antlr.runtime.CharStream;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.parser.indentation.parser.antlr.IndentationAwareTestLanguageParser;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class CustomIndentationAwareTestLanguageParser extends IndentationAwareTestLanguageParser {

	@Override
	protected TokenSource createLexer(CharStream stream) {
		return new IndentationAwareTestLanguageTokenSource(super.createLexer(stream));
	}
	
}
