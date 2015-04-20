package org.eclipse.xtext.linking.lazy.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class LazyLinkingTestLanguageFileType extends LanguageFileType {

	public static final LazyLinkingTestLanguageFileType INSTANCE = new LazyLinkingTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "lazylinkingtestlanguage";

	private LazyLinkingTestLanguageFileType() {
		super(LazyLinkingTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "LazyLinkingTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "LazyLinkingTestLanguage";
	}

}
