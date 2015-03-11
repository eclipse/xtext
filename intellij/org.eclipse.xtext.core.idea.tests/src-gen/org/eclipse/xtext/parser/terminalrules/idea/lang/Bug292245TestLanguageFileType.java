package org.eclipse.xtext.parser.terminalrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug292245TestLanguageFileType extends LanguageFileType {

	public static final Bug292245TestLanguageFileType INSTANCE = new Bug292245TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug292245testlanguage";

	private Bug292245TestLanguageFileType() {
		super(Bug292245TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug292245TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug292245TestLanguage";
	}

}
