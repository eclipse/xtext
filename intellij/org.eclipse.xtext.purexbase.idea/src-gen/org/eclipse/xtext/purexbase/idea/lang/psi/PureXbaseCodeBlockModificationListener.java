package org.eclipse.xtext.purexbase.idea.lang.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.purexbase.idea.lang.PureXbaseLanguage;

public class PureXbaseCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public PureXbaseCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(PureXbaseLanguage.INSTANCE, psiModificationTracker);
	}

	protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		return true;
	}

}
