package org.eclipse.xtext.linking.lazy.idea.lang;

class LazyLinkingTestLanguageFileType extends AbstractLazyLinkingTestLanguageFileType {

	public static final LazyLinkingTestLanguageFileType INSTANCE = new LazyLinkingTestLanguageFileType()
	
	new() {
		super(LazyLinkingTestLanguageLanguage.INSTANCE)
	}

}
