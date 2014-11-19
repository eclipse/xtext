package org.eclipse.xtend.core.idea.lang.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

public class XtendCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public XtendCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(XtendLanguage.INSTANCE, psiModificationTracker);
	}

	protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		return true;
	}

}
