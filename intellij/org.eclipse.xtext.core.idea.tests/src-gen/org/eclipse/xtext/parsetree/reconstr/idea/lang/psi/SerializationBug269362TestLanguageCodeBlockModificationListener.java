package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.SerializationBug269362TestLanguageLanguage;

public class SerializationBug269362TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SerializationBug269362TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SerializationBug269362TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
