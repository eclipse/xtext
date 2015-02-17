package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleBacktrackingBug325745TestLanguageLanguage;

public class SimpleBacktrackingBug325745TestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SimpleBacktrackingBug325745TestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SimpleBacktrackingBug325745TestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
