package org.eclipse.xtext.resource.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.resource.idea.lang.LiveContainerBuilderIntegerationTestLanguageLanguage;

public class LiveContainerBuilderIntegerationTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public LiveContainerBuilderIntegerationTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(LiveContainerBuilderIntegerationTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
