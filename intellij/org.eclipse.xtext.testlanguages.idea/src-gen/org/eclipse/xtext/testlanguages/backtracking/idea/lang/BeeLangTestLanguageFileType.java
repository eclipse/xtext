package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class BeeLangTestLanguageFileType extends LanguageFileType {

	public static final BeeLangTestLanguageFileType INSTANCE = new BeeLangTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "beelangtestlanguage";

	private BeeLangTestLanguageFileType() {
		super(BeeLangTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "BeeLangTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "BeeLangTestLanguage";
	}

}
