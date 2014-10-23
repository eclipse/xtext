package org.eclipse.xtext.psi.impl

import com.intellij.psi.tree.IElementType
import org.eclipse.xtext.psi.XtextPsiReference

class LeafXtextPsiReferenceElement extends LeafXtextPsiElement {

	new(IElementType type, CharSequence text) {
		super(type, text)
	}

	override getReference() {
		return new XtextPsiReference(this)
	}

}