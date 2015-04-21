package org.eclipse.xtext.parser.antlr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageFileType;
import org.eclipse.xtext.parser.antlr.idea.lang.Bug443221TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug443221TestLanguageFileImpl extends BaseXtextFile {

	public Bug443221TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug443221TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug443221TestLanguageFileType.INSTANCE;
	}

}
