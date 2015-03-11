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

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "IgnoreCaseNamespacesTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "IgnoreCaseNamespacesTestLanguage";
	}

}
