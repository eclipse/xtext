package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.UnorderedGroupsTestLanguageLanguage;

public class UnorderedGroupsTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public UnorderedGroupsTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(UnorderedGroupsTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
