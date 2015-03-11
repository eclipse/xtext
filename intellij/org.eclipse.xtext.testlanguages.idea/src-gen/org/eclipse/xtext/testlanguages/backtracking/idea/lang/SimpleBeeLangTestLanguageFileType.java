package org.eclipse.xtext.testlanguages.backtracking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SimpleBeeLangTestLanguageFileType extends LanguageFileType {

	public static final SimpleBeeLangTestLanguageFileType INSTANCE = new SimpleBeeLangTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "simplebeelangtestlanguage";

	private SimpleBeeLangTestLanguageFileType() {
		super(SimpleBeeLangTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "SimpleBeeLangTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "SimpleBeeLangTestLanguage";
	}

}
