package org.eclipse.xtext.xtext.ecoreInference.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.xtext.ecoreInference.idea.lang.MultiValueFeatureTestLanguageLanguage;

public class MultiValueFeatureTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public MultiValueFeatureTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(MultiValueFeatureTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
