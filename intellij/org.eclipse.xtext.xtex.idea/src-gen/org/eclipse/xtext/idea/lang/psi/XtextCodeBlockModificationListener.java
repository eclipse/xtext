package org.eclipse.xtext.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.idea.lang.XtextLanguage;

public class XtextCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public XtextCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(XtextLanguage.INSTANCE, psiModificationTracker);
	}

}
