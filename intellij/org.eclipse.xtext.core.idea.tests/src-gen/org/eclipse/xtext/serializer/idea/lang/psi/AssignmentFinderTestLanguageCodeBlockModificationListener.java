package org.eclipse.xtext.serializer.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.serializer.idea.lang.AssignmentFinderTestLanguageLanguage;

public class AssignmentFinderTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public AssignmentFinderTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(AssignmentFinderTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
