package org.eclipse.xtext.psi.impl

import com.intellij.psi.tree.IElementType

class LeafXtextPsiReferenceElement extends LeafXtextPsiElement {

	new(IElementType type, CharSequence text) {
		super(type, text)
	}

	override getReference() {
		return new XtextPsiReferenceImpl(this)
	}

}