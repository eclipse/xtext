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

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "SimpleBeeLangTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "SimpleBeeLangTestLanguage";
	}

}
