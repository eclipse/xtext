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
import org.eclipse.xtext.common.types.JvmExecutable
import com.intellij.psi.PsiClass
import org.eclipse.xtext.common.types.JvmField
import org.eclipse.xtext.common.types.JvmFormalParameter
import com.intellij.psi.PsiMethod

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
					if (jvmElement.declaringType == null) {
						new JvmPsiClassImpl(jvmElement, sourceElement.psiElement as PsiNamedElement)
					} else {
						val psiClass = psiAssociations.getPsiElement(jvmElement.declaringType) as PsiClass
						if (psiClass == null)
							return null
						psiClass.innerClasses.findFirst [
							getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY) == jvmElement
						]
					}
				]
			}
			JvmExecutable: {
				[
					val psiClass = psiAssociations.getPsiElement(jvmElement.declaringType) as PsiClass
					if (psiClass == null)
						return null
					psiClass.methods.findFirst [
						getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY) == jvmElement
					]
				]
			}
			JvmField: {
				[
					val psiClass = psiAssociations.getPsiElement(jvmElement.declaringType) as PsiClass
					if (psiClass == null)
						return null
					psiClass.fields.findFirst [
						getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY) == jvmElement
					]
				]
			}
			JvmFormalParameter: {
				[
					val psiMethod = psiAssociations.getPsiElement(jvmElement.eContainer) as PsiMethod
					if (psiMethod == null)
						return null
					psiMethod.parameterList.parameters.findFirst [
						getUserData(JvmPsiClassImpl.JVM_ELEMENT_KEY) == jvmElement
					]
				]
			}
		}
	}
}
