package org.eclipse.xtext.lexer.idea.lang;

import javax.swing.Icon;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NonNls;

public final class BacktrackingLexerTestLanguageFileType extends LanguageFileType {

	public static final BacktrackingLexerTestLanguageFileType INSTANCE = new BacktrackingLexerTestLanguageFileType();
	
	@NonNls 
	public static final String DEFAULT_EXTENSION = "";

	private BacktrackingLexerTestLanguageFileType() {
		super(BacktrackingLexerTestLanguageLanguage.INSTANCE);
	}

	public String getDefaultExtension() {
		return DEFAULT_EXTENSION;
	}

	public String getDescription() {
		return "BacktrackingLexerTestLanguage files";
	}

	public Icon getIcon() {
		return null;
	}

	public String getName() {
		return "BacktrackingLexerTestLanguage";
	}

}
