package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ExBeeLangTestLanguageFileType extends LanguageFileType {

	public static final ExBeeLangTestLanguageFileType INSTANCE = new ExBeeLangTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "exbeelangtestlanguage";

	private ExBeeLangTestLanguageFileType() {
		super(ExBeeLangTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "ExBeeLangTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "ExBeeLangTestLanguage";
	}

}
