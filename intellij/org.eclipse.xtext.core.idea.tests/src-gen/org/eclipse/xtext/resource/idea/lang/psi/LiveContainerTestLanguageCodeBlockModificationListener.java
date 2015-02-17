package org.eclipse.xtext.resource.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.resource.idea.lang.LiveContainerTestLanguageLanguage;

public class LiveContainerTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public LiveContainerTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(LiveContainerTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
