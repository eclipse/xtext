package org.eclipse.xtext.parser.keywords.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class KeywordsTestLanguageFileType extends LanguageFileType {

	public static final KeywordsTestLanguageFileType INSTANCE = new KeywordsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "keywordstestlanguage";

	private KeywordsTestLanguageFileType() {
		super(KeywordsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "KeywordsTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "KeywordsTestLanguage";
	}

}
