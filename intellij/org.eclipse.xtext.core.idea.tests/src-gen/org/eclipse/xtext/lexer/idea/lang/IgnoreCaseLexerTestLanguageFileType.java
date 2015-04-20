package org.eclipse.xtext.lexer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class IgnoreCaseLexerTestLanguageFileType extends LanguageFileType {

	public static final IgnoreCaseLexerTestLanguageFileType INSTANCE = new IgnoreCaseLexerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "ignorecaselexertestlanguage";

	private IgnoreCaseLexerTestLanguageFileType() {
		super(IgnoreCaseLexerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "IgnoreCaseLexerTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "IgnoreCaseLexerTestLanguage";
	}

}
