/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr

import org.eclipse.xtext.Grammar

import static extension org.eclipse.xtext.GrammarUtil.*
import org.eclipse.xtext.xtext.generator.model.TypeReference

class ExtendedGrammarNaming extends GrammarNaming {

	override getParserGrammar(Grammar it) {
		new AntlrGrammar(internalParserPackage, '''Internal«simpleName»Parser''')
	}

	override getLexerGrammar(Grammar it) {
		new AntlrGrammar(internalParserPackage, '''Internal«simpleName»Lexer''')
	}
	
	override TypeReference getLexerClass(Grammar it) {
		new TypeReference(lexerGrammar.packageName, lexerGrammar.simpleName)
	}

	override TypeReference getParserClass(Grammar it) {
		new TypeReference(parserGrammar.packageName, parserGrammar.simpleName)
	}

}