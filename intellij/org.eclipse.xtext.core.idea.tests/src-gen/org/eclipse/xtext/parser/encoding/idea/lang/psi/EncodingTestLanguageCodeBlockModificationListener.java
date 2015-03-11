package org.eclipse.xtext.parser.encoding.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.encoding.idea.lang.EncodingTestLanguageLanguage;

public class EncodingTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public EncodingTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(EncodingTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
