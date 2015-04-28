package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageFileType;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.EcoreReferenceTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class EcoreReferenceTestLanguageFileImpl extends BaseXtextFile {

	public EcoreReferenceTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, EcoreReferenceTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return EcoreReferenceTestLanguageFileType.INSTANCE;
	}

}
