package org.eclipse.xtext.testlanguages.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.TestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class TestLanguageFileImpl extends BaseXtextFile {

	public TestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, TestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return TestLanguageFileType.INSTANCE;
	}

}
