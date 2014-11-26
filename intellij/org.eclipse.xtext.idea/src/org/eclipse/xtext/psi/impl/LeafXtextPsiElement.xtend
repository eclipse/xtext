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
