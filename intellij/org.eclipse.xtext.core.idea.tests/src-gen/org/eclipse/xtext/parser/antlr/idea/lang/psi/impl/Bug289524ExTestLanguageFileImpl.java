package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289524ExTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug289524ExTestLanguageFileImpl extends BaseXtextFile {

	public Bug289524ExTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug289524ExTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug289524ExTestLanguageFileType.INSTANCE;
	}

}
