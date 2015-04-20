package org.eclipse.xtext.testlanguages.idea.lang.psi.impl;

import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageFileType;
import org.eclipse.xtext.testlanguages.idea.lang.LookaheadTestLanguageLanguage;

import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;

public final class LookaheadTestLanguageFileImpl extends BaseXtextFile {

	public LookaheadTestLanguageFileImpl(FileViewProvider viewProvider) {
		super(viewProvider, LookaheadTestLanguageLanguage.INSTANCE);
	}

	@Override
	public FileType getFileType() {
		return LookaheadTestLanguageFileType.INSTANCE;
	}

}
