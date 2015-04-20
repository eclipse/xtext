package org.eclipse.xtext.enumrules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EnumAndReferenceTestLanguageFileType extends LanguageFileType {

	public static final EnumAndReferenceTestLanguageFileType INSTANCE = new EnumAndReferenceTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "enumandreferencetestlanguage";

	private EnumAndReferenceTestLanguageFileType() {
		super(EnumAndReferenceTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "EnumAndReferenceTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "EnumAndReferenceTestLanguage";
	}

}
