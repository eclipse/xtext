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
	
	def isCombinedGrammar(Grammar it) {
		CombinedGrammarMarker.findInEmfObject(it).isCombinedGrammar
	}

	protected def String getParserPackage(Grammar it) {
		runtimeBasePackage + ".parser.antlr"
	}

	protected def String getInternalParserPackage(Grammar it) {
		parserPackage + ".internal"
	}
	
	protected def String getInternalLexerPackage(Grammar it) {
		parserPackage + ".lexer"
	}

	def AntlrGrammar getParserGrammar(Grammar it) {
		new AntlrGrammar(internalParserPackage, '''«grammarNamePrefix»Internal«simpleName»«IF !combinedGrammar»Parser«ENDIF»''')
	}

	def AntlrGrammar getLexerGrammar(Grammar it) {
		if (combinedGrammar) {
			getParserGrammar(it)
		} else {
			new AntlrGrammar(internalLexerPackage, '''«grammarNamePrefix»Internal«simpleName»Lexer''')
		}
	}
	
	protected def String getGrammarNamePrefix(Grammar it) {
		""
	}

	def TypeReference getLexerClass(Grammar it) {
		new TypeReference(lexerGrammar.packageName, '''«lexerGrammar.simpleName»«IF combinedGrammar»Lexer«ENDIF»''')
	}
	
	def TypeReference getLexerSuperClass(Grammar it) {
		new TypeReference("org.eclipse.xtext.parser.antlr.Lexer")
	}

	def TypeReference getParserClass(Grammar it) {
		new TypeReference(parserPackage, '''«simpleName»Parser''')
	}

	def TypeReference getParserSuperClass(Grammar it, boolean partialParsing) {
		new TypeReference("org.eclipse.xtext.parser.antlr.AbstractAntlrParser")
	}

	def TypeReference getInternalParserClass(Grammar it) {
		new TypeReference(parserGrammar.packageName, '''«parserGrammar.simpleName»«IF combinedGrammar»Parser«ENDIF»''')
	}

	def TypeReference getInternalParserSuperClass(Grammar it) {
		new TypeReference("org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser")
	}

	def TypeReference getAntlrTokenFileProviderClass(Grammar it) {
		new TypeReference(parserPackage, '''«simpleName»AntlrTokenFileProvider''')
	}

	def TypeReference getTokenSourceClass(Grammar it) {
		new TypeReference(parserPackage, simpleName + "TokenSource")
	}

}
