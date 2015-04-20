package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EcoreReferenceTestLanguageFileType extends LanguageFileType {

	public static final EcoreReferenceTestLanguageFileType INSTANCE = new EcoreReferenceTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "ecorereferencetestlanguage";

	private EcoreReferenceTestLanguageFileType() {
		super(EcoreReferenceTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "EcoreReferenceTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "EcoreReferenceTestLanguage";
	}

}
