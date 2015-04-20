package org.eclipse.xtext.formatting2.internal.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class FormatterTestLanguageFileType extends LanguageFileType {

	public static final FormatterTestLanguageFileType INSTANCE = new FormatterTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "formattertestlanguage";

	private FormatterTestLanguageFileType() {
		super(FormatterTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "FormatterTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "FormatterTestLanguage";
	}

}
