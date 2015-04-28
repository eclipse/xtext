package org.eclipse.xtext.validation.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ConcreteSyntaxValidationTestLanguageFileType extends LanguageFileType {

	public static final ConcreteSyntaxValidationTestLanguageFileType INSTANCE = new ConcreteSyntaxValidationTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "concretesyntaxvalidationtestlanguage";

	private ConcreteSyntaxValidationTestLanguageFileType() {
		super(ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "ConcreteSyntaxValidationTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "ConcreteSyntaxValidationTestLanguage";
	}

}
