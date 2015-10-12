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

	def String getParserPackage(Grammar it) '''«runtimeBasePackage».parser.antlr'''

	def String getInternalParserPackage(Grammar it) '''«runtimeBasePackage».parser.antlr.internal'''

	def TypeReference getGrammarClass(Grammar it) {
		new TypeReference(internalParserPackage, '''Internal«simpleName»''')
	}

	def TypeReference getLexerClass(Grammar it) {
		new TypeReference(internalParserPackage, '''Internal«simpleName»Lexer''')
	}

	def TypeReference getParserClass(Grammar it) {
		new TypeReference(parserPackage, '''«simpleName»Parser''')
	}

	def TypeReference getInternalParserClass(Grammar it) {
		new TypeReference(internalParserPackage, '''Internal«simpleName»Parser''')
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
	
	def String getTokenFileName(Grammar it) {
		internalParserPackage.replace('.', '/') + "/Internal" + simpleName + ".tokens"
	}

}
