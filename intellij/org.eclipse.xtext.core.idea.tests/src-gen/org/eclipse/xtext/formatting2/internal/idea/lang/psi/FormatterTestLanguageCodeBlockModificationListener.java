package org.eclipse.xtext.formatting2.internal.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.formatting2.internal.idea.lang.FormatterTestLanguageLanguage;

public class FormatterTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public FormatterTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(FormatterTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
