package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug313089TestLanguageFileType extends LanguageFileType {

	public static final Bug313089TestLanguageFileType INSTANCE = new Bug313089TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private Bug313089TestLanguageFileType() {
		super(Bug313089TestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "Bug313089TestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "Bug313089TestLanguage";
	}

}
