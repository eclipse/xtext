package org.eclipse.xtext.metamodelreferencing.tests.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class EcoreReferenceTestLanguageFileType extends LanguageFileType {

	public static final EcoreReferenceTestLanguageFileType INSTANCE = new EcoreReferenceTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private EcoreReferenceTestLanguageFileType() {
		super(EcoreReferenceTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "EcoreReferenceTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "EcoreReferenceTestLanguage";
	}

}
