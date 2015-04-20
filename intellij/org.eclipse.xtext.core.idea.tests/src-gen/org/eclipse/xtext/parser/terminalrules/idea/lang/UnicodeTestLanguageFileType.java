package org.eclipse.xtext.parser.terminalrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class UnicodeTestLanguageFileType extends LanguageFileType {

	public static final UnicodeTestLanguageFileType INSTANCE = new UnicodeTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "unicodetestlanguage";

	private UnicodeTestLanguageFileType() {
		super(UnicodeTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "UnicodeTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "UnicodeTestLanguage";
	}

}
