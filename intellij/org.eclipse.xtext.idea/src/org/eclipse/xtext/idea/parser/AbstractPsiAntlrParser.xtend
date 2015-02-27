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
import org.eclipse.xtext.parser.antlr.ISyntaxErrorMessageProvider
import org.eclipse.xtext.parser.antlr.IUnorderedGroupHelper
import org.eclipse.xtext.idea.lang.GrammarAwareErrorElementType

abstract class AbstractPsiAntlrParser extends Parser {
	
	List<String> readableTokenNames
	
	@Accessors
	extension ISyntaxErrorMessageProvider
	
	@Accessors
	IUnorderedGroupHelper unorderedGroupHelper

	@Accessors(PROTECTED_SETTER)
	PsiBuilder psiBuilder

	val leafMarkers = <PsiBuilder.Marker>newLinkedList
	
	val compositeMarkers = <CompositeMarker>newLinkedList
	
	String currentError

	new(TokenStream input) {
		this(input, new RecognizerSharedState)
	}

	new(TokenStream input, RecognizerSharedState state) {
		super(input, state)
	}
	
	protected def String getFirstRuleName()

	def parse() throws RecognitionException {
		parse(firstRuleName)
	}
	
	def void parse(String entryRuleName) throws RecognitionException {
		val antlrEntryRuleName = entryRuleName.normalizeEntryRuleName
		try {
			antlrEntryRuleName.invokeEntryRule
			appendAllTokens
		} catch (InvocationTargetException ite) {
			switch targetException : ite.targetException {
				RecognitionException: {
					appendAllTokens 
					throw targetException
				}
				ProcessCanceledException:
					throw targetException
				default:
					throw ite
			}
		}
	}
	
	protected def invokeEntryRule(String antlrEntryRuleName) {
		val method = class.getMethod(antlrEntryRuleName)
		method.accessible = true
		method.invoke(this)
	}
	
	protected def appendAllTokens() {
		while(!psiBuilder.eof) {
			input.consume
		}
		if (currentError != null) {
			psiBuilder.error(currentError)
			currentError = null
		}
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
		compositeMarkers.push(new CompositeMarker(psiBuilder.mark, currentLookAhead, elementType))
	}

	protected def void markLeaf() {
		val marker = psiBuilder.mark
		leafMarkers.push(marker)
	}
	
	protected def void precedeComposite(IElementType elementType) {
		val compositeMarker = compositeMarkers.pop
		compositeMarkers.push(compositeMarker.precede(elementType))
		compositeMarkers.push(compositeMarker)
	}
	
	protected def drop() {
		leafMarkers.pop.drop
	}

	protected def void doneComposite() {
		compositeMarkers.pop.done()
	}

	protected def void doneLeaf(Token matchedToken, IElementType elementType) {
		if (matchedToken == null) {
			drop
			psiBuilder.mark.done(new GrammarAwareErrorElementType(elementType))
			return
		}
		val marker = leafMarkers.pop
		val endTokenIndex = psiBuilder.rawTokenIndex
		marker.rollbackTo
		val startTokenIndex = psiBuilder.rawTokenIndex
		val n = endTokenIndex - startTokenIndex - 1
		for (var i = 0; i < n; i++) {
			psiBuilder.advanceLexer
		}
		psiBuilder.remapCurrentToken(elementType)
		if (currentError != null) {
			val errorMarker = psiBuilder.mark
			psiBuilder.advanceLexer
			errorMarker.error(currentError)
			currentError = null
		} else {
			psiBuilder.advanceLexer
		}
	}
	
	protected def getCurrentLookAhead() {
		if (input instanceof PsiXtextTokenStream) {
			return input.currentLookAhead
		} 
		throw new IllegalStateException('the input should be an instance of '+ PsiXtextTokenStream.simpleName)
	}
	
	override protected Object recoverFromMismatchedToken(IntStream input, int ttype, BitSet follow) {
		if (mismatchIsUnwantedToken(input, ttype)) {
			val marked = !leafMarkers.empty 
			if (marked) {
				drop
			}
			
			val exception = new UnwantedTokenException(ttype, input)
			
			recover [
				beginResync()
				input.consume()
				endResync()
				reportError(exception)
			]
		
			if (marked) {
				markLeaf
			}
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
		if (currentError == null) {
			currentError = getErrorMessage(re, readableTokenNames)
		}
		
		for (leafMarker : leafMarkers) {
			leafMarker.drop
		}
		leafMarkers.clear
		
		recover [
			super.recover(input, re)
		]
	}
	
	protected def recover(()=>void recoverStrategy) {
		val startTokenIndex = psiBuilder.rawTokenIndex
		val marker = psiBuilder.mark
		
		recoverStrategy.apply
		
		val endTokenIndex = psiBuilder.rawTokenIndex
		marker.rollbackTo
		if (startTokenIndex != endTokenIndex) {
			val n = endTokenIndex - startTokenIndex
			for (var i = 0; i < n; i++) {
				val hidden = input.get(psiBuilder.rawTokenIndex).channel == HIDDEN
				if (hidden) {
					psiBuilder.advanceLexer
				} else if (currentError != null) {
					val errorMarker = psiBuilder.mark
					psiBuilder.advanceLexer
					errorMarker.error(currentError)
					currentError = null
				} else {
					psiBuilder.advanceLexer
				}
			}
		}
	}
	
	override reportError(RecognitionException e) {
		if ( state.errorRecovery ) {
			return;
		}
		state.syntaxErrors++; // don't count spurious
		state.errorRecovery = true;
		if (currentError == null)
			currentError = getErrorMessage(e, readableTokenNames)
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