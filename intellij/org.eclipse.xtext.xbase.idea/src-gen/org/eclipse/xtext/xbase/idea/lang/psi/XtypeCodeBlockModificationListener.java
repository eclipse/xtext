package org.eclipse.xtext.xbase.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.xbase.idea.lang.XtypeLanguage;

import com.intellij.psi.util.PsiModificationTracker;

public class XtypeCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public XtypeCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(XtypeLanguage.INSTANCE, psiModificationTracker);
	}

}
