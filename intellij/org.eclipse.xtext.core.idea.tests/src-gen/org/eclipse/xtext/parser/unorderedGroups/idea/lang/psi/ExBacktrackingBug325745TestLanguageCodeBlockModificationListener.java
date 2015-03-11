package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.ExBacktrackingBug325745TestLanguageLanguage;

public class ExBacktrackingBug325745TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public ExBacktrackingBug325745TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(ExBacktrackingBug325745TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
