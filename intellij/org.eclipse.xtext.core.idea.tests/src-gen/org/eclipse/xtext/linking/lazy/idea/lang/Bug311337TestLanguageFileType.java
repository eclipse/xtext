package org.eclipse.xtext.linking.lazy.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug311337TestLanguageFileType extends LanguageFileType {

	public static final Bug311337TestLanguageFileType INSTANCE = new Bug311337TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug311337testlanguage";

	private Bug311337TestLanguageFileType() {
		super(Bug311337TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug311337TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug311337TestLanguage";
	}

}
