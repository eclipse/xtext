package org.eclipse.xtext.serializer.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.serializer.idea.lang.SyntacticSequencerTestLanguageLanguage;

public class SyntacticSequencerTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SyntacticSequencerTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SyntacticSequencerTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
