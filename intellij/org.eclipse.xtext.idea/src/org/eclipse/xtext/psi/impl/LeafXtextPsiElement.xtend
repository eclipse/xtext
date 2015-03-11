/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.psi.impl

import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.tree.IElementType
import org.eclipse.xtext.idea.lang.IXtextLanguage
import org.eclipse.xtext.psi.XtextPsiElement

class LeafXtextPsiElement extends LeafPsiElement implements XtextPsiElement {

	new(IElementType type, CharSequence text) {
		super(type, text)
	}

	override getXtextLanguage() {
		elementType.language as IXtextLanguage
	}

	override BaseXtextFile getXtextFile() {
		containingFile as BaseXtextFile
	}

	override getResource() {
		xtextFile.resource
	}
	
	override getINode() {
		xtextFile.getINode(this)
	}

}
