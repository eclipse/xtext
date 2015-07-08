/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.idea.editorActions

import com.google.inject.Inject
import com.intellij.psi.tree.TokenSet
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider

/**
 * @author kosyakov - Initial contribution and API
 */
class DefaultAutoEditBlockProvider implements AutoEditBlockProvider {

	@Inject
	IBracePairProvider bracePairProvider

	@Inject
	extension TokenSetProvider tokenSetProvider

	override getQuotes() {
		#[
			new AutoEditString('"', stringLiteralTokens),
			new AutoEditString("'", stringLiteralTokens)
		]
	}

	override getBlocks(TokenSet tokenSet) {
		val multiLineCommentBlock = new AutoEditMultiLineBlock('/*', ' * ', ' */')
		switch tokenSet {
			case singleLineCommentTokens:
				emptyList
			case commentTokens:
				#[
					multiLineCommentBlock
				]
			default:
				bracePairProvider.pairs.map [
					new AutoEditMultiLineBlock(leftBrace, null, rightBrace, structural)
				] + #[multiLineCommentBlock]
		}
	}

}