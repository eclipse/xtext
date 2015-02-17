package org.eclipse.xtext.linking.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.linking.idea.lang.ImportUriTestLanguageLanguage;

public class ImportUriTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ImportUriTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ImportUriTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
