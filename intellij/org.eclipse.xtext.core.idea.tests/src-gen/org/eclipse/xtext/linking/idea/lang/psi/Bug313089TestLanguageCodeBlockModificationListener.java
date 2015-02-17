package org.eclipse.xtext.linking.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.linking.idea.lang.Bug313089TestLanguageLanguage;

public class Bug313089TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug313089TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug313089TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
