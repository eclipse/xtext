package org.eclipse.xtext.idea.sdomain.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class SDomainLanguage extends AbstractXtextLanguage {

	public static final SDomainLanguage INSTANCE = new SDomainLanguage();

	private SDomainLanguage() {
		super("org.eclipse.xtext.idea.sdomain.SDomain");
	}

}
