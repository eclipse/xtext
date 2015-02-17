package org.eclipse.xtext.resource.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.resource.idea.lang.LocationProviderTestLanguageLanguage;

public class LocationProviderTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public LocationProviderTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(LocationProviderTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
