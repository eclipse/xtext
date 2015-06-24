package org.eclipse.xtext.xbase.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class XtypeLanguage extends AbstractXtextLanguage {

	public static final XtypeLanguage INSTANCE = new XtypeLanguage();

	private XtypeLanguage() {
		super("org.eclipse.xtext.xbase.Xtype");
	}

}
