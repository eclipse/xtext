package org.eclipse.xtext.psi

import com.google.inject.ImplementedBy
import com.intellij.lang.ASTNode
import org.eclipse.xtext.psi.impl.PsiEObjectFactoryImpl

@ImplementedBy(PsiEObjectFactoryImpl)
interface PsiEObjectFactory {
	
	def ASTNode createLeafIdentifier(String name, ASTNode context)
	
	def ASTNode createCompositeIdentifier(String name, String currentName, ASTNode context)
	
}