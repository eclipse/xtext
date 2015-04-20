package org.eclipse.xtext.testlanguages.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.SimpleExpressionsTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class SimpleExpressionsTestLanguageFileImpl extends BaseXtextFile {

	public SimpleExpressionsTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, SimpleExpressionsTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return SimpleExpressionsTestLanguageFileType.INSTANCE;
	}

}
