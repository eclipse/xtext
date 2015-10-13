/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator.parser.antlr

import com.google.inject.Inject
import com.google.inject.Singleton
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.xtext.generator.XtextGeneratorNaming
import org.eclipse.xtext.xtext.generator.model.TypeReference

import static extension org.eclipse.xtext.GrammarUtil.*

@Singleton
class GrammarNaming {

	@Inject
	extension XtextGeneratorNaming

	protected def String getParserPackage(Grammar it) '''«runtimeBasePackage».parser.antlr'''

	protected def String getInternalParserPackage(Grammar it) '''«runtimeBasePackage».parser.antlr.internal'''

	def AntlrGrammar getParserGrammar(Grammar it) {
		new AntlrGrammar(internalParserPackage, '''Internal«simpleName»''')
	}
	
	def AntlrGrammar getLexerGrammar(Grammar it) {
		parserGrammar
	}

	def TypeReference getLexerClass(Grammar it) {
		new TypeReference(lexerGrammar.packageName, '''«lexerGrammar.simpleName»Lexer''')
	}

	def TypeReference getParserClass(Grammar it) {
		new TypeReference(parserPackage, '''«simpleName»Parser''')
	}

	def TypeReference getInternalParserClass(Grammar it) {
		new TypeReference(parserGrammar.packageName, '''«parserGrammar.simpleName»Parser''')
	}

	def TypeReference getContentAssistParserClass(Grammar it) {
		new TypeReference('''«genericIdeBasePackage».contentassist.antlr''', '''«simpleName»Parser''')
	}

	def TypeReference getInternalContentAssistLexerClass(Grammar it) {
		new TypeReference('''«genericIdeBasePackage».contentassist.antlr.internal''', '''Internal«simpleName»Lexer''')
	}

	def TypeReference getAntlrTokenFileProviderClass(Grammar it) {
		new TypeReference(parserPackage, '''«simpleName»AntlrTokenFileProvider''')
	}
	
	def TypeReference getTokenSourceClass(Grammar it) {
		new TypeReference(parserPackage, simpleName + "TokenSource")
	}

}
