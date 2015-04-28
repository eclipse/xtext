package org.eclipse.xtext.lexer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class BacktrackingLexerTestLanguageFileType extends LanguageFileType {

	public static final BacktrackingLexerTestLanguageFileType INSTANCE = new BacktrackingLexerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "backtrackinglexertestlanguage";

	private BacktrackingLexerTestLanguageFileType() {
		super(BacktrackingLexerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	@Override
	public String getDescription() {
		return "BacktrackingLexerTestLanguage files";
	}

	@Override
	public Icon getIcon() {
		return null;
	}

	@Override
	public String getName() {
		return "BacktrackingLexerTestLanguage";
	}

}
