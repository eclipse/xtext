package org.eclipse.xtext.parser.datatyperules.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class DatatypeRulesTestLanguageFileType extends LanguageFileType {

	public static final DatatypeRulesTestLanguageFileType INSTANCE = new DatatypeRulesTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "datatyperulestestlanguage";

	private DatatypeRulesTestLanguageFileType() {
		super(DatatypeRulesTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "DatatypeRulesTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "DatatypeRulesTestLanguage";
	}

}
