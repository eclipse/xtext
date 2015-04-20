package org.eclipse.xtext.linking.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageFileType;
import org.eclipse.xtext.linking.idea.lang.Bug289059TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug289059TestLanguageFileImpl extends BaseXtextFile {

	public Bug289059TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug289059TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug289059TestLanguageFileType.INSTANCE;
	}

}
