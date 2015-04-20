package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug287988TestLanguageFileType extends LanguageFileType {

	public static final Bug287988TestLanguageFileType INSTANCE = new Bug287988TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug287988testlanguage";

	private Bug287988TestLanguageFileType() {
		super(Bug287988TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug287988TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug287988TestLanguage";
	}

}
