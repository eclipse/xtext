/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.idea.findusages

import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.Singleton
import com.intellij.lang.cacheBuilder.SimpleWordsScanner
import com.intellij.lang.cacheBuilder.WordOccurrence
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lexer.Lexer
import com.intellij.util.Processor
import org.eclipse.xtext.idea.findusages.WordsScannerProvider
import org.eclipse.xtext.idea.parser.TokenTypeProvider
import org.eclipse.xtext.xbase.idea.parser.OperatorTokenTypeProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class XbaseWordsScanner implements WordsScanner {

	@Inject
	Lexer lexer

	@Inject
	TokenTypeProvider tokenTypeProvider

	@Inject
	OperatorTokenTypeProvider operatorTokenTypeProvider

	val simpleWordsScanner = new SimpleWordsScanner

	override void processWords(CharSequence fileText, Processor<WordOccurrence> processor) {
		lexer.start(fileText)
		while (lexer.tokenType != null) {
			scanOperator(processor)
			scanWords(processor)
			lexer.advance
		}
	}

	protected def void scanOperator(Processor<WordOccurrence> processor) {
		if (!operator)
			return;

		val start = lexer.tokenStart
		var end = lexer.tokenEnd
		lexer.advance
		while (operator) {
			end = lexer.tokenEnd
			lexer.advance
		}
		val occurrence = new WordOccurrence(lexer.bufferSequence, start, end, WordOccurrence.Kind.CODE)
		processor.process(occurrence)
	}

	protected def boolean isOperator() {
		operatorTokenTypeProvider.operatorTokens.contains(lexer.tokenType)
	}

	protected def void scanWords(Processor<WordOccurrence> processor) {
		if (lexer.tokenType == null)
			return;

		val kind = occurrenceKind
		val tokenStart = lexer.tokenStart
		simpleWordsScanner.processWords(lexer.tokenSequence) [ occurrence |
			occurrence.init(lexer.bufferSequence, tokenStart + occurrence.start, tokenStart + occurrence.end, kind)
			processor.process(occurrence)
		]
	}

	protected def getOccurrenceKind() {
		if (comments)
			return WordOccurrence.Kind.COMMENTS

		if (literals)
			return WordOccurrence.Kind.LITERALS

		return WordOccurrence.Kind.CODE
	}

	protected def isComments() {
		tokenTypeProvider.commentTokens.contains(lexer.tokenType)
	}

	protected def isLiterals() {
		tokenTypeProvider.stringLiteralTokens.contains(lexer.tokenType)
	}

	@Singleton
	static class XbaseWordsScannerProvider implements WordsScannerProvider {

		@Inject
		Provider<XbaseWordsScanner> provider

		override get() {
			provider.get
		}

	}

}