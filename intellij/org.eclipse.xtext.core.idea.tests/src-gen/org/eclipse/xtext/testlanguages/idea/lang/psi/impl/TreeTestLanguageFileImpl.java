package org.eclipse.xtext.testlanguages.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.TreeTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class TreeTestLanguageFileImpl extends BaseXtextFile {

	public TreeTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, TreeTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return TreeTestLanguageFileType.INSTANCE;
	}

}
