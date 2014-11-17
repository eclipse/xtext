package org.eclipse.xtext.idea.types.access

import com.intellij.psi.PsiClass
import org.eclipse.xtext.common.types.JvmDeclaredType
import org.eclipse.xtext.common.types.access.TypeResource
import org.eclipse.xtext.common.types.access.impl.AbstractClassMirror
import org.eclipse.xtext.common.types.access.impl.ITypeFactory

class PsiClassMirror extends AbstractClassMirror {
	
	val PsiClass psiClass
	
	val ITypeFactory<PsiClass, JvmDeclaredType> typeFactory
	
	new(PsiClass psiClass, ITypeFactory<PsiClass, JvmDeclaredType> typeFactory) {
		this.psiClass = psiClass
		this.typeFactory = typeFactory
	}
	
	override protected getTypeName() {
		psiClass.qualifiedName
	}
	
	override initialize(TypeResource typeResource) {
		typeResource.contents.add(typeFactory.createType(psiClass))
	}
	
	override isSealed() {
		true
	}
	
}