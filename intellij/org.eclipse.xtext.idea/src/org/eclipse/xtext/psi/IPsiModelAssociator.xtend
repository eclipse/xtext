package org.eclipse.xtext.psi

import com.intellij.psi.PsiElement
import org.eclipse.emf.ecore.EObject

interface IPsiModelAssociator {
	
	def boolean associate(EObject eObject, PsiElementProvider psiElementProvider)
	
	def boolean associatePrimary(EObject eObject, PsiElementProvider psiElementProvider)
	
}

interface PsiElementProvider {
	
	def PsiElement get()
	
}