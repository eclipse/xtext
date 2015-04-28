package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug296889TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug296889TestLanguageFileImpl extends BaseXtextFile {

	public Bug296889TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug296889TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug296889TestLanguageFileType.INSTANCE;
	}

}
