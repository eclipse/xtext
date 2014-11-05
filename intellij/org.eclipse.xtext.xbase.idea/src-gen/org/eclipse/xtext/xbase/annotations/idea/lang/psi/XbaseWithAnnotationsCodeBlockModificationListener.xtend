package org.eclipse.xtext.xbase.annotations.idea.lang.psi

import com.intellij.psi.util.PsiModificationTracker
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage

class XbaseWithAnnotationsCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	new(PsiModificationTracker psiModificationTracker) {
		super(XbaseWithAnnotationsLanguage.INSTANCE, psiModificationTracker)
	}

}
