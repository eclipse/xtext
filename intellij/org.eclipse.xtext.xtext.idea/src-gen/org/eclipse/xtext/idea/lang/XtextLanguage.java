package org.eclipse.xtext.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class XtextLanguage extends AbstractXtextLanguage {

	public static final XtextLanguage INSTANCE = new XtextLanguage();

	private XtextLanguage() {
		super("org.eclipse.xtext.Xtext");
	}

}
