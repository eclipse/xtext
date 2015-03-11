package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.PartialSerializationTestLanguageLanguage;

public class PartialSerializationTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public PartialSerializationTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(PartialSerializationTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
