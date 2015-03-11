package org.eclipse.xtext.serializer.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.serializer.idea.lang.ContextFinderTestLanguageLanguage;

public class ContextFinderTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ContextFinderTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ContextFinderTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
