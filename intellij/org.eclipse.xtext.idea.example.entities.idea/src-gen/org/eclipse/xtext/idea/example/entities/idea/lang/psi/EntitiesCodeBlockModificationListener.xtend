package org.eclipse.xtext.idea.example.entities.idea.lang.psi

import com.intellij.psi.impl.PsiTreeChangeEventImpl
import com.intellij.psi.util.PsiModificationTracker
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener
import org.eclipse.xtext.idea.example.entities.idea.lang.EntitiesLanguage

class EntitiesCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	new(PsiModificationTracker psiModificationTracker) {
		super(EntitiesLanguage.INSTANCE, psiModificationTracker)
	}

	override protected hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		true
	}

}
