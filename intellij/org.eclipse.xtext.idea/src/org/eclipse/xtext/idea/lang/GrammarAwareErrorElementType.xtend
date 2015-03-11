package org.eclipse.xtext.idea.lang

import com.intellij.psi.tree.IElementType
import org.eclipse.xtend.lib.annotations.Accessors

class GrammarAwareErrorElementType extends IElementType {
	
	@Accessors
	val IElementType elementType

	new(IElementType elementType) {
		super(typeof(GrammarAwareErrorElementType).name, elementType.language, false)
		this.elementType = elementType
	}
	
	override toString() {
		'''«class.simpleName» [«elementType»]'''
	}
	
}