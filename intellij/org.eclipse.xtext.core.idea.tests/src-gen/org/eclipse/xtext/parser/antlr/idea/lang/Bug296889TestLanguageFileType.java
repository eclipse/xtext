package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug296889TestLanguageFileType extends LanguageFileType {

	public static final Bug296889TestLanguageFileType INSTANCE = new Bug296889TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private Bug296889TestLanguageFileType() {
		super(Bug296889TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug296889TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug296889TestLanguage";
	}

}
