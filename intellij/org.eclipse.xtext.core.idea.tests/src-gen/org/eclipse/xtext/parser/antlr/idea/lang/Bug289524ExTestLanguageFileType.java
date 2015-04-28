package org.eclipse.xtext.parser.antlr.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class Bug289524ExTestLanguageFileType extends LanguageFileType {

	public static final Bug289524ExTestLanguageFileType INSTANCE = new Bug289524ExTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "bug289524extestlanguage";

	private Bug289524ExTestLanguageFileType() {
		super(Bug289524ExTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "Bug289524ExTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "Bug289524ExTestLanguage";
	}

}
