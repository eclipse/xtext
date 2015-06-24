package org.eclipse.xtext.linking.lazy.idea.lang;

import org.eclipse.xtext.idea.lang.AbstractXtextLanguage;

public final class LazyLinkingTestLanguageLanguage extends AbstractXtextLanguage {

	public static final LazyLinkingTestLanguageLanguage INSTANCE = new LazyLinkingTestLanguageLanguage();

	private LazyLinkingTestLanguageLanguage() {
		super("org.eclipse.xtext.linking.lazy.LazyLinkingTestLanguage");
	}

}
