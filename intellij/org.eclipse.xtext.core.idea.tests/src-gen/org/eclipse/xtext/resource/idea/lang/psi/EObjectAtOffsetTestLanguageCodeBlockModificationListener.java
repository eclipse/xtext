package org.eclipse.xtext.resource.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.resource.idea.lang.EObjectAtOffsetTestLanguageLanguage;

public class EObjectAtOffsetTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public EObjectAtOffsetTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(EObjectAtOffsetTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
