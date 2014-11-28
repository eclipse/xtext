package org.eclipse.xtext.idea.completion

import com.intellij.codeInsight.completion.CompletionResultSet
import com.intellij.codeInsight.lookup.LookupElement

class CompletionExtensions {
	def +=(CompletionResultSet result, LookupElement element) {
		result.addElement(element)
	}
	
	def +=(CompletionResultSet result, Iterable<? extends LookupElement> elements) {
		result.addAllElements(elements)
	}
}