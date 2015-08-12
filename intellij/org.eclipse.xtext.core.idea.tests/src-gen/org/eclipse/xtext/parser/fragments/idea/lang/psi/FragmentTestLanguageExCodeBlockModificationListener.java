package org.eclipse.xtext.parser.fragments.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.fragments.idea.lang.FragmentTestLanguageExLanguage;

public class FragmentTestLanguageExCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public FragmentTestLanguageExCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(FragmentTestLanguageExLanguage.INSTANCE, psiModificationTracker);
	}

}
