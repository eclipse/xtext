package org.eclipse.xtext.validation.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageFileType;
import org.eclipse.xtext.validation.idea.lang.ConcreteSyntaxValidationTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class ConcreteSyntaxValidationTestLanguageFileImpl extends BaseXtextFile {

	public ConcreteSyntaxValidationTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, ConcreteSyntaxValidationTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return ConcreteSyntaxValidationTestLanguageFileType.INSTANCE;
	}

}
