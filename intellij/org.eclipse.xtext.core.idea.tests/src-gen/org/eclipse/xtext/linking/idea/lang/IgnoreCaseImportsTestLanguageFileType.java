package org.eclipse.xtext.linking.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class IgnoreCaseImportsTestLanguageFileType extends LanguageFileType {

	public static final IgnoreCaseImportsTestLanguageFileType INSTANCE = new IgnoreCaseImportsTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private IgnoreCaseImportsTestLanguageFileType() {
		super(IgnoreCaseImportsTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "IgnoreCaseImportsTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "IgnoreCaseImportsTestLanguage";
	}

}
