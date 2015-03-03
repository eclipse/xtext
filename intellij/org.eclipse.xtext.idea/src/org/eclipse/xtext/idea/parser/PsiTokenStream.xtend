package org.eclipse.xtext.idea.parser

import org.antlr.runtime.TokenStream
import com.intellij.psi.tree.IElementType

interface PsiTokenStream extends TokenStream {
	
	def int getCurrentLookAhead()
	
	def void reportError(()=>String reporter)
	
	def IElementType remapToken(IElementType tokenType)
	
	def void appendAllTokens()
	
}