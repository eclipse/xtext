package org.eclipse.xtext.idea.completion

import com.google.inject.Singleton
import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PsiElementPattern
import com.intellij.psi.PsiElement
import com.intellij.util.ProcessingContext
import org.eclipse.emf.ecore.EReference
import org.eclipse.xtext.psi.PsiEObject

@Singleton
class PatternExtensions {

	def withEReference(PsiElementPattern.Capture<PsiElement> it, EReference reference) {
		with(new PatternCondition<PsiElement>("withEReference") {

			override accepts(PsiElement element, ProcessingContext context) {
				element.withEReference(reference)
			}

		})
	}

	protected def boolean withEReference(PsiElement element, EReference reference) {
		if (element == null) {
			return false
		}
		if (element instanceof PsiEObject) {
			if (element.EReference == reference) {
				return true
			}
		}
		element.parent.withEReference(reference)
	}
	
}