package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class LangATestLanguageFileType extends LanguageFileType {

	public static final LangATestLanguageFileType INSTANCE = new LangATestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private LangATestLanguageFileType() {
		super(LangATestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "LangATestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "LangATestLanguage";
	}

}
