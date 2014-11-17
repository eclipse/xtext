package org.eclipse.xtext.idea.jvmmodel.codeInsight

import com.intellij.codeInsight.TargetElementEvaluator
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.light.LightElement

class PsiJvmTargetElementEvaluator implements TargetElementEvaluator {
	
	override getElementByReference(PsiReference ref, int flags) {
		switch element : ref.resolve {
			LightElement: element.navigationElement
			default: element
		}
	}
	
	override includeSelfInGotoImplementation(PsiElement element) {
		true
	}
	
}