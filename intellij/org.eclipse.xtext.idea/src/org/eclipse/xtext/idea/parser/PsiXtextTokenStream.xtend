/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.parser

import com.intellij.lang.PsiBuilder
import com.intellij.psi.tree.IElementType
import java.util.List
import java.util.Map
import org.antlr.runtime.BaseRecognizer
import org.antlr.runtime.Token
import org.antlr.runtime.TokenSource
import org.eclipse.xtend.lib.annotations.Data
import org.eclipse.xtext.idea.lang.CreateElementType
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder
import org.eclipse.xtext.parser.antlr.ITokenDefProvider
import org.eclipse.xtext.parser.antlr.XtextTokenStream

class PsiXtextTokenStream extends XtextTokenStream implements PsiTokenStream {

	boolean afterSeek

	val PsiBuilder builder

	val List<PsiTokenStreamState> states

	val Map<Integer, Integer> psiToOriginalMarkers
	
	String errorMessage
	
	IElementType tokenType

	new(PsiBuilder builder, TokenSource tokenSource, ITokenDefProvider tokenDefProvider) {
		super(tokenSource, tokenDefProvider)
		this.builder = builder
		this.afterSeek = false
		this.states = newArrayList
		this.psiToOriginalMarkers = newHashMap
	}
	
	override reportError(()=>String reporter) {
		if (errorMessage == null) {
			errorMessage = reporter.apply
		}
	}
	
	override remapToken(IElementType tokenType) {
		val currentTokenType = this.tokenType
		this.tokenType = tokenType
		currentTokenType
	}
	
	override void appendAllTokens() {
		while(!builder.eof) {
			consume
		}
		if (errorMessage != null) {
			builder.error(errorMessage)
			errorMessage = null
		}
	}

	override consume() {
		if (afterSeek) {
			super.consume
		} else {
			val rawTokenIndex = builder.rawTokenIndex
			if (rawTokenIndex < p) {
				val n = p - rawTokenIndex
				for (var i = 0; i < n; i++) {
					advanceLexer(null)
				}
			}
			super.consume
			advanceLexer(this.tokenType)
		}
	}
	
	protected def advanceLexer(IElementType tokenType) {
		if (builder.eof) {
			return
		}
		val token = get(builder.rawTokenIndex)
		val hidden = token.channel == BaseRecognizer.HIDDEN
		
		val currentTokenType = if (tokenType == null) builder.tokenType else tokenType
		builder.remapCurrentToken(
			new CreateElementType(currentTokenType) [
				putUserData(IASTNodeAwareNodeModelBuilder.HIDDEN_KEY, hidden)
			]
		)
		
		val errorMessage = token.errorMessage
		if (errorMessage != null) {
			val errorMarker = builder.mark
			builder.advanceLexer
			errorMarker.error(errorMessage)
		} else {
			builder.advanceLexer
		}
	}
	
	protected def String getErrorMessage(Token token) {
		if (token.channel != BaseRecognizer.HIDDEN && errorMessage != null) {
			val result = errorMessage
			errorMessage = null
			return result
		}
		if (token.type == Token.INVALID_TOKEN_TYPE) {
			return token.lexerErrorMessage
		}
	}

	override mark() {
		val psiMarker = markPsi
		psiToOriginalMarkers.put(psiMarker, super.mark)
		psiMarker
	}

	protected def markPsi() {
		states += new PsiTokenStreamState(errorMessage, tokenType, builder.mark)
		lastPsiMarker
	}

	protected def getLastPsiMarker() {
		states.size - 1
	}

	override release(int psiMarker) {
		super.release(psiToOriginalMarkers.get(psiMarker))
		val state = states.get(psiMarker)
		this.tokenType = state.tokenType 
		this.errorMessage = state.errorMessage
		state.marker.drop
	}

	override rewind() {
		super.rewind
		rewind(lastPsiMarker)

		mark
		afterSeek = false
	}

	override rewind(int psiMarker) {
		super.rewind(psiToOriginalMarkers.get(psiMarker))
		val state = states.get(psiMarker)
		this.tokenType = state.tokenType 
		this.errorMessage = state.errorMessage
		state.marker.rollbackTo
		afterSeek = false
	}

	override seek(int index) {
		super.seek(index)
		afterSeek = true
	}

}

@Data
class PsiTokenStreamState {
	String errorMessage
	IElementType tokenType
	PsiBuilder.Marker marker
}