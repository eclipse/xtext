package org.eclipse.xtext.parser.terminalrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug317840TestLanguageFileType extends LanguageFileType {

	public static final Bug317840TestLanguageFileType INSTANCE = new Bug317840TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug317840testlanguage";

	private Bug317840TestLanguageFileType() {
		super(Bug317840TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug317840TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug317840TestLanguage";
	}

}
