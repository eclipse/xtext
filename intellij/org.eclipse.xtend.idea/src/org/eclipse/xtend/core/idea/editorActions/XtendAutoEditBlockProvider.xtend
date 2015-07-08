/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.editorActions

import com.google.inject.Inject
import com.google.inject.Singleton
import com.intellij.psi.tree.TokenSet
import org.eclipse.xtext.idea.editorActions.AutoEditMultiLineBlock
import org.eclipse.xtext.idea.editorActions.AutoEditString
import org.eclipse.xtext.idea.editorActions.DefaultAutoEditBlockProvider

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
class XtendAutoEditBlockProvider extends DefaultAutoEditBlockProvider {

	@Inject
	extension XtendTokenSetProvider tokenSetProvider

	override getQuotes() {
		#[
			new AutoEditString("'''", richStringLiteralTokens),
			new AutoEditString('"', stringLiteralTokens),
			new AutoEditString("'", stringLiteralTokens)
		]
	}

	override getBlocks(TokenSet tokenSet) {
		if (tokenSet == richStringLiteralTokens) {
			return #[
				new AutoEditMultiLineBlockInRichString('{', '}'),
				new AutoEditMultiLineBlock('«', '»') => [
					shouldDeleteClosing = true
					shouldInsertClosingTerminalBeforeDigit = true
					shouldInsertClosingTerminalBeforeSpecialCharacters = true
				]
			]
		}
		super.getBlocks(tokenSet)
	}

}