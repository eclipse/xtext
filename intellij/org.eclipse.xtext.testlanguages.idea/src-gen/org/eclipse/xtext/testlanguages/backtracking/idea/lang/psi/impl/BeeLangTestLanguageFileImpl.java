package org.eclipse.xtext.testlanguages.backtracking.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageFileType;
import org.eclipse.xtext.testlanguages.backtracking.idea.lang.BeeLangTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class BeeLangTestLanguageFileImpl extends BaseXtextFile {

	public BeeLangTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, BeeLangTestLanguageLanguage.INSTANCE);
	}

	public FileType getFileType() {
		return BeeLangTestLanguageFileType.INSTANCE;
	}

}
