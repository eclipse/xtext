package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class IgnoreCaseNamespacesTestLanguageFileType extends LanguageFileType {

	public static final IgnoreCaseNamespacesTestLanguageFileType INSTANCE = new IgnoreCaseNamespacesTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "ignorecasenamespacestestlanguage";

	private IgnoreCaseNamespacesTestLanguageFileType() {
		super(IgnoreCaseNamespacesTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "IgnoreCaseNamespacesTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "IgnoreCaseNamespacesTestLanguage";
	}

}
