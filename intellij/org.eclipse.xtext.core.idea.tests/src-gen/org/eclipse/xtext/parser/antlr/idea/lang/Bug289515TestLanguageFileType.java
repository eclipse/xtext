package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug289515TestLanguageFileType extends LanguageFileType {

	public static final Bug289515TestLanguageFileType INSTANCE = new Bug289515TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug289515testlanguage";

	private Bug289515TestLanguageFileType() {
		super(Bug289515TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug289515TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug289515TestLanguage";
	}

}
