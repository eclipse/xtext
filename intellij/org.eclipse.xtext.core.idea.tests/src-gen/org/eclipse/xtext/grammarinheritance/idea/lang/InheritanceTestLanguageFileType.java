package org.eclipse.xtext.grammarinheritance.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class InheritanceTestLanguageFileType extends LanguageFileType {

	public static final InheritanceTestLanguageFileType INSTANCE = new InheritanceTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "inheritancetestlanguage";

	private InheritanceTestLanguageFileType() {
		super(InheritanceTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "InheritanceTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "InheritanceTestLanguage";
	}

}
