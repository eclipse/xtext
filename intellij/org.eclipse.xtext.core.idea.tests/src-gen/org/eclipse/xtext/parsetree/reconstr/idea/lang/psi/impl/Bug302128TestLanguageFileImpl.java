package org.eclipse.xtext.parsetree.reconstr.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageFileType;
import org.eclipse.xtext.parsetree.reconstr.idea.lang.Bug302128TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug302128TestLanguageFileImpl extends BaseXtextFile {

	public Bug302128TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug302128TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug302128TestLanguageFileType.INSTANCE;
	}

}
