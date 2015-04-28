package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug301935ExTestLanguageFileType extends LanguageFileType {

	public static final Bug301935ExTestLanguageFileType INSTANCE = new Bug301935ExTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug301935extestlanguage";

	private Bug301935ExTestLanguageFileType() {
		super(Bug301935ExTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug301935ExTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug301935ExTestLanguage";
	}

}
