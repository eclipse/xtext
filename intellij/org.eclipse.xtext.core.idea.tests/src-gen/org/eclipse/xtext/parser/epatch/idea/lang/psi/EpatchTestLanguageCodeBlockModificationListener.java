package org.eclipse.xtext.parser.epatch.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.epatch.idea.lang.EpatchTestLanguageLanguage;

public class EpatchTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public EpatchTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(EpatchTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
