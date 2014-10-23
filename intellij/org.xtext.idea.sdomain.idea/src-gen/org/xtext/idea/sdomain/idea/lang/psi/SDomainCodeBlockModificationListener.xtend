package org.xtext.idea.sdomain.idea.lang.psi

import com.intellij.psi.util.PsiModificationTracker
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener
import org.xtext.idea.sdomain.idea.lang.SDomainLanguage

class SDomainCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	new(PsiModificationTracker psiModificationTracker) {
		super(SDomainLanguage.INSTANCE, psiModificationTracker)
	}

}
