package org.eclipse.xtext.parser.terminalrules.idea.lang.psi;

import com.intellij.psi.util.PsiModificationTracker;
import org.eclipse.xtext.psi.BaseXtextCodeBlockModificationListener;
import org.eclipse.xtext.parser.terminalrules.idea.lang.XtextTerminalsTestLanguageLanguage;

public class XtextTerminalsTestLanguageCodeBlockModificationListener extends BaseXtextCodeBlockModificationListener {

	public XtextTerminalsTestLanguageCodeBlockModificationListener(PsiModificationTracker psiModificationTracker) {
		super(XtextTerminalsTestLanguageLanguage.INSTANCE, psiModificationTracker);
	}

}
