package org.eclipse.xtext.parser.fragments.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageLanguage;

public class FragmentTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public FragmentTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(FragmentTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
