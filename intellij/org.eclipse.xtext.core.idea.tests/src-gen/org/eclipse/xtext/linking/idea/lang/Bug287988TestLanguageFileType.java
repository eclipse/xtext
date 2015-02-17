package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug287988TestLanguageFileType extends LanguageFileType {

	public static final Bug287988TestLanguageFileType INSTANCE = new Bug287988TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private Bug287988TestLanguageFileType() {
		super(Bug287988TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug287988TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug287988TestLanguage";
	}

}
