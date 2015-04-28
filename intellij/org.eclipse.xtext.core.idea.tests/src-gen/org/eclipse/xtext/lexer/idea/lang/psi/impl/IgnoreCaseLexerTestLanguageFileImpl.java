package org.eclipse.xtext.lexer.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageFileType;
import org.eclipse.xtext.lexer.idea.lang.IgnoreCaseLexerTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class IgnoreCaseLexerTestLanguageFileImpl extends BaseXtextFile {

	public IgnoreCaseLexerTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, IgnoreCaseLexerTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return IgnoreCaseLexerTestLanguageFileType.INSTANCE;
	}

}
