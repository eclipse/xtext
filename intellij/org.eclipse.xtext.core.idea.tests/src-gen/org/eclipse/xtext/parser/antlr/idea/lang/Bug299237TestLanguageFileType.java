package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug299237TestLanguageFileType extends LanguageFileType {

	public static final Bug299237TestLanguageFileType INSTANCE = new Bug299237TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug299237testlanguage";

	private Bug299237TestLanguageFileType() {
		super(Bug299237TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug299237TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug299237TestLanguage";
	}

}
