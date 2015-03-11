package org.eclipse.xtext.enumrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EnumRulesTestLanguageFileType extends LanguageFileType {

	public static final EnumRulesTestLanguageFileType INSTANCE = new EnumRulesTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "enumrulestestlanguage";

	private EnumRulesTestLanguageFileType() {
		super(EnumRulesTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "EnumRulesTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "EnumRulesTestLanguage";
	}

}
