package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug289515TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug289515TestLanguageFileImpl extends BaseXtextFile {

	public Bug289515TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug289515TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug289515TestLanguageFileType.INSTANCE;
	}

}
