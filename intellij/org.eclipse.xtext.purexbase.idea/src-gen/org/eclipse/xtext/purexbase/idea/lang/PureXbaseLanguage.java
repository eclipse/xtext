package org.eclipse.xtext.purexbase.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class PureXbaseLanguage extends AbstractXtextLanguage {

	public static final PureXbaseLanguage INSTANCE = new PureXbaseLanguage();

	private PureXbaseLanguage() {
		super("org.eclipse.xtext.purexbase.PureXbase");
	}

}
