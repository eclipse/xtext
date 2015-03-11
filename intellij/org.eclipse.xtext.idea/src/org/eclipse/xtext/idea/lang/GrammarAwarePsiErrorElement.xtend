package org.eclipse.xtext.idea.lang

import com.intellij.psi.PsiErrorElement
import com.intellij.psi.impl.source.tree.PsiErrorElementImpl
import com.intellij.psi.tree.IElementType
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType

class GrammarAwarePsiErrorElement extends PsiErrorElementImpl implements PsiErrorElement {
	
	@Accessors
	IElementType elementType
	
	new(IElementType elementType) {
		super(elementType.toString)
		this.elementType = elementType
	}
	
	def getGrammarElement() {
		if (elementType instanceof IGrammarAwareElementType) {
			elementType.grammarElement
		}
	}
	
	override toString() {
		'''«class.simpleName»:«errorDescription»'''
	}
	
}