package org.eclipse.xtext.metamodelreferencing.tests.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageFileType;
import org.eclipse.xtext.metamodelreferencing.tests.idea.lang.MultiGenMMTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class MultiGenMMTestLanguageFileImpl extends BaseXtextFile {

	public MultiGenMMTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, MultiGenMMTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return MultiGenMMTestLanguageFileType.INSTANCE;
	}

}
