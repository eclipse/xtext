/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.editor.bracketmatching

import com.google.inject.Inject
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher
import org.eclipse.jface.text.source.ICharacterPairMatcher
import org.eclipse.xtend.lib.annotations.Delegate
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider

/**
 * @author kosyakov - Initial contribution and API
 * 
 * @since 2.8
 */
class BracePairMatcher implements ICharacterPairMatcher {
	
	@Delegate
	DefaultCharacterPairMatcher characterPairMatcher
	
	@Inject
	def void setBracePairProvider(IBracePairProvider bracePairProvider) {
		val chars = bracePairProvider.chars
		characterPairMatcher = new DefaultCharacterPairMatcher(chars)
	}
	
	protected def getChars(IBracePairProvider bracePairProvider) {
		val chars = newArrayList
		for (pair : bracePairProvider.pairs) {
			if (pair.leftBrace.length == 1 && pair.rightBrace.length == 1) {
				chars += pair.leftBrace.charAt(0)
				chars += pair.rightBrace.charAt(0)
			} else {
				throw new IllegalStateException('Brace pair is invalid: ' + pair + '; left and right braces should have length of one character.')
			}
		}
		chars
	}

}