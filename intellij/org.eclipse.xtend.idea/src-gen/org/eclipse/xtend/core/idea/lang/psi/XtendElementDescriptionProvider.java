package org.eclipse.xtend.core.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtend.core.idea.lang.XtendLanguage;

public class XtendElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public XtendElementDescriptionProvider() {
		super(XtendLanguage.INSTANCE);
	}

}
