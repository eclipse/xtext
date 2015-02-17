package org.eclipse.xtext.parser.assignments.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug287184TestLanguageFileType extends LanguageFileType {

	public static final Bug287184TestLanguageFileType INSTANCE = new Bug287184TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private Bug287184TestLanguageFileType() {
		super(Bug287184TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug287184TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug287184TestLanguage";
	}

}
