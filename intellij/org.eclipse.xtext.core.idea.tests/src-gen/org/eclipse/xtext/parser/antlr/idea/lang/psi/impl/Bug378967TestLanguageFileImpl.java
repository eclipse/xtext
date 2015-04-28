package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug378967TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug378967TestLanguageFileImpl extends BaseXtextFile {

	public Bug378967TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug378967TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug378967TestLanguageFileType.INSTANCE;
	}

}
