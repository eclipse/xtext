package org.eclipse.xtext.index.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.index.idea.lang.IndexTestLanguageFileType;
import org.eclipse.xtext.index.idea.lang.IndexTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class IndexTestLanguageFileImpl extends BaseXtextFile {

	public IndexTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, IndexTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return IndexTestLanguageFileType.INSTANCE;
	}

}
