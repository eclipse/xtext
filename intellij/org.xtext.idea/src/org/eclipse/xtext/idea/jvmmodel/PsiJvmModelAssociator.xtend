package org.eclipse.xtext.idea.jvmmodel

import com.google.inject.Inject
import com.intellij.psi.PsiNamedElement
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.idea.types.psi.impl.JvmPsiClassImpl
import org.eclipse.xtext.psi.IPsiModelAssociations
import org.eclipse.xtext.psi.IPsiModelAssociator
import org.eclipse.xtext.psi.PsiElementProvider
import org.eclipse.xtext.xbase.jvmmodel.JvmModelAssociator

class PsiJvmModelAssociator extends JvmModelAssociator {

	@Inject
	extension IPsiModelAssociator

	@Inject
	extension IPsiModelAssociations psiAssociations

	override associate(EObject sourceElement, EObject jvmElement) {
		super.associate(sourceElement, jvmElement)
		val psiElementProvider = createPsiElementProvider(sourceElement, jvmElement)
		if (psiElementProvider != null) {
			jvmElement.associate(psiElementProvider)
		}
	}

	override associatePrimary(EObject sourceElement, EObject jvmElement) {
		super.associatePrimary(sourceElement, jvmElement)
		val psiElementProvider = createPsiElementProvider(sourceElement, jvmElement)
		if (psiElementProvider != null) {
			jvmElement.associatePrimary(psiElementProvider)
		}
	}

	def PsiElementProvider createPsiElementProvider(EObject sourceElement, EObject jvmElement) {
		switch jvmElement {
			JvmDeclaredType: {
				return [
					new JvmPsiClassImpl(jvmElement, sourceElement.psiElement as PsiNamedElement)
				]
			}
		}
	}
}
