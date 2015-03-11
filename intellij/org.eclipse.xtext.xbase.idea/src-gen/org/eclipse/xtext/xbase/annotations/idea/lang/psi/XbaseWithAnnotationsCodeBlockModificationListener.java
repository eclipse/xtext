package org.eclipse.xtext.xbase.annotations.idea.lang.psi;

import com.intellij.psi.impl.PsiTreeChangeEventImpl;
import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.xbase.annotations.idea.lang.XbaseWithAnnotationsLanguage;

public class XbaseWithAnnotationsCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public XbaseWithAnnotationsCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(XbaseWithAnnotationsLanguage.INSTANCE, psiModificationTracker);
	}

	protected boolean hasJavaStructuralChanges(PsiTreeChangeEventImpl event) {
		return true;
	}

}
