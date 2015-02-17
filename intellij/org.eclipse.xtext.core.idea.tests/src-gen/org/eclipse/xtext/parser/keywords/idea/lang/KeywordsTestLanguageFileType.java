package org.eclipse.xtext.parser.keywords.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class KeywordsTestLanguageFileType extends LanguageFileType {

	public static final KeywordsTestLanguageFileType INSTANCE = new KeywordsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private KeywordsTestLanguageFileType() {
		super(KeywordsTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "KeywordsTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "KeywordsTestLanguage";
	}

}
