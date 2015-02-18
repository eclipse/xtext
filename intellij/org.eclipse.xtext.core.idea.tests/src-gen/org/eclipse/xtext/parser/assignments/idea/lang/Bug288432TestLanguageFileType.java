package org.eclipse.xtext.parser.assignments.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug288432TestLanguageFileType extends LanguageFileType {

	public static final Bug288432TestLanguageFileType INSTANCE = new Bug288432TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug288432testlanguage";

	private Bug288432TestLanguageFileType() {
		super(Bug288432TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug288432TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug288432TestLanguage";
	}

}
