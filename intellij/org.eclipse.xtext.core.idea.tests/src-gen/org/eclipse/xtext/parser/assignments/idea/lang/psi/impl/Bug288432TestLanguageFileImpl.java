package org.eclipse.xtext.parser.assignments.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageFileType;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug288432TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug288432TestLanguageFileImpl extends BaseXtextFile {

	public Bug288432TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug288432TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug288432TestLanguageFileType.INSTANCE;
	}

}
