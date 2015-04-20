package org.eclipse.xtext.testlanguages.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class OptionalEmptyTestLanguageFileType extends LanguageFileType {

	public static final OptionalEmptyTestLanguageFileType INSTANCE = new OptionalEmptyTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "optionalemptytestlanguage";

	private OptionalEmptyTestLanguageFileType() {
		super(OptionalEmptyTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "OptionalEmptyTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "OptionalEmptyTestLanguage";
	}

}
