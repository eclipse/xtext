package org.eclipse.xtext.serializer.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.serializer.idea.lang.SequencerTestLanguageLanguage;

public class SequencerTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SequencerTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SequencerTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
