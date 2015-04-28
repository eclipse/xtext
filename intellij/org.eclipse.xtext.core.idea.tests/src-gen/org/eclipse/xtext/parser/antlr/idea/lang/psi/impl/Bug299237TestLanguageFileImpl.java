package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug299237TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug299237TestLanguageFileImpl extends BaseXtextFile {

	public Bug299237TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug299237TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug299237TestLanguageFileType.INSTANCE;
	}

}
