package org.eclipse.xtext.testlanguages.backtracking.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageFileType;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.SimpleBeeLangTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SimpleBeeLangTestLanguageFileImpl extends BaseXtextFile {

	public SimpleBeeLangTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SimpleBeeLangTestLanguageLanguage.INSTANCE);
	}

	public FileType getFileType() {
		return SimpleBeeLangTestLanguageFileType.INSTANCE;
	}

}
