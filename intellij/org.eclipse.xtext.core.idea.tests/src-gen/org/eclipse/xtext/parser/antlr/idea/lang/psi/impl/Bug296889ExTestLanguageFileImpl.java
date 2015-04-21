package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889ExTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug296889ExTestLanguageFileImpl extends BaseXtextFile {

	public Bug296889ExTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug296889ExTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug296889ExTestLanguageFileType.INSTANCE;
	}

}
