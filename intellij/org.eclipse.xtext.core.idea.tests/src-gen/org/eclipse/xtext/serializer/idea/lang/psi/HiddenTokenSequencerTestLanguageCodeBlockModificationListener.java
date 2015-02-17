package org.eclipse.xtext.serializer.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.serializer.idea.lang.HiddenTokenSequencerTestLanguageLanguage;

public class HiddenTokenSequencerTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public HiddenTokenSequencerTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(HiddenTokenSequencerTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
