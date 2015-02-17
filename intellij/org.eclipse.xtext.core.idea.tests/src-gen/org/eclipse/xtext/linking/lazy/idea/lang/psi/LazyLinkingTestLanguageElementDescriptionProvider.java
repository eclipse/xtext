package org.eclipse.xtext.linking.lazy.idea.lang.psi;

import org.eclipse.xtext.psi.BaseXtextElementDescriptionProvider;
import org.eclipse.xtext.linking.lazy.idea.lang.LazyLinkingTestLanguageLanguage;

public class LazyLinkingTestLanguageElementDescriptionProvider extends BaseXtextElementDescriptionProvider {

	public LazyLinkingTestLanguageElementDescriptionProvider() {
		super(LazyLinkingTestLanguageLanguage.INSTANCE);
	}

}
