package org.eclipse.xtext.resource.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.resource.idea.lang.Bug385636Language;

public class Bug385636CodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug385636CodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug385636Language.INSTANCE, psiModificationTracker);
	}

}
