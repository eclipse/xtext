package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug301935TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug301935TestLanguageFileImpl extends BaseXtextFile {

	public Bug301935TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug301935TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug301935TestLanguageFileType.INSTANCE;
	}

}
