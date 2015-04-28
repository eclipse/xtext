package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class LangATestLanguageFileType extends LanguageFileType {

	public static final LangATestLanguageFileType INSTANCE = new LangATestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "langatestlanguage";

	private LangATestLanguageFileType() {
		super(LangATestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "LangATestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "LangATestLanguage";
	}

}
