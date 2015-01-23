/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.parser

import com.intellij.lang.PsiBuilder
import java.util.List
import java.util.Map
import org.antlr.runtime.BaseRecognizer
import org.antlr.runtime.TokenSource
import org.eclipse.xtext.idea.lang.CreateElementType
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder
import org.eclipse.xtext.parser.antlr.ITokenDefProvider
import org.eclipse.xtext.parser.antlr.XtextTokenStream

class PsiXtextTokenStream extends XtextTokenStream {

	boolean afterSeek

	val PsiBuilder builder

	val List<PsiBuilder.Marker> markers

	val Map<Integer, Integer> psiToOriginalMarkers

	new(PsiBuilder builder, TokenSource tokenSource, ITokenDefProvider tokenDefProvider) {
		super(tokenSource, tokenDefProvider)
		this.builder = builder
		this.afterSeek = false
		this.markers = newArrayList
		this.psiToOriginalMarkers = newHashMap
	}

	override consume() {
		if (afterSeek) {
			super.consume
		} else {
			val rawTokenIndex = builder.rawTokenIndex
			if (rawTokenIndex < p) {
				val n = p - rawTokenIndex
				for (var i = 0; i < n; i++) {
					advanceLexer
				}
			}
			super.consume
			advanceLexer
		}
	}
	
	protected def advanceLexer() {
		if (builder.eof) {
			return
		}
		val token = get(builder.rawTokenIndex)
		val hidden = token.channel == BaseRecognizer.HIDDEN
		val tokenType = builder.tokenType
		builder.remapCurrentToken(
			new CreateElementType(tokenType) [
				putUserData(IASTNodeAwareNodeModelBuilder.HIDDEN_KEY, hidden)
			]
		)
		builder.advanceLexer
	}

	override mark() {
		val psiMarker = markPsi
		psiToOriginalMarkers.put(psiMarker, super.mark)
		psiMarker
	}

	protected def markPsi() {
		markers += builder.mark
		lastPsiMarker
	}

	protected def getLastPsiMarker() {
		markers.size - 1
	}

	override release(int psiMarker) {
		super.release(psiToOriginalMarkers.get(psiMarker))
		markers.get(psiMarker).drop
	}

	override rewind() {
		super.rewind
		rewind(lastPsiMarker)

		mark
		afterSeek = false
	}

	override rewind(int psiMarker) {
		super.rewind(psiToOriginalMarkers.get(psiMarker))
		markers.get(psiMarker).rollbackTo
		afterSeek = false
	}

	override seek(int index) {
		super.seek(index)
		afterSeek = true
	}

}
