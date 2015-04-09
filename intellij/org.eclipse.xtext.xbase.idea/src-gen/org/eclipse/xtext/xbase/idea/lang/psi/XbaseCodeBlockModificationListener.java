package org.eclipse.xtext.xbase.idea.lang.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.xbase.idea.lang.XbaseLanguage;

public class XbaseCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public XbaseCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(XbaseLanguage.INSTANCE, psiModificationTracker);
	}

	protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		return true;
	}

}
