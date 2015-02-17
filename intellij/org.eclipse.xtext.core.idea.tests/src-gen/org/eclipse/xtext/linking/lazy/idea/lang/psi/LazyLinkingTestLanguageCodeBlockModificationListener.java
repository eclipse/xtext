package org.eclipse.xtext.linking.lazy.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;

public class LazyLinkingTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public LazyLinkingTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(LazyLinkingTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
