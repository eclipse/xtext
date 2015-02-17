package org.eclipse.xtext.valueconverter.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.valueconverter.idea.lang.QualifiedNameTestLanguageLanguage;

public class QualifiedNameTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public QualifiedNameTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(QualifiedNameTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
