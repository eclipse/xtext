package org.eclipse.xtext.lexer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class IgnoreCaseLexerTestLanguageFileType extends LanguageFileType {

	public static final IgnoreCaseLexerTestLanguageFileType INSTANCE = new IgnoreCaseLexerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private IgnoreCaseLexerTestLanguageFileType() {
		super(IgnoreCaseLexerTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "IgnoreCaseLexerTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "IgnoreCaseLexerTestLanguage";
	}

}
