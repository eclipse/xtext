package org.eclipse.xtext.xbase.idea.lang.psi

import com.intellij.psi.util.PsiModificationTracker
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener
import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage

class XtypeCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	new(PsiModificationTracker psiModificationTracker) {
		super(XtypeLanguage.INSTANCE, psiModificationTracker)
	}

}
