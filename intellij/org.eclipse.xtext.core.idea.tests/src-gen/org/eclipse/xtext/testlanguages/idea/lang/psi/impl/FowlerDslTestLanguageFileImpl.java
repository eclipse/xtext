package org.eclipse.xtext.testlanguages.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.FowlerDslTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class FowlerDslTestLanguageFileImpl extends BaseXtextFile {

	public FowlerDslTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, FowlerDslTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return FowlerDslTestLanguageFileType.INSTANCE;
	}

}
