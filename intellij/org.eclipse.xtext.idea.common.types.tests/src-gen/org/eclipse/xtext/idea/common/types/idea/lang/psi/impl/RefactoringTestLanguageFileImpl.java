package org.eclipse.xtext.idea.common.types.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageFileType;
import org.eclipse.xtext.idea.common.types.idea.lang.RefactoringTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class RefactoringTestLanguageFileImpl extends BaseXtextFile {

	public RefactoringTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, RefactoringTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return RefactoringTestLanguageFileType.INSTANCE;
	}

}
