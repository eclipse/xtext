package org.eclipse.xtext.linking.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.linking.idea.lang.Bug362902Language;

public class Bug362902CodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug362902CodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug362902Language.INSTANCE, psiModificationTracker);
	}

}
