package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MetamodelRefTestLanguageLanguage;

public class MetamodelRefTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public MetamodelRefTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(MetamodelRefTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
