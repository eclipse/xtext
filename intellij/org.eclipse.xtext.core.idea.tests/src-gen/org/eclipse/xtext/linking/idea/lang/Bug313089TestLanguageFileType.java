package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug313089TestLanguageFileType extends LanguageFileType {

	public static final Bug313089TestLanguageFileType INSTANCE = new Bug313089TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug313089testlanguage";

	private Bug313089TestLanguageFileType() {
		super(Bug313089TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug313089TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug313089TestLanguage";
	}

}
