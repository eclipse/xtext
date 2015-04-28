package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug296889ExTestLanguageFileType extends LanguageFileType {

	public static final Bug296889ExTestLanguageFileType INSTANCE = new Bug296889ExTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug296889extestlanguage";

	private Bug296889ExTestLanguageFileType() {
		super(Bug296889ExTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug296889ExTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug296889ExTestLanguage";
	}

}
