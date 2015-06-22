package org.eclipse.xtext.parsetree.transientvalues.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class TransientValuesTestLanguage extends AbstractXtextLanguage {

	public static final TransientValuesTestLanguage INSTANCE = new TransientValuesTestLanguage();

	private TransientValuesTestLanguage() {
		super("org.eclipse.xtext.parsetree.transientvalues.TransientValuesTest");
	}

}
