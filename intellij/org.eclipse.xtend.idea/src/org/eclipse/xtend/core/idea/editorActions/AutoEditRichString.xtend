/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.idea.editorActions

import com.intellij.psi.tree.TokenSet
import org.eclipse.xtext.idea.editorActions.AutoEditContext
import org.eclipse.xtext.idea.editorActions.AutoEditString

/**
 * @author kosyakov - Initial contribution and API
 */
class AutoEditRichString extends AutoEditString {

	val TokenSet richStringLiteralTokens

	new(TokenSet richStringLiteralTokens) {
		super("'''")
		this.richStringLiteralTokens = richStringLiteralTokens
	}

	override protected isStringLiteral(TokenSet tokenSet, extension AutoEditContext context) {
		tokenSet == richStringLiteralTokens || super.isStringLiteral(tokenSet, context)
	}

}