package org.eclipse.xtend.core.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class XtendLanguage extends AbstractXtextLanguage {

	public static final XtendLanguage INSTANCE = new XtendLanguage();

	private XtendLanguage() {
		super("org.eclipse.xtend.core.Xtend");
	}

}
