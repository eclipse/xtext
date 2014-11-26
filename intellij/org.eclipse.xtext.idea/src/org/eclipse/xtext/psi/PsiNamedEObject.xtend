package org.eclipse.xtext.psi

import com.intellij.pom.PomRenameableTarget
import com.intellij.psi.PsiNameIdentifierOwner

interface PsiNamedEObject extends PsiEObject, PsiNameIdentifierOwner, PomRenameableTarget<PsiNamedEObject> {
	override PsiEObjectIdentifier getNameIdentifier()
}
