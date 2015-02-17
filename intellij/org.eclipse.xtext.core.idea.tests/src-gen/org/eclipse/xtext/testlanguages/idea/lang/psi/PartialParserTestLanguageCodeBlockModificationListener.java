package org.eclipse.xtext.testlanguages.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.testlanguages.idea.lang.PartialParserTestLanguageLanguage;

public class PartialParserTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public PartialParserTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(PartialParserTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
