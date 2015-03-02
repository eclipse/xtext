package org.eclipse.xtext.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.idea.lang.XtextLanguage;

public class XtextElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public XtextElementDescriptionProvider() {
		super(XtextLanguage.INSTANCE);
	}

}
