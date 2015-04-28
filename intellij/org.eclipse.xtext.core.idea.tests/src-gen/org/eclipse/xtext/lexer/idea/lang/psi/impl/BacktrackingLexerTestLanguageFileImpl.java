package org.eclipse.xtext.lexer.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageFileType;
import org.eclipse.xtext.lexer.idea.lang.BacktrackingLexerTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class BacktrackingLexerTestLanguageFileImpl extends BaseXtextFile {

	public BacktrackingLexerTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, BacktrackingLexerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return BacktrackingLexerTestLanguageFileType.INSTANCE;
	}

}
