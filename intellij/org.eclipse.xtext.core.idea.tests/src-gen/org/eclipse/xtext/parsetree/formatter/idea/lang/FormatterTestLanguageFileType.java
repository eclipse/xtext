package org.eclipse.xtext.parsetree.formatter.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class FormatterTestLanguageFileType extends LanguageFileType {

	public static final FormatterTestLanguageFileType INSTANCE = new FormatterTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private FormatterTestLanguageFileType() {
		super(FormatterTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "FormatterTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "FormatterTestLanguage";
	}

}
