package org.eclipse.xtext.linking.lazy.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageFileType;
import org.eclipse.xtext.linking.lazy.idea.lang.Bug311337TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug311337TestLanguageFileImpl extends BaseXtextFile {

	public Bug311337TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug311337TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug311337TestLanguageFileType.INSTANCE;
	}

}
