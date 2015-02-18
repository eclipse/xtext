package org.eclipse.xtext.generator.ecore.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class SuperTestLanguageFileType extends LanguageFileType {

	public static final SuperTestLanguageFileType INSTANCE = new SuperTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "supertestlanguage";

	private SuperTestLanguageFileType() {
		super(SuperTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "SuperTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "SuperTestLanguage";
	}

}
