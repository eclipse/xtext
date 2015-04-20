package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935ExTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug301935ExTestLanguageFileImpl extends BaseXtextFile {

	public Bug301935ExTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug301935ExTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug301935ExTestLanguageFileType.INSTANCE;
	}

}
