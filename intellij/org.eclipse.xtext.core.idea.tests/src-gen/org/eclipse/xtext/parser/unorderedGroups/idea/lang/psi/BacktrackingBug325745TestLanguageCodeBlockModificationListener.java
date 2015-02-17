package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.BacktrackingBug325745TestLanguageLanguage;

public class BacktrackingBug325745TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public BacktrackingBug325745TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(BacktrackingBug325745TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
