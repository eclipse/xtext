package org.eclipse.xtext.xtext.ecoreInference.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class MultiValueFeatureTestLanguageFileType extends LanguageFileType {

	public static final MultiValueFeatureTestLanguageFileType INSTANCE = new MultiValueFeatureTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "multivaluefeaturetestlanguage";

	private MultiValueFeatureTestLanguageFileType() {
		super(MultiValueFeatureTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "MultiValueFeatureTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "MultiValueFeatureTestLanguage";
	}

}
