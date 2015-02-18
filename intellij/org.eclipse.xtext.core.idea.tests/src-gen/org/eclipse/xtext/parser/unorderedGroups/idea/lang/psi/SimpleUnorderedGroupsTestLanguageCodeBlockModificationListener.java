package org.eclipse.xtext.parser.unorderedGroups.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.unorderedGroups.idea.lang.SimpleUnorderedGroupsTestLanguageLanguage;

public class SimpleUnorderedGroupsTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public SimpleUnorderedGroupsTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(SimpleUnorderedGroupsTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
