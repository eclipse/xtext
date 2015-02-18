package org.eclipse.xtext.parsetree.reconstr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class ComplexReconstrTestLanguageFileType extends LanguageFileType {

	public static final ComplexReconstrTestLanguageFileType INSTANCE = new ComplexReconstrTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "complexreconstrtestlanguage";

	private ComplexReconstrTestLanguageFileType() {
		super(ComplexReconstrTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "ComplexReconstrTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "ComplexReconstrTestLanguage";
	}

}
