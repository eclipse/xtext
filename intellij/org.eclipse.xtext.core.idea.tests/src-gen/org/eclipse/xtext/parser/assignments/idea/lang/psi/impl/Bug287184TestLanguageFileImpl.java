package org.eclipse.xtext.parser.assignments.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageFileType;
import org.eclipse.xtext.parser.assignments.idea.lang.Bug287184TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class Bug287184TestLanguageFileImpl extends BaseXtextFile {

	public Bug287184TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, Bug287184TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return Bug287184TestLanguageFileType.INSTANCE;
	}

}
