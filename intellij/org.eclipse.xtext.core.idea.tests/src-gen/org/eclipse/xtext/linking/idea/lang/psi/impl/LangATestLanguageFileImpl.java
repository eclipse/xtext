package org.eclipse.xtext.linking.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.LangATestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class LangATestLanguageFileImpl extends BaseXtextFile {

	public LangATestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, LangATestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return LangATestLanguageFileType.INSTANCE;
	}

}
