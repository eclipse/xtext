package org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.formatting2.regionaccess.internal.idea.lang.RegionAccessTestLanguageLanguage;

public class RegionAccessTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public RegionAccessTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(RegionAccessTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
