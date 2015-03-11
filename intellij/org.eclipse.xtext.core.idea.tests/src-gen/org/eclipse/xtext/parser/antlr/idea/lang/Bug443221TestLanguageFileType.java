package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug443221TestLanguageFileType extends LanguageFileType {

	public static final Bug443221TestLanguageFileType INSTANCE = new Bug443221TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug443221testlanguage";

	private Bug443221TestLanguageFileType() {
		super(Bug443221TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug443221TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug443221TestLanguage";
	}

}
