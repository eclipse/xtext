/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.parser

import com.intellij.lang.PsiBuilder
import com.intellij.openapi.progress.ProcessCanceledException
import com.intellij.psi.tree.IElementType
import java.lang.reflect.InvocationTargetException
import java.util.List
import java.util.Map
import org.antlr.runtime.BitSet
import org.antlr.runtime.IntStream
import org.antlr.runtime.MismatchedTokenException
import org.antlr.runtime.MissingTokenException
import org.antlr.runtime.Parser
import org.antlr.runtime.RecognitionException
import org.antlr.runtime.RecognizerSharedState
import org.antlr.runtime.Token
import org.antlr.runtime.TokenStream
import org.antlr.runtime.UnwantedTokenException
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.idea.lang.GrammarAwareErrorElementType
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper

abstract class AbstractPsiAntlrParser extends Parser {

	List<String> readableTokenNames

	@Accessors
	extension ISyntaxErrorMessageProvider

	@Accessors
	IUnorderedGroupHelper unorderedGroupHelper

	@Accessors(PROTECTED_SETTER)
	PsiBuilder psiBuilder

	val compositeMarkers = <CompositeMarker>newLinkedList

	val PsiTokenStream psiInput

	new(TokenStream input) {
		this(input, new RecognizerSharedState)
	}

	new(TokenStream input, RecognizerSharedState state) {
		super(input, state)
		psiInput = input as PsiTokenStream
	}

	protected def String getFirstRuleName()

	def parse() throws RecognitionException {
		parse(firstRuleName)
	}

	def void parse(String entryRuleName) throws RecognitionException {
		val antlrEntryRuleName = entryRuleName.normalizeEntryRuleName
		try {
			antlrEntryRuleName.invokeEntryRule
			psiInput.appendAllTokens
		} catch (InvocationTargetException ite) {
			switch targetException : ite.targetException {
				RecognitionException: {
					psiInput.appendAllTokens
					throw targetException
				}
				ProcessCanceledException:
					throw targetException
				default:
					throw ite
			}
		} finally {
			doneComposite
		}
	}

	protected def invokeEntryRule(String antlrEntryRuleName) {
		val method = class.getMethod(antlrEntryRuleName)
		method.accessible = true
		method.invoke(this)
	}

	protected def String normalizeEntryRuleName(String entryRuleName) {
		if (entryRuleName.startsWith("entryRule")) {
			return entryRuleName
		}
		if (entryRuleName.startsWith("rule")) {
			return '''entry«entryRuleName.toFirstUpper»'''
		}
		'''entryRule«entryRuleName»'''
	}

	override getSourceName() {
		input.sourceName
	}

	protected def void markComposite(IElementType elementType) {
		compositeMarkers.push(new CompositeMarker(psiBuilder.mark, psiInput.currentLookAhead, elementType))
	}

	protected def void markLeaf(IElementType elementType) {
		psiInput.remapToken(elementType)
	}

	protected def void precedeComposite(IElementType elementType) {
		val compositeMarker = compositeMarkers.pop
		compositeMarkers.push(compositeMarker.precede(elementType))
		compositeMarkers.push(compositeMarker)
	}

	protected def void doneComposite() {
		compositeMarkers.pop.done()
	}

	protected def void doneLeaf(Token matchedToken) {
		val tokenType = psiInput.remapToken(null)
		if (matchedToken == null) {
			psiBuilder.mark.done(new GrammarAwareErrorElementType(tokenType))
			return
		}
	}

	override protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) {
		if (mismatchIsUnwantedToken(input, ttype)) {
			val tokenType = psiInput.remapToken(null)

			reportError(new UnwantedTokenException(ttype, input))
			beginResync()
			input.consume()
			endResync()

			psiInput.remapToken(tokenType)
			var Object matchedSymbol = getCurrentInputSymbol(input)
			input.consume()
			return matchedSymbol
		}
		if (mismatchIsMissingToken(input, follow)) {
			var Object inserted = getMissingSymbol(input, null, ttype, follow)
			reportError(new MissingTokenException(ttype, input, inserted))
			return null
		}
		throw new MismatchedTokenException(ttype, input)
	}

	override recover(IntStream input, RecognitionException re) {
		psiInput.reportError[getErrorMessage(re, readableTokenNames)]
		psiInput.remapToken(null)
		super.recover(input, re)
	}

	override reportError(RecognitionException e) {
		if (state.errorRecovery) {
			return;
		}
		state.syntaxErrors++; // don't count spurious
		state.errorRecovery = true;
		psiInput.reportError[getErrorMessage(e, readableTokenNames)]
	}

	override emitErrorMessage(String msg) {
		throw new UnsupportedOperationException
	}

	def void setTokenTypeMap(Map<Integer, String> tokenTypeMap) {
		var tokenNames = tokenNames
		readableTokenNames = newArrayOfSize(tokenNames.length)
		for (var i = 0; i < tokenNames.length; i++) {
			if (tokenTypeMap.containsKey(i)) {
				readableTokenNames.set(i, tokenTypeMap.get(i))
			} else {
				readableTokenNames.set(i, tokenNames.get(i))
			}
		}
	}

}