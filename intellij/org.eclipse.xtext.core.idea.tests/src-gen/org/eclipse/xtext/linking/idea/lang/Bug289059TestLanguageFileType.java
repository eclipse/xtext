package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug289059TestLanguageFileType extends LanguageFileType {

	public static final Bug289059TestLanguageFileType INSTANCE = new Bug289059TestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug289059testlanguage";

	private Bug289059TestLanguageFileType() {
		super(Bug289059TestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug289059TestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug289059TestLanguage";
	}

}
