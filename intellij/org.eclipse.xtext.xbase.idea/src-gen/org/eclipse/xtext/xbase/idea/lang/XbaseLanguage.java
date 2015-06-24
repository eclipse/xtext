package org.eclipse.xtext.xbase.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class XbaseLanguage extends AbstractXtextLanguage {

	public static final XbaseLanguage INSTANCE = new XbaseLanguage();

	private XbaseLanguage() {
		super("org.eclipse.xtext.xbase.Xbase");
	}

}
