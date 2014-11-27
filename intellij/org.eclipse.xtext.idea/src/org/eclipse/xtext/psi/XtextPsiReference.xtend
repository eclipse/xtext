package org.eclipse.xtext.psi

import com.intellij.openapi.util.TextRange
import com.intellij.psi.MultiRangeReference

interface XtextPsiReference extends MultiRangeReference {

	def TextRange getRangeToHighlightInElement()

}