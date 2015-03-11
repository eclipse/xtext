package org.eclipse.xtext.valueconverter.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.valueconverter.idea.lang.Bug250313Language;

public class Bug250313CodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public Bug250313CodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(Bug250313Language.INSTANCE, psiModificationTracker);
	}

}
